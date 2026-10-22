package com.ss.android.lark.filedetail.impl.folder.manage.page.file_list;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import butterknife.BindView;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.filedetail.dto.FolderManageLaunchParams;
import com.ss.android.lark.filedetail.impl.folder.manage.adapter.FileInfoAdapter;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.ChatWindowPtrLoadingHeader;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u009d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010*\u0001@\u0018\u0000 c2\u00020\u0001:\u0004cdefB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020JH\u0002J\b\u0010L\u001a\u00020;H\u0002J\u0012\u0010M\u001a\u00020J2\b\u0010N\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010O\u001a\u00020JH\u0002J\b\u0010P\u001a\u00020JH\u0002J\u0018\u0010Q\u001a\u00020J2\u000e\u0010R\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010SH\u0016J\u0010\u0010U\u001a\u00020J2\u0006\u0010V\u001a\u00020WH\u0016J\u001a\u0010X\u001a\u00020J2\u0006\u0010Y\u001a\u00020;2\b\u0010Z\u001a\u0004\u0018\u00010FH\u0016J \u0010[\u001a\u00020J2\u0006\u0010\\\u001a\u00020W2\u0006\u0010]\u001a\u00020W2\u0006\u0010^\u001a\u00020WH\u0016J\b\u0010_\u001a\u00020JH\u0016J\b\u0010`\u001a\u00020JH\u0016J\u0012\u0010a\u001a\u00020J2\b\u0010b\u001a\u0004\u0018\u00010>H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\u001e\u0010+\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\u001e\u0010.\u001a\u00020/8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bA\u0010BR\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082.¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/FileListView;", "Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/IView;", "mContext", "Landroid/content/Context;", "mDependency", "Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/FileListView$IViewDependency;", "params", "Lcom/ss/android/lark/filedetail/dto/FolderManageLaunchParams;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/FileListView$IViewDependency;Lcom/ss/android/lark/filedetail/dto/FolderManageLaunchParams;)V", "mFileListRv", "Landroidx/recyclerview/widget/RecyclerView;", "getMFileListRv", "()Landroidx/recyclerview/widget/RecyclerView;", "setMFileListRv", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mPtrView", "Lcom/ss/android/lark/widget/ptr/LKUIPtrClassicFrameLayout;", "getMPtrView", "()Lcom/ss/android/lark/widget/ptr/LKUIPtrClassicFrameLayout;", "setMPtrView", "(Lcom/ss/android/lark/widget/ptr/LKUIPtrClassicFrameLayout;)V", "mContentLayout", "Landroid/view/ViewGroup;", "getMContentLayout", "()Landroid/view/ViewGroup;", "setMContentLayout", "(Landroid/view/ViewGroup;)V", "mLoadingLayout", "Landroid/view/View;", "getMLoadingLayout", "()Landroid/view/View;", "setMLoadingLayout", "(Landroid/view/View;)V", "loadingIv", "Landroid/widget/ImageView;", "getLoadingIv", "()Landroid/widget/ImageView;", "setLoadingIv", "(Landroid/widget/ImageView;)V", "mEmptyLayout", "getMEmptyLayout", "setMEmptyLayout", "mEmptyIv", "getMEmptyIv", "setMEmptyIv", "mEmptyHint", "Landroid/widget/TextView;", "getMEmptyHint", "()Landroid/widget/TextView;", "setMEmptyHint", "(Landroid/widget/TextView;)V", "mAdapter", "Lcom/ss/android/lark/filedetail/impl/folder/manage/adapter/FileInfoAdapter;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "gridLayoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "mLoadingStatus", BuildConfig.FLAVOR, "itemLayoutType", "mViewDelegate", "Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/IView$Delegate;", "switchAction", "com/ss/android/lark/filedetail/impl/folder/manage/page/file_list/FileListView$switchAction$2$1", "getSwitchAction", "()Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/FileListView$switchAction$2$1;", "switchAction$delegate", "Lkotlin/Lazy;", "chatId", BuildConfig.FLAVOR, "loadingDrawable", "Lcom/larksuite/component/universe_design/loading/UDLoadingDrawable;", "create", BuildConfig.FLAVOR, "initView", "getSwitchLayoutResId", "switchItemLayout", "view", "initRecyclerView", "initPullToRefresh", "updateFileList", "list", BuildConfig.FLAVOR, "Lcom/ss/android/lark/filedetail/impl/folder/manage/entity/FilePreviewInfo;", "updateTitleBar", "isDownload", BuildConfig.FLAVOR, "showError", "errorCode", "displayMsg", "handleLoadingStatus", "listVisible", "loadingVisible", "emptyVisible", "finishLoadMore", "destroy", "setViewDelegate", "viewDelegate", "Companion", "IViewDependency", "LoadingStatus", "SpaceItemDecoration", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileListView implements j {
    public static final /* synthetic */ int m = 0;
    public final Context a;
    public final b b;
    public final FolderManageLaunchParams c;
    public FileInfoAdapter d;
    public LinearLayoutManager e;
    public GridLayoutManager f;
    public int g;
    public int h;
    public j.a i;
    public final Lazy j;
    public final String k;
    public UDLoadingDrawable l;

    @BindView(9355)
    public ImageView loadingIv;

    @BindView(9182)
    public ViewGroup mContentLayout;

    @BindView(9304)
    public TextView mEmptyHint;

    @BindView(9305)
    public ImageView mEmptyIv;

    @BindView(9357)
    public View mEmptyLayout;

    @BindView(9363)
    public RecyclerView mFileListRv;

    @BindView(9354)
    public View mLoadingLayout;

    @BindView(9940)
    public LKUIPtrClassicFrameLayout mPtrView;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/FileListView$LoadingStatus;", BuildConfig.FLAVOR, "Companion", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface LoadingStatus {
        public static final a Companion = null;
        public static final int HIDE = 1;
        public static final int LOADING_DELAY = 2;
        public static final int UNKNOWN = -1;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/FileListView$SpaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spanCount", BuildConfig.FLAVOR, "margin", "dataProvider", "Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/SpaceItemDataProvider;", "<init>", "(Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/FileListView;IILcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/SpaceItemDataProvider;)V", "getItemOffsets", BuildConfig.FLAVOR, "outRect", "Landroid/graphics/Rect;", "itemPosition", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        public final int a;
        public final int b;
        public final k c;

        public SpaceItemDecoration(int r2, int r3, g r4) {
            Intrinsics.checkNotNullParameter(r4, "dataProvider");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }

        public final void getItemOffsets(Rect r3, int r4, RecyclerView r5) {
            Intrinsics.checkNotNullParameter(r3, "outRect");
            Intrinsics.checkNotNullParameter(r5, "parent");
            if (this.c.a() != 0) goto L5;
            return;
        L5:
            int r0 = this.a;
            int r1 = r4 / r0;
            int r6 = r4 % r0;
            if (r1 != 0) goto L8;
            r3.top = UIUtils.dp2px(r5.getContext(), 20.0f);
        L8:
            int r7 = this.b;
            int r2 = this.a;
            r3.left = r7 - ((r6 * r7) / r2);
            r3.right = ((r6 + 1) * r7) / r2;
        }
    }

    public static final class a {
    }

    public interface b {
        Triple<Long, Integer, Integer> a();

        void b(boolean r1, FileListView$switchAction$2.a r2);

        void c();

        void d(nfb.a r1);

        void e(j r1);
    }

    public static final class c implements Runnable {
        public final /* synthetic */ FileListView a;

        public c(FileListView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FileListView r0 = this.a;     // Catch: Throwable -> L14
            if (r0.g != 2) goto L17;
            CircularProgressDrawable r1 = r0.l;     // Catch: Throwable -> L14
            View r2 = null;
            if (r1 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");     // Catch: Throwable -> L14
            r1 = null;
        L8:
            r1.start();     // Catch: Throwable -> L14
            View r3 = this.a.mLoadingLayout;     // Catch: Throwable -> L14
            if (r3 == null) goto L11;
            r2 = r3;
        L12:
            r2.setVisibility(0);     // Catch: Throwable -> L14
            return;
        L11:
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingLayout");     // Catch: Throwable -> L14
            goto L12
        L17:
            return;
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        }
    }

    static {
    }

    public final void destroy() {
    }

    public final void create() {
        this.b.e(this);
        j.a r0 = this.i;
        if (r0 == null) goto L5;
        int r1 = r0.M();
    L6:
        this.h = r1;
        ChatWindowPtrLoadingHeader r2 = new ChatWindowPtrLoadingHeader(this.a);
        k().setKeepHeaderWhenRefresh(true);
        k().setFooterView(r2);
        k().addPtrUIHandler(r2);
        k().disableWhenHorizontalMove(true);
        k().setPtrHandler(new e(this));
        FileInfoAdapter r3 = new FileInfoAdapter();
        this.d = r3;
        r3.b = this.h;
        f r4 = new f(this);
        Intrinsics.checkNotNullParameter(r4, "listener");
        r3.a = r4;
        this.e = new LinearLayoutManager(this.a, 1, false);
        int r5 = ((Number) this.b.a().getSecond()).intValue();
        int r6 = ((Number) this.b.a().getThird()).intValue();
        this.f = new GridLayoutManager(this.a, r5, 1, false);
        SpaceItemDecoration r7 = new SpaceItemDecoration(r5, r6, new g(this));
        RecyclerView r8 = h();
        Drawable r9 = null;
        if (this.d == null) goto L13;
        zdc.h.b(r8);
        r8.setItemAnimator(null);
        if (this.h != 1) goto L11;
        GridLayoutManager r10 = this.f;
    L12:
        r8.setLayoutManager(r10);
        r8.addItemDecoration(r7);
        r8.setAdapter(this.d);
        goto L13
    L11:
        r10 = this.e;
    L13:
        k();
        h();
        int r11 = DesktopUtil.a;
        UDLoadingDrawable r12 = new UDLoadingDrawable(this.a);
        r12.setColorSchemeColors(new int[]{UIUtils.getColor(this.a, 2131105548)});
        this.l = r12;
        ImageView r13 = this.loadingIv;
        if (r13 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("loadingIv");
        r13 = null;
    L17:
        Drawable r14 = this.l;
        if (r14 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
    L21:
        r13.setImageDrawable(r9);
        return;
    L20:
        r9 = r14;
        goto L21
    L5:
        r1 = 0;
        goto L6
    }

    public final RecyclerView h() {
        RecyclerView r0 = this.mFileListRv;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mFileListRv");
        return null;
    }

    public final LKUIPtrClassicFrameLayout k() {
        LKUIPtrClassicFrameLayout r0 = this.mPtrView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mPtrView");
        return null;
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.j
    public final void n() {
        if (k().isRefreshing() == false) goto L6;
        k().refreshComplete();
        return;
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.j
    public final void J0(List<nfb.a> r5) {
        List<nfb.a> r6 = r5;
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L20;
        ImageView r7 = this.mEmptyIv;
        TextView r3 = null;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyIv");
        r7 = null;
    L14:
        r7.setImageResource(2131238196);
        TextView r8 = this.mEmptyHint;
        if (r8 == null) goto L17;
        r3 = r8;
    L18:
        r3.setText(UIHelper.getString(2131892104));
        T3(false, false, true);
        return;
    L17:
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyHint");
        goto L18
    L20:
        T3(true, false, false);
        FileInfoAdapter r0 = this.d;
        if (r0 == null) goto L24;
        r0.diff(r6);
        return;
    L24:
        return;
    L5:
        if (r6.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.j
    public final void Q5(boolean r3) {
        this.b.b(r3, (FileListView$switchAction$2.a) this.j.getValue());
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        j.a r2 = (j.a) r1;
        if (r2 == null) goto L7;
        this.i = r2;
        return;
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.j
    public final void h6(int r5, String r6) {
        ImageView r0 = this.mEmptyIv;
        TextView r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyIv");
        r0 = null;
    L6:
        r0.setImageResource(2131238189);
        TextView r2 = this.mEmptyHint;
        if (r2 == null) goto L9;
        r1 = r2;
    L11:
        if (r5 != 5607) goto L21;
        if (r6 != null) goto L14;
    L17:
        boolean r3 = true;
    L18:
        if (r3 == true) goto L21;
    L24:
        r1.setText(r6);
        T3(false, false, true);
        return;
    L14:
        if (r6.length() == 0) goto L17;
        r3 = false;
    L21:
        if (com.ss.android.lark.widget.utils.e.a(r5) == false) goto L23;
        this.b.c();
        r6 = UIHelper.getString(2131891433);
        goto L24
    L23:
        r6 = UIHelper.getString(2131891723);
        goto L24
    L9:
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyHint");
        goto L11
    }

    public FileListView(Context r2, FileListFragment.a r3, FolderManageLaunchParams r4) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "mDependency");
        Intrinsics.checkNotNullParameter(r4, "params");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.g = -1;
        this.j = LazyKt.lazy(new FileListView$switchAction$2(this));
        String r5 = r4.j;
        if (r5 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == true) goto L11;
        String r7 = r4.j;
    L12:
        this.k = r7;
        return;
    L11:
        r7 = r4.b;
        goto L12
    L5:
        if (r5.length() == 0) goto L8;
        r6 = false;
        goto L9
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.j
    public final void T3(boolean r6, boolean r7, boolean r8) {
        RecyclerView r0 = h();
        if (r6 == false) goto L5;
        int r9 = 0;
    L6:
        r0.setVisibility(r9);
        View r1 = null;
        if (r7 == false) goto L13;
        this.g = 2;
        View r10 = this.mLoadingLayout;
        if (r10 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingLayout");
        r10 = null;
    L12:
        r10.postDelayed(new c(this), 300);
    L22:
        if (r8 == false) goto L32;
        View r11 = this.mEmptyLayout;
        if (r11 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
        r11 = null;
    L27:
        r11.setVisibility(0);
        View r12 = this.mEmptyLayout;
        if (r12 == null) goto L30;
        r1 = r12;
    L31:
        UIUtils.setViewOnScreenOneThirdPlaceByTranslationY(r1);
        return;
    L30:
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
        goto L31
    L32:
        View r13 = this.mEmptyLayout;
        if (r13 == null) goto L35;
        r1 = r13;
    L36:
        r1.setVisibility(8);
        return;
    L35:
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
        goto L36
    L13:
        CircularProgressDrawable r14 = this.l;
        if (r14 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
        r14 = null;
    L16:
        r14.stop();
        View r15 = this.mLoadingLayout;
        if (r15 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingLayout");
        r15 = null;
    L20:
        r15.setVisibility(8);
        this.g = 1;
        goto L22
    L5:
        r9 = 8;
        goto L6
    }
}
