package com.ss.android.lark.picker.base.view.avatar;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bytedance.lark.pb.basic.v1.Doc;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchOpenSearchInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.search.dto.info.SearchWikiInfo;
import com.ss.android.lark.utils.UIHelper;
import j08.b;
import kac.a;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import uz7.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\u0012\u0010\u000f\u001a\u00020\u000e*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"TAG", "", "dp", "", "", "context", "Landroid/content/Context;", "dpF", "bindExternalTargetAvatar", "", "Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", "data", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "bindCCMAvatar", "", "bindOpenSearchAvatar", "Lcom/ss/android/lark/search/dto/info/SearchOpenSearchInfo;", "picker-base_release"}, k = 2, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class AvatarHelperKt {
    private static final String TAG = "SearcherAvatar";

    public static final void bindCCMAvatar(LarkAvatarView r5, SearchBaseInfo r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "data");
    L26:
        th = move-exception;
        Log.e(TAG, th.getMessage(), th);
        r5.setImageDrawable(UDIconUtils.getIconDrawable(r5.getContext(), a.b(2131237841)));
        return;
    L4:
        if ((r6 instanceof SearchSpaceInfo) == false) goto L10;
        if (((SearchSpaceInfo) r6).getDocType() != Doc.Type.FOLDER) goto L10;
        int r7 = PickerBaseModuleDependency.getDependency().getFolderIcon(((SearchSpaceInfo) r6).getIsShareFolder().booleanValue());     // Catch: Throwable -> L26
        d.a r0 = new d.a();     // Catch: Throwable -> L26
        r0.d(r7);     // Catch: Throwable -> L26
        r5.j(new d(r0));     // Catch: Throwable -> L26
        return;
    L10:
        if ((r6 instanceof SearchWikiInfo) == false) goto L13;
        Pair r8 = TuplesKt.to(((SearchWikiInfo) r6).getSpaceInfo(), ((SearchWikiInfo) r6).getUrl());     // Catch: Throwable -> L26
    L16:
        SearchSpaceInfo r1 = (SearchSpaceInfo) r8.component1();     // Catch: Throwable -> L26
        String r9 = (String) r8.component2();     // Catch: Throwable -> L26
        tz7.a.a r2 = new tz7.a.a();     // Catch: Throwable -> L26
        if (r1 == null) goto L24;
        if (r9 == null) goto L24;
        Intrinsics.checkNotNullParameter(r9, "url");     // Catch: Throwable -> L26
        r2.k = r9;     // Catch: Throwable -> L26
        if (r1.getDocType() != Doc.Type.SHORTCUT) goto L22;
        Boolean r10 = Boolean.TRUE;     // Catch: Throwable -> L26
    L23:
        obb.a r3 = new obb.a(r10, r1.getIsShareFolder(), null);     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r3, "container");     // Catch: Throwable -> L26
        r2.n = r3;     // Catch: Throwable -> L26
        String r11 = r1.getIconInfo();     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r11, AppbrandHostConstants.Schema_RESERVED_FIELD.META);     // Catch: Throwable -> L26
        r2.l = r11;     // Catch: Throwable -> L26
        goto L24
    L22:
        r10 = null;
    L24:
        r5.j(new tz7.a(r2));     // Catch: Throwable -> L26
        return;
    L13:
        if ((r6 instanceof SearchSpaceInfo) == false) goto L15;
        r8 = TuplesKt.to(r6, ((SearchSpaceInfo) r6).getDocUrl());     // Catch: Throwable -> L26
        goto L16
    L15:
        r8 = TuplesKt.to(null, null);     // Catch: Throwable -> L26
        goto L16
    }

    public static final boolean bindExternalTargetAvatar(LarkAvatarView r2, SearchBaseInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "data");
        ExternalTargetAvatarProviderStore r0 = ExternalTargetAvatarProviderStore.INSTANCE;
        if (r0.requiresProvider(r3) == true) goto L6;
        return false;
    L6:
        r2.l(null);
        Drawable r1 = r0.createDrawableOrNull();
        if (r1 != null) goto L10;
        r2.m(uz7.a.class);
        r2.setImageDrawable(null);
        return true;
    L10:
        uz7.a.a r4 = new uz7.a.a();
        r4.e(r1);
        r2.j(new uz7.a(r4));
        return true;
    }

    public static final void bindOpenSearchAvatar(LarkAvatarView r11, SearchOpenSearchInfo r12) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "data");
        String r0 = r12.getTitle();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        String r3 = r12.getTitle().substring(0, 1);
    L12:
        String r5 = r12.getImageUrl();
        if (r5 == null) goto L18;
        if ((!StringsKt.isBlank(r5)) != true) goto L18;
        r1 = true;
    L18:
        if (r1 == false) goto L25;
        Context r4 = r11.getContext();
        if (r4 == null) goto L32;
        Drawable r6 = UIHelper.getDrawable(2131238420);
        if (StringsKt.isBlank(r3) == true) goto L24;
        r6 = new BitmapDrawable(r4.getResources(), FakePickerAvatarCreator.createNameAvatarBitmap(dp(48.0f, r4), dp(48.0f, r4), r3, UIHelper.getColor(2131108721)));
    L24:
        Drawable r8 = r6;
        PickerBaseModuleDependency.getDependency().loadImage(r4, r5, r11, r8, r8, dp(48.0f, r4), dp(48.0f, r4));
        return;
    L32:
        return;
    L25:
        Context r7 = r11.getContext();
        if (r7 == null) goto L34;
        Drawable r9 = UIHelper.getDrawable(2131238420);
        if (StringsKt.isBlank(r3) == true) goto L30;
        r9 = new BitmapDrawable(r7.getResources(), FakePickerAvatarCreator.createNameAvatarBitmap(dp(48.0f, r7), dp(48.0f, r7), r3, UIHelper.getColor(2131108721)));
    L30:
        r11.setImageDrawable(r9);
        return;
    L34:
        return;
    L11:
        r3 = "";
        goto L12
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r2 = false;
        goto L9
    }

    public static final int dp(float r1, Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return (int) dpF(r1, r2);
    }

    public static final float dpF(float r1, Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return b.a(r2, r1);
    }
}
