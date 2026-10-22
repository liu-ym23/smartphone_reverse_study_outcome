package com.obric.oui.coachmark;

import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmark;", "", "()V", "COACHMARK_CONTENT_SHADOW_STYLE_RES", "", "DEFAULT_ACTION_STYLE", "Lcom/obric/oui/coachmark/OCoachmarkView$ActionStyle;", "DEFAULT_AUTO_DISMISS_MILLIS", "", "DEFAULT_MARGIN_DP", "SIDE_BOTTOM_SAFE_MARGIN_DP", "SIDE_HORIZONTAL_SAFE_MARGIN_DP", "TAG", "", "Builder", "Type", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCoachmark {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OCoachmark f13457a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final OCoachmarkView.ActionStyle f13458b = null;
    private static final int c = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmark$Type;", "", "(Ljava/lang/String;I)V", "PILL", "CARD", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type CARD = null;
        public static final Type PILL = null;

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{PILL, CARD};
        }

        static {
            PILL = new Type("PILL", 0);
            CARD = new Type("CARD", 1);
            $VALUES = $values();
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        public static Type valueOf(String r2) {
            return (Type) ZeusTransformUtils.preCheckCast(Enum.valueOf(Type.class, r2), Type.class, "com.obric.memorydata.plugin");
        }

        public static Type[] values() {
            return (Type[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Type[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f13457a = new OCoachmark();
        f13458b = OCoachmarkView.ActionStyle.TEXT_ONLY;
        c = ZeusTransformUtils.mapRes(R.style.OUIShadow_3, "style", "OUIShadow_3");
    }

    private OCoachmark() {
    }
}
