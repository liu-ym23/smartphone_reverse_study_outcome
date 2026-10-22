package com.bytedance.lark.lark_bitable_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/lark/lark_bitable_android/ErrorContent;", "", "(Ljava/lang/String;I)V", "into", "Llark_bitable/proto/ErrorContent;", "intoInt", "", "NoPermission", "NoContent", "Companion", "lark_bitable_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum ErrorContent extends Enum<ErrorContent> {
    public static final a Companion = null;
    public static final ErrorContent NoContent = null;
    public static final ErrorContent NoPermission = null;
    public static final /* synthetic */ ErrorContent[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ErrorContent.values().length];
            r0[ErrorContent.NoPermission.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ErrorContent.NoContent.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static EnumEntries<ErrorContent> getEntries() {
        return b;
    }

    public static ErrorContent valueOf(String r1) {
        return (ErrorContent) r27.a.a(ErrorContent.class, r1);
    }

    public static ErrorContent[] values() {
        return (ErrorContent[]) a.clone();
    }

    static {
        ErrorContent r0 = new ErrorContent("NoPermission", 0);
        NoPermission = r0;
        ErrorContent r1 = new ErrorContent("NoContent", 1);
        NoContent = r1;
        ErrorContent[] r10 = {r0, r1};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
        Companion = new a();
    }

    public final lark_bitable.proto.ErrorContent into() {
        int r0 = b.a[ordinal()];
        if (r0 == 1) goto L10;
        if (r0 != 2) goto L8;
        return lark_bitable.proto.ErrorContent.VAR_ERROR_CONTENT_NO_CONTENT;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return lark_bitable.proto.ErrorContent.VAR_ERROR_CONTENT_NO_PERMISSION;
    }

    public final int intoInt() {
        int r0 = b.a[ordinal()];
        if (r0 != 1) goto L5;
        return 0;
    L5:
        if (r0 != 2) goto L8;
        return 1;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final ErrorContent fromInt(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L8;
        return NoContent;
    L8:
        throw new RuntimeException("Unmatched primitive enum value: ErrorContent with ");
    L10:
        return NoPermission;
    }

    public ErrorContent(String r1, int r10) {
        super(r1, r10);
    }
}
