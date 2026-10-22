package com.ss.android.lark.chat.export.entity.chatter;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/chat/export/entity/chatter/NameRule;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "NAME", "ALIAS_NAME", "NICKNAME_ALIAS_NAME", "ALIAS_NICKNAME_NAME", "NICKNAME_NAME", "NICKNAME_WITH_ALIAS", "chat-export-min_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NameRule extends Enum<NameRule> {
    public static final NameRule ALIAS_NAME = null;
    public static final NameRule ALIAS_NICKNAME_NAME = null;
    public static final NameRule NAME = null;
    public static final NameRule NICKNAME_ALIAS_NAME = null;
    public static final NameRule NICKNAME_NAME = null;
    public static final NameRule NICKNAME_WITH_ALIAS = null;
    public static final /* synthetic */ NameRule[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<NameRule> getEntries() {
        return b;
    }

    static {
        NameRule r0 = new NameRule("NAME", 0);
        NAME = r0;
        NameRule r1 = new NameRule("ALIAS_NAME", 1);
        ALIAS_NAME = r1;
        NameRule r3 = new NameRule("NICKNAME_ALIAS_NAME", 2);
        NICKNAME_ALIAS_NAME = r3;
        NameRule r5 = new NameRule("ALIAS_NICKNAME_NAME", 3);
        ALIAS_NICKNAME_NAME = r5;
        NameRule r7 = new NameRule("NICKNAME_NAME", 4);
        NICKNAME_NAME = r7;
        NameRule r9 = new NameRule("NICKNAME_WITH_ALIAS", 5);
        NICKNAME_WITH_ALIAS = r9;
        NameRule[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static NameRule[] values() {
        return (NameRule[]) a.clone();
    }

    public static NameRule valueOf(String r1) {
        return (NameRule) r27.a.a(NameRule.class, r1);
    }

    public NameRule(String r1, int r2) {
        super(r1, r2);
    }
}
