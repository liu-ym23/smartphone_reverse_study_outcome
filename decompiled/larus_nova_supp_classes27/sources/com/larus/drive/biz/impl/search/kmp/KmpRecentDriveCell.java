package com.larus.drive.biz.impl.search.kmp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.RecentDrivePayload;
import com.bytedance.flow.search.kmp.api.spi.SearchDriveItem;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.impl.sdk.DriveSdkService;
import com.larus.drive.sdk.api.IDriveSdkService;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.extension.aggregate_search_ui.api.BaseSearchListCell;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.utils.e1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import n79.f;
import n79.g;
import v19.b7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/drive/biz/impl/search/kmp/KmpRecentDriveCell;", "Lcom/larus/extension/aggregate_search_ui/api/BaseSearchListCell;", "Lcom/larus/drive/biz/impl/search/kmp/KmpRecentDriveCellState;", "<init>", "()V", "layoutId", "", "getLayoutId", "()I", "iconView", "Landroid/widget/ImageView;", "thumbnailView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "titleView", "Landroid/widget/TextView;", "subtitleView", "currentSourceData", "Lcom/bytedance/flow/search/kmp/api/model/FlowSearchData;", "currentPayload", "Lcom/bytedance/flow/search/kmp/api/model/payload/RecentDrivePayload;", "onViewCreated", "", "view", "Landroid/view/View;", "onBindView", "state", "position", "bindDriveFileIcon", "fileItem", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpRecentDriveCell extends BaseSearchListCell<b> {
    public static final /* synthetic */ int h = 0;
    public final int a;
    public ImageView b;
    public SimpleDraweeView c;
    public TextView d;
    public TextView e;
    public FlowSearchData f;
    public RecentDrivePayload g;

    public static final class a {
    }

    static {
    }

    public KmpRecentDriveCell() {
        this.a = 2131562654;
    }

    public final int getLayoutId() {
        return this.a;
    }

    public final void onViewCreated(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        IOfficeSdkServiceV2 r0 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r0 == null) goto L5;
        IOfficeSdkServiceV2.a.b(r0, false, "kmp_recent_drive_cell", 5);
    L5:
        this.b = (ImageView) r5.findViewById(2131375046);
        this.c = r5.findViewById(2131375047);
        this.d = (TextView) r5.findViewById(2131388486);
        this.e = (TextView) r5.findViewById(2131388485);
        r5.setOnClickListener(new f(this));
    }

    public final void onBindView(View r25, ei9.f r26, int r27) {
        b r1 = (b) r26;
        Intrinsics.checkNotNullParameter(r25, "view");
        Intrinsics.checkNotNullParameter(r1, "state");
        RecentDrivePayload r2 = r1.a;
        this.f = ((ISearchDataPayload) r2).h;
        this.g = r2;
        TextView r3 = this.d;
        ImageView r4 = null;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r3 = null;
    L5:
        r3.setText(r2.i);
        long r5 = RangesKt.coerceAtLeast(r2.l, r2.m);
        TextView r6 = this.e;
        if (r6 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("subtitleView");
        r6 = null;
    L9:
        if (r5 <= 0) goto L11;
        String r7 = b7.a(r5);
    L12:
        r6.setText(r7);
        String r10 = r2.i;
        String r11 = r2.k;
        SearchDriveItem r8 = r2.o;
        if (r8 == null) goto L15;
        String r9 = r8.c;
    L16:
        if (r9 != null) goto L18;
        String r12 = "";
    L19:
        if (r8 == null) goto L21;
        int r13 = r8.d;
    L22:
        if (r8 == null) goto L24;
        String r14 = r8.e;
    L25:
        if (r14 != null) goto L27;
        String r15 = "";
    L28:
        long r16 = r2.l;
        long r17 = r2.m;
        int r18 = r2.n;
        if (r8 == null) goto L31;
        String r20 = r8.h;
    L32:
        if (r20 != null) goto L34;
        String r21 = "";
    L35:
        DriveFileType.a r22 = DriveFileType.Companion;
        String r23 = r2.j;
        r22.getClass();
        DriveFileType r24 = DriveFileType.a.a(r23);
        if (r24 != null) goto L38;
        r24 = DriveFileType.UNKNOWN;
    L38:
        DriveFileType r28 = r24;
        SearchDriveItem r30 = r2.o;
        if (r30 == null) goto L41;
        int r210 = r30.j;
    L42:
        if (r30 == null) goto L44;
        String r211 = r30.k;
    L45:
        DriveFileItem r31 = new DriveFileItem(r10, r11, r12, r13, r15, r16, r17, r18, r21, r28, r210, r211);
        DriveSdkService r32 = DriveSdkService.a;
        ImageView r33 = this.b;
        if (r33 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r33 = null;
    L48:
        r32.F(r31, r33);
        if (r31.j == DriveFileType.IMAGE) goto L51;
    L72:
        View r34 = this.c;
        if (r34 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("thumbnailView");
        r34 = null;
    L75:
        e1.q(r34);
        ImageView r35 = this.b;
        if (r35 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L79:
        e1.x(r4);
        return;
    L78:
        r4 = r35;
        goto L79
    L51:
        if (r31.h() == false) goto L72;
        String r36 = IDriveSdkService.a.b(r32, r31.b, 120, 120);
        if (r36 != null) goto L62;
        View r37 = this.c;
        if (r37 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("thumbnailView");
        r37 = null;
    L57:
        e1.q(r37);
        ImageView r38 = this.b;
        if (r38 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L61:
        e1.x(r4);
        return;
    L60:
        r4 = r38;
        goto L61
    L62:
        View r40 = this.c;
        if (r40 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("thumbnailView");
        r40 = null;
    L65:
        e1.x(r40);
        ImageView r41 = this.b;
        if (r41 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r41 = null;
    L68:
        e1.q(r41);
        GenericDraweeView r42 = this.c;
        if (r42 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("thumbnailView");
        r42 = null;
    L71:
        ImageLoaderKt.v(r42, r36, "aggregate_search_driver", null, new g(this));
        return;
    L44:
        r211 = null;
        goto L45
    L41:
        r210 = 1;
        goto L42
    L34:
        r21 = r20;
        goto L35
    L31:
        r20 = null;
        goto L32
    L27:
        r15 = r14;
        goto L28
    L24:
        r14 = null;
        goto L25
    L21:
        r13 = 0;
        goto L22
    L18:
        r12 = r9;
        goto L19
    L15:
        r9 = null;
        goto L16
    L11:
        r7 = "";
        goto L12
    }
}
