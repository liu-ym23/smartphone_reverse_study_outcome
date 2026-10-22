package com.ss.android.lark.chat.vo;

import android.text.TextUtils;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.chat.entity.chatter.UserPrivateDescription;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SenderStatusDisplayHelper {
    public static final SenderStatusDisplayHelper a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chat/vo/SenderStatusDisplayHelper$Type;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "PRIVATE_DESCRIPTION", "PUBLIC_DESCRIPTION", "HIDE", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type HIDE = null;
        public static final Type PRIVATE_DESCRIPTION = null;
        public static final Type PUBLIC_DESCRIPTION = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("PRIVATE_DESCRIPTION", 0);
            PRIVATE_DESCRIPTION = r0;
            Type r1 = new Type("PUBLIC_DESCRIPTION", 1);
            PUBLIC_DESCRIPTION = r1;
            Type r3 = new Type("HIDE", 2);
            HIDE = r3;
            Type[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static final /* synthetic */ int d = 0;
        public final Type a;
        public final UserPrivateDescription b;
        public final ChatterDescription c;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.vo.SenderStatusDisplayHelper$a$a, reason: collision with other inner class name */
        public static final class C0116a {
        }

        static {
        }

        public final Type getType() {
            return this.a;
        }

        public a(Type r1, UserPrivateDescription r2, ChatterDescription r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
        a = new SenderStatusDisplayHelper();
    }

    public SenderStatusDisplayHelper() {
    }

    public static a a(ChatterDescription r3) {
        if (r3 != null) goto L4;
    L9:
        boolean r0 = true;
    L11:
        if (r0 == true) goto L13;
        if (r3 == null) goto L18;
        int r1 = a.d;
        Intrinsics.checkNotNullParameter(r3, "publicDescription");
        return new a(Type.PUBLIC_DESCRIPTION, null, r3);
    L18:
        return new a(Type.HIDE, null, null);
    L13:
        return new a(Type.HIDE, null, null);
    L4:
        if (TextUtils.isEmpty(r3.description) == true) goto L6;
    L8:
        r0 = false;
        goto L11
    L6:
        if (r3.type != ChatterDescription.Type.DEFAULT) goto L8;
        goto L8
    }
}
