package com.obric.memorydata.memory.ui.feedback;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.memory.ui.list.MemoryTab;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0080\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B)\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackScene;", "", "descriptionTitleResId", "", "optionResIds", "", "attachmentType", "Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackAttachmentType;", "<init>", "(Ljava/lang/String;IILjava/util/List;Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackAttachmentType;)V", "getDescriptionTitleResId", "()I", "getOptionResIds", "()Ljava/util/List;", "getAttachmentType", "()Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackAttachmentType;", "SCREEN", "AUDIO", "AUTO_MEMORY_PRO", "COLLECTION_OR_PROFILE", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MemoryFeedbackScene extends Enum<MemoryFeedbackScene> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MemoryFeedbackScene[] $VALUES = null;
    public static final MemoryFeedbackScene AUDIO = null;
    public static final MemoryFeedbackScene AUTO_MEMORY_PRO = null;
    public static final MemoryFeedbackScene COLLECTION_OR_PROFILE = null;
    public static final a Companion = null;
    public static final MemoryFeedbackScene SCREEN = null;
    private final MemoryFeedbackAttachmentType attachmentType;
    private final int descriptionTitleResId;
    private final List<Integer> optionResIds;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackScene$Companion;", "", "<init>", "()V", "fromMemoryItem", "Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackScene;", "memoryItem", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "fromMemoryTab", "tab", "Lcom/obric/memorydata/memory/ui/list/MemoryTab;", "fromMemoryTab$memory_obricRelease", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.feedback.MemoryFeedbackScene$a$a, reason: collision with other inner class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class C0557a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f10924a = null;

            static {
                int[] r0 = new int[MemoryTab.values().length];
                r0[MemoryTab.COLLECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[MemoryTab.PROFILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f10924a = r0;
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final MemoryFeedbackScene a(com.obric.memorydata.memory.ui.data.a r4) {
            Intrinsics.checkNotNullParameter(r4, "memoryItem");
            if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L6;
            return MemoryFeedbackScene.SCREEN;
        L6:
            if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.memory.ui.data.a.C0539a.class) == false) goto L9;
            return MemoryFeedbackScene.AUDIO;
        L9:
            if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.memory.ui.data.a.b.class) == false) goto L12;
            return MemoryFeedbackScene.AUTO_MEMORY_PRO;
        L12:
            if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.memory.ui.data.a.h.class) == false) goto L16;
            com.obric.memorydata.memory.utils.f r0 = com.obric.memorydata.memory.utils.f.f11537a;
            MemoryEntity r5 = ((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b();
        L23:
            return a(r0.a((AppEntity) ZeusTransformUtils.preCheckCast(r5, AppEntity.class, "com.obric.memorydata.plugin")));
        L16:
            if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.memory.ui.data.a.e.class) == false) goto L18;
            r0 = com.obric.memorydata.memory.utils.f.f11537a;
            r5 = ((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b();
            goto L23
        L18:
            return null;
        }

        public final MemoryFeedbackScene a(MemoryTab r1) {
            Intrinsics.checkNotNullParameter(r1, "tab");
            int r0 = C0557a.f10924a[r1.ordinal()];
            if (r0 == 1) goto L8;
            if (r0 == 2) goto L8;
            return null;
        L8:
            return MemoryFeedbackScene.COLLECTION_OR_PROFILE;
        }
    }

    private static final /* synthetic */ MemoryFeedbackScene[] $values() {
        return new MemoryFeedbackScene[]{SCREEN, AUDIO, AUTO_MEMORY_PRO, COLLECTION_OR_PROFILE};
    }

    static {
        SCREEN = new MemoryFeedbackScene("SCREEN", 0, ZeusTransformUtils.mapRes(R.string.memory_global_feedback_title, TypedValues.Custom.S_STRING, "memory_global_feedback_title"), CollectionsKt.listOf(new Integer[]{Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feedback_content_wrong, TypedValues.Custom.S_STRING, "memory_feedback_content_wrong")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feedback_content_missing, TypedValues.Custom.S_STRING, "memory_feedback_content_missing")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feedback_content_redundant, TypedValues.Custom.S_STRING, "memory_feedback_content_redundant")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feedback_content_meaningless, TypedValues.Custom.S_STRING, "memory_feedback_content_meaningless")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feedback_blocked_content_recorded, TypedValues.Custom.S_STRING, "memory_feedback_blocked_content_recorded")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feed_back_other_title, TypedValues.Custom.S_STRING, "memory_feed_back_other_title"))}), MemoryFeedbackAttachmentType.SCREEN_ENTITY_JSON);
        AUDIO = new MemoryFeedbackScene("AUDIO", 1, ZeusTransformUtils.mapRes(R.string.memory_global_feedback_title, TypedValues.Custom.S_STRING, "memory_global_feedback_title"), CollectionsKt.listOf(new Integer[]{Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feedback_content_wrong, TypedValues.Custom.S_STRING, "memory_feedback_content_wrong")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feedback_content_missing, TypedValues.Custom.S_STRING, "memory_feedback_content_missing")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feedback_content_redundant, TypedValues.Custom.S_STRING, "memory_feedback_content_redundant")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feedback_content_meaningless, TypedValues.Custom.S_STRING, "memory_feedback_content_meaningless")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feed_back_other_title, TypedValues.Custom.S_STRING, "memory_feed_back_other_title"))}), MemoryFeedbackAttachmentType.AUDIO_ENTITY_JSON);
        AUTO_MEMORY_PRO = new MemoryFeedbackScene("AUTO_MEMORY_PRO", 2, ZeusTransformUtils.mapRes(R.string.memory_auto_pro_feedback_pro_title, TypedValues.Custom.S_STRING, "memory_auto_pro_feedback_pro_title"), CollectionsKt.listOf(new Integer[]{Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feedback_content_wrong, TypedValues.Custom.S_STRING, "memory_feedback_content_wrong")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feedback_content_missing, TypedValues.Custom.S_STRING, "memory_feedback_content_missing")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feedback_content_redundant, TypedValues.Custom.S_STRING, "memory_feedback_content_redundant")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feedback_content_meaningless, TypedValues.Custom.S_STRING, "memory_feedback_content_meaningless")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feedback_format_issue, TypedValues.Custom.S_STRING, "memory_feedback_format_issue")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feedback_not_updated_or_duplicated, TypedValues.Custom.S_STRING, "memory_feedback_not_updated_or_duplicated")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feed_back_other_title, TypedValues.Custom.S_STRING, "memory_feed_back_other_title"))}), MemoryFeedbackAttachmentType.AUTO_MEMORY_PRO_PACKAGE);
        COLLECTION_OR_PROFILE = new MemoryFeedbackScene("COLLECTION_OR_PROFILE", 3, ZeusTransformUtils.mapRes(R.string.memory_global_feedback_title, TypedValues.Custom.S_STRING, "memory_global_feedback_title"), CollectionsKt.listOf(new Integer[]{Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feedback_content_wrong, TypedValues.Custom.S_STRING, "memory_feedback_content_wrong")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feedback_content_missing, TypedValues.Custom.S_STRING, "memory_feedback_content_missing")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feedback_content_redundant, TypedValues.Custom.S_STRING, "memory_feedback_content_redundant")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feedback_category_wrong, TypedValues.Custom.S_STRING, "memory_feedback_category_wrong")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feedback_format_issue, TypedValues.Custom.S_STRING, "memory_feedback_format_issue")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feed_back_other_title, TypedValues.Custom.S_STRING, "memory_feed_back_other_title"))}), MemoryFeedbackAttachmentType.COLLECTION_OR_PROFILE_LEGACY);
        MemoryFeedbackScene[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private MemoryFeedbackScene(String r3, int r4, int r5, List r6, MemoryFeedbackAttachmentType r7) {
        List<Integer> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        super(r3, r4);
        this.descriptionTitleResId = r5;
        this.optionResIds = r8;
        this.attachmentType = r7;
    }

    public static EnumEntries<MemoryFeedbackScene> getEntries() {
        return $ENTRIES;
    }

    public static MemoryFeedbackScene valueOf(String r2) {
        return (MemoryFeedbackScene) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryFeedbackScene.class, r2), MemoryFeedbackScene.class, "com.obric.memorydata.plugin");
    }

    public static MemoryFeedbackScene[] values() {
        return (MemoryFeedbackScene[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryFeedbackScene[].class, "com.obric.memorydata.plugin");
    }

    public final MemoryFeedbackAttachmentType getAttachmentType() {
        return this.attachmentType;
    }

    public final int getDescriptionTitleResId() {
        return this.descriptionTitleResId;
    }

    public final List<Integer> getOptionResIds() {
        return this.optionResIds;
    }
}
