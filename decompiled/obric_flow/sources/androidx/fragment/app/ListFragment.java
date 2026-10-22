package androidx.fragment.app;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class ListFragment extends Fragment {
    static final int INTERNAL_EMPTY_ID = 16711681;
    static final int INTERNAL_LIST_CONTAINER_ID = 16711683;
    static final int INTERNAL_PROGRESS_CONTAINER_ID = 16711682;
    ListAdapter mAdapter;
    CharSequence mEmptyText;
    View mEmptyView;
    private final Handler mHandler;
    ListView mList;
    View mListContainer;
    boolean mListShown;
    private final AdapterView.OnItemClickListener mOnClickListener;
    View mProgressContainer;
    private final Runnable mRequestFocus;
    TextView mStandardEmptyView;

    public ListFragment() {
        this.mHandler = new Handler();
        this.mRequestFocus = new AnonymousClass1(this);
        this.mOnClickListener = new AnonymousClass2(this);
    }

    private void ensureList() {
        if (this.mList == null) goto L5;
        return;
    L5:
        View r5 = getView();
        if (r5 == null) goto L36;
        if ((r5 instanceof ListView) == false) goto L10;
        this.mList = (ListView) r5;
    L27:
        this.mListShown = true;
        this.mList.setOnItemClickListener(this.mOnClickListener);
        ListAdapter r10 = this.mAdapter;
        if (r10 == null) goto L31;
        this.mAdapter = null;
        setListAdapter(r10);
    L33:
        this.mHandler.post(this.mRequestFocus);
        return;
    L31:
        if (this.mProgressContainer == null) goto L33;
        setListShown(false, false);
        goto L33
    L10:
        TextView r11 = (TextView) r5.findViewById(INTERNAL_EMPTY_ID);
        this.mStandardEmptyView = r11;
        if (r11 != null) goto L13;
        this.mEmptyView = r5.findViewById(R.id.empty);
    L14:
        this.mProgressContainer = r5.findViewById(INTERNAL_PROGRESS_CONTAINER_ID);
        this.mListContainer = r5.findViewById(INTERNAL_LIST_CONTAINER_ID);
        View r12 = r5.findViewById(R.id.list);
        if ((r12 instanceof ListView) == true) goto L21;
        if (r12 != null) goto L20;
        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
    L20:
        throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
    L21:
        ListView r13 = (ListView) r12;
        this.mList = r13;
        View r14 = this.mEmptyView;
        if (r14 == null) goto L24;
        r13.setEmptyView(r14);
        goto L27
    L24:
        CharSequence r15 = this.mEmptyText;
        if (r15 == null) goto L27;
        this.mStandardEmptyView.setText(r15);
        this.mList.setEmptyView(this.mStandardEmptyView);
        goto L27
    L13:
        r11.setVisibility(8);
        goto L14
    L36:
        throw new IllegalStateException("Content view not yet created");
    }

    @Nullable
    public ListAdapter getListAdapter() {
        return this.mAdapter;
    }

    @NonNull
    public ListView getListView() {
        ensureList();
        return this.mList;
    }

    public long getSelectedItemId() {
        ensureList();
        return this.mList.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        ensureList();
        return this.mList.getSelectedItemPosition();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater r5, @Nullable ViewGroup r10, @Nullable Bundle r11) {
        Context r12 = requireContext();
        FrameLayout r13 = new FrameLayout(r12);
        LinearLayout r14 = new LinearLayout(r12);
        r14.setId(INTERNAL_PROGRESS_CONTAINER_ID);
        r14.setOrientation(1);
        r14.setVisibility(8);
        r14.setGravity(17);
        r14.addView(new ProgressBar(r12, null, R.attr.progressBarStyleLarge), new FrameLayout.LayoutParams(-2, -2));
        r13.addView(r14, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout r15 = new FrameLayout(r12);
        r15.setId(INTERNAL_LIST_CONTAINER_ID);
        TextView r16 = new TextView(r12);
        r16.setId(INTERNAL_EMPTY_ID);
        r16.setGravity(17);
        r15.addView(r16, new FrameLayout.LayoutParams(-1, -1));
        ListView r17 = new ListView(r12);
        r17.setId(R.id.list);
        r17.setDrawSelectorOnTop(false);
        r15.addView(r17, new FrameLayout.LayoutParams(-1, -1));
        r13.addView(r15, new FrameLayout.LayoutParams(-1, -1));
        r13.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return r13;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mList = null;
        this.mListShown = false;
        this.mListContainer = null;
        this.mProgressContainer = null;
        this.mEmptyView = null;
        this.mStandardEmptyView = null;
        super.onDestroyView();
    }

    public void onListItemClick(@NonNull ListView r5, @NonNull View r10, int r11, long r12) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View r5, @Nullable Bundle r10) {
        super.onViewCreated(r5, r10);
        ensureList();
    }

    @NonNull
    public final ListAdapter requireListAdapter() {
        ListAdapter r5 = getListAdapter();
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new IllegalStateException("ListFragment " + this + " does not have a ListAdapter.");
    }

    public void setEmptyText(@Nullable CharSequence r5) {
        ensureList();
        TextView r10 = this.mStandardEmptyView;
        if (r10 == null) goto L10;
        r10.setText(r5);
        if (this.mEmptyText != null) goto L7;
        this.mList.setEmptyView(this.mStandardEmptyView);
    L7:
        this.mEmptyText = r5;
        return;
    L10:
        throw new IllegalStateException("Can't be used with a custom content view");
    }

    public void setListAdapter(@Nullable ListAdapter r5) {
        boolean r10 = false;
        if (this.mAdapter == null) goto L5;
        boolean r11 = true;
    L6:
        this.mAdapter = r5;
        ListView r12 = this.mList;
        if (r12 == null) goto L16;
        r12.setAdapter(r5);
        if (this.mListShown == true) goto L17;
        if (r11 == false) goto L12;
        return;
    L12:
        if (requireView().getWindowToken() == null) goto L14;
        r10 = true;
    L14:
        setListShown(true, r10);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r11 = false;
        goto L6
    }

    public void setListShown(boolean r5) {
        setListShown(r5, true);
    }

    public void setListShownNoAnimation(boolean r5) {
        setListShown(r5, false);
    }

    public void setSelection(int r5) {
        ensureList();
        this.mList.setSelection(r5);
    }

    private void setListShown(boolean r10, boolean r11) {
        ensureList();
        View r5 = this.mProgressContainer;
        if (r5 == null) goto L19;
        if (this.mListShown != r10) goto L7;
        return;
    L7:
        this.mListShown = r10;
        if (r10 == false) goto L13;
        if (r11 == false) goto L11;
        r5.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
        this.mListContainer.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
    L12:
        this.mProgressContainer.setVisibility(8);
        this.mListContainer.setVisibility(0);
        return;
    L11:
        r5.clearAnimation();
        this.mListContainer.clearAnimation();
        goto L12
    L13:
        if (r11 == false) goto L15;
        r5.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
        this.mListContainer.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
    L16:
        this.mProgressContainer.setVisibility(0);
        this.mListContainer.setVisibility(8);
        return;
    L15:
        r5.clearAnimation();
        this.mListContainer.clearAnimation();
        goto L16
    L19:
        throw new IllegalStateException("Can't be used with a custom content view");
    }
}
