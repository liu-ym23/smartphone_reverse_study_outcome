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
        View r10 = getView();
        if (r10 == null) goto L37;
        if ((r10 instanceof ListView) == false) goto L10;
        this.mList = (ListView) r10;
    L28:
        this.mListShown = true;
        this.mList.setOnItemClickListener(this.mOnClickListener);
        ListAdapter r11 = this.mAdapter;
        if (r11 == null) goto L32;
        this.mAdapter = null;
        setListAdapter(r11);
    L34:
        this.mHandler.post(this.mRequestFocus);
        return;
    L32:
        if (this.mProgressContainer == null) goto L34;
        setListShown(false, false);
        goto L34
    L10:
        TextView r12 = (TextView) r10.findViewById(INTERNAL_EMPTY_ID);
        this.mStandardEmptyView = r12;
        if (r12 != null) goto L13;
        this.mEmptyView = r10.findViewById(R.id.empty);
    L14:
        this.mProgressContainer = r10.findViewById(INTERNAL_PROGRESS_CONTAINER_ID);
        this.mListContainer = r10.findViewById(INTERNAL_LIST_CONTAINER_ID);
        View r13 = r10.findViewById(R.id.list);
        if ((r13 instanceof ListView) == false) goto L17;
        ListView r14 = (ListView) r13;
        this.mList = r14;
        View r15 = this.mEmptyView;
        if (r15 == null) goto L25;
    L24:
        r14.setEmptyView(r15);
        goto L28
    L25:
        CharSequence r16 = this.mEmptyText;
        if (r16 == null) goto L28;
        this.mStandardEmptyView.setText(r16);
        r14 = this.mList;
        r15 = this.mStandardEmptyView;
        goto L24
    L17:
        if (r13 != null) goto L21;
        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
    L21:
        throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
    L13:
        r12.setVisibility(8);
        goto L14
    L37:
        throw new IllegalStateException("Content view not yet created");
    }

    private void setListShown(boolean r10, boolean r11) {
        ensureList();
        View r12 = this.mProgressContainer;
        if (r12 == null) goto L19;
        if (this.mListShown != r10) goto L7;
        return;
    L7:
        this.mListShown = r10;
        if (r10 == false) goto L13;
        if (r11 == false) goto L11;
        r12.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
        this.mListContainer.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
    L12:
        this.mProgressContainer.setVisibility(8);
        this.mListContainer.setVisibility(0);
        return;
    L11:
        r12.clearAnimation();
        this.mListContainer.clearAnimation();
        goto L12
    L13:
        if (r11 == false) goto L15;
        r12.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
        this.mListContainer.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
    L16:
        this.mProgressContainer.setVisibility(0);
        this.mListContainer.setVisibility(8);
        return;
    L15:
        r12.clearAnimation();
        this.mListContainer.clearAnimation();
        goto L16
    L19:
        throw new IllegalStateException("Can't be used with a custom content view");
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
    public View onCreateView(@NonNull LayoutInflater r10, @Nullable ViewGroup r11, @Nullable Bundle r12) {
        Context r13 = requireContext();
        FrameLayout r14 = new FrameLayout(r13);
        LinearLayout r15 = new LinearLayout(r13);
        r15.setId(INTERNAL_PROGRESS_CONTAINER_ID);
        r15.setOrientation(1);
        r15.setVisibility(8);
        r15.setGravity(17);
        r15.addView(new ProgressBar(r13, null, R.attr.progressBarStyleLarge), new FrameLayout.LayoutParams(-2, -2));
        r14.addView(r15, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout r16 = new FrameLayout(r13);
        r16.setId(INTERNAL_LIST_CONTAINER_ID);
        TextView r17 = new TextView(r13);
        r17.setId(INTERNAL_EMPTY_ID);
        r17.setGravity(17);
        r16.addView(r17, new FrameLayout.LayoutParams(-1, -1));
        ListView r18 = new ListView(r13);
        r18.setId(R.id.list);
        r18.setDrawSelectorOnTop(false);
        r16.addView(r18, new FrameLayout.LayoutParams(-1, -1));
        r14.addView(r16, new FrameLayout.LayoutParams(-1, -1));
        r14.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return r14;
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

    public void onListItemClick(@NonNull ListView r10, @NonNull View r11, int r12, long r13) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View r10, @Nullable Bundle r11) {
        super.onViewCreated(r10, r11);
        ensureList();
    }

    @NonNull
    public final ListAdapter requireListAdapter() {
        ListAdapter r10 = getListAdapter();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("ListFragment " + this + " does not have a ListAdapter.");
    }

    public void setEmptyText(@Nullable CharSequence r10) {
        ensureList();
        TextView r11 = this.mStandardEmptyView;
        if (r11 == null) goto L10;
        r11.setText(r10);
        if (this.mEmptyText != null) goto L7;
        this.mList.setEmptyView(this.mStandardEmptyView);
    L7:
        this.mEmptyText = r10;
        return;
    L10:
        throw new IllegalStateException("Can't be used with a custom content view");
    }

    public void setListAdapter(@Nullable ListAdapter r10) {
        boolean r11 = false;
        if (this.mAdapter == null) goto L5;
        boolean r12 = true;
    L6:
        this.mAdapter = r10;
        ListView r13 = this.mList;
        if (r13 == null) goto L16;
        r13.setAdapter(r10);
        if (this.mListShown == true) goto L17;
        if (r12 == false) goto L12;
        return;
    L12:
        if (requireView().getWindowToken() == null) goto L14;
        r11 = true;
    L14:
        setListShown(true, r11);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r12 = false;
        goto L6
    }

    public void setListShown(boolean r10) {
        setListShown(r10, true);
    }

    public void setListShownNoAnimation(boolean r10) {
        setListShown(r10, false);
    }

    public void setSelection(int r10) {
        ensureList();
        this.mList.setSelection(r10);
    }
}
