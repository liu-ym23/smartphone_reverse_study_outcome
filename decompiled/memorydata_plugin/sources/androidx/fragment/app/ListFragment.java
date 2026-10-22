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
import com.volcengine.zeus.transform.ZeusTransformUtils;

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
        View r0 = getView();
        if (r0 == null) goto L37;
        if (ZeusTransformUtils.instanceOf(r0, ListView.class) == false) goto L10;
        this.mList = (ListView) ZeusTransformUtils.preCheckCast(r0, ListView.class, "com.obric.memorydata.plugin");
    L28:
        this.mListShown = true;
        this.mList.setOnItemClickListener(this.mOnClickListener);
        ListAdapter r1 = this.mAdapter;
        if (r1 == null) goto L32;
        this.mAdapter = null;
        setListAdapter(r1);
    L34:
        this.mHandler.post(this.mRequestFocus);
        return;
    L32:
        if (this.mProgressContainer == null) goto L34;
        setListShown(false, false);
        goto L34
    L10:
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(r0.findViewById(INTERNAL_EMPTY_ID), TextView.class, "com.obric.memorydata.plugin");
        this.mStandardEmptyView = r2;
        if (r2 != null) goto L13;
        this.mEmptyView = r0.findViewById(R.id.empty);
    L14:
        this.mProgressContainer = r0.findViewById(INTERNAL_PROGRESS_CONTAINER_ID);
        this.mListContainer = r0.findViewById(INTERNAL_LIST_CONTAINER_ID);
        View r3 = r0.findViewById(R.id.list);
        if (ZeusTransformUtils.instanceOf(r3, ListView.class) == false) goto L17;
        ListView r4 = (ListView) ZeusTransformUtils.preCheckCast(r3, ListView.class, "com.obric.memorydata.plugin");
        this.mList = r4;
        View r5 = this.mEmptyView;
        if (r5 == null) goto L25;
    L24:
        r4.setEmptyView(r5);
        goto L28
    L25:
        CharSequence r6 = this.mEmptyText;
        if (r6 == null) goto L28;
        this.mStandardEmptyView.setText(r6);
        r4 = this.mList;
        r5 = this.mStandardEmptyView;
        goto L24
    L17:
        if (r3 != null) goto L21;
        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
    L21:
        throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
    L13:
        r2.setVisibility(8);
        goto L14
    L37:
        throw new IllegalStateException("Content view not yet created");
    }

    private void setListShown(boolean r7, boolean r8) {
        ensureList();
        View r0 = this.mProgressContainer;
        if (r0 == null) goto L19;
        if (this.mListShown != r7) goto L7;
        return;
    L7:
        this.mListShown = r7;
        if (r7 == false) goto L13;
        if (r8 == false) goto L11;
        r0.startAnimation(AnimationUtils.loadAnimation((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), R.anim.fade_out));
        this.mListContainer.startAnimation(AnimationUtils.loadAnimation((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), R.anim.fade_in));
    L12:
        this.mProgressContainer.setVisibility(8);
        this.mListContainer.setVisibility(0);
        return;
    L11:
        r0.clearAnimation();
        this.mListContainer.clearAnimation();
        goto L12
    L13:
        if (r8 == false) goto L15;
        r0.startAnimation(AnimationUtils.loadAnimation((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), R.anim.fade_in));
        this.mListContainer.startAnimation(AnimationUtils.loadAnimation((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), R.anim.fade_out));
    L16:
        this.mProgressContainer.setVisibility(0);
        this.mListContainer.setVisibility(8);
        return;
    L15:
        r0.clearAnimation();
        this.mListContainer.clearAnimation();
        goto L16
    L19:
        throw new IllegalStateException("Can't be used with a custom content view");
    }

    public ListAdapter getListAdapter() {
        return this.mAdapter;
    }

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
    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        FrameLayout r7 = new FrameLayout(r3);
        LinearLayout r8 = new LinearLayout(r3);
        r8.setId(INTERNAL_PROGRESS_CONTAINER_ID);
        r8.setOrientation(1);
        r8.setVisibility(8);
        r8.setGravity(17);
        r8.addView(new ProgressBar(r3, null, R.attr.progressBarStyleLarge), new FrameLayout.LayoutParams(-2, -2));
        r7.addView(r8, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout r9 = new FrameLayout(r3);
        r9.setId(INTERNAL_LIST_CONTAINER_ID);
        TextView r0 = new TextView(r3);
        r0.setId(INTERNAL_EMPTY_ID);
        r0.setGravity(17);
        r9.addView(r0, new FrameLayout.LayoutParams(-1, -1));
        ListView r10 = new ListView(r3);
        r10.setId(R.id.list);
        r10.setDrawSelectorOnTop(false);
        r9.addView(r10, new FrameLayout.LayoutParams(-1, -1));
        r7.addView(r9, new FrameLayout.LayoutParams(-1, -1));
        r7.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return r7;
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

    public void onListItemClick(ListView r1, View r2, int r3, long r4) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        ensureList();
    }

    public final ListAdapter requireListAdapter() {
        ListAdapter r0 = getListAdapter();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("ListFragment " + this + " does not have a ListAdapter.");
    }

    public void setEmptyText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        ensureList();
        TextView r0 = this.mStandardEmptyView;
        if (r0 == null) goto L10;
        r0.setText(r4);
        if (this.mEmptyText != null) goto L7;
        this.mList.setEmptyView(this.mStandardEmptyView);
    L7:
        this.mEmptyText = r4;
        return;
    L10:
        throw new IllegalStateException("Can't be used with a custom content view");
    }

    public void setListAdapter(ListAdapter r5) {
        ListAdapter r6 = (ListAdapter) ZeusTransformUtils.wrapperContextForParams(r5, ListAdapter.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        if (this.mAdapter == null) goto L5;
        boolean r0 = true;
    L6:
        this.mAdapter = r6;
        ListView r3 = this.mList;
        if (r3 == null) goto L16;
        r3.setAdapter(r6);
        if (this.mListShown == true) goto L17;
        if (r0 == false) goto L12;
        return;
    L12:
        if (requireView().getWindowToken() == null) goto L14;
        r1 = true;
    L14:
        setListShown(true, r1);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void setListShown(boolean r2) {
        setListShown(r2, true);
    }

    public void setListShownNoAnimation(boolean r2) {
        setListShown(r2, false);
    }

    public void setSelection(int r1) {
        ensureList();
        this.mList.setSelection(r1);
    }
}
