package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select;

import com.larus.bot.impl.databinding.LarusItemBotGenBgSelectItemBinding;
import com.larus.common_ui.view.ViewBindingHolder;
import com.larus.utils.w0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0002\r\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/BgSelectViewHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "binding", "Lcom/larus/bot/impl/databinding/LarusItemBotGenBgSelectItemBinding;", "<init>", "(Lcom/larus/bot/impl/databinding/LarusItemBotGenBgSelectItemBinding;)V", "bindData", "", "data", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/BgSelectViewHolder$BgSelectItemData;", "position", "", "showSparklesLottieAnim", "BgSelectItemData", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BgSelectViewHolder extends ViewBindingHolder {
    public static final /* synthetic */ int b = 0;
    public final LarusItemBotGenBgSelectItemBinding a;

    public static final class a {
        public final boolean a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final Integer g;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = r0 * 31;
            String r2 = this.b;
            int r3 = 0;
            if (r2 != null) goto L9;
            int r4 = 0;
        L10:
            int r5 = (r1 + r4) * 31;
            String r6 = this.c;
            if (r6 != null) goto L13;
            int r7 = 0;
        L14:
            int r8 = (r5 + r7) * 31;
            String r9 = this.d;
            if (r9 != null) goto L17;
            int r10 = 0;
        L18:
            int r11 = (r8 + r10) * 31;
            String r12 = this.e;
            if (r12 != null) goto L21;
            int r13 = 0;
        L22:
            int r14 = (r11 + r13) * 31;
            String r15 = this.f;
            if (r15 != null) goto L25;
            int r16 = 0;
        L26:
            int r17 = (r14 + r16) * 31;
            Integer r18 = this.g;
            if (r18 == null) goto L31;
            r3 = r18.hashCode();
        L31:
            return r17 + r3;
        L25:
            r16 = r15.hashCode();
            goto L26
        L21:
            r13 = r12.hashCode();
            goto L22
        L17:
            r10 = r9.hashCode();
            goto L18
        L13:
            r7 = r6.hashCode();
            goto L14
        L9:
            r4 = r2.hashCode();
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "BgSelectItemData(isError=" + this.a + ", previewUrl=" + this.b + ", downloadUrl=" + this.c + ", url=" + this.d + ", uri=" + this.e + ", prompt=" + this.f + ", progress=" + this.g + ')';
        }

        public a(boolean r1, String r2, String r3, String r4, String r5, String r6, Integer r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    public static final class b {
    }

    static {
    }

    public BgSelectViewHolder(LarusItemBotGenBgSelectItemBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        super(r2);
        this.a = r2;
        w0.e(r2.c, c7.b(16));
    }
}
