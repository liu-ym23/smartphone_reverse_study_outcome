package com.larus.dora.obric.device_management.setting.g;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/DoraObricGSettingsAction;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "DEVICE_NAME", "GESTURE", "DOUBAO_CONVERSATION", "SOUND", "VIDEO_RECORD", "GENERAL", "DEVICE_INFO", "ENV_OBSERVE", "MEMORY_DATA", "PRIVACY_AND_PERMISSION", "FEEDBACK", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricGSettingsAction extends Enum<DoraObricGSettingsAction> {
    public static final DoraObricGSettingsAction DEVICE_INFO = null;
    public static final DoraObricGSettingsAction DEVICE_NAME = null;
    public static final DoraObricGSettingsAction DOUBAO_CONVERSATION = null;
    public static final DoraObricGSettingsAction ENV_OBSERVE = null;
    public static final DoraObricGSettingsAction FEEDBACK = null;
    public static final DoraObricGSettingsAction GENERAL = null;
    public static final DoraObricGSettingsAction GESTURE = null;
    public static final DoraObricGSettingsAction MEMORY_DATA = null;
    public static final DoraObricGSettingsAction NONE = null;
    public static final DoraObricGSettingsAction PRIVACY_AND_PERMISSION = null;
    public static final DoraObricGSettingsAction SOUND = null;
    public static final DoraObricGSettingsAction VIDEO_RECORD = null;
    public static final /* synthetic */ DoraObricGSettingsAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraObricGSettingsAction> getEntries() {
        return b;
    }

    static {
        DoraObricGSettingsAction r0 = new DoraObricGSettingsAction("NONE", 0);
        NONE = r0;
        DoraObricGSettingsAction r1 = new DoraObricGSettingsAction("DEVICE_NAME", 1);
        DEVICE_NAME = r1;
        DoraObricGSettingsAction r3 = new DoraObricGSettingsAction("GESTURE", 2);
        GESTURE = r3;
        DoraObricGSettingsAction r5 = new DoraObricGSettingsAction("DOUBAO_CONVERSATION", 3);
        DOUBAO_CONVERSATION = r5;
        DoraObricGSettingsAction r7 = new DoraObricGSettingsAction("SOUND", 4);
        SOUND = r7;
        DoraObricGSettingsAction r9 = new DoraObricGSettingsAction("VIDEO_RECORD", 5);
        VIDEO_RECORD = r9;
        DoraObricGSettingsAction r11 = new DoraObricGSettingsAction("GENERAL", 6);
        GENERAL = r11;
        DoraObricGSettingsAction r13 = new DoraObricGSettingsAction("DEVICE_INFO", 7);
        DEVICE_INFO = r13;
        DoraObricGSettingsAction r15 = new DoraObricGSettingsAction("ENV_OBSERVE", 8);
        ENV_OBSERVE = r15;
        DoraObricGSettingsAction r14 = new DoraObricGSettingsAction("MEMORY_DATA", 9);
        MEMORY_DATA = r14;
        DoraObricGSettingsAction r12 = new DoraObricGSettingsAction("PRIVACY_AND_PERMISSION", 10);
        PRIVACY_AND_PERMISSION = r12;
        DoraObricGSettingsAction r10 = new DoraObricGSettingsAction("FEEDBACK", 11);
        FEEDBACK = r10;
        DoraObricGSettingsAction[] r8 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static DoraObricGSettingsAction[] values() {
        return (DoraObricGSettingsAction[]) a.clone();
    }

    public static DoraObricGSettingsAction valueOf(String r1) {
        return (DoraObricGSettingsAction) r27.a.a(DoraObricGSettingsAction.class, r1);
    }

    public DoraObricGSettingsAction(String r1, int r2) {
        super(r1, r2);
    }
}
