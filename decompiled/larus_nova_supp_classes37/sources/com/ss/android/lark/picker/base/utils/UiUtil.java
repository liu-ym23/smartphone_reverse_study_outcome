package com.ss.android.lark.picker.base.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.lark.pb.basic.v1.Image;
import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.ss.android.lark.export.entity.preview.UDIcon;
import com.ss.android.lark.image.entity.b;
import com.ss.android.lark.image.entity.c;
import com.ss.android.lark.image.entity.e;
import com.ss.android.lark.image.entity.f;
import com.ss.android.lark.image.entity.g;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rz7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/picker/base/utils/UiUtil;", "", "<init>", "()V", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class UiUtil {
    public static final Companion Companion = null;
    private static final int[] rgbList = null;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J2\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002JL\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/ss/android/lark/picker/base/utils/UiUtil$Companion;", "", "<init>", "()V", "getColorResByTagType", "Lcom/larksuite/component/universe_design/tag/UDTagsDrawable$TagColorSet;", "tagType", "", "rgbList", "", "loadImageSet", "", "imageView", "Landroid/widget/ImageView;", "imageSet", "Lcom/bytedance/lark/pb/basic/v1/ImageSet;", "width", "", "height", "aslFileStorage", "Lcom/ss/android/lark/search/dto/userscope/IASLFileStorage;", "isFileExists", "", "localPath", "getTargetShowKey", "loadImage", "context", "Landroid/content/Context;", "udIcon", "Lcom/ss/android/lark/export/entity/preview/UDIcon;", "iconUrl", "imageWidth", "imageHeight", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private final String getTargetShowKey(ImageSet r6) {
            if (r6 == null) goto L44;
            b[] r1 = new b[5];
            Image r3 = r6.thumbnail_webp;
            if (r3 == null) goto L7;
            String r4 = r3.key;
        L8:
            r1[0] = new g(r4);
            Image r5 = r6.thumbnail;
            if (r5 == null) goto L11;
            String r7 = r5.key;
        L12:
            r1[1] = new g(r7);
            Image r8 = r6.middle_webp;
            if (r8 == null) goto L15;
            String r9 = r8.key;
        L16:
            r1[2] = new e(r9);
            Image r10 = r6.middle;
            if (r10 == null) goto L19;
            String r11 = r10.key;
        L20:
            r1[3] = new e(r11);
            Image r12 = r6.origin;
            if (r12 == null) goto L23;
            String r13 = r12.key;
        L24:
            r1[4] = new f(r13);
            ArrayList<b> r2 = CollectionsKt.arrayListOf(r1);
            PickerBaseModuleDependency.IPickerCommonModuleDependency r14 = PickerBaseModuleDependency.getDependency();
            Image r15 = r6.origin;
            if (r15 == null) goto L27;
            String r16 = r15.key;
        L28:
            c r17 = r14.findImageCache("look_large_image", r2, r16);
            if (r17 == null) goto L32;
            String r18 = r17.a;
            if (r18 == null) goto L32;
        L43:
            return r18;
        L32:
            r18 = r6.key;
            if (r18 != null) goto L43;
            Image r19 = r6.thumbnail_webp;
            if (r19 == null) goto L37;
            r18 = r19.key;
        L38:
            if (r18 != null) goto L43;
            Image r20 = r6.thumbnail;
            if (r20 != null) goto L46;
            return null;
        L46:
            return r20.key;
        L37:
            r18 = null;
            goto L38
        L27:
            r16 = null;
            goto L28
        L23:
            r13 = null;
            goto L24
        L19:
            r11 = null;
            goto L20
        L15:
            r9 = null;
            goto L16
        L11:
            r7 = null;
            goto L12
        L7:
            r4 = null;
            goto L8
        L44:
            return null;
        }

        public final UDTagsDrawable.TagColorSet getColorResByTagType(String r3) {
            Intrinsics.checkNotNullParameter(r3, "tagType");
            int r0 = r3.hashCode();
            if (r0 == 66) goto L61;
            if (r0 == 71) goto L57;
            if (r0 == 82) goto L53;
            if (r0 == 87) goto L49;
            if (r0 == 89) goto L45;
            if (r0 == 2500) goto L41;
            if (r0 == 2502) goto L37;
            if (r0 == 2620) goto L33;
            switch(r0) {
                case 78: goto L29;
                case 79: goto L25;
                case 80: goto L21;
                default: goto L75;
            };
        L21:
            if (r3.equals("P") == false) goto L75;
            return UDTagsDrawable.TagColorSet.PURPLE;
        L25:
            if (r3.equals("O") == false) goto L75;
            return UDTagsDrawable.TagColorSet.ORANGE;
        L29:
            if (r3.equals("N") == false) goto L75;
            return UDTagsDrawable.TagColorSet.GRAY;
        L75:
            return UDTagsDrawable.TagColorSet.GRAY;
        L33:
            if (r3.equals("RN") == false) goto L75;
            return UDTagsDrawable.TagColorSet.DARK_GRAY;
        L37:
            if (r3.equals("NT") == false) goto L75;
            return UDTagsDrawable.TagColorSet.THROUGH;
        L41:
            if (r3.equals("NR") == false) goto L75;
            return UDTagsDrawable.TagColorSet.DARK_RAD;
        L45:
            if (r3.equals("Y") == false) goto L75;
            return UDTagsDrawable.TagColorSet.YELLOW;
        L49:
            if (r3.equals("W") == false) goto L75;
            return UDTagsDrawable.TagColorSet.WATHET;
        L53:
            if (r3.equals("R") == false) goto L75;
            return UDTagsDrawable.TagColorSet.RAD;
        L57:
            if (r3.equals("G") == false) goto L75;
            return UDTagsDrawable.TagColorSet.GREEN;
        L61:
            if (r3.equals("B") == false) goto L75;
            return UDTagsDrawable.TagColorSet.BLUE;
        }

        private final boolean isFileExists(String r2, b4c.b r3) {
            VFSPath r4 = r3.c(com.ss.android.lark.storage.f.h, r2);
            if (VFSFiles.b.F(r4).exists() == false) goto L6;
            return true;
        L6:
            return false;
        }

        @JvmStatic
        public final void loadImageSet(final ImageView r17, ImageSet r18, int r19, int r20, b4c.b r21) {
            Intrinsics.checkNotNullParameter(r17, "imageView");
            Intrinsics.checkNotNullParameter(r21, "aslFileStorage");
            String r12 = getTargetShowKey(r18);
            if (r18 == null) goto L8;
            Image r3 = r18.thumbnail_webp;
            if (r3 == null) goto L8;
            List r4 = r3.urls;
            if (r4 == null) goto L8;
        L13:
            boolean r1 = false;
            if (r4 != null) goto L16;
        L18:
            String r5 = "";
        L19:
            String r8 = r5;
            Drawable r6 = UDIconUtils.getIconDrawable(r17.getContext(), 2131255013);
            r6.setTint(r17.getContext().getResources().getColor(2131106616));
            if (Intrinsics.areEqual(r17.getTag(), r8) == false) goto L22;
            final Drawable r7 = r17.getDrawable();
        L23:
            if (r12 != null) goto L25;
        L26:
            r1 = true;
        L27:
            if (r1 == true) goto L30;
            a.a.getEncryptIconLoader().a(r17.getContext(), r12, r19, r20, new UiUtil$Companion$loadImageSet$1(r17, r7));
            r17.setTag(r8);
            return;
        L30:
            if (TextUtils.isEmpty(r8) == false) goto L32;
        L34:
            r17.setImageDrawable(r6);
            return;
        L32:
            if (isFileExists(r8, r21) == false) goto L34;
            PickerBaseModuleDependency.getDependency().loadImage(r17.getContext(), r8, r17, r7, r7, r19, r20);
            r17.setTag(r8);
            return;
        L25:
            if (r12.length() != 0) goto L27;
        L22:
            r7 = r6;
            goto L23
        L16:
            if (r4.size() <= 0) goto L18;
            r5 = (String) ListProtector.get(r4, 0);
        L8:
            if (r18 == null) goto L12;
            Image r2 = r18.thumbnail;
            if (r2 == null) goto L12;
            r4 = r2.urls;
        L12:
            r4 = null;
            goto L13
        }

        public final void loadImage(Context r9, ImageView r10, UDIcon r11, ImageSet r12, String r13, int r14, int r15, b4c.b r16) {
            Intrinsics.checkNotNullParameter(r9, "context");
            Intrinsics.checkNotNullParameter(r10, "imageView");
            Intrinsics.checkNotNullParameter(r16, "aslFileStorage");
            Drawable r6 = UDIconUtils.getIconDrawable(r9, 2131255013);
            r6.setTint(r10.getContext().getResources().getColor(2131106616));
            if (r11 == null) goto L9;
            int r0 = PickerBaseModuleDependency.getDependency().getUDIconByKey(r11.getKey());
            if (r0 <= 0) goto L8;
            r6 = UDIconUtils.getIconDrawable(r9, r0);
            r6.setTint(r10.getContext().getResources().getColor(2131106616));
        L8:
            r10.setImageDrawable(r6);
            return;
        L9:
            if (r12 == null) goto L11;
            loadImageSet(r10, r12, r14, r15, r16);
            return;
        L11:
            if (r13 != null) goto L13;
        L16:
            boolean r1 = true;
        L17:
            if (r1 == true) goto L19;
            PickerBaseModuleDependency.getDependency().loadImage(r9, r13, r10, null, r6, r14, r15);
            return;
        L19:
            r10.setImageDrawable(r6);
            return;
        L13:
            if (r13.length() == 0) goto L16;
            r1 = false;
            goto L17
        }
    }

    public UiUtil() {
    }

    @JvmStatic
    public static final void loadImageSet(ImageView r6, ImageSet r7, int r8, int r9, b4c.b r10) {
        Companion.loadImageSet(r6, r7, r8, r9, r10);
    }

    static {
        Companion = new Companion(null);
        rgbList = new int[]{-15516518, -13405953, -30720, -562844, -8438795, -11971354, -4991488};
    }
}
