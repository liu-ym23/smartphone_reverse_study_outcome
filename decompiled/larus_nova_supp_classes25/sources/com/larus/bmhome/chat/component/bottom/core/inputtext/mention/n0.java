package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.component.bottom.core.inputtext.InputReferenceType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n0 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[InputReferenceType.values().length];
            r0[InputReferenceType.CONTACT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[InputReferenceType.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L51:
            r0[InputReferenceType.ATTACHMENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L39:
            r0[InputReferenceType.FILE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L41:
            r0[InputReferenceType.SKILL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L31:
            r0[InputReferenceType.DRIVE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L43:
            r0[InputReferenceType.CONVERSATION.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L13:
            a = r0;
            int[] r1 = new int[MentionSearchDomain.values().length];
            r1[MentionSearchDomain.CONTACT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L35:
            r1[MentionSearchDomain.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L45:
            r1[MentionSearchDomain.DRIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L33:
            r1[MentionSearchDomain.CONVERSATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L18:
            b = r1;
        }
    }

    public static final String a(MentionSearchDomain r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r2 = a.b[r1.ordinal()];
        if (r2 != 1) goto L5;
        return "contact";
    L5:
        if (r2 != 2) goto L7;
        return "group_chat";
    L7:
        if (r2 != 3) goto L9;
        return "cloud_doc";
    L9:
        if (r2 != 4) goto L12;
        return "conversation";
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
