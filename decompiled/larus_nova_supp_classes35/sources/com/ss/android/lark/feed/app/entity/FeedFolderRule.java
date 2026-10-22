package com.ss.android.lark.feed.app.entity;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/FeedFolderRule;", BuildConfig.FLAVOR, "additionFolderId", BuildConfig.FLAVOR, Keys.API_PARAM_KEY_ACTION, "Lcom/ss/android/lark/feed/app/entity/FeedFolderRule$ActionRule;", "scene", "Lcom/ss/android/lark/feed/app/entity/FeedFolderRule$RuleProperties;", "<init>", "(JLcom/ss/android/lark/feed/app/entity/FeedFolderRule$ActionRule;Lcom/ss/android/lark/feed/app/entity/FeedFolderRule$RuleProperties;)V", "getAdditionFolderId", "()J", "getAction", "()Lcom/ss/android/lark/feed/app/entity/FeedFolderRule$ActionRule;", "getScene", "()Lcom/ss/android/lark/feed/app/entity/FeedFolderRule$RuleProperties;", "toString", BuildConfig.FLAVOR, "ActionRule", "RuleProperties", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedFolderRule {
    private final ActionRule action;
    private final long additionFolderId;
    private final RuleProperties scene;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/FeedFolderRule$ActionRule;", BuildConfig.FLAVOR, "isEligible", BuildConfig.FLAVOR, "displayPriority", BuildConfig.FLAVOR, "importantMessageType", BuildConfig.FLAVOR, "<init>", "(ZILjava/util/List;)V", "()Z", "getDisplayPriority", "()I", "getImportantMessageType", "()Ljava/util/List;", "toString", BuildConfig.FLAVOR, "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ActionRule {
        private final int displayPriority;
        private final List<Integer> importantMessageType;
        private final boolean isEligible;

        public String toString() {
            return "ActionRule(isEligible=" + this.isEligible + ", displayPriority=" + this.displayPriority + ", importantMessageType=" + this.importantMessageType + ')';
        }

        public final int getDisplayPriority() {
            return this.displayPriority;
        }

        public final List<Integer> getImportantMessageType() {
            return this.importantMessageType;
        }

        public final boolean isEligible() {
            return this.isEligible;
        }

        public ActionRule(boolean r2, int r3, List<Integer> r4) {
            Intrinsics.checkNotNullParameter(r4, "importantMessageType");
            this.isEligible = r2;
            this.displayPriority = r3;
            this.importantMessageType = r4;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/FeedFolderRule$RuleProperties;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Immediate", "SwitchTab", "Companion", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RuleProperties extends Enum<RuleProperties> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ RuleProperties[] $VALUES = null;
        public static final Companion Companion = null;
        public static final RuleProperties Immediate = null;
        public static final RuleProperties SwitchTab = null;
        private final int value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/FeedFolderRule$RuleProperties$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "valueOf", "Lcom/ss/android/lark/feed/app/entity/FeedFolderRule$RuleProperties;", "value", BuildConfig.FLAVOR, "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            @JvmStatic
            public final RuleProperties valueOf(int r2) {
                if (r2 == 1) goto L9;
                if (r2 == 2) goto L11;
                return RuleProperties.Immediate;
            L11:
                return RuleProperties.SwitchTab;
            L9:
                return RuleProperties.Immediate;
            }
        }

        private static final /* synthetic */ RuleProperties[] $values() {
            return new RuleProperties[]{Immediate, SwitchTab};
        }

        public static EnumEntries<RuleProperties> getEntries() {
            return $ENTRIES;
        }

        @JvmStatic
        public static final RuleProperties valueOf(int r1) {
            return Companion.valueOf(r1);
        }

        static {
            Immediate = new RuleProperties("Immediate", 0, 1);
            SwitchTab = new RuleProperties("SwitchTab", 1, 2);
            RuleProperties[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
            Companion = new Companion(null);
        }

        public static RuleProperties[] values() {
            return (RuleProperties[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static RuleProperties valueOf(String r1) {
            return (RuleProperties) a.a(RuleProperties.class, r1);
        }

        private RuleProperties(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public String toString() {
        return "FeedFolderRule(additionFolderId=" + this.additionFolderId + ", action=" + this.action + ", scene=" + this.scene + ')';
    }

    public final ActionRule getAction() {
        return this.action;
    }

    public final long getAdditionFolderId() {
        return this.additionFolderId;
    }

    public final RuleProperties getScene() {
        return this.scene;
    }

    public FeedFolderRule(long r2, ActionRule r4, RuleProperties r5) {
        Intrinsics.checkNotNullParameter(r4, Keys.API_PARAM_KEY_ACTION);
        Intrinsics.checkNotNullParameter(r5, "scene");
        this.additionFolderId = r2;
        this.action = r4;
        this.scene = r5;
    }
}
