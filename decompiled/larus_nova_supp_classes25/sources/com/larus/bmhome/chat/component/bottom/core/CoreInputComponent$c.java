package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.component.bottom.core.inputtext.InputReferenceType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public /* synthetic */ class CoreInputComponent$c {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[InputReferenceType.values().length];
        r0[InputReferenceType.DRIVE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
    L21:
        r0[InputReferenceType.CONVERSATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
    L31:
        r0[InputReferenceType.GROUP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
    L23:
        r0[InputReferenceType.FILE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
    L25:
        r0[InputReferenceType.ATTACHMENT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
    L19:
        r0[InputReferenceType.SKILL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
    L27:
        r0[InputReferenceType.CONTACT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
    L10:
        a = r0;
    }
}
