package com.ss.android.lark.export.entity;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/export/entity/Type;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FLEX_LAYOUT", "ENGINE_VIEW", "EMPTY", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Type extends Enum<Type> {
    public static final a Companion = null;
    public static final Type EMPTY = null;
    public static final Type ENGINE_VIEW = null;
    public static final Type FLEX_LAYOUT = null;
    public static final /* synthetic */ Type[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<Type> getEntries() {
        return b;
    }

    static {
        Type r0 = new Type("FLEX_LAYOUT", 0, 0);
        FLEX_LAYOUT = r0;
        Type r1 = new Type("ENGINE_VIEW", 1, 1);
        ENGINE_VIEW = r1;
        Type r3 = new Type("EMPTY", 2, 100);
        EMPTY = r3;
        Type[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static Type[] values() {
        return (Type[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Type valueOf(String r1) {
        return (Type) r27.a.a(Type.class, r1);
    }

    public Type(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
