package com.obric.aiproactive.ui.entry;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u000eJ\b\u0010\u0014\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/aiproactive/ui/entry/AiProactiveUserRequirementComposerViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Landroidx/lifecycle/SavedStateHandle;)V", EventBody.KEY_VALUE, "", "draft", "getDraft", "()Ljava/lang/String;", "setDraft", "(Ljava/lang/String;)V", "onDraftChanged", "", "prepareSubmission", "Lcom/obric/aiproactive/api/AiProactiveUserRequirementRequest;", "nowMillis", "", "onSubmissionSucceeded", "clearRequestIdentity", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AiProactiveUserRequirementComposerViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String KEY_DRAFT = "user_requirement_draft";
    private static final String KEY_REQUEST_CONTENT = "user_requirement_request_content";
    private static final String KEY_REQUEST_ID = "user_requirement_request_id";
    private static final String KEY_SUBMITTED_AT = "user_requirement_submitted_at";
    private final SavedStateHandle savedStateHandle;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/aiproactive/ui/entry/AiProactiveUserRequirementComposerViewModel$Companion;", "", "<init>", "()V", "KEY_DRAFT", "", "KEY_REQUEST_CONTENT", "KEY_REQUEST_ID", "KEY_SUBMITTED_AT", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public AiProactiveUserRequirementComposerViewModel(SavedStateHandle r2) {
        Intrinsics.checkNotNullParameter(r2, "savedStateHandle");
        this.savedStateHandle = r2;
    }

    private final void clearRequestIdentity() {
        this.savedStateHandle.remove(KEY_REQUEST_CONTENT);
        this.savedStateHandle.remove(KEY_REQUEST_ID);
        this.savedStateHandle.remove(KEY_SUBMITTED_AT);
    }

    private final void setDraft(String r2) {
        this.savedStateHandle.set(KEY_DRAFT, r2);
    }

    public final String getDraft() {
        String r2 = (String) ZeusTransformUtils.preCheckCast(this.savedStateHandle.get(KEY_DRAFT), String.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2;
    }

    public final void onDraftChanged(String r3) {
        Intrinsics.checkNotNullParameter(r3, EventBody.KEY_VALUE);
        setDraft(r3);
        if (Intrinsics.areEqual(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString(), this.savedStateHandle.get(KEY_REQUEST_CONTENT)) == true) goto L6;
        clearRequestIdentity();
        return;
    }

    public final void onSubmissionSucceeded() {
        setDraft("");
        clearRequestIdentity();
    }

    public final com.obric.aiproactive.api.x prepareSubmission(long r17) {
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(getDraft(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        boolean r2 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return null;
    L9:
        String r3 = (String) ZeusTransformUtils.preCheckCast(this.savedStateHandle.get(KEY_REQUEST_CONTENT), String.class, "com.obric.memorydata.plugin");
        Long r7 = (Long) ZeusTransformUtils.preCheckCast(this.savedStateHandle.get(KEY_REQUEST_ID), Long.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L12;
        long r11 = r7.longValue();
    L13:
        Long r4 = (Long) ZeusTransformUtils.preCheckCast(this.savedStateHandle.get(KEY_SUBMITTED_AT), Long.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L16;
        long r14 = r4.longValue();
    L18:
        if (Intrinsics.areEqual(r3, r5) == true) goto L20;
    L24:
        r2 = false;
    L25:
        if (r2 == true) goto L28;
        r11 = com.obric.aiproactive.api.y.a();
    L28:
        if (r2 == true) goto L31;
        r14 = r17;
    L31:
        this.savedStateHandle.set(KEY_REQUEST_CONTENT, r5);
        this.savedStateHandle.set(KEY_REQUEST_ID, Long.valueOf(r11));
        this.savedStateHandle.set(KEY_SUBMITTED_AT, Long.valueOf(r14));
        return new com.obric.aiproactive.api.x(r5, r11, r14, null, 8, null);
    L20:
        if (r11 <= 0) goto L24;
        if (r14 <= 0) goto L24;
    L16:
        r14 = 0;
        goto L18
    L12:
        r11 = 0;
        goto L13
    L5:
        r1 = false;
        goto L6
    }
}
