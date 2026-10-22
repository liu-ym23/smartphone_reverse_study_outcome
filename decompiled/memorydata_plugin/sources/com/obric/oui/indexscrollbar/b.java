package com.obric.oui.indexscrollbar;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR&\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/indexscrollbar/LBLetter;", "", "type", "", "letter", "", "letterBitmaps", "", "Landroid/graphics/Bitmap;", "(ILjava/lang/String;[Landroid/graphics/Bitmap;)V", "getLetter", "()Ljava/lang/String;", "getLetterBitmaps", "()[Landroid/graphics/Bitmap;", "setLetterBitmaps", "([Landroid/graphics/Bitmap;)V", "[Landroid/graphics/Bitmap;", "getType", "()I", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13915a = null;
    private static b e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13916b;
    private final String c;
    private Bitmap[] d;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012J#\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00122\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/indexscrollbar/LBLetter$Companion;", "", "()V", "ICON_STATUS_HOLDER", "", "ICON_STATUS_NORMAL", "ICON_STATUS_TOUCHED", "POUND", "Lcom/obric/oui/indexscrollbar/LBLetter;", "getPOUND", "()Lcom/obric/oui/indexscrollbar/LBLetter;", "setPOUND", "(Lcom/obric/oui/indexscrollbar/LBLetter;)V", "TYPE_LETTER", "TYPE_LOCALE_LETTER", "TYPE_SYMBOL", "fromLetter", "letter", "", "fromLocaleLetter", "fromSymbol", "symbol", "letterBitmaps", "", "Landroid/graphics/Bitmap;", "(Ljava/lang/String;[Landroid/graphics/Bitmap;)Lcom/obric/oui/indexscrollbar/LBLetter;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final b a() {
            return b.c();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final b a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "letter");
            return new b(0, r3, null, 0 == true ? 1 : 0);
        }

        public final b a(String r3, Bitmap[] r4) {
            Intrinsics.checkNotNullParameter(r3, "symbol");
            Intrinsics.checkNotNullParameter(r4, "letterBitmaps");
            return new b(2, r3, r4, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final b b(String r3) {
            Intrinsics.checkNotNullParameter(r3, "letter");
            return new b(1, r3, null, 0 == true ? 1 : 0);
        }
    }

    static {
        a r0 = new a(null);
        f13915a = r0;
        e = r0.a("#");
    }

    private b(int r2, String r3, Bitmap[] r4) {
        this.f13916b = r2;
        this.c = r3;
        this.d = r4;
        if (r2 != 2) goto L15;
        boolean r5 = false;
        if (r4 != null) goto L7;
        int r6 = 0;
    L9:
        if (r6 != 3) goto L11;
        r5 = true;
    L11:
        if (r5 == false) goto L14;
        this.d = r4;
        return;
    L14:
        throw new IllegalStateException("symbol must have 3 bitmaps!".toString());
    L7:
        r6 = r4.length;
        goto L9
    }

    public /* synthetic */ b(int r1, String r2, Bitmap[] r3, DefaultConstructorMarker r4) {
        this(r1, r2, r3);
    }

    public static final /* synthetic */ b c() {
        return e;
    }

    public final String a() {
        return this.c;
    }

    public final Bitmap[] b() {
        return this.d;
    }

    public final int getType() {
        return this.f13916b;
    }
}
