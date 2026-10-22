package com.suite.lark.platform.feature.forward.doubao.api.entity;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/api/entity/ForwardScene;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "CHAT", "forward-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum ForwardScene extends Enum<ForwardScene> {
    public static final ForwardScene CHAT = null;
    public static final ForwardScene UNKNOWN = null;
    public static final /* synthetic */ ForwardScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ForwardScene> getEntries() {
        return b;
    }

    static {
        ForwardScene r0 = new ForwardScene("UNKNOWN", 0);
        UNKNOWN = r0;
        ForwardScene r1 = new ForwardScene("CHAT", 1);
        CHAT = r1;
        ForwardScene[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ForwardScene[] values() {
        return (ForwardScene[]) a.clone();
    }

    public static ForwardScene valueOf(String r1) {
        return (ForwardScene) a.a(ForwardScene.class, r1);
    }

    public ForwardScene(String r1, int r2) {
        super(r1, r2);
    }
}
