package com.larus.voice_setting.voice.base;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/voice_setting/voice/base/MainTabFragmentAction;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "NONE", "CREATE_VOICE", "flow-voice-setting-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MainTabFragmentAction extends Enum<MainTabFragmentAction> {
    public static final MainTabFragmentAction CREATE_VOICE = null;
    public static final MainTabFragmentAction NONE = null;
    public static final /* synthetic */ MainTabFragmentAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MainTabFragmentAction> getEntries() {
        return b;
    }

    static {
        MainTabFragmentAction r0 = new MainTabFragmentAction("NONE", 0);
        NONE = r0;
        MainTabFragmentAction r1 = new MainTabFragmentAction("CREATE_VOICE", 1);
        CREATE_VOICE = r1;
        MainTabFragmentAction[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MainTabFragmentAction[] values() {
        return (MainTabFragmentAction[]) a.clone();
    }

    public static MainTabFragmentAction valueOf(String r1) {
        return (MainTabFragmentAction) r27.a.a(MainTabFragmentAction.class, r1);
    }

    public MainTabFragmentAction(String r1, int r2) {
        super(r1, r2);
    }
}
