package com.larus.slides.impl.select;

import com.larus.common_ui.view.ViewBindingHolder;
import com.larus.slides.biz.impl.databinding.LarusSlidesItemGenerateImageBinding;
import com.larus.utils.w0;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017BN\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012%\b\u0002\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005J\b\u0010\u0015\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R+\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/slides/impl/select/GenerateImageViewHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "binding", "Lcom/larus/slides/biz/impl/databinding/LarusSlidesItemGenerateImageBinding;", "defaultWidth", "", "defaultHeight", "onFinalImageSet", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "<init>", "(Lcom/larus/slides/biz/impl/databinding/LarusSlidesItemGenerateImageBinding;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "Ljava/lang/Integer;", "bindData", "data", "Lcom/larus/slides/impl/select/GenerateImageViewHolder$GenerateImageItemData;", "position", "showSparklesLottieAnim", "GenerateImageItemData", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class GenerateImageViewHolder extends ViewBindingHolder {
    public static final /* synthetic */ int e = 0;
    public final LarusSlidesItemGenerateImageBinding a;
    public final Integer b;
    public final Integer c;
    public final Function1<Boolean, Unit> d;

    public static final class a {
    }

    public static final class b {
        public final boolean a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final Integer g;
        public final Integer h;
        public final Integer i;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
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
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
            return false;
        L35:
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
            if (r18 != null) goto L29;
            int r19 = 0;
        L30:
            int r20 = (r17 + r19) * 31;
            Integer r21 = this.h;
            if (r21 != null) goto L33;
            int r22 = 0;
        L34:
            int r23 = (r20 + r22) * 31;
            Integer r24 = this.i;
            if (r24 == null) goto L39;
            r3 = r24.hashCode();
        L39:
            return r23 + r3;
        L33:
            r22 = r21.hashCode();
            goto L34
        L29:
            r19 = r18.hashCode();
            goto L30
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
            return "GenerateImageItemData(isError=" + this.a + ", previewUrl=" + this.b + ", downloadUrl=" + this.c + ", url=" + this.d + ", uri=" + this.e + ", prompt=" + this.f + ", progress=" + this.g + ", width=" + this.h + ", height=" + this.i + ')';
        }

        public static b a(b r11, Integer r12, Integer r13, Integer r14, int r15) {
            if ((r15 & 1) == 0) goto L5;
            boolean r2 = r11.a;
        L7:
            if ((r15 & 2) == 0) goto L9;
            String r3 = r11.b;
        L11:
            if ((r15 & 4) == 0) goto L13;
            String r4 = r11.c;
        L15:
            if ((r15 & 8) == 0) goto L17;
            String r5 = r11.d;
        L19:
            if ((r15 & 16) == 0) goto L21;
            String r6 = r11.e;
        L23:
            if ((r15 & 32) == 0) goto L25;
            String r7 = r11.f;
        L27:
            if ((r15 & 64) == 0) goto L29;
            r12 = r11.g;
        L29:
            Integer r8 = r12;
            if ((r15 & 128) == 0) goto L32;
            r13 = r11.h;
        L32:
            Integer r9 = r13;
            if ((r15 & 256) == 0) goto L35;
            r14 = r11.i;
        L35:
            r11.getClass();
            return new b(r2, r3, r4, r5, r6, r7, r8, r9, r14);
        L25:
            r7 = null;
            goto L27
        L21:
            r6 = null;
            goto L23
        L17:
            r5 = null;
            goto L19
        L13:
            r4 = null;
            goto L15
        L9:
            r3 = null;
            goto L11
        L5:
            r2 = false;
            goto L7
        }

        public b(boolean r1, String r2, String r3, String r4, String r5, String r6, Integer r7, Integer r8, Integer r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
        }
    }

    static {
    }

    public GenerateImageViewHolder(LarusSlidesItemGenerateImageBinding r2, Integer r3, Integer r4, c r5) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        super(r2);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        w0.e(r2.c, c7.b(16));
    }
}
