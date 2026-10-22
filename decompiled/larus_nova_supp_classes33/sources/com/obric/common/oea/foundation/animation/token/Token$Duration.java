package com.obric.common.oea.foundation.animation.token;

import com.obric.assistant.interaction.impl.performance.WindowAnimationBoostCoordinator;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.memorydata.sdk.entity.search.SearchError;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"com/obric/common/oea/foundation/animation/token/Token$Duration", "", "Lcom/obric/common/oea/foundation/animation/token/Token$Duration;", "", "duration", "I", "getDuration", "()I", "stiffness", "getStiffness", "OUI_ANIMATION_DURATION_SHORT_1", "OUI_ANIMATION_DURATION_SHORT_2", "OUI_ANIMATION_DURATION_SHORT_3", "OUI_ANIMATION_DURATION_SHORT_4", "OUI_ANIMATION_DURATION_MEDIUM_1", "OUI_ANIMATION_DURATION_MEDIUM_2", "OUI_ANIMATION_DURATION_MEDIUM_3", "OUI_ANIMATION_DURATION_MEDIUM_4", "OUI_ANIMATION_DURATION_LONG_1", "OUI_ANIMATION_DURATION_LONG_2", "OUI_ANIMATION_DURATION_LONG_3", "OUI_ANIMATION_DURATION_LONG_4", "OUI_ANIMATION_DURATION_VERY_LONG_1", "OUI_ANIMATION_DURATION_VERY_LONG_2", "OUI_ANIMATION_DURATION_VERY_LONG_3", "OUI_ANIMATION_DURATION_VERY_LONG_4", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum Token$Duration extends Enum<Token$Duration> {
    public static final Token$Duration OUI_ANIMATION_DURATION_LONG_1 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_LONG_2 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_LONG_3 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_LONG_4 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_MEDIUM_1 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_MEDIUM_2 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_MEDIUM_3 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_MEDIUM_4 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_SHORT_1 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_SHORT_2 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_SHORT_3 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_SHORT_4 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_VERY_LONG_1 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_VERY_LONG_2 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_VERY_LONG_3 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_VERY_LONG_4 = null;
    public static final /* synthetic */ Token$Duration[] a = null;
    private final int duration;
    private final int stiffness;

    public static Token$Duration valueOf(String r1) {
        return (Token$Duration) a.a(Token$Duration.class, r1);
    }

    public static Token$Duration[] values() {
        return (Token$Duration[]) a.clone();
    }

    static {
        Token$Duration r1 = new Token$Duration("OUI_ANIMATION_DURATION_SHORT_1", 0, 50, 15791);
        OUI_ANIMATION_DURATION_SHORT_1 = r1;
        Token$Duration r2 = new Token$Duration("OUI_ANIMATION_DURATION_SHORT_2", 1, 100, 3948);
        OUI_ANIMATION_DURATION_SHORT_2 = r2;
        Token$Duration r3 = new Token$Duration("OUI_ANIMATION_DURATION_SHORT_3", 2, 150, 1755);
        OUI_ANIMATION_DURATION_SHORT_3 = r3;
        Token$Duration r4 = new Token$Duration("OUI_ANIMATION_DURATION_SHORT_4", 3, ErrorCode.ENTITY_NOT_EXIST_ERROR, 987);
        OUI_ANIMATION_DURATION_SHORT_4 = r4;
        Token$Duration r5 = new Token$Duration("OUI_ANIMATION_DURATION_MEDIUM_1", 4, 250, 632);
        OUI_ANIMATION_DURATION_MEDIUM_1 = r5;
        Token$Duration r6 = new Token$Duration("OUI_ANIMATION_DURATION_MEDIUM_2", 5, 300, 439);
        OUI_ANIMATION_DURATION_MEDIUM_2 = r6;
        Token$Duration r7 = new Token$Duration("OUI_ANIMATION_DURATION_MEDIUM_3", 6, 350, 322);
        OUI_ANIMATION_DURATION_MEDIUM_3 = r7;
        Token$Duration r8 = new Token$Duration("OUI_ANIMATION_DURATION_MEDIUM_4", 7, WindowAnimationBoostCoordinator.DEFAULT_WINDOW_ANIMATION_DURATION_MS, 247);
        OUI_ANIMATION_DURATION_MEDIUM_4 = r8;
        Token$Duration r9 = new Token$Duration("OUI_ANIMATION_DURATION_LONG_1", 8, 450, 195);
        OUI_ANIMATION_DURATION_LONG_1 = r9;
        Token$Duration r10 = new Token$Duration("OUI_ANIMATION_DURATION_LONG_2", 9, 500, 158);
        OUI_ANIMATION_DURATION_LONG_2 = r10;
        Token$Duration r11 = new Token$Duration("OUI_ANIMATION_DURATION_LONG_3", 10, 550, ApWakeEvent.ACCELERATING_END);
        OUI_ANIMATION_DURATION_LONG_3 = r11;
        Token$Duration r12 = new Token$Duration("OUI_ANIMATION_DURATION_LONG_4", 11, 600, ApWakeEvent.RUNNING_START);
        OUI_ANIMATION_DURATION_LONG_4 = r12;
        Token$Duration r13 = new Token$Duration("OUI_ANIMATION_DURATION_VERY_LONG_1", 12, WindowAnimationBoostCoordinator.SLIDE_WINDOW_ANIMATION_DURATION_MS, 81);
        OUI_ANIMATION_DURATION_VERY_LONG_1 = r13;
        Token$Duration r14 = new Token$Duration("OUI_ANIMATION_DURATION_VERY_LONG_2", 13, 800, 62);
        OUI_ANIMATION_DURATION_VERY_LONG_2 = r14;
        Token$Duration r15 = new Token$Duration("OUI_ANIMATION_DURATION_VERY_LONG_3", 14, 900, 49);
        OUI_ANIMATION_DURATION_VERY_LONG_3 = r15;
        Token$Duration r16 = new Token$Duration("OUI_ANIMATION_DURATION_VERY_LONG_4", 15, SearchError.ERR_UNKNOWN, 39);
        OUI_ANIMATION_DURATION_VERY_LONG_4 = r16;
        a = new Token$Duration[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16};
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getStiffness() {
        return this.stiffness;
    }

    public Token$Duration(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.duration = r3;
        this.stiffness = r4;
    }
}
