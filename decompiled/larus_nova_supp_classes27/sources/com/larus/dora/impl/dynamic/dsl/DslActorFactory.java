package com.larus.dora.impl.dynamic.dsl;

import com.larus.dora.api.model.FlowDoraConnectReason;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DslActorFactory {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/dynamic/dsl/DslActorFactory$ToastType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SUCCESS", "WARNING", "FAILURE", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ToastType extends Enum<ToastType> {
        public static final a Companion = null;
        public static final ToastType FAILURE = null;
        public static final ToastType SUCCESS = null;
        public static final ToastType WARNING = null;
        public static final /* synthetic */ ToastType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<ToastType> getEntries() {
            return b;
        }

        static {
            ToastType r0 = new ToastType("SUCCESS", 0, FlowDoraConnectReason.SUCCESS);
            SUCCESS = r0;
            ToastType r1 = new ToastType("WARNING", 1, "warning");
            WARNING = r1;
            ToastType r3 = new ToastType("FAILURE", 2, "failure");
            FAILURE = r3;
            ToastType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new a();
        }

        public static ToastType[] values() {
            return (ToastType[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static ToastType valueOf(String r1) {
            return (ToastType) r27.a.a(ToastType.class, r1);
        }

        public ToastType(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DslActionType.values().length];
            r0[DslActionType.EXTERNAL_JUMP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[DslActionType.EXTERNAL_JUMP_BY_EXPLICIT_INTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[DslActionType.WEB_JUMP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[DslActionType.TOAST.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }
}
