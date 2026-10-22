package com.obric.oui.shadow;

import androidx.annotation.Keep;
import av.i;
import es.a;
import es.c;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/shadow/ShadowToken;", "", "<init>", "()V", "", "name", "", "Les/a;", "parse", "(Ljava/lang/String;)[Les/a;", "Oui_Shadow_Thin", "[Les/a;", "Oui_Shadow_Regular", "Oui_Shadow_Thick", "Oui_Shadow_UltraThick", "Oui_Shadow_Text_Regular", "Shadow_1", "Shadow_2", "Shadow_3", "Shadow_Thick", "Shadow_Text", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShadowToken {
    public static final ShadowToken INSTANCE = null;

    @JvmField
    public static final a[] Oui_Shadow_Regular = null;

    @JvmField
    public static final a[] Oui_Shadow_Text_Regular = null;

    @JvmField
    public static final a[] Oui_Shadow_Thick = null;

    @JvmField
    public static final a[] Oui_Shadow_Thin = null;

    @JvmField
    public static final a[] Oui_Shadow_UltraThick = null;

    @JvmField
    public static final a[] Shadow_1 = null;

    @JvmField
    public static final a[] Shadow_2 = null;

    @JvmField
    public static final a[] Shadow_3 = null;

    @JvmField
    public static final a[] Shadow_Text = null;

    @JvmField
    public static final a[] Shadow_Thick = null;

    static {
        INSTANCE = new ShadowToken();
        Oui_Shadow_Thin = c.f16865b;
        Oui_Shadow_Regular = c.f16866c;
        Oui_Shadow_Thick = c.d;
        Oui_Shadow_UltraThick = c.e;
        Oui_Shadow_Text_Regular = c.f;
        Shadow_1 = c.g;
        Shadow_2 = c.f16867h;
        Shadow_3 = c.f16868i;
        Shadow_Thick = c.f16869j;
        Shadow_Text = c.f16870k;
    }

    private ShadowToken() {
    }

    @JvmStatic
    public static final a[] parse(String r5) {
        ShadowToken r10 = INSTANCE;
        ConcurrentHashMap r11 = c.f16864a;
        if (r11 != null) goto L16;
        monitor-enter(c.class);
        r11 = c.f16864a;     // Catch: Throwable -> L9
        if (r11 != null) goto L11;
        ConcurrentHashMap r12 = i.n(a[].class, r10);     // Catch: Throwable -> L9
        c.f16864a = r12;     // Catch: Throwable -> L9
        r11 = r12;
    L11:
        monitor-exit(c.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L16:
        return (a[]) i.w(r5, r11);
    }
}
