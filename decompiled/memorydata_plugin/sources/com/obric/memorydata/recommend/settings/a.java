package com.obric.memorydata.recommend.settings;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.at;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/recommend/settings/AppCategoryUtils;", "", "<init>", "()V", "VIDEO", "", "LIFE", "SHOPPING", "TOOLS", "FINANCE", "PHOTOGRAPHY", "MUSIC", "READING", "SOCIAL", "TRAVEL", "OFFICE", "HEALTH", "SYSTEM", "BEAUTY", "TRANSPORTATION", "EDUCATION", "GAME", "OTHER", "getDescByCategoryCode", "", "categoryCode", "getCategoryPriority", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12594a = null;

    static {
        f12594a = new a();
    }

    private a() {
    }

    public final String a(int r2) {
        if (r2 != 301) goto L5;
        int r1 = R.string.screen_observation_app_category_desc_life;
        String r3 = "screen_observation_app_category_desc_life";
    L22:
        return at.a(ZeusTransformUtils.mapRes(r1, TypedValues.Custom.S_STRING, r3));
    L5:
        if (r2 != 302) goto L7;
        r1 = R.string.screen_observation_app_category_desc_commute;
        r3 = "screen_observation_app_category_desc_commute";
        goto L22
    L7:
        if (r2 != 304) goto L9;
        r1 = R.string.screen_observation_app_category_desc_office;
        r3 = "screen_observation_app_category_desc_office";
        goto L22
    L9:
        if (r2 != 306) goto L11;
        r1 = R.string.screen_observation_app_category_desc_social;
        r3 = "screen_observation_app_category_desc_social";
        goto L22
    L11:
        if (r2 != 470) goto L13;
        r1 = R.string.screen_observation_app_category_desc_shopping;
        r3 = "screen_observation_app_category_desc_shopping";
        goto L22
    L13:
        if (r2 == 483) goto L15;
        return "";
    L15:
        r1 = R.string.screen_observation_app_category_desc_travel;
        r3 = "screen_observation_app_category_desc_travel";
        goto L22
    }

    public final int b(int r1) {
        if (r1 != 297) goto L5;
        return 11;
    L5:
        if (r1 != 465) goto L7;
        return 16;
    L7:
        if (r1 != 470) goto L9;
        return 3;
    L9:
        if (r1 != 478) goto L11;
        return 13;
    L11:
        if (r1 != 483) goto L13;
        return 5;
    L13:
        if (r1 == 88888888) goto L27;
        switch(r1) {
            case 301: goto L26;
            case 302: goto L25;
            case 303: goto L24;
            case 304: goto L23;
            case 305: goto L22;
            case 306: goto L21;
            case 307: goto L20;
            case 308: goto L19;
            case 309: goto L18;
            case 310: goto L17;
            case 311: goto L16;
            default: goto L15;
        };
    L15:
        return 1000;
    L16:
        return 17;
    L17:
        return 9;
    L18:
        return 10;
    L19:
        return 12;
    L20:
        return 14;
    L21:
        return 1;
    L22:
        return 15;
    L23:
        return 2;
    L24:
        return 8;
    L25:
        return 6;
    L26:
        return 4;
    L27:
        return 7;
    }
}
