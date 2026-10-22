package com.obric.aiproactive.ui.feedback;

import android.content.Context;
import android.content.SharedPreferences;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0006J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0006J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/aiproactive/ui/feedback/ProactiveValueRatingStore;", "", "context", "Landroid/content/Context;", "userIdProvider", "Lkotlin/Function0;", "", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "preferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "Landroid/content/SharedPreferences;", "get", "Lcom/obric/aiproactive/ui/feedback/ProactiveValueRating;", "recommendationId", "put", "Lcom/obric/aiproactive/ui/feedback/ProactiveValueSubmitType;", "rating", "clear", "", "recordKey", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f6672a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0<String> f6673b;
    private final SharedPreferences c;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/aiproactive/ui/feedback/ProactiveValueRatingStore$Companion;", "", "<init>", "()V", "PREFERENCES_NAME", "", "KEY_PREFIX", "ANONYMOUS_USER", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f6672a = new a(null);
    }

    public n(Context r3, Function0<String> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Function0<String> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "userIdProvider");
        this.f6673b = r6;
        this.c = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("proactive_value_rating", 0);
    }

    public /* synthetic */ n(Context r2, Function0 r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = (Function0) ZeusTransformUtils.preCheckCast(new ProactiveValueRatingStore$1(AppContext.INSTANCE), Function0.class, "com.obric.memorydata.plugin");
    L5:
        this(r6, r7);
    }

    private final String b(String r4) {
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r5 = null;
    L10:
        if (r5 != null) goto L12;
        return null;
    L12:
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(this.f6673b.invoke(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r3) == false) goto L16;
        r3 = "anonymous";
    L16:
        return "rating_v1:" + ((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin")) + ':' + r5;
    L5:
        r0 = false;
        goto L7
    }

    public final ProactiveValueSubmitType a(String r3, j r4) {
        Intrinsics.checkNotNullParameter(r3, "recommendationId");
        Intrinsics.checkNotNullParameter(r4, "rating");
        String r5 = b(r3);
        if (r5 != null) goto L5;
        return null;
    L5:
        ProactiveValueSubmitType r1 = o.b(o.b(this.c.getString(r5, null)));
        if (this.c.edit().putString(r5, o.c(r4)).commit() == true) goto L8;
        return null;
    L8:
        return r1;
    }

    public final j a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "recommendationId");
        String r3 = b(r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        return o.b(this.c.getString(r3, null));
    }
}
