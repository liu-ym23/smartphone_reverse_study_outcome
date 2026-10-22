package com.ss.android.lark.chat.entity;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chat/entity/ComponentType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CHAT", "REPLY_IN_THREAD", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ComponentType extends Enum<ComponentType> {
    public static final ComponentType CHAT = null;
    public static final a Companion = null;
    public static final ComponentType REPLY_IN_THREAD = null;
    public static final /* synthetic */ ComponentType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ComponentType> getEntries() {
        return b;
    }

    static {
        ComponentType r0 = new ComponentType("CHAT", 0, 0);
        CHAT = r0;
        ComponentType r1 = new ComponentType("REPLY_IN_THREAD", 1, 1);
        REPLY_IN_THREAD = r1;
        ComponentType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
        Companion = new a();
    }

    public static ComponentType[] values() {
        return (ComponentType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final ComponentType fromValue(int r3) {
        Companion.getClass();
        ComponentType r0 = CHAT;
        if (r3 == r0.getValue()) goto L10;
        ComponentType r1 = REPLY_IN_THREAD;
        if (r3 == r1.getValue()) goto L8;
        return r0;
    L8:
        return r1;
    L10:
        return r0;
    }

    @JvmStatic
    public static final boolean isChat(ComponentType r1) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1 != CHAT) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean isReplyInThread(ComponentType r1) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1 != REPLY_IN_THREAD) goto L5;
        return true;
    L5:
        return false;
    }

    public static ComponentType valueOf(String r1) {
        return (ComponentType) r27.a.a(ComponentType.class, r1);
    }

    public ComponentType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
