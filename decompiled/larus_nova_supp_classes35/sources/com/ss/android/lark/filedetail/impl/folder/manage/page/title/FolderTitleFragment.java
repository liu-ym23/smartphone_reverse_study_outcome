package com.ss.android.lark.filedetail.impl.folder.manage.page.title;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.breadcrumb.UDBreadcrumb;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.chat.constant.ChatFromType;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.filedetail.FileDetailModule;
import com.ss.android.lark.filedetail.dto.FolderManageLaunchParams;
import com.ss.android.lark.filedetail.impl.folder.manage.entity.FileType;
import com.ss.android.lark.filedetail.impl.folder.manage.page.FolderManageActivity;
import com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.FileListView$switchAction$2;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.suite.lark.emm.design.edittext.SCEditText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u001e\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001HB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ&\u0010#\u001a\u0004\u0018\u00010\u00122\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010*\u001a\u00020+2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010,\u001a\u00020+H\u0002J\b\u0010-\u001a\u00020+H\u0002J\b\u0010.\u001a\u00020\u0014H\u0002J\b\u0010/\u001a\u00020+H\u0002J\b\u00100\u001a\u00020+H\u0002J\b\u00101\u001a\u00020+H\u0002J\b\u00102\u001a\u00020+H\u0002J\u0010\u00103\u001a\u00020+2\u0006\u00104\u001a\u000205H\u0002J\u0018\u00106\u001a\u00020+2\u0006\u0010\u0017\u001a\u00020\u00142\b\u00107\u001a\u0004\u0018\u000108J\u0006\u00109\u001a\u00020+J\u000e\u0010:\u001a\u00020+2\u0006\u0010;\u001a\u00020\u001aJ\b\u0010<\u001a\u0004\u0018\u00010\u001aJ\b\u0010=\u001a\u00020\u0014H\u0016J\u0010\u0010>\u001a\u00020+2\u0006\u0010;\u001a\u00020\u001aH\u0002J0\u0010?\u001a\u00020+2\u0006\u0010@\u001a\u00020A2\u001e\u0010B\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020D\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0E0C0\u0019H\u0002J\u0010\u0010F\u001a\u00020+2\u0006\u0010;\u001a\u00020\u001aH\u0002J\u0010\u0010G\u001a\u00020+2\u0006\u0010;\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 ¨\u0006I"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/page/title/FolderTitleFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/ss/android/lark/filedetail/impl/folder/manage/page/IFolderFragment;", "params", "Lcom/ss/android/lark/filedetail/dto/FolderManageLaunchParams;", "dependency", "Lcom/ss/android/lark/filedetail/impl/folder/manage/page/title/ITitleDependency;", "<init>", "(Lcom/ss/android/lark/filedetail/dto/FolderManageLaunchParams;Lcom/ss/android/lark/filedetail/impl/folder/manage/page/title/ITitleDependency;)V", "titleBar", "Lcom/ss/android/lark/ui/CommonTitleBar;", "searchEt", "Lcom/suite/lark/emm/design/edittext/SCEditText;", "breadcrumb", "Lcom/larksuite/component/universe_design/breadcrumb/UDBreadcrumb;", "singleFolderNameTv", "Landroid/widget/TextView;", "divider", "Landroid/view/View;", "isShowSearch", BuildConfig.FLAVOR, "isShowForward", "isShowJumpToChat", "isShowDownload", "breadcrumbList", BuildConfig.FLAVOR, "Lcom/ss/android/lark/filedetail/impl/folder/manage/entity/FilePreviewInfo;", "chatId", BuildConfig.FLAVOR, "moreAction", "com/ss/android/lark/filedetail/impl/folder/manage/page/title/FolderTitleFragment$moreAction$2$1", "getMoreAction", "()Lcom/ss/android/lark/filedetail/impl/folder/manage/page/title/FolderTitleFragment$moreAction$2$1;", "moreAction$delegate", "Lkotlin/Lazy;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityCreated", BuildConfig.FLAVOR, "initView", "setActionVisibility", "isHideActionInMessageLinkCard", "initTitleBar", "initSearchEt", "initBreadcrumb", "onChangeBreadcrumb", "backToFolder", "position", BuildConfig.FLAVOR, "updateTitleBar", "extraAction", "Lcom/ss/android/lark/ui/IActionTitlebar$Action;", "change2SimpleTitleBar", "addItemToBreadcrumb", Keys.API_RETURN_KEY_DATA, "getCurFilePreviewInfo", "onBackPressed", "generateDialog", "showActionDialog", "context", "Landroid/content/Context;", "itemList", "Lkotlin/Pair;", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogBuilder$ListItemBuilder;", "Lkotlin/Function0;", "doJumpToChat", "doForward", "Companion", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderTitleFragment extends BaseFragment implements com.ss.android.lark.filedetail.impl.folder.manage.page.c {
    public static final /* synthetic */ int r = 0;
    public final FolderManageLaunchParams d;
    public final e e;
    public CommonTitleBar f;
    public SCEditText g;
    public UDBreadcrumb h;
    public TextView i;
    public View j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public List<nfb.a> o;
    public final String p;
    public final Lazy q;

    public static final class a {
    }

    static {
    }

    public final void U90() {
        CommonTitleBar r0 = this.f;
        CommonTitleBar r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r0 = null;
    L5:
        r0.removeAllActions();
        EditText r1 = this.g;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("searchEt");
        r1 = null;
    L8:
        r1.setVisibility(8);
        FrameLayout r3 = this.h;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("breadcrumb");
        r3 = null;
    L11:
        r3.setVisibility(8);
        TextView r4 = this.i;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("singleFolderNameTv");
        r4 = null;
    L14:
        r4.setVisibility(8);
        View r5 = this.j;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("divider");
        r5 = null;
    L17:
        r5.setVisibility(8);
        CommonTitleBar r6 = this.f;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
    L21:
        r2.setTitle(BuildConfig.FLAVOR);
        return;
    L20:
        r2 = r6;
        goto L21
    }

    public final void V90() {
        int r1 = 0;
        boolean r2 = true;
        if (this.o.size() > 1) goto L6;
        r2 = false;
    L6:
        FrameLayout r0 = this.h;
        TextView r3 = null;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("breadcrumb");
        r0 = null;
    L10:
        if (r2 == false) goto L12;
        int r5 = 0;
    L13:
        r0.setVisibility(r5);
        TextView r4 = this.i;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("singleFolderNameTv");
    L17:
        if (r2 == false) goto L19;
        r1 = 8;
    L19:
        r3.setVisibility(r1);
        return;
    L16:
        r3 = r4;
        goto L17
    L12:
        r5 = 8;
        goto L13
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.c
    public final boolean onBackPressed() {
        if (((ArrayList) this.o).size() > 1) goto L6;
        return false;
    L6:
        T90(CollectionsKt.getLastIndex(this.o) - 1);
        return true;
    }

    public final void T90(int r4) {
        if (this.o.size() > r4) goto L5;
        return;
    L5:
        int r5 = r4 + 1;
        UDBreadcrumb r0 = this.h;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("breadcrumb");
        r0 = null;
    L8:
        r0.c(r5);
        this.o = new ArrayList(this.o.subList(0, r5));
        V90();
        this.e.a((nfb.a) CollectionsKt.last(this.o));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onActivityCreated(Bundle r6) {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onActivityCreated(r6);
        FolderManageLaunchParams r7 = this.d;
        int r0 = r7.e;
        int r2 = 0;
        if (r0 != 4) goto L5;
        this.k = false;
        this.m = false;
    L16:
        if (this.n == true) goto L18;
    L20:
        boolean r1 = false;
    L21:
        this.n = r1;
        String r8 = r7.s;
        if (r8 != null) goto L24;
    L27:
        boolean r9 = true;
    L28:
        boolean r10 = !r9;
        if (this.l == true) goto L31;
    L34:
        boolean r3 = false;
    L35:
        this.l = r3;
        if (this.m == false) goto L39;
        if (r10 == true) goto L39;
        boolean r4 = true;
    L40:
        this.m = r4;
        if (this.k == false) goto L44;
        if (r10 == true) goto L44;
        boolean r11 = true;
    L45:
        this.k = r11;
        CommonTitleBar r12 = this.f;
        UDBreadcrumb r5 = null;
        if (r12 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r12 = null;
    L48:
        r12.setTitle(2131891739);
        r12.setLeftClickListener(new c(this));
        EditText r13 = this.g;
        if (r13 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("searchEt");
        r13 = null;
    L52:
        if (this.k == true) goto L55;
        r2 = 8;
    L55:
        r13.setVisibility(r2);
        EditText r14 = this.g;
        if (r14 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("searchEt");
        r14 = null;
    L58:
        r14.setOnClickListener(new b(this));
        if (this.d.r != 1) goto L61;
        FileType r15 = FileType.FOLDER;
    L62:
        nfb.a.C0266a r16 = new nfb.a.C0266a();
        String r17 = this.d.h;
        Intrinsics.checkNotNullParameter(r17, IPortraitService.NAME);
        r16.c = r17;
        String r18 = this.d.g;
        Intrinsics.checkNotNullParameter(r18, "key");
        r16.a = r18;
        FolderManageLaunchParams r19 = this.d;
        r16.d = r19.n;
        r16.k = r19.s;
        r16.l = r19.t;
        Intrinsics.checkNotNullParameter(r15, IPortraitService.TYPE);
        r16.b = r15;
        nfb.a r20 = r16.a();
        this.e.a(r20);
        UDBreadcrumb r21 = this.h;
        if (r21 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("breadcrumb");
        r21 = null;
    L65:
        r21.setItems(CollectionsKt.listOf(r20.c));
        ((ArrayList) this.o).add(r20);
        TextView r22 = this.i;
        if (r22 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("singleFolderNameTv");
        r22 = null;
    L68:
        r22.setText(r20.c);
        V90();
        UDBreadcrumb r23 = this.h;
        if (r23 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("breadcrumb");
    L72:
        r5.setOnItemClickListener(new com.ss.android.lark.filedetail.impl.folder.manage.page.title.a(this));
        return;
    L71:
        r5 = r23;
        goto L72
    L61:
        r15 = FileType.FILE;
    L44:
        r11 = false;
    L39:
        r4 = false;
        goto L40
    L31:
        if (this.d.q == false) goto L34;
        if (r10 == true) goto L34;
        r3 = true;
        goto L35
    L24:
        if (r8.length() == 0) goto L27;
        r9 = false;
        goto L28
    L18:
        if (r7.p == false) goto L20;
        r1 = true;
        goto L21
    L5:
        if (r0 != 5) goto L7;
        this.k = false;
        this.l = true;
        this.m = false;
        goto L16
    L7:
        if (r0 != 6) goto L9;
        this.k = false;
        goto L16
    L9:
        if (r0 != 9) goto L16;
        this.k = false;
        this.m = false;
        goto L16
    }

    public FolderTitleFragment(FolderManageLaunchParams r2, FolderManageActivity.b r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "dependency");
        this.d = r2;
        this.e = r3;
        boolean r4 = true;
        this.k = true;
        this.l = true;
        this.m = true;
        this.o = new ArrayList();
        String r0 = r2.j;
        if (r0 != null) goto L5;
    L8:
        if (r4 == true) goto L10;
        String r5 = r2.j;
    L11:
        this.p = r5;
        this.q = LazyKt.lazy(new FolderTitleFragment$moreAction$2(this));
        return;
    L10:
        r5 = r2.b;
        goto L11
    L5:
        if (r0.length() == 0) goto L8;
        r4 = false;
        goto L8
    }

    public static final void S90(FolderTitleFragment r10, nfb.a r11) {
        Message r0 = r10.d.m;
        if (r0 != null) goto L10;
        com.ss.android.lark.storage.a r1 = FileDetailModule.a;
        hfb.b r2 = FileDetailModule.a.a();
        if (r2 == null) goto L9;
        hfb.b.d r3 = r2.getChatDependency();
        if (r3 == null) goto L9;
        String r4 = r10.d.a;
        r3.d();
    L9:
        r0 = null;
    L10:
        if (r0 == null) goto L12;
        r0.getRootId();
    L12:
        com.ss.android.lark.storage.a r5 = FileDetailModule.a;
        hfb.b r6 = FileDetailModule.a.a();
        if (r6 == null) goto L18;
        hfb.b.d r7 = r6.getChatDependency();
        if (r7 == null) goto L18;
        r7.d();
    L18:
        if (r0 != null) goto L20;
    L22:
        boolean r8 = false;
    L23:
        if (r8 == true) goto L43;
        if (r0 == null) goto L29;
        if (r0.isReplyInThreadChildMessage() == true) goto L29;
    L29:
        int r9 = pfb.d.a;
        pfb.d.a.f(r10.p, ChatFromType.FORWARD, "none", pfb.d.a.a(r11.getType(), r11.c, r11.d));
        nfb.a r12 = (nfb.a) CollectionsKt.lastOrNull(r10.o);
        if (r12 != null) goto L32;
        return;
    L32:
        if (TextUtils.isEmpty(r10.d.v) == false) goto L34;
        String r13 = r10.d.a;
    L35:
        String r14 = r13;
        if (r14 == null) goto L42;
        int r15 = com.ss.android.lark.filedetail.impl.detail.templatefactory.b.a;
        Context r16 = r10.requireContext();
        String r17 = r12.a;
        String r18 = r12.c;
        long r19 = r12.d;
        if (r12.getType() != FileType.FOLDER) goto L40;
        boolean r20 = true;
    L41:
        com.ss.android.lark.filedetail.impl.detail.templatefactory.b.a(r16, r17, r18, r19, r20, r14);
        return;
    L40:
        r20 = false;
        goto L41
    L42:
        Log.e("FolderTitleFragment", "forward messageId is invalid!");
        return;
    L34:
        r13 = r10.d.v;
        goto L35
    L43:
        LKUIToast.show(((BaseFragment) r10).mContext, 2131891223);
        return;
    L20:
        if (r0.isRestricted() != true) goto L22;
        r8 = true;
        goto L23
    }

    public final void W90(boolean r9, FileListView$switchAction$2.a r10) {
        boolean r0 = false;
        if (r9 == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        this.n = r2;
        if (r9 == false) goto L11;
    L16:
        boolean r11 = true;
    L17:
        if (r10 == null) goto L19;
        boolean r3 = true;
    L20:
        CommonTitleBar r4 = this.f;
        CommonTitleBar r5 = null;
        if (r4 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r4 = null;
    L24:
        if (r4.getViewByAction((FolderTitleFragment$moreAction$2.a) this.q.getValue()) == null) goto L26;
        boolean r6 = true;
    L27:
        if (r10 == null) goto L34;
        CommonTitleBar r7 = this.f;
        if (r7 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r7 = null;
    L32:
        if (r7.getViewByAction(r10) != null) goto L46;
    L47:
        if (r11 != r6) goto L50;
        if (r3 != r0) goto L50;
        return;
    L50:
        CommonTitleBar r1 = this.f;
        if (r1 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
    L54:
        r5.removeAllActions();
        if (r10 == null) goto L57;
        r5.addAction(r10);
    L57:
        if (r11 == false) goto L60;
        r5.addAction((FolderTitleFragment$moreAction$2.a) this.q.getValue());
        return;
    L60:
        return;
    L53:
        r5 = r1;
    L46:
        r0 = true;
        goto L47
    L34:
        if (r6 == false) goto L41;
        CommonTitleBar r8 = this.f;
        if (r8 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r8 = null;
    L39:
        if (r8.getActionCount() < 2) goto L47;
    L41:
        CommonTitleBar r12 = this.f;
        if (r12 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r12 = null;
    L45:
        if (r12.getActionCount() < 1) goto L47;
    L26:
        r6 = false;
        goto L27
    L19:
        r3 = false;
        goto L20
    L11:
        if (this.m == true) goto L16;
        if (this.l == true) goto L16;
        r11 = false;
        goto L17
    L5:
        if (this.d.p == false) goto L7;
        r2 = true;
        goto L8
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131561200, r3, false);
        this.f = r5.findViewById(2131388928);
        this.g = r5.findViewById(2131385429);
        this.h = r5.findViewById(2131373075);
        this.i = (TextView) r5.findViewById(2131381931);
        this.j = r5.findViewById(2131392112);
        return r5;
    }
}
