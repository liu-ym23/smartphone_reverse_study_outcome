package com.obric.aiproactive.ui.feedback;

import kotlin.Metadata;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"initialValueRatingSelection", "Lcom/obric/aiproactive/ui/feedback/ProactiveValueRatingSelection;", "rating", "Lcom/obric/aiproactive/ui/feedback/ProactiveValueRating;", "EDITABLE_INTEGER_AMOUNT_REGEX", "Lkotlin/text/Regex;", "KEYBOARD_SHOW_DELAY_MS", "", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Regex f6671a = null;

    static {
        f6671a = new Regex("(?:[1-9]\\d{0,3})?");
    }

    public static final k a(j r3) {
        if (r3 != null) goto L7;
        return new k(null, null, "");
    L7:
        return new k(Integer.valueOf(r3.a()), r3.b(), "");
    }

    public static final /* synthetic */ Regex a() {
        return f6671a;
    }
}
