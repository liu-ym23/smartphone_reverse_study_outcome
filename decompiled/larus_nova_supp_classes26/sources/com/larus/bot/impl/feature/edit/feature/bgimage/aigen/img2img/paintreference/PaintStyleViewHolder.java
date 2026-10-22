package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.paintreference;

import android.net.Uri;
import com.larus.bot.impl.databinding.LarusItemBotAvatarPaintStyleBinding;
import com.larus.common_ui.view.ViewBindingHolder;
import com.larus.utils.w0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/paintreference/PaintStyleViewHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "binding", "Lcom/larus/bot/impl/databinding/LarusItemBotAvatarPaintStyleBinding;", "<init>", "(Lcom/larus/bot/impl/databinding/LarusItemBotAvatarPaintStyleBinding;)V", "bindData", "", "data", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/paintreference/PaintStyleViewHolder$PaintStyleViewData;", "PaintStyleViewData", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PaintStyleViewHolder extends ViewBindingHolder {
    public final LarusItemBotAvatarPaintStyleBinding a;

    public static final class a {
        public final Uri a;
        public final String b;
        public final String c;
        public final boolean d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            Uri r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            int r8 = (r6 + r1) * 31;
            if (this.d == false) goto L17;
            int r9 = 1231;
        L19:
            return r8 + r9;
        L17:
            r9 = 1237;
            goto L19
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "PaintStyleViewData(imageUri=" + this.a + ", textStarlingKey=" + this.b + ", text=" + this.c + ", isSelected=" + this.d + ')';
        }

        public static a a(a r3, boolean r4) {
            Uri r0 = r3.a;
            String r1 = r3.b;
            String r2 = r3.c;
            r3.getClass();
            return new a(r0, r1, r2, r4);
        }

        public a(Uri r1, String r2, String r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public PaintStyleViewHolder(LarusItemBotAvatarPaintStyleBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        super(r2);
        this.a = r2;
        w0.e(r2.b, c7.b(14));
    }
}
