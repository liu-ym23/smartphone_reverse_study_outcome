package com.ss.android.lark.chat.export.entity.chatter;

import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface IChatterDesc {
    public static final a F1 = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/export/entity/chatter/IChatterDesc$Type;", BuildConfig.FLAVOR, "number", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "DEFAULT", "BUSINESS", "LEAVE", "MEETING", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type BUSINESS = null;
        public static final a Companion = null;
        public static final Type DEFAULT = null;
        public static final Type LEAVE = null;
        public static final Type MEETING = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int number;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("DEFAULT", 0, 0);
            DEFAULT = r0;
            Type r1 = new Type("BUSINESS", 1, 1);
            BUSINESS = r1;
            Type r3 = new Type("LEAVE", 2, 2);
            LEAVE = r3;
            Type r5 = new Type("MEETING", 3, 3);
            MEETING = r5;
            Type[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new a();
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public final int getNumber() {
            return this.number;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.number = r3;
        }
    }

    public static final class a {
        public static final /* synthetic */ a a = null;
        public static final com.ss.android.lark.chat.export.entity.chatter.a b = null;

        public a() {
        }

        static {
            a = new a();
            Type r0 = Type.DEFAULT;
            Intrinsics.checkNotNullParameter(r0, IPortraitService.TYPE);
            b = new com.ss.android.lark.chat.export.entity.chatter.a(r0);
        }
    }

    static {
        F1 = a.a;
    }

    String getContent();

    Type getType();
}
