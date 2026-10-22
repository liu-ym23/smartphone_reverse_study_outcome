package com.ss.android.lark.chat.message.menu.v2.popup;

import com.ss.android.lark.chat.message.menu.v2.PanelType;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface IPopupMenuContent {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/popup/IPopupMenuContent$ShadowTarget;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "NONE", "SELF", "CHILD", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ShadowTarget extends Enum<ShadowTarget> {
        public static final ShadowTarget CHILD = null;
        public static final ShadowTarget NONE = null;
        public static final ShadowTarget SELF = null;
        public static final /* synthetic */ ShadowTarget[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ShadowTarget> getEntries() {
            return b;
        }

        static {
            ShadowTarget r0 = new ShadowTarget("NONE", 0);
            NONE = r0;
            ShadowTarget r1 = new ShadowTarget("SELF", 1);
            SELF = r1;
            ShadowTarget r3 = new ShadowTarget("CHILD", 2);
            CHILD = r3;
            ShadowTarget[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static ShadowTarget[] values() {
            return (ShadowTarget[]) a.clone();
        }

        public static ShadowTarget valueOf(String r1) {
            return (ShadowTarget) r27.a.a(ShadowTarget.class, r1);
        }

        public ShadowTarget(String r1, int r2) {
            super(r1, r2);
        }
    }

    PanelType getPanelType();

    ShadowTarget getShadowTarget();
}
