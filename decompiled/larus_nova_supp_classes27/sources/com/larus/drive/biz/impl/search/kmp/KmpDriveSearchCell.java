package com.larus.drive.biz.impl.search.kmp;

import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.DrivePayload;
import com.bytedance.flow.search.kmp.api.spi.SearchDriveItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.impl.sdk.DriveSdkService;
import com.larus.drive.sdk.api.IDriveSdkService;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.extension.aggregate_search_ui.api.BaseSearchListCell;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ei9.f;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import n79.c;
import n79.d;
import v19.b7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/drive/biz/impl/search/kmp/KmpDriveSearchCell;", "Lcom/larus/extension/aggregate_search_ui/api/BaseSearchListCell;", "Lcom/larus/drive/biz/impl/search/kmp/KmpDriveSearchCellState;", "<init>", "()V", "layoutId", "", "getLayoutId", "()I", "iconView", "Landroid/widget/ImageView;", "thumbnailView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "titleView", "Landroid/widget/TextView;", "subtitleView", "currentSourceData", "Lcom/bytedance/flow/search/kmp/api/model/FlowSearchData;", "currentPayload", "Lcom/bytedance/flow/search/kmp/api/model/payload/DrivePayload;", "onViewCreated", "", "view", "Landroid/view/View;", "onBindView", "state", "position", "bindDriveFileIcon", "fileItem", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpDriveSearchCell extends BaseSearchListCell<com.larus.drive.biz.impl.search.kmp.a> {
    public static final Regex h = null;
    public final int a;
    public ImageView b;
    public SimpleDraweeView c;
    public TextView d;
    public TextView e;
    public FlowSearchData f;
    public DrivePayload g;

    public static final class a {
    }

    public static final class b extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ KmpDriveSearchCell a;

        public b(KmpDriveSearchCell r1) {
            this.a = r1;
        }

        public final void onFailure(String r1, Throwable r2) {
            View r3 = this.a.c;
            ImageView r4 = null;
            if (r3 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("thumbnailView");
            r3 = null;
        L5:
            e1.q(r3);
            ImageView r5 = this.a.b;
            if (r5 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
        L9:
            e1.x(r4);
            return;
        L8:
            r4 = r5;
            goto L9
        }
    }

    static {
        h = new Regex("<h>(.*?)</h>");
    }

    public KmpDriveSearchCell() {
        this.a = 2131562647;
    }

    public final int getLayoutId() {
        return this.a;
    }

    public final void b(DriveFileItem r7) {
        DriveSdkService r0 = DriveSdkService.a;
        ImageView r1 = this.b;
        ImageView r3 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r1 = null;
    L5:
        r0.F(r7, r1);
        if (r7.j == DriveFileType.IMAGE) goto L8;
    L29:
        View r8 = this.c;
        if (r8 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("thumbnailView");
        r8 = null;
    L32:
        e1.q(r8);
        ImageView r9 = this.b;
        if (r9 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L36:
        e1.x(r3);
        return;
    L35:
        r3 = r9;
        goto L36
    L8:
        if (r7.h() == false) goto L29;
        String r10 = IDriveSdkService.a.b(r0, r7.b, 120, 120);
        if (r10 != null) goto L19;
        View r11 = this.c;
        if (r11 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("thumbnailView");
        r11 = null;
    L14:
        e1.q(r11);
        ImageView r12 = this.b;
        if (r12 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L18:
        e1.x(r3);
        return;
    L17:
        r3 = r12;
        goto L18
    L19:
        View r2 = this.c;
        if (r2 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("thumbnailView");
        r2 = null;
    L22:
        e1.x(r2);
        ImageView r4 = this.b;
        if (r4 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r4 = null;
    L25:
        e1.q(r4);
        GenericDraweeView r5 = this.c;
        if (r5 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("thumbnailView");
        r5 = null;
    L28:
        ImageLoaderKt.v(r5, r10, "aggregate_search_driver", null, new c(this));
    }

    public final void onViewCreated(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        IOfficeSdkServiceV2 r0 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r0 == null) goto L5;
        IOfficeSdkServiceV2.a.b(r0, false, "kmp_drive_search_cell", 5);
    L5:
        this.b = (ImageView) r5.findViewById(2131377278);
        this.c = r5.findViewById(2131377281);
        this.d = (TextView) r5.findViewById(2131377287);
        this.e = (TextView) r5.findViewById(2131377288);
        r5.setOnClickListener(new d(this));
    }

    public final void onBindView(View r22, f r23, int r24) {
        com.larus.drive.biz.impl.search.kmp.a r0 = (com.larus.drive.biz.impl.search.kmp.a) r23;
        Intrinsics.checkNotNullParameter(r22, "view");
        Intrinsics.checkNotNullParameter(r0, "state");
        DrivePayload r2 = r0.a;
        this.f = ((ISearchDataPayload) r2).h;
        this.g = r2;
        String r5 = r2.i;
        String r6 = r2.o;
        int r8 = r2.r;
        String r9 = r2.p;
        long r12 = r2.n;
        int r14 = r2.u;
        String r15 = r2.v;
        DriveFileType.Companion.getClass();
        DriveFileType r16 = DriveFileType.a.b(r5);
        SearchDriveItem r4 = r2.w;
        if (r4 == null) goto L5;
        int r17 = r4.j;
    L7:
        if (r4 == null) goto L9;
        String r18 = r4.k;
    L52:
        b(new DriveFileItem(r5, r6, "", r8, r9, 0, r12, r14, r15, r16, r17, r18));     // Catch: NullPointerException -> L13
    L15:
        int r7 = 0;
        TypedArray r1 = r22.getContext().obtainStyledAttributes(new int[]{2130972123});
        int r10 = r1.getColor(0, 0);
        r1.recycle();
        TextView r11 = this.d;
        TextView r13 = r11;
        if (r11 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r13 = null;
    L18:
        String r3 = r2.j;
        boolean r20 = StringsKt.isBlank(r3);
        String r21 = r3;
        if (r20 == false) goto L21;
        r21 = r2.i;
    L21:
        Intrinsics.checkNotNullParameter(r21, "text");
        boolean r25 = StringsKt.contains$default(r21, "<h>", false, 2, null);
        CharSequence r26 = r21;
        if (r25 == false) goto L32;
        SpannableStringBuilder r27 = new SpannableStringBuilder();
        Iterator r28 = Regex.findAll$default(h, r21, 0, 2, null).iterator();
    L26:
        if (r28.hasNext() == false) goto L29;
        MatchResult r30 = (MatchResult) r28.next();
        r27.append(r21, r7, r30.getRange().getFirst());
        int r31 = r27.length();
        r27.append((CharSequence) ListProtector.get(r30.getGroupValues(), 1));
        r27.setSpan(new ForegroundColorSpan(r10), r31, r27.length(), 33);
        r7 = r30.getRange().getLast() + 1;
        goto L26
    L29:
        if (r7 >= r21.length()) goto L31;
        r27.append(r21, r7, r21.length());
    L31:
        r26 = r27;
    L32:
        r13.setText(r26);
        TextView r110 = this.e;
        if (r110 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("subtitleView");
        r110 = null;
    L35:
        long r32 = r2.n;
        String r33 = "";
        if (r32 <= 0) goto L38;
        String r34 = b7.a(r32);
    L39:
        String r35 = r2.l;
        if ((!StringsKt.isBlank(r35)) == false) goto L45;
        if ((!StringsKt.isBlank(r34)) == false) goto L45;
        r33 = r35 + " · " + r34;
    L50:
        r110.setText(r33);
        return;
    L45:
        if ((!StringsKt.isBlank(r35)) == false) goto L48;
        r33 = r35;
        goto L50
    L48:
        if ((!StringsKt.isBlank(r34)) == false) goto L50;
        r33 = r34;
        goto L50
    L38:
        r34 = "";
    L13:
        e = move-exception;
        FLogger.a.e("KmpDriverSearchCell", "driver search cell npe icon", e);
        goto L15
    L9:
        r18 = null;
        goto L52
    L5:
        r17 = 1;
        goto L7
    }
}
