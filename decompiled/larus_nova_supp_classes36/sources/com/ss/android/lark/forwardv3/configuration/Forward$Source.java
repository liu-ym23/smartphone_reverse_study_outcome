package com.ss.android.lark.forwardv3.configuration;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/Forward$Source;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "MESSAGE", "GROUP_CHAT", "MY_AI", "KNOWLEDGE_AI", "DOUBAO", "Companion", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum Forward$Source extends Enum<Forward$Source> {
    public static final a Companion = null;
    public static final Forward$Source DOUBAO = null;
    public static final Forward$Source GROUP_CHAT = null;
    public static final Forward$Source KNOWLEDGE_AI = null;
    public static final Forward$Source MESSAGE = null;
    public static final Forward$Source MY_AI = null;
    public static final Forward$Source UNKNOWN = null;
    public static final /* synthetic */ Forward$Source[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<Forward$Source> getEntries() {
        return b;
    }

    static {
        Forward$Source r0 = new Forward$Source("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        Forward$Source r1 = new Forward$Source("MESSAGE", 1, 1);
        MESSAGE = r1;
        Forward$Source r3 = new Forward$Source("GROUP_CHAT", 2, 2);
        GROUP_CHAT = r3;
        Forward$Source r5 = new Forward$Source("MY_AI", 3, 10);
        MY_AI = r5;
        Forward$Source r7 = new Forward$Source("KNOWLEDGE_AI", 4, 11);
        KNOWLEDGE_AI = r7;
        Forward$Source r9 = new Forward$Source("DOUBAO", 5, 12);
        DOUBAO = r9;
        Forward$Source[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
        Companion = new a();
    }

    public static Forward$Source[] values() {
        return (Forward$Source[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Forward$Source valueOf(String r1) {
        return (Forward$Source) r27.a.a(Forward$Source.class, r1);
    }

    public Forward$Source(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
