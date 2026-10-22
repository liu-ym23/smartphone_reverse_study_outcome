package com.ss.android.lark.chat.preview.entity.component;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\u0081\u0002\u0018\u0000 \u001f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u001fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006 "}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/Tag;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "UNKNOWN_TAG", "OFFICIAL", "ONCALL", "BOT", "MEETING", "APPROVAL", "SECRET_CHAT", "WHOLE", "DEPARTMENT", "EXTERNAL", "PUBLIC", "GROUP_ADMIN", "SUPERVISOR", "STOPPED", "OFFLINE", "DELETED", "UNACTIVATED", "EDU", "FROZEN", "ONCALL_OFFLINE", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Tag extends Enum<Tag> implements Serializable {
    public static final Tag APPROVAL = null;
    public static final Tag BOT = null;
    public static final a Companion = null;
    public static final Tag DELETED = null;
    public static final Tag DEPARTMENT = null;
    public static final Tag EDU = null;
    public static final Tag EXTERNAL = null;
    public static final Tag FROZEN = null;
    public static final Tag GROUP_ADMIN = null;
    public static final Tag MEETING = null;
    public static final Tag OFFICIAL = null;
    public static final Tag OFFLINE = null;
    public static final Tag ONCALL = null;
    public static final Tag ONCALL_OFFLINE = null;
    public static final Tag PUBLIC = null;
    public static final Tag SECRET_CHAT = null;
    public static final Tag STOPPED = null;
    public static final Tag SUPERVISOR = null;
    public static final Tag UNACTIVATED = null;
    public static final Tag UNKNOWN_TAG = null;
    public static final Tag WHOLE = null;
    public static final /* synthetic */ Tag[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private int value;

    public static final class a {
        public a() {
        }

        public static Tag a(int r1) {
            if (r1 == 100) goto L26;
            switch(r1) {
                case 1: goto L44;
                case 2: goto L43;
                case 3: goto L42;
                case 4: goto L41;
                case 5: goto L40;
                case 6: goto L39;
                case 7: goto L38;
                case 8: goto L37;
                case 9: goto L36;
                case 10: goto L35;
                case 11: goto L34;
                case 12: goto L33;
                case 13: goto L32;
                case 14: goto L31;
                case 15: goto L30;
                case 16: goto L29;
                case 17: goto L28;
                case 18: goto L27;
                default: goto L24;
            };
        L24:
            return null;
        L27:
            return Tag.FROZEN;
        L28:
            return Tag.EDU;
        L29:
            return Tag.UNACTIVATED;
        L30:
            return Tag.DELETED;
        L31:
            return Tag.OFFLINE;
        L32:
            return Tag.STOPPED;
        L33:
            return Tag.SUPERVISOR;
        L34:
            return Tag.GROUP_ADMIN;
        L35:
            return Tag.PUBLIC;
        L36:
            return Tag.EXTERNAL;
        L37:
            return Tag.DEPARTMENT;
        L38:
            return Tag.WHOLE;
        L39:
            return Tag.SECRET_CHAT;
        L40:
            return Tag.APPROVAL;
        L41:
            return Tag.MEETING;
        L42:
            return Tag.BOT;
        L43:
            return Tag.ONCALL;
        L44:
            return Tag.OFFICIAL;
        L26:
            return Tag.ONCALL_OFFLINE;
        }
    }

    public static EnumEntries<Tag> getEntries() {
        return b;
    }

    static {
        Tag r0 = new Tag("UNKNOWN_TAG", 0, 0);
        UNKNOWN_TAG = r0;
        Tag r1 = new Tag("OFFICIAL", 1, 1);
        OFFICIAL = r1;
        Tag r3 = new Tag("ONCALL", 2, 2);
        ONCALL = r3;
        Tag r5 = new Tag("BOT", 3, 3);
        BOT = r5;
        Tag r7 = new Tag("MEETING", 4, 4);
        MEETING = r7;
        Tag r9 = new Tag("APPROVAL", 5, 5);
        APPROVAL = r9;
        Tag r11 = new Tag("SECRET_CHAT", 6, 6);
        SECRET_CHAT = r11;
        Tag r13 = new Tag("WHOLE", 7, 7);
        WHOLE = r13;
        Tag r15 = new Tag("DEPARTMENT", 8, 8);
        DEPARTMENT = r15;
        Tag r14 = new Tag("EXTERNAL", 9, 9);
        EXTERNAL = r14;
        Tag r12 = new Tag("PUBLIC", 10, 10);
        PUBLIC = r12;
        Tag r10 = new Tag("GROUP_ADMIN", 11, 11);
        GROUP_ADMIN = r10;
        Tag r8 = new Tag("SUPERVISOR", 12, 12);
        SUPERVISOR = r8;
        Tag r6 = new Tag("STOPPED", 13, 13);
        STOPPED = r6;
        Tag r4 = new Tag("OFFLINE", 14, 14);
        OFFLINE = r4;
        Tag r2 = new Tag("DELETED", 15, 15);
        DELETED = r2;
        Tag r16 = new Tag("UNACTIVATED", 16, 16);
        UNACTIVATED = r16;
        Tag r17 = new Tag("EDU", 17, 17);
        EDU = r17;
        Tag r18 = new Tag("FROZEN", 18, 18);
        FROZEN = r18;
        Tag r19 = new Tag("ONCALL_OFFLINE", 19, 100);
        ONCALL_OFFLINE = r19;
        Tag[] r20 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19};
        a = r20;
        b = EnumEntriesKt.enumEntries(r20);
        Companion = new a();
    }

    public static Tag[] values() {
        return (Tag[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Tag valueOf(String r1) {
        return (Tag) r27.a.a(Tag.class, r1);
    }

    public final void setValue(int r1) {
        this.value = r1;
    }

    public Tag(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
