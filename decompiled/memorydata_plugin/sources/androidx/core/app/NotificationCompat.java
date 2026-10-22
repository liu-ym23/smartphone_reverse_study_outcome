package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.LocusId;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class NotificationCompat {
    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_LOCATION_SHARING = "location_sharing";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_MISSED_CALL = "missed_call";
    public static final String CATEGORY_NAVIGATION = "navigation";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_STOPWATCH = "stopwatch";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    public static final String CATEGORY_WORKOUT = "workout";
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_ANSWER_COLOR = "android.answerColor";
    public static final String EXTRA_ANSWER_INTENT = "android.answerIntent";
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    public static final String EXTRA_CALL_IS_VIDEO = "android.callIsVideo";
    public static final String EXTRA_CALL_PERSON = "android.callPerson";
    public static final String EXTRA_CALL_PERSON_COMPAT = "android.callPersonCompat";
    public static final String EXTRA_CALL_TYPE = "android.callType";
    public static final String EXTRA_CHANNEL_GROUP_ID = "android.intent.extra.CHANNEL_GROUP_ID";
    public static final String EXTRA_CHANNEL_ID = "android.intent.extra.CHANNEL_ID";
    public static final String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";
    public static final String EXTRA_COLORIZED = "android.colorized";
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_COMPAT_TEMPLATE = "androidx.core.app.extra.COMPAT_TEMPLATE";
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
    public static final String EXTRA_DECLINE_COLOR = "android.declineColor";
    public static final String EXTRA_DECLINE_INTENT = "android.declineIntent";
    public static final String EXTRA_HANG_UP_INTENT = "android.hangUpIntent";
    public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";
    public static final String EXTRA_HISTORIC_MESSAGES = "android.messages.historic";
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final String EXTRA_MESSAGES = "android.messages";
    public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";
    public static final String EXTRA_NOTIFICATION_ID = "android.intent.extra.NOTIFICATION_ID";
    public static final String EXTRA_NOTIFICATION_TAG = "android.intent.extra.NOTIFICATION_TAG";

    @Deprecated
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PEOPLE_LIST = "android.people.list";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PICTURE_CONTENT_DESCRIPTION = "android.pictureContentDescription";
    public static final String EXTRA_PICTURE_ICON = "android.pictureIcon";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
    public static final String EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED = "android.showBigPictureWhenCollapsed";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEMPLATE = "android.template";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final String EXTRA_VERIFICATION_ICON = "android.verificationIcon";
    public static final String EXTRA_VERIFICATION_ICON_COMPAT = "android.verificationIconCompat";
    public static final String EXTRA_VERIFICATION_TEXT = "android.verificationText";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_BUBBLE = 4096;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;

    @Deprecated
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int FOREGROUND_SERVICE_DEFAULT = 0;
    public static final int FOREGROUND_SERVICE_DEFERRED = 2;
    public static final int FOREGROUND_SERVICE_IMMEDIATE = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    public static final String GROUP_KEY_SILENT = "silent";
    public static final String INTENT_CATEGORY_NOTIFICATION_PREFERENCES = "android.intent.category.NOTIFICATION_PREFERENCES";
    public static final int MAX_ACTION_BUTTONS = 3;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    private static final String TAG = "NotifCompat";
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    /* JADX INFO: renamed from: androidx.core.app.NotificationCompat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Action {
        static final String EXTRA_SEMANTIC_ACTION = "android.support.action.semanticAction";
        static final String EXTRA_SHOWS_USER_INTERFACE = "android.support.action.showsUserInterface";
        public static final int SEMANTIC_ACTION_ARCHIVE = 5;
        public static final int SEMANTIC_ACTION_CALL = 10;
        public static final int SEMANTIC_ACTION_DELETE = 4;
        public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
        public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
        public static final int SEMANTIC_ACTION_MUTE = 6;
        public static final int SEMANTIC_ACTION_NONE = 0;
        public static final int SEMANTIC_ACTION_REPLY = 1;
        public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
        public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
        public static final int SEMANTIC_ACTION_UNMUTE = 7;
        public PendingIntent actionIntent;

        @Deprecated
        public int icon;
        private boolean mAllowGeneratedReplies;
        private boolean mAuthenticationRequired;
        private final RemoteInput[] mDataOnlyRemoteInputs;
        final Bundle mExtras;
        private IconCompat mIcon;
        private final boolean mIsContextual;
        private final RemoteInput[] mRemoteInputs;
        private final int mSemanticAction;
        boolean mShowsUserInterface;
        public CharSequence title;

        public static final class Builder {
            private boolean mAllowGeneratedReplies;
            private boolean mAuthenticationRequired;
            private final Bundle mExtras;
            private final IconCompat mIcon;
            private final PendingIntent mIntent;
            private boolean mIsContextual;
            private ArrayList<RemoteInput> mRemoteInputs;
            private int mSemanticAction;
            private boolean mShowsUserInterface;
            private final CharSequence mTitle;

            static class Api20Impl {
                private Api20Impl() {
                }

                static Bundle getExtras(Notification.Action r0) {
                    return r0.getExtras();
                }

                static android.app.RemoteInput[] getRemoteInputs(Notification.Action r0) {
                    return r0.getRemoteInputs();
                }
            }

            static class Api23Impl {
                private Api23Impl() {
                }

                static Icon getIcon(Notification.Action r0) {
                    return r0.getIcon();
                }
            }

            static class Api24Impl {
                private Api24Impl() {
                }

                static boolean getAllowGeneratedReplies(Notification.Action r0) {
                    return r0.getAllowGeneratedReplies();
                }
            }

            static class Api28Impl {
                private Api28Impl() {
                }

                static int getSemanticAction(Notification.Action r0) {
                    return r0.getSemanticAction();
                }
            }

            static class Api29Impl {
                private Api29Impl() {
                }

                static boolean isContextual(Notification.Action r0) {
                    return r0.isContextual();
                }
            }

            static class Api31Impl {
                private Api31Impl() {
                }

                static boolean isAuthenticationRequired(Notification.Action r0) {
                    return r0.isAuthenticationRequired();
                }
            }

            public Builder(int r12, CharSequence r13, PendingIntent r14) {
                CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin");
                if (r12 != 0) goto L5;
                IconCompat r1 = null;
            L6:
                this(r1, r2, r14, new Bundle(), null, true, 0, true, false, false);
                return;
            L5:
                r1 = IconCompat.createWithResource(null, "", r12);
                goto L6
            }

            public Builder(Action r12) {
                this(r12.getIconCompat(), r12.title, r12.actionIntent, new Bundle(r12.mExtras), r12.getRemoteInputs(), r12.getAllowGeneratedReplies(), r12.getSemanticAction(), r12.mShowsUserInterface, r12.isContextual(), r12.isAuthenticationRequired());
            }

            public Builder(IconCompat r12, CharSequence r13, PendingIntent r14) {
                this(r12, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin"), r14, new Bundle(), null, true, 0, true, false, false);
            }

            private Builder(IconCompat r3, CharSequence r4, PendingIntent r5, Bundle r6, RemoteInput[] r7, boolean r8, int r9, boolean r10, boolean r11, boolean r12) {
                CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
                this.mAllowGeneratedReplies = true;
                this.mShowsUserInterface = true;
                this.mIcon = r3;
                this.mTitle = Builder.limitCharSequenceLength(r13);
                this.mIntent = r5;
                this.mExtras = r6;
                if (r7 != null) goto L5;
                ArrayList<RemoteInput> r14 = null;
            L6:
                this.mRemoteInputs = r14;
                this.mAllowGeneratedReplies = r8;
                this.mSemanticAction = r9;
                this.mShowsUserInterface = r10;
                this.mIsContextual = r11;
                this.mAuthenticationRequired = r12;
                return;
            L5:
                r14 = new ArrayList(Arrays.asList(r7));
                goto L6
            }

            private void checkContextualActionNullFields() {
                if (this.mIsContextual == true) goto L5;
                return;
            L5:
                Objects.requireNonNull(this.mIntent, "Contextual Actions must contain a valid PendingIntent");
            }

            public static Builder fromAndroidAction(Notification.Action r6) {
                if (Build.VERSION.SDK_INT >= 23) goto L5;
            L7:
                Builder r1 = new Builder(r6.icon, r6.title, r6.actionIntent);
            L9:
                if (Build.VERSION.SDK_INT < 20) goto L18;
                android.app.RemoteInput[] r0 = Api20Impl.getRemoteInputs(r6);
                if (r0 == null) goto L18;
                if (r0.length == 0) goto L18;
                int r3 = r0.length;
                int r4 = 0;
            L15:
                if (r4 >= r3) goto L18;
                r1.addRemoteInput(RemoteInput.fromPlatform(r0[r4]));
                r4 = r4 + 1;
            L18:
                if (Build.VERSION.SDK_INT < 24) goto L21;
                r1.mAllowGeneratedReplies = Api24Impl.getAllowGeneratedReplies(r6);
            L21:
                if (Build.VERSION.SDK_INT < 28) goto L24;
                r1.setSemanticAction(Api28Impl.getSemanticAction(r6));
            L24:
                if (Build.VERSION.SDK_INT < 29) goto L27;
                r1.setContextual(Api29Impl.isContextual(r6));
            L27:
                if (Build.VERSION.SDK_INT < 31) goto L30;
                r1.setAuthenticationRequired(Api31Impl.isAuthenticationRequired(r6));
            L30:
                if (Build.VERSION.SDK_INT < 20) goto L32;
                r1.addExtras(Api20Impl.getExtras(r6));
            L32:
                return r1;
            L5:
                if (Api23Impl.getIcon(r6) == null) goto L7;
                r1 = new Builder(IconCompat.createFromIconOrNullIfZeroResId(Api23Impl.getIcon(r6)), r6.title, r6.actionIntent);
                goto L9
            }

            public Builder addExtras(Bundle r2) {
                if (r2 == null) goto L4;
                this.mExtras.putAll(r2);
            L4:
                return this;
            }

            public Builder addRemoteInput(RemoteInput r2) {
                if (this.mRemoteInputs != null) goto L5;
                this.mRemoteInputs = new ArrayList();
            L5:
                if (r2 == null) goto L7;
                this.mRemoteInputs.add(r2);
            L7:
                return this;
            }

            public Action build() {
                checkContextualActionNullFields();
                ArrayList r1 = new ArrayList();
                ArrayList r2 = new ArrayList();
                ArrayList<RemoteInput> r3 = this.mRemoteInputs;
                if (r3 == null) goto L11;
                Iterator<RemoteInput> r4 = r3.iterator();
            L6:
                if (r4.hasNext() == false) goto L11;
                RemoteInput r5 = (RemoteInput) ZeusTransformUtils.preCheckCast(r4.next(), RemoteInput.class, "com.obric.memorydata.plugin");
                if (r5.isDataOnly() == true) goto L9;
                r2.add(r5);
                goto L6
            L9:
                r1.add(r5);
            L11:
                RemoteInput[] r6 = null;
                if (r1.isEmpty() == false) goto L14;
                RemoteInput[] r12 = null;
            L16:
                if (r2.isEmpty() == true) goto L20;
                r6 = (RemoteInput[]) ZeusTransformUtils.preCheckCast(r2.toArray(new RemoteInput[r2.size()]), RemoteInput[].class, "com.obric.memorydata.plugin");
            L20:
                return new Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, r6, r12, this.mAllowGeneratedReplies, this.mSemanticAction, this.mShowsUserInterface, this.mIsContextual, this.mAuthenticationRequired);
            L14:
                r12 = (RemoteInput[]) ZeusTransformUtils.preCheckCast(r1.toArray(new RemoteInput[r1.size()]), RemoteInput[].class, "com.obric.memorydata.plugin");
                goto L16
            }

            public Builder extend(Extender r3) {
                ((Extender) ZeusTransformUtils.wrapperContextForParams(r3, Extender.class, "com.obric.memorydata.plugin")).extend(this);
                return this;
            }

            public Bundle getExtras() {
                return this.mExtras;
            }

            public Builder setAllowGeneratedReplies(boolean r1) {
                this.mAllowGeneratedReplies = r1;
                return this;
            }

            public Builder setAuthenticationRequired(boolean r1) {
                this.mAuthenticationRequired = r1;
                return this;
            }

            public Builder setContextual(boolean r1) {
                this.mIsContextual = r1;
                return this;
            }

            public Builder setSemanticAction(int r1) {
                this.mSemanticAction = r1;
                return this;
            }

            public Builder setShowsUserInterface(boolean r1) {
                this.mShowsUserInterface = r1;
                return this;
            }
        }

        public interface Extender {
            Builder extend(Builder r1);
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface SemanticAction {
        }

        public static final class WearableExtender implements Extender {
            private static final int DEFAULT_FLAGS = 1;
            private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
            private static final int FLAG_AVAILABLE_OFFLINE = 1;
            private static final int FLAG_HINT_DISPLAY_INLINE = 4;
            private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
            private static final String KEY_CANCEL_LABEL = "cancelLabel";
            private static final String KEY_CONFIRM_LABEL = "confirmLabel";
            private static final String KEY_FLAGS = "flags";
            private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
            private CharSequence mCancelLabel;
            private CharSequence mConfirmLabel;
            private int mFlags;
            private CharSequence mInProgressLabel;

            public WearableExtender() {
                this.mFlags = 1;
            }

            public WearableExtender(Action r3) {
                this.mFlags = 1;
                Bundle r4 = r3.getExtras().getBundle(EXTRA_WEARABLE_EXTENSIONS);
                if (r4 == null) goto L6;
                this.mFlags = r4.getInt(KEY_FLAGS, 1);
                this.mInProgressLabel = r4.getCharSequence(KEY_IN_PROGRESS_LABEL);
                this.mConfirmLabel = r4.getCharSequence(KEY_CONFIRM_LABEL);
                this.mCancelLabel = r4.getCharSequence(KEY_CANCEL_LABEL);
                return;
            }

            private void setFlag(int r1, boolean r2) {
                if (r2 == false) goto L4;
                int r3 = r1 | this.mFlags;
            L5:
                this.mFlags = r3;
                return;
            L4:
                int r4 = this.mFlags;
                r3 = (~r1) & r4;
                goto L5
            }

            public WearableExtender clone() {
                WearableExtender r0 = new WearableExtender();
                r0.mFlags = this.mFlags;
                r0.mInProgressLabel = this.mInProgressLabel;
                r0.mConfirmLabel = this.mConfirmLabel;
                r0.mCancelLabel = this.mCancelLabel;
                return r0;
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m39clone() {
                return clone();
            }

            @Override // androidx.core.app.NotificationCompat.Action.Extender
            public Builder extend(Builder r4) {
                Bundle r0 = new Bundle();
                int r1 = this.mFlags;
                if (r1 == 1) goto L5;
                r0.putInt(KEY_FLAGS, r1);
            L5:
                CharSequence r2 = this.mInProgressLabel;
                if (r2 == null) goto L8;
                r0.putCharSequence(KEY_IN_PROGRESS_LABEL, r2);
            L8:
                CharSequence r3 = this.mConfirmLabel;
                if (r3 == null) goto L11;
                r0.putCharSequence(KEY_CONFIRM_LABEL, r3);
            L11:
                CharSequence r5 = this.mCancelLabel;
                if (r5 == null) goto L14;
                r0.putCharSequence(KEY_CANCEL_LABEL, r5);
            L14:
                r4.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, r0);
                return r4;
            }

            @Deprecated
            public CharSequence getCancelLabel() {
                return this.mCancelLabel;
            }

            @Deprecated
            public CharSequence getConfirmLabel() {
                return this.mConfirmLabel;
            }

            public boolean getHintDisplayActionInline() {
                if ((this.mFlags & 4) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean getHintLaunchesActivity() {
                if ((this.mFlags & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Deprecated
            public CharSequence getInProgressLabel() {
                return this.mInProgressLabel;
            }

            public boolean isAvailableOffline() {
                if ((this.mFlags & 1) != 0) goto L7;
                return false;
            L7:
                return true;
            }

            public WearableExtender setAvailableOffline(boolean r2) {
                setFlag(1, r2);
                return this;
            }

            @Deprecated
            public WearableExtender setCancelLabel(CharSequence r3) {
                this.mCancelLabel = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
                return this;
            }

            @Deprecated
            public WearableExtender setConfirmLabel(CharSequence r3) {
                this.mConfirmLabel = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
                return this;
            }

            public WearableExtender setHintDisplayActionInline(boolean r2) {
                setFlag(4, r2);
                return this;
            }

            public WearableExtender setHintLaunchesActivity(boolean r2) {
                setFlag(2, r2);
                return this;
            }

            @Deprecated
            public WearableExtender setInProgressLabel(CharSequence r3) {
                this.mInProgressLabel = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
                return this;
            }
        }

        public Action(int r3, CharSequence r4, PendingIntent r5) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
            IconCompat r0 = null;
            if (r3 == 0) goto L6;
            r0 = IconCompat.createWithResource(null, "", r3);
        L6:
            this(r0, r6, r5);
        }

        Action(int r15, CharSequence r16, PendingIntent r17, Bundle r18, RemoteInput[] r19, RemoteInput[] r20, boolean r21, int r22, boolean r23, boolean r24, boolean r25) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r16, CharSequence.class, "com.obric.memorydata.plugin");
            if (r15 != 0) goto L5;
            IconCompat r3 = null;
        L6:
            this(r3, r4, r17, r18, r19, r20, r21, r22, r23, r24, r25);
            return;
        L5:
            r3 = IconCompat.createWithResource(null, "", r15);
            goto L6
        }

        public Action(IconCompat r13, CharSequence r14, PendingIntent r15) {
            this(r13, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r14, CharSequence.class, "com.obric.memorydata.plugin"), r15, new Bundle(), null, null, true, 0, true, false, false);
        }

        Action(IconCompat r3, CharSequence r4, PendingIntent r5, Bundle r6, RemoteInput[] r7, RemoteInput[] r8, boolean r9, int r10, boolean r11, boolean r12, boolean r13) {
            CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
            this.mShowsUserInterface = true;
            this.mIcon = r3;
            if (r3 != null) goto L5;
        L7:
            this.title = Builder.limitCharSequenceLength(r14);
            this.actionIntent = r5;
            if (r6 != null) goto L11;
            r6 = new Bundle();
        L11:
            this.mExtras = r6;
            this.mRemoteInputs = r7;
            this.mDataOnlyRemoteInputs = r8;
            this.mAllowGeneratedReplies = r9;
            this.mSemanticAction = r10;
            this.mShowsUserInterface = r11;
            this.mIsContextual = r12;
            this.mAuthenticationRequired = r13;
            return;
        L5:
            if (r3.getType() != 2) goto L7;
            this.icon = r3.getResId();
            goto L7
        }

        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public boolean getAllowGeneratedReplies() {
            return this.mAllowGeneratedReplies;
        }

        public RemoteInput[] getDataOnlyRemoteInputs() {
            return this.mDataOnlyRemoteInputs;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        @Deprecated
        public int getIcon() {
            return this.icon;
        }

        public IconCompat getIconCompat() {
            if (this.mIcon != null) goto L8;
            int r0 = this.icon;
            if (r0 == 0) goto L8;
            this.mIcon = IconCompat.createWithResource(null, "", r0);
        L8:
            return this.mIcon;
        }

        public RemoteInput[] getRemoteInputs() {
            return this.mRemoteInputs;
        }

        public int getSemanticAction() {
            return this.mSemanticAction;
        }

        public boolean getShowsUserInterface() {
            return this.mShowsUserInterface;
        }

        public CharSequence getTitle() {
            return this.title;
        }

        public boolean isAuthenticationRequired() {
            return this.mAuthenticationRequired;
        }

        public boolean isContextual() {
            return this.mIsContextual;
        }
    }

    static class Api20Impl {
        private Api20Impl() {
        }

        static boolean getAllowFreeFormInput(android.app.RemoteInput r0) {
            return r0.getAllowFreeFormInput();
        }

        static CharSequence[] getChoices(android.app.RemoteInput r0) {
            return r0.getChoices();
        }

        static Bundle getExtras(Notification.Action r0) {
            return r0.getExtras();
        }

        static Bundle getExtras(android.app.RemoteInput r0) {
            return r0.getExtras();
        }

        static String getGroup(Notification r0) {
            return r0.getGroup();
        }

        static CharSequence getLabel(android.app.RemoteInput r0) {
            return r0.getLabel();
        }

        static android.app.RemoteInput[] getRemoteInputs(Notification.Action r0) {
            return r0.getRemoteInputs();
        }

        static String getResultKey(android.app.RemoteInput r0) {
            return r0.getResultKey();
        }

        static String getSortKey(Notification r0) {
            return r0.getSortKey();
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static Icon getIcon(Notification.Action r0) {
            return r0.getIcon();
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static boolean getAllowGeneratedReplies(Notification.Action r0) {
            return r0.getAllowGeneratedReplies();
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static int getBadgeIconType(Notification r0) {
            return r0.getBadgeIconType();
        }

        static String getChannelId(Notification r0) {
            return r0.getChannelId();
        }

        static int getGroupAlertBehavior(Notification r0) {
            return r0.getGroupAlertBehavior();
        }

        static CharSequence getSettingsText(Notification r0) {
            return r0.getSettingsText();
        }

        static String getShortcutId(Notification r0) {
            return r0.getShortcutId();
        }

        static long getTimeoutAfter(Notification r2) {
            return r2.getTimeoutAfter();
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static int getSemanticAction(Notification.Action r0) {
            return r0.getSemanticAction();
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static boolean getAllowSystemGeneratedContextualActions(Notification r0) {
            return r0.getAllowSystemGeneratedContextualActions();
        }

        static Notification.BubbleMetadata getBubbleMetadata(Notification r0) {
            return r0.getBubbleMetadata();
        }

        static int getEditChoicesBeforeSending(android.app.RemoteInput r0) {
            return r0.getEditChoicesBeforeSending();
        }

        static LocusId getLocusId(Notification r0) {
            return r0.getLocusId();
        }

        static boolean isContextual(Notification.Action r0) {
            return r0.isContextual();
        }
    }

    static class Api31Impl {
        private Api31Impl() {
        }

        static boolean isAuthenticationRequired(Notification.Action r0) {
            return r0.isAuthenticationRequired();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeIconType {
    }

    public static class BigPictureStyle extends Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigPictureStyle";
        private IconCompat mBigLargeIcon;
        private boolean mBigLargeIconSet;
        private CharSequence mPictureContentDescription;
        private IconCompat mPictureIcon;
        private boolean mShowBigPictureWhenCollapsed;

        private static class Api16Impl {
            private Api16Impl() {
            }

            static Notification.BigPictureStyle bigPicture(Notification.BigPictureStyle r0, Bitmap r1) {
                return r0.bigPicture(r1);
            }

            static Notification.BigPictureStyle createBigPictureStyle(Notification.Builder r1) {
                return new Notification.BigPictureStyle(r1);
            }

            static Notification.BigPictureStyle setBigContentTitle(Notification.BigPictureStyle r2, CharSequence r3) {
                return r2.setBigContentTitle((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            }

            static void setBigLargeIcon(Notification.BigPictureStyle r0, Bitmap r1) {
                r0.bigLargeIcon(r1);
            }

            static void setSummaryText(Notification.BigPictureStyle r2, CharSequence r3) {
                r2.setSummaryText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            }
        }

        private static class Api23Impl {
            private Api23Impl() {
            }

            static void setBigLargeIcon(Notification.BigPictureStyle r0, Icon r1) {
                r0.bigLargeIcon(r1);
            }
        }

        private static class Api31Impl {
            private Api31Impl() {
            }

            static void setBigPicture(Notification.BigPictureStyle r0, Icon r1) {
                r0.bigPicture(r1);
            }

            static void setContentDescription(Notification.BigPictureStyle r2, CharSequence r3) {
                r2.setContentDescription((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            }

            static void showBigPictureWhenCollapsed(Notification.BigPictureStyle r0, boolean r1) {
                r0.showBigPictureWhenCollapsed(r1);
            }
        }

        public BigPictureStyle() {
        }

        public BigPictureStyle(Builder r1) {
            setBuilder(r1);
        }

        private static IconCompat asIconCompat(Parcelable r3) {
            Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L5;
            return null;
        L5:
            if (Build.VERSION.SDK_INT < 23) goto L11;
            if (ZeusTransformUtils.instanceOf(r4, Icon.class) == false) goto L11;
            return IconCompat.createFromIcon((Icon) ZeusTransformUtils.preCheckCast(r4, Icon.class, "com.obric.memorydata.plugin"));
        L11:
            if (ZeusTransformUtils.instanceOf(r4, Bitmap.class) == true) goto L13;
            return null;
        L13:
            return IconCompat.createWithBitmap((Bitmap) ZeusTransformUtils.preCheckCast(r4, Bitmap.class, "com.obric.memorydata.plugin"));
        }

        public static IconCompat getPictureIcon(Bundle r1) {
            if (r1 != null) goto L5;
            return null;
        L5:
            Parcelable r0 = r1.getParcelable(NotificationCompat.EXTRA_PICTURE);
            if (r0 == null) goto L10;
            return asIconCompat(r0);
        L10:
            return asIconCompat(r1.getParcelable(NotificationCompat.EXTRA_PICTURE_ICON));
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor r8) {
            NotificationBuilderWithBuilderAccessor r9 = (NotificationBuilderWithBuilderAccessor) ZeusTransformUtils.wrapperContextForParams(r8, NotificationBuilderWithBuilderAccessor.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT < 16) goto L37;
            Notification.BigPictureStyle r0 = Api16Impl.setBigContentTitle(Api16Impl.createBigPictureStyle(r9.getBuilder()), this.mBigContentTitle);
            Context r5 = null;
            if (this.mPictureIcon == null) goto L17;
            if (Build.VERSION.SDK_INT < 31) goto L14;
            if (ZeusTransformUtils.instanceOf(r9, NotificationCompatBuilder.class) == false) goto L11;
            Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((NotificationCompatBuilder) ZeusTransformUtils.preCheckCast(r9, NotificationCompatBuilder.class, "com.obric.memorydata.plugin")).getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        L12:
            Api31Impl.setBigPicture(r0, this.mPictureIcon.toIcon(r2));
            goto L17
        L11:
            r2 = null;
            goto L12
        L14:
            if (this.mPictureIcon.getType() != 1) goto L17;
            r0 = Api16Impl.bigPicture(r0, this.mPictureIcon.getBitmap());
        L17:
            if (this.mBigLargeIconSet == false) goto L31;
            if (this.mBigLargeIcon != null) goto L22;
        L20:
            Api16Impl.setBigLargeIcon(r0, null);
            goto L31
        L22:
            if (Build.VERSION.SDK_INT < 23) goto L28;
            if (ZeusTransformUtils.instanceOf(r9, NotificationCompatBuilder.class) == false) goto L26;
            r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((NotificationCompatBuilder) ZeusTransformUtils.preCheckCast(r9, NotificationCompatBuilder.class, "com.obric.memorydata.plugin")).getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        L26:
            Api23Impl.setBigLargeIcon(r0, this.mBigLargeIcon.toIcon(r5));
            goto L31
        L28:
            if (this.mBigLargeIcon.getType() != 1) goto L20;
            Api16Impl.setBigLargeIcon(r0, this.mBigLargeIcon.getBitmap());
        L31:
            if (this.mSummaryTextSet == false) goto L34;
            Api16Impl.setSummaryText(r0, this.mSummaryText);
        L34:
            if (Build.VERSION.SDK_INT < 31) goto L38;
            Api31Impl.showBigPictureWhenCollapsed(r0, this.mShowBigPictureWhenCollapsed);
            Api31Impl.setContentDescription(r0, this.mPictureContentDescription);
            return;
        L38:
            return;
        }

        public BigPictureStyle bigLargeIcon(Bitmap r1) {
            if (r1 != null) goto L4;
            IconCompat r2 = null;
        L5:
            this.mBigLargeIcon = r2;
            this.mBigLargeIconSet = true;
            return this;
        L4:
            r2 = IconCompat.createWithBitmap(r1);
            goto L5
        }

        public BigPictureStyle bigLargeIcon(Icon r1) {
            if (r1 != null) goto L4;
            IconCompat r2 = null;
        L5:
            this.mBigLargeIcon = r2;
            this.mBigLargeIconSet = true;
            return this;
        L4:
            r2 = IconCompat.createFromIcon(r1);
            goto L5
        }

        public BigPictureStyle bigPicture(Bitmap r1) {
            if (r1 != null) goto L4;
            IconCompat r2 = null;
        L5:
            this.mPictureIcon = r2;
            return this;
        L4:
            r2 = IconCompat.createWithBitmap(r1);
            goto L5
        }

        public BigPictureStyle bigPicture(Icon r1) {
            this.mPictureIcon = IconCompat.createFromIcon(r1);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void clearCompatExtraKeys(Bundle r1) {
            super.clearCompatExtraKeys(r1);
            r1.remove(NotificationCompat.EXTRA_LARGE_ICON_BIG);
            r1.remove(NotificationCompat.EXTRA_PICTURE);
            r1.remove(NotificationCompat.EXTRA_PICTURE_ICON);
            r1.remove(NotificationCompat.EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void restoreFromCompatExtras(Bundle r3) {
            super.restoreFromCompatExtras(r3);
            if (r3.containsKey(NotificationCompat.EXTRA_LARGE_ICON_BIG) == false) goto L5;
            this.mBigLargeIcon = asIconCompat(r3.getParcelable(NotificationCompat.EXTRA_LARGE_ICON_BIG));
            this.mBigLargeIconSet = true;
        L5:
            this.mPictureIcon = getPictureIcon(r3);
            this.mShowBigPictureWhenCollapsed = r3.getBoolean(NotificationCompat.EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED);
        }

        public BigPictureStyle setBigContentTitle(CharSequence r3) {
            this.mBigContentTitle = Builder.limitCharSequenceLength((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public BigPictureStyle setContentDescription(CharSequence r3) {
            this.mPictureContentDescription = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            return this;
        }

        public BigPictureStyle setSummaryText(CharSequence r3) {
            this.mSummaryText = Builder.limitCharSequenceLength((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            this.mSummaryTextSet = true;
            return this;
        }

        public BigPictureStyle showBigPictureWhenCollapsed(boolean r1) {
            this.mShowBigPictureWhenCollapsed = r1;
            return this;
        }
    }

    public static class BigTextStyle extends Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigTextStyle";
        private CharSequence mBigText;

        static class Api16Impl {
            private Api16Impl() {
            }

            static Notification.BigTextStyle bigText(Notification.BigTextStyle r2, CharSequence r3) {
                return r2.bigText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            }

            static Notification.BigTextStyle createBigTextStyle(Notification.Builder r1) {
                return new Notification.BigTextStyle(r1);
            }

            static Notification.BigTextStyle setBigContentTitle(Notification.BigTextStyle r2, CharSequence r3) {
                return r2.setBigContentTitle((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            }

            static Notification.BigTextStyle setSummaryText(Notification.BigTextStyle r2, CharSequence r3) {
                return r2.setSummaryText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            }
        }

        public BigTextStyle() {
        }

        public BigTextStyle(Builder r1) {
            setBuilder(r1);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void addCompatExtras(Bundle r3) {
            super.addCompatExtras(r3);
            if (Build.VERSION.SDK_INT >= 21) goto L6;
            r3.putCharSequence(NotificationCompat.EXTRA_BIG_TEXT, this.mBigText);
            return;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor r3) {
            NotificationBuilderWithBuilderAccessor r4 = (NotificationBuilderWithBuilderAccessor) ZeusTransformUtils.wrapperContextForParams(r3, NotificationBuilderWithBuilderAccessor.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT < 16) goto L8;
            Notification.BigTextStyle r5 = Api16Impl.bigText(Api16Impl.setBigContentTitle(Api16Impl.createBigTextStyle(r4.getBuilder()), this.mBigContentTitle), this.mBigText);
            if (this.mSummaryTextSet == false) goto L9;
            Api16Impl.setSummaryText(r5, this.mSummaryText);
            return;
        L9:
            return;
        }

        public BigTextStyle bigText(CharSequence r3) {
            this.mBigText = Builder.limitCharSequenceLength((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void clearCompatExtraKeys(Bundle r1) {
            super.clearCompatExtraKeys(r1);
            r1.remove(NotificationCompat.EXTRA_BIG_TEXT);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void restoreFromCompatExtras(Bundle r2) {
            super.restoreFromCompatExtras(r2);
            this.mBigText = r2.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
        }

        public BigTextStyle setBigContentTitle(CharSequence r3) {
            this.mBigContentTitle = Builder.limitCharSequenceLength((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public BigTextStyle setSummaryText(CharSequence r3) {
            this.mSummaryText = Builder.limitCharSequenceLength((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            this.mSummaryTextSet = true;
            return this;
        }
    }

    public static final class BubbleMetadata {
        private static final int FLAG_AUTO_EXPAND_BUBBLE = 1;
        private static final int FLAG_SUPPRESS_NOTIFICATION = 2;
        private PendingIntent mDeleteIntent;
        private int mDesiredHeight;
        private int mDesiredHeightResId;
        private int mFlags;
        private IconCompat mIcon;
        private PendingIntent mPendingIntent;
        private String mShortcutId;

        private static class Api29Impl {
            private Api29Impl() {
            }

            static BubbleMetadata fromPlatform(Notification.BubbleMetadata r3) {
                if (r3 != null) goto L6;
                return null;
            L6:
                if (r3.getIntent() != null) goto L8;
                return null;
            L8:
                Builder r0 = new Builder(r3.getIntent(), IconCompat.createFromIcon(r3.getIcon())).setAutoExpandBubble(r3.getAutoExpandBubble()).setDeleteIntent(r3.getDeleteIntent()).setSuppressNotification(r3.isNotificationSuppressed());
                if (r3.getDesiredHeight() == 0) goto L12;
                r0.setDesiredHeight(r3.getDesiredHeight());
            L12:
                if (r3.getDesiredHeightResId() == 0) goto L15;
                r0.setDesiredHeightResId(r3.getDesiredHeightResId());
            L15:
                return r0.build();
            }

            static Notification.BubbleMetadata toPlatform(BubbleMetadata r2) {
                if (r2 != null) goto L6;
                return null;
            L6:
                if (r2.getIntent() != null) goto L8;
                return null;
            L8:
                Notification.BubbleMetadata.Builder r0 = new Notification.BubbleMetadata.Builder().setIcon(r2.getIcon().toIcon()).setIntent(r2.getIntent()).setDeleteIntent(r2.getDeleteIntent()).setAutoExpandBubble(r2.getAutoExpandBubble()).setSuppressNotification(r2.isNotificationSuppressed());
                if (r2.getDesiredHeight() == 0) goto L12;
                r0.setDesiredHeight(r2.getDesiredHeight());
            L12:
                if (r2.getDesiredHeightResId() == 0) goto L15;
                r0.setDesiredHeightResId(r2.getDesiredHeightResId());
            L15:
                return r0.build();
            }
        }

        private static class Api30Impl {
            private Api30Impl() {
            }

            static BubbleMetadata fromPlatform(Notification.BubbleMetadata r3) {
                if (r3 != null) goto L6;
                return null;
            L6:
                if (r3.getShortcutId() == null) goto L8;
                Builder r0 = new Builder(r3.getShortcutId());
            L9:
                r0.setAutoExpandBubble(r3.getAutoExpandBubble()).setDeleteIntent(r3.getDeleteIntent()).setSuppressNotification(r3.isNotificationSuppressed());
                if (r3.getDesiredHeight() == 0) goto L13;
                r0.setDesiredHeight(r3.getDesiredHeight());
            L13:
                if (r3.getDesiredHeightResId() == 0) goto L16;
                r0.setDesiredHeightResId(r3.getDesiredHeightResId());
            L16:
                return r0.build();
            L8:
                r0 = new Builder(r3.getIntent(), IconCompat.createFromIcon(r3.getIcon()));
                goto L9
            }

            static Notification.BubbleMetadata toPlatform(BubbleMetadata r3) {
                if (r3 != null) goto L6;
                return null;
            L6:
                if (r3.getShortcutId() == null) goto L8;
                Notification.BubbleMetadata.Builder r0 = new Notification.BubbleMetadata.Builder(r3.getShortcutId());
            L9:
                r0.setDeleteIntent(r3.getDeleteIntent()).setAutoExpandBubble(r3.getAutoExpandBubble()).setSuppressNotification(r3.isNotificationSuppressed());
                if (r3.getDesiredHeight() == 0) goto L13;
                r0.setDesiredHeight(r3.getDesiredHeight());
            L13:
                if (r3.getDesiredHeightResId() == 0) goto L16;
                r0.setDesiredHeightResId(r3.getDesiredHeightResId());
            L16:
                return r0.build();
            L8:
                r0 = new Notification.BubbleMetadata.Builder(r3.getIntent(), r3.getIcon().toIcon());
                goto L9
            }
        }

        public static final class Builder {
            private PendingIntent mDeleteIntent;
            private int mDesiredHeight;
            private int mDesiredHeightResId;
            private int mFlags;
            private IconCompat mIcon;
            private PendingIntent mPendingIntent;
            private String mShortcutId;

            @Deprecated
            public Builder() {
            }

            public Builder(PendingIntent r2, IconCompat r3) {
                Objects.requireNonNull(r2, "Bubble requires non-null pending intent");
                Objects.requireNonNull(r3, "Bubbles require non-null icon");
                this.mPendingIntent = r2;
                this.mIcon = r3;
            }

            public Builder(String r2) {
                if (TextUtils.isEmpty(r2) == true) goto L7;
                this.mShortcutId = r2;
                return;
            L7:
                throw new NullPointerException("Bubble requires a non-null shortcut id");
            }

            private Builder setFlag(int r1, boolean r2) {
                if (r2 == false) goto L4;
                int r3 = r1 | this.mFlags;
            L5:
                this.mFlags = r3;
                return this;
            L4:
                int r4 = this.mFlags;
                r3 = (~r1) & r4;
                goto L5
            }

            public BubbleMetadata build() {
                String r0 = this.mShortcutId;
                if (r0 != null) goto L5;
                Objects.requireNonNull(this.mPendingIntent, "Must supply pending intent or shortcut to bubble");
            L5:
                if (r0 != null) goto L7;
                Objects.requireNonNull(this.mIcon, "Must supply an icon or shortcut for the bubble");
            L7:
                BubbleMetadata r1 = new BubbleMetadata(this.mPendingIntent, this.mDeleteIntent, this.mIcon, this.mDesiredHeight, this.mDesiredHeightResId, this.mFlags, this.mShortcutId, null);
                r1.setFlags(this.mFlags);
                return r1;
            }

            public Builder setAutoExpandBubble(boolean r2) {
                setFlag(1, r2);
                return this;
            }

            public Builder setDeleteIntent(PendingIntent r1) {
                this.mDeleteIntent = r1;
                return this;
            }

            public Builder setDesiredHeight(int r2) {
                this.mDesiredHeight = Math.max(r2, 0);
                this.mDesiredHeightResId = 0;
                return this;
            }

            public Builder setDesiredHeightResId(int r1) {
                this.mDesiredHeightResId = r1;
                this.mDesiredHeight = 0;
                return this;
            }

            public Builder setIcon(IconCompat r2) {
                if (this.mShortcutId != null) goto L7;
                Objects.requireNonNull(r2, "Bubbles require non-null icon");
                this.mIcon = r2;
                return this;
            L7:
                throw new IllegalStateException("Created as a shortcut bubble, cannot set an Icon. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
            }

            public Builder setIntent(PendingIntent r2) {
                if (this.mShortcutId != null) goto L7;
                Objects.requireNonNull(r2, "Bubble requires non-null pending intent");
                this.mPendingIntent = r2;
                return this;
            L7:
                throw new IllegalStateException("Created as a shortcut bubble, cannot set a PendingIntent. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
            }

            public Builder setSuppressNotification(boolean r2) {
                setFlag(2, r2);
                return this;
            }
        }

        private BubbleMetadata(PendingIntent r1, PendingIntent r2, IconCompat r3, int r4, int r5, int r6, String r7) {
            this.mPendingIntent = r1;
            this.mIcon = r3;
            this.mDesiredHeight = r4;
            this.mDesiredHeightResId = r5;
            this.mDeleteIntent = r2;
            this.mFlags = r6;
            this.mShortcutId = r7;
        }

        /* synthetic */ BubbleMetadata(PendingIntent r1, PendingIntent r2, IconCompat r3, int r4, int r5, int r6, String r7, AnonymousClass1 r8) {
            this(r1, r2, r3, r4, r5, r6, r7);
        }

        public static BubbleMetadata fromPlatform(Notification.BubbleMetadata r3) {
            if (r3 != null) goto L6;
            return null;
        L6:
            if (Build.VERSION.SDK_INT < 30) goto L10;
            return Api30Impl.fromPlatform(r3);
        L10:
            if (Build.VERSION.SDK_INT == 29) goto L12;
            return null;
        L12:
            return Api29Impl.fromPlatform(r3);
        }

        public static Notification.BubbleMetadata toPlatform(BubbleMetadata r3) {
            if (r3 != null) goto L6;
            return null;
        L6:
            if (Build.VERSION.SDK_INT < 30) goto L10;
            return Api30Impl.toPlatform(r3);
        L10:
            if (Build.VERSION.SDK_INT == 29) goto L12;
            return null;
        L12:
            return Api29Impl.toPlatform(r3);
        }

        public boolean getAutoExpandBubble() {
            if ((this.mFlags & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public PendingIntent getDeleteIntent() {
            return this.mDeleteIntent;
        }

        public int getDesiredHeight() {
            return this.mDesiredHeight;
        }

        public int getDesiredHeightResId() {
            return this.mDesiredHeightResId;
        }

        public IconCompat getIcon() {
            return this.mIcon;
        }

        public PendingIntent getIntent() {
            return this.mPendingIntent;
        }

        public String getShortcutId() {
            return this.mShortcutId;
        }

        public boolean isNotificationSuppressed() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void setFlags(int r1) {
            this.mFlags = r1;
        }
    }

    public static class Builder {
        private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
        public ArrayList<Action> mActions;
        boolean mAllowSystemGeneratedContextualActions;
        int mBadgeIcon;
        RemoteViews mBigContentView;
        BubbleMetadata mBubbleMetadata;
        String mCategory;
        String mChannelId;
        boolean mChronometerCountDown;
        int mColor;
        boolean mColorized;
        boolean mColorizedSet;
        CharSequence mContentInfo;
        PendingIntent mContentIntent;
        CharSequence mContentText;
        CharSequence mContentTitle;
        RemoteViews mContentView;
        public Context mContext;
        Bundle mExtras;
        int mFgsDeferBehavior;
        PendingIntent mFullScreenIntent;
        int mGroupAlertBehavior;
        String mGroupKey;
        boolean mGroupSummary;
        RemoteViews mHeadsUpContentView;
        ArrayList<Action> mInvisibleActions;
        IconCompat mLargeIcon;
        boolean mLocalOnly;
        LocusIdCompat mLocusId;
        Notification mNotification;
        int mNumber;

        @Deprecated
        public ArrayList<String> mPeople;
        public ArrayList<Person> mPersonList;
        int mPriority;
        int mProgress;
        boolean mProgressIndeterminate;
        int mProgressMax;
        Notification mPublicVersion;
        CharSequence[] mRemoteInputHistory;
        CharSequence mSettingsText;
        String mShortcutId;
        boolean mShowWhen;
        boolean mSilent;
        Object mSmallIcon;
        String mSortKey;
        Style mStyle;
        CharSequence mSubText;
        RemoteViews mTickerView;
        long mTimeout;
        boolean mUseChronometer;
        int mVisibility;

        static class Api21Impl {
            private Api21Impl() {
            }

            static AudioAttributes build(AudioAttributes.Builder r0) {
                return r0.build();
            }

            static AudioAttributes.Builder createBuilder() {
                return new AudioAttributes.Builder();
            }

            static AudioAttributes.Builder setContentType(AudioAttributes.Builder r0, int r1) {
                return r0.setContentType(r1);
            }

            static AudioAttributes.Builder setLegacyStreamType(AudioAttributes.Builder r0, int r1) {
                return r0.setLegacyStreamType(r1);
            }

            static AudioAttributes.Builder setUsage(AudioAttributes.Builder r0, int r1) {
                return r0.setUsage(r1);
            }
        }

        static class Api23Impl {
            private Api23Impl() {
            }

            static Icon getLargeIcon(Notification r0) {
                return r0.getLargeIcon();
            }

            static Icon getSmallIcon(Notification r0) {
                return r0.getSmallIcon();
            }
        }

        static class Api24Impl {
            private Api24Impl() {
            }

            static RemoteViews createBigContentView(Notification.Builder r0) {
                return r0.createHeadsUpContentView();
            }

            static RemoteViews createContentView(Notification.Builder r0) {
                return r0.createContentView();
            }

            static RemoteViews createHeadsUpContentView(Notification.Builder r0) {
                return r0.createHeadsUpContentView();
            }

            static Notification.Builder recoverBuilder(Context r2, Notification r3) {
                return Notification.Builder.recoverBuilder((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
            }
        }

        @Deprecated
        public Builder(Context r4) {
            this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin"));
        }

        public Builder(Context r7, Notification r8) {
            this((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"), NotificationCompat.getChannelId(r8));
            Bundle r9 = r8.extras;
            Style r0 = Style.extractStyleFromNotification(r8);
            setContentTitle(NotificationCompat.getContentTitle(r8)).setContentText(NotificationCompat.getContentText(r8)).setContentInfo(NotificationCompat.getContentInfo(r8)).setSubText(NotificationCompat.getSubText(r8)).setSettingsText(NotificationCompat.getSettingsText(r8)).setStyle(r0).setContentIntent(r8.contentIntent).setGroup(NotificationCompat.getGroup(r8)).setGroupSummary(NotificationCompat.isGroupSummary(r8)).setLocusId(NotificationCompat.getLocusId(r8)).setWhen(r8.when).setShowWhen(NotificationCompat.getShowWhen(r8)).setUsesChronometer(NotificationCompat.getUsesChronometer(r8)).setAutoCancel(NotificationCompat.getAutoCancel(r8)).setOnlyAlertOnce(NotificationCompat.getOnlyAlertOnce(r8)).setOngoing(NotificationCompat.getOngoing(r8)).setLocalOnly(NotificationCompat.getLocalOnly(r8)).setLargeIcon(r8.largeIcon).setBadgeIconType(NotificationCompat.getBadgeIconType(r8)).setCategory(NotificationCompat.getCategory(r8)).setBubbleMetadata(NotificationCompat.getBubbleMetadata(r8)).setNumber(r8.number).setTicker(r8.tickerText).setContentIntent(r8.contentIntent).setDeleteIntent(r8.deleteIntent).setFullScreenIntent(r8.fullScreenIntent, NotificationCompat.getHighPriority(r8)).setSound(r8.sound, r8.audioStreamType).setVibrate(r8.vibrate).setLights(r8.ledARGB, r8.ledOnMS, r8.ledOffMS).setDefaults(r8.defaults).setPriority(r8.priority).setColor(NotificationCompat.getColor(r8)).setVisibility(NotificationCompat.getVisibility(r8)).setPublicVersion(NotificationCompat.getPublicVersion(r8)).setSortKey(NotificationCompat.getSortKey(r8)).setTimeoutAfter(NotificationCompat.getTimeoutAfter(r8)).setShortcutId(NotificationCompat.getShortcutId(r8)).setProgress(r9.getInt(NotificationCompat.EXTRA_PROGRESS_MAX), r9.getInt(NotificationCompat.EXTRA_PROGRESS), r9.getBoolean(NotificationCompat.EXTRA_PROGRESS_INDETERMINATE)).setAllowSystemGeneratedContextualActions(NotificationCompat.getAllowSystemGeneratedContextualActions(r8)).setSmallIcon(r8.icon, r8.iconLevel).addExtras(getExtrasWithoutDuplicateData(r8, r0));
            if (Build.VERSION.SDK_INT < 23) goto L7;
            this.mSmallIcon = Api23Impl.getSmallIcon(r8);
            Icon r1 = Api23Impl.getLargeIcon(r8);
            if (r1 == null) goto L7;
            this.mLargeIcon = IconCompat.createFromIcon(r1);
        L7:
            int r2 = 0;
            if (r8.actions == null) goto L15;
            if (r8.actions.length == 0) goto L15;
            Notification.Action[] r3 = r8.actions;
            int r4 = r3.length;
            int r5 = 0;
        L12:
            if (r5 >= r4) goto L15;
            addAction(Action.Builder.fromAndroidAction(r3[r5]).build());
            r5 = r5 + 1;
        L15:
            if (Build.VERSION.SDK_INT < 21) goto L22;
            List<Action> r6 = NotificationCompat.getInvisibleActions(r8);
            if (r6.isEmpty() == true) goto L22;
            Iterator<Action> r10 = r6.iterator();
        L20:
            if (r10.hasNext() == false) goto L22;
            addInvisibleAction((Action) ZeusTransformUtils.preCheckCast(r10.next(), Action.class, "com.obric.memorydata.plugin"));
        L22:
            String[] r11 = r8.extras.getStringArray(NotificationCompat.EXTRA_PEOPLE);
            if (r11 == null) goto L30;
            if (r11.length == 0) goto L30;
            int r12 = r11.length;
        L27:
            if (r2 >= r12) goto L30;
            addPerson(r11[r2]);
            r2 = r2 + 1;
        L30:
            if (Build.VERSION.SDK_INT < 28) goto L40;
            ArrayList r13 = r8.extras.getParcelableArrayList(NotificationCompat.EXTRA_PEOPLE_LIST);
            if (r13 == null) goto L40;
            if (r13.isEmpty() == true) goto L40;
            Iterator r14 = r13.iterator();
        L37:
            if (r14.hasNext() == false) goto L40;
            addPerson(Person.fromAndroidPerson((android.app.Person) ZeusTransformUtils.preCheckCast(r14.next(), android.app.Person.class, "com.obric.memorydata.plugin")));
        L40:
            if (Build.VERSION.SDK_INT < 24) goto L45;
            if (r9.containsKey(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN) == false) goto L45;
            setChronometerCountDown(r9.getBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN));
        L45:
            if (Build.VERSION.SDK_INT >= 26) goto L47;
            return;
        L47:
            if (r9.containsKey(NotificationCompat.EXTRA_COLORIZED) == false) goto L55;
            setColorized(r9.getBoolean(NotificationCompat.EXTRA_COLORIZED));
            return;
        }

        public Builder(Context r6, String r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
            this.mActions = new ArrayList();
            this.mPersonList = new ArrayList();
            this.mInvisibleActions = new ArrayList();
            this.mShowWhen = true;
            this.mLocalOnly = false;
            this.mColor = 0;
            this.mVisibility = 0;
            this.mBadgeIcon = 0;
            this.mGroupAlertBehavior = 0;
            this.mFgsDeferBehavior = 0;
            this.mNotification = new Notification();
            this.mContext = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
            this.mChannelId = r7;
            Notification r9 = this.mNotification;
            r9.when = System.currentTimeMillis();
            this.mNotification.audioStreamType = -1;
            this.mPriority = 0;
            this.mPeople = new ArrayList();
            this.mAllowSystemGeneratedContextualActions = true;
        }

        private static Bundle getExtrasWithoutDuplicateData(Notification r3, Style r4) {
            if (r3.extras != null) goto L6;
            return null;
        L6:
            Bundle r0 = new Bundle(r3.extras);
            r0.remove(NotificationCompat.EXTRA_TITLE);
            r0.remove(NotificationCompat.EXTRA_TEXT);
            r0.remove(NotificationCompat.EXTRA_INFO_TEXT);
            r0.remove(NotificationCompat.EXTRA_SUB_TEXT);
            r0.remove(NotificationCompat.EXTRA_CHANNEL_ID);
            r0.remove(NotificationCompat.EXTRA_CHANNEL_GROUP_ID);
            r0.remove(NotificationCompat.EXTRA_SHOW_WHEN);
            r0.remove(NotificationCompat.EXTRA_PROGRESS);
            r0.remove(NotificationCompat.EXTRA_PROGRESS_MAX);
            r0.remove(NotificationCompat.EXTRA_PROGRESS_INDETERMINATE);
            r0.remove(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN);
            r0.remove(NotificationCompat.EXTRA_COLORIZED);
            r0.remove(NotificationCompat.EXTRA_PEOPLE_LIST);
            r0.remove(NotificationCompat.EXTRA_PEOPLE);
            r0.remove(NotificationCompatExtras.EXTRA_SORT_KEY);
            r0.remove(NotificationCompatExtras.EXTRA_GROUP_KEY);
            r0.remove(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
            r0.remove(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
            r0.remove(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
            Bundle r1 = r0.getBundle("android.car.EXTENSIONS");
            if (r1 == null) goto L9;
            Bundle r2 = new Bundle(r1);
            r2.remove("invisible_actions");
            r0.putBundle("android.car.EXTENSIONS", r2);
        L9:
            if (r4 == null) goto L11;
            r4.clearCompatExtraKeys(r0);
        L11:
            return r0;
        }

        public static CharSequence limitCharSequenceLength(CharSequence r2) {
            CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L6;
            return r3;
        L6:
            if (r3.length() > MAX_CHARSEQUENCE_LENGTH) goto L8;
            return r3;
        L8:
            return r3.subSequence(0, MAX_CHARSEQUENCE_LENGTH);
        }

        private void setFlag(int r1, boolean r2) {
            Notification r0 = this.mNotification;
            if (r2 == false) goto L5;
            int r3 = r1 | r0.flags;
        L6:
            r0.flags = r3;
            return;
        L5:
            int r4 = r0.flags;
            r3 = (~r1) & r4;
            goto L6
        }

        private boolean useExistingRemoteView() {
            Style r0 = this.mStyle;
            if (r0 != null) goto L5;
        L8:
            return true;
        L5:
            if (r0.displayCustomViewInline() == false) goto L8;
            return false;
        }

        public Builder addAction(int r3, CharSequence r4, PendingIntent r5) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
            this.mActions.add(new Action(r3, r6, r5));
            return this;
        }

        public Builder addAction(Action r2) {
            if (r2 == null) goto L4;
            this.mActions.add(r2);
        L4:
            return this;
        }

        public Builder addExtras(Bundle r2) {
            if (r2 == null) goto L7;
            Bundle r0 = this.mExtras;
            if (r0 != null) goto L6;
            this.mExtras = new Bundle(r2);
            goto L7
        L6:
            r0.putAll(r2);
        L7:
            return this;
        }

        public Builder addInvisibleAction(int r3, CharSequence r4, PendingIntent r5) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
            this.mInvisibleActions.add(new Action(r3, r6, r5));
            return this;
        }

        public Builder addInvisibleAction(Action r2) {
            if (r2 == null) goto L4;
            this.mInvisibleActions.add(r2);
        L4:
            return this;
        }

        public Builder addPerson(Person r2) {
            if (r2 == null) goto L4;
            this.mPersonList.add(r2);
        L4:
            return this;
        }

        @Deprecated
        public Builder addPerson(String r2) {
            if (r2 != null) goto L4;
        L6:
            return this;
        L4:
            if (r2.isEmpty() == true) goto L6;
            this.mPeople.add(r2);
            goto L6
        }

        public Notification build() {
            return new NotificationCompatBuilder(this).build();
        }

        public Builder clearActions() {
            this.mActions.clear();
            return this;
        }

        public Builder clearInvisibleActions() {
            this.mInvisibleActions.clear();
            Bundle r0 = this.mExtras.getBundle("android.car.EXTENSIONS");
            if (r0 == null) goto L5;
            Bundle r2 = new Bundle(r0);
            r2.remove("invisible_actions");
            this.mExtras.putBundle("android.car.EXTENSIONS", r2);
        L5:
            return this;
        }

        public Builder clearPeople() {
            this.mPersonList.clear();
            this.mPeople.clear();
            return this;
        }

        public RemoteViews createBigContentView() {
            if (Build.VERSION.SDK_INT >= 16) goto L7;
            return null;
        L7:
            if (this.mBigContentView != null) goto L9;
        L12:
            NotificationCompatBuilder r0 = new NotificationCompatBuilder(this);
            Style r1 = this.mStyle;
            if (r1 == null) goto L17;
            RemoteViews r2 = r1.makeBigContentView(r0);
            if (r2 == null) goto L17;
            return r2;
        L17:
            Notification r3 = r0.build();
            if (Build.VERSION.SDK_INT < 24) goto L22;
            return Api24Impl.createBigContentView(Api24Impl.recoverBuilder(this.mContext, r3));
        L22:
            return r3.bigContentView;
        L9:
            if (useExistingRemoteView() == false) goto L12;
            return this.mBigContentView;
        }

        public RemoteViews createContentView() {
            if (this.mContentView != null) goto L5;
        L8:
            NotificationCompatBuilder r0 = new NotificationCompatBuilder(this);
            Style r1 = this.mStyle;
            if (r1 == null) goto L13;
            RemoteViews r2 = r1.makeContentView(r0);
            if (r2 == null) goto L13;
            return r2;
        L13:
            Notification r3 = r0.build();
            if (Build.VERSION.SDK_INT < 24) goto L18;
            return Api24Impl.createContentView(Api24Impl.recoverBuilder(this.mContext, r3));
        L18:
            return r3.contentView;
        L5:
            if (useExistingRemoteView() == false) goto L8;
            return this.mContentView;
        }

        public RemoteViews createHeadsUpContentView() {
            if (Build.VERSION.SDK_INT >= 21) goto L7;
            return null;
        L7:
            if (this.mHeadsUpContentView != null) goto L9;
        L12:
            NotificationCompatBuilder r0 = new NotificationCompatBuilder(this);
            Style r1 = this.mStyle;
            if (r1 == null) goto L17;
            RemoteViews r2 = r1.makeHeadsUpContentView(r0);
            if (r2 == null) goto L17;
            return r2;
        L17:
            Notification r3 = r0.build();
            if (Build.VERSION.SDK_INT < 24) goto L22;
            return Api24Impl.createHeadsUpContentView(Api24Impl.recoverBuilder(this.mContext, r3));
        L22:
            return r3.headsUpContentView;
        L9:
            if (useExistingRemoteView() == false) goto L12;
            return this.mHeadsUpContentView;
        }

        public Builder extend(Extender r3) {
            ((Extender) ZeusTransformUtils.wrapperContextForParams(r3, Extender.class, "com.obric.memorydata.plugin")).extend(this);
            return this;
        }

        public RemoteViews getBigContentView() {
            return this.mBigContentView;
        }

        public BubbleMetadata getBubbleMetadata() {
            return this.mBubbleMetadata;
        }

        public int getColor() {
            return this.mColor;
        }

        public RemoteViews getContentView() {
            return this.mContentView;
        }

        public Bundle getExtras() {
            if (this.mExtras != null) goto L6;
            this.mExtras = new Bundle();
        L6:
            return this.mExtras;
        }

        public int getForegroundServiceBehavior() {
            return this.mFgsDeferBehavior;
        }

        public RemoteViews getHeadsUpContentView() {
            return this.mHeadsUpContentView;
        }

        @Deprecated
        public Notification getNotification() {
            return build();
        }

        public int getPriority() {
            return this.mPriority;
        }

        public long getWhenIfShowing() {
            if (this.mShowWhen == true) goto L7;
            return 0;
        L7:
            return this.mNotification.when;
        }

        public Builder setAllowSystemGeneratedContextualActions(boolean r1) {
            this.mAllowSystemGeneratedContextualActions = r1;
            return this;
        }

        public Builder setAutoCancel(boolean r2) {
            setFlag(16, r2);
            return this;
        }

        public Builder setBadgeIconType(int r1) {
            this.mBadgeIcon = r1;
            return this;
        }

        public Builder setBubbleMetadata(BubbleMetadata r1) {
            this.mBubbleMetadata = r1;
            return this;
        }

        public Builder setCategory(String r1) {
            this.mCategory = r1;
            return this;
        }

        public Builder setChannelId(String r1) {
            this.mChannelId = r1;
            return this;
        }

        public Builder setChronometerCountDown(boolean r3) {
            this.mChronometerCountDown = r3;
            getExtras().putBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN, r3);
            return this;
        }

        public Builder setColor(int r1) {
            this.mColor = r1;
            return this;
        }

        public Builder setColorized(boolean r1) {
            this.mColorized = r1;
            this.mColorizedSet = true;
            return this;
        }

        public Builder setContent(RemoteViews r2) {
            this.mNotification.contentView = r2;
            return this;
        }

        public Builder setContentInfo(CharSequence r3) {
            this.mContentInfo = limitCharSequenceLength((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public Builder setContentIntent(PendingIntent r1) {
            this.mContentIntent = r1;
            return this;
        }

        public Builder setContentText(CharSequence r3) {
            this.mContentText = limitCharSequenceLength((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public Builder setContentTitle(CharSequence r3) {
            this.mContentTitle = limitCharSequenceLength((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public Builder setCustomBigContentView(RemoteViews r1) {
            this.mBigContentView = r1;
            return this;
        }

        public Builder setCustomContentView(RemoteViews r1) {
            this.mContentView = r1;
            return this;
        }

        public Builder setCustomHeadsUpContentView(RemoteViews r1) {
            this.mHeadsUpContentView = r1;
            return this;
        }

        public Builder setDefaults(int r2) {
            this.mNotification.defaults = r2;
            if ((r2 & 4) == 0) goto L5;
            this.mNotification.flags |= 1;
        L5:
            return this;
        }

        public Builder setDeleteIntent(PendingIntent r2) {
            this.mNotification.deleteIntent = r2;
            return this;
        }

        public Builder setExtras(Bundle r1) {
            this.mExtras = r1;
            return this;
        }

        public Builder setForegroundServiceBehavior(int r1) {
            this.mFgsDeferBehavior = r1;
            return this;
        }

        public Builder setFullScreenIntent(PendingIntent r1, boolean r2) {
            this.mFullScreenIntent = r1;
            setFlag(128, r2);
            return this;
        }

        public Builder setGroup(String r1) {
            this.mGroupKey = r1;
            return this;
        }

        public Builder setGroupAlertBehavior(int r1) {
            this.mGroupAlertBehavior = r1;
            return this;
        }

        public Builder setGroupSummary(boolean r1) {
            this.mGroupSummary = r1;
            return this;
        }

        public Builder setLargeIcon(Bitmap r2) {
            if (r2 != null) goto L4;
            IconCompat r3 = null;
        L5:
            this.mLargeIcon = r3;
            return this;
        L4:
            r3 = IconCompat.createWithBitmap(NotificationCompat.reduceLargeIconSize(this.mContext, r2));
            goto L5
        }

        public Builder setLargeIcon(Icon r1) {
            if (r1 != null) goto L4;
            IconCompat r2 = null;
        L5:
            this.mLargeIcon = r2;
            return this;
        L4:
            r2 = IconCompat.createFromIcon(r1);
            goto L5
        }

        public Builder setLights(int r2, int r3, int r4) {
            this.mNotification.ledARGB = r2;
            this.mNotification.ledOnMS = r3;
            this.mNotification.ledOffMS = r4;
            if (this.mNotification.ledOnMS != 0) goto L5;
        L7:
            int r5 = 0;
        L8:
            Notification r6 = this.mNotification;
            r6.flags = r5 | (r6.flags & (-2));
            return this;
        L5:
            if (this.mNotification.ledOffMS == 0) goto L7;
            r5 = 1;
            goto L8
        }

        public Builder setLocalOnly(boolean r1) {
            this.mLocalOnly = r1;
            return this;
        }

        public Builder setLocusId(LocusIdCompat r1) {
            this.mLocusId = r1;
            return this;
        }

        @Deprecated
        public Builder setNotificationSilent() {
            this.mSilent = true;
            return this;
        }

        public Builder setNumber(int r1) {
            this.mNumber = r1;
            return this;
        }

        public Builder setOngoing(boolean r2) {
            setFlag(2, r2);
            return this;
        }

        public Builder setOnlyAlertOnce(boolean r2) {
            setFlag(8, r2);
            return this;
        }

        public Builder setPriority(int r1) {
            this.mPriority = r1;
            return this;
        }

        public Builder setProgress(int r1, int r2, boolean r3) {
            this.mProgressMax = r1;
            this.mProgress = r2;
            this.mProgressIndeterminate = r3;
            return this;
        }

        public Builder setPublicVersion(Notification r1) {
            this.mPublicVersion = r1;
            return this;
        }

        public Builder setRemoteInputHistory(CharSequence[] r1) {
            this.mRemoteInputHistory = r1;
            return this;
        }

        public Builder setSettingsText(CharSequence r3) {
            this.mSettingsText = limitCharSequenceLength((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public Builder setShortcutId(String r1) {
            this.mShortcutId = r1;
            return this;
        }

        public Builder setShortcutInfo(ShortcutInfoCompat r3) {
            if (r3 != null) goto L4;
            return this;
        L4:
            this.mShortcutId = r3.getId();
            if (this.mLocusId != null) goto L14;
            if (r3.getLocusId() == null) goto L11;
            LocusIdCompat r0 = r3.getLocusId();
        L9:
            this.mLocusId = r0;
            goto L14
        L11:
            if (r3.getId() == null) goto L14;
            r0 = new LocusIdCompat(r3.getId());
        L14:
            if (this.mContentTitle != null) goto L16;
            setContentTitle(r3.getShortLabel());
        L16:
            return this;
        }

        public Builder setShowWhen(boolean r1) {
            this.mShowWhen = r1;
            return this;
        }

        public Builder setSilent(boolean r1) {
            this.mSilent = r1;
            return this;
        }

        public Builder setSmallIcon(int r2) {
            this.mNotification.icon = r2;
            return this;
        }

        public Builder setSmallIcon(int r2, int r3) {
            this.mNotification.icon = r2;
            this.mNotification.iconLevel = r3;
            return this;
        }

        public Builder setSmallIcon(IconCompat r2) {
            this.mSmallIcon = r2.toIcon(this.mContext);
            return this;
        }

        public Builder setSortKey(String r1) {
            this.mSortKey = r1;
            return this;
        }

        public Builder setSound(Uri r2) {
            this.mNotification.sound = r2;
            this.mNotification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT < 21) goto L5;
            AudioAttributes.Builder r3 = Api21Impl.setUsage(Api21Impl.setContentType(Api21Impl.createBuilder(), 4), 5);
            Notification r0 = this.mNotification;
            r0.audioAttributes = Api21Impl.build(r3);
        L5:
            return this;
        }

        public Builder setSound(Uri r2, int r3) {
            this.mNotification.sound = r2;
            this.mNotification.audioStreamType = r3;
            if (Build.VERSION.SDK_INT < 21) goto L5;
            AudioAttributes.Builder r4 = Api21Impl.setLegacyStreamType(Api21Impl.setContentType(Api21Impl.createBuilder(), 4), r3);
            Notification r5 = this.mNotification;
            r5.audioAttributes = Api21Impl.build(r4);
        L5:
            return this;
        }

        public Builder setStyle(Style r2) {
            if (this.mStyle == r2) goto L7;
            this.mStyle = r2;
            if (r2 == null) goto L7;
            r2.setBuilder(this);
        L7:
            return this;
        }

        public Builder setSubText(CharSequence r3) {
            this.mSubText = limitCharSequenceLength((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public Builder setTicker(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            Notification r0 = this.mNotification;
            r0.tickerText = limitCharSequenceLength(r4);
            return this;
        }

        @Deprecated
        public Builder setTicker(CharSequence r3, RemoteViews r4) {
            CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            Notification r0 = this.mNotification;
            r0.tickerText = limitCharSequenceLength(r5);
            this.mTickerView = r4;
            return this;
        }

        public Builder setTimeoutAfter(long r1) {
            this.mTimeout = r1;
            return this;
        }

        public Builder setUsesChronometer(boolean r1) {
            this.mUseChronometer = r1;
            return this;
        }

        public Builder setVibrate(long[] r2) {
            this.mNotification.vibrate = r2;
            return this;
        }

        public Builder setVisibility(int r1) {
            this.mVisibility = r1;
            return this;
        }

        public Builder setWhen(long r2) {
            this.mNotification.when = r2;
            return this;
        }
    }

    public static class CallStyle extends Style {
        public static final int CALL_TYPE_INCOMING = 1;
        public static final int CALL_TYPE_ONGOING = 2;
        public static final int CALL_TYPE_SCREENING = 3;
        public static final int CALL_TYPE_UNKNOWN = 0;
        private static final String KEY_ACTION_PRIORITY = "key_action_priority";
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$CallStyle";
        private Integer mAnswerButtonColor;
        private PendingIntent mAnswerIntent;
        private int mCallType;
        private Integer mDeclineButtonColor;
        private PendingIntent mDeclineIntent;
        private PendingIntent mHangUpIntent;
        private boolean mIsVideo;
        private Person mPerson;
        private IconCompat mVerificationIcon;
        private CharSequence mVerificationText;

        static class Api16Impl {
            private Api16Impl() {
            }

            static void setBuilder(Notification.CallStyle r0, Notification.Builder r1) {
                r0.setBuilder(r1);
            }
        }

        static class Api20Impl {
            private Api20Impl() {
            }

            static Notification.Action.Builder addExtras(Notification.Action.Builder r0, Bundle r1) {
                return r0.addExtras(r1);
            }

            static Notification.Action.Builder addRemoteInput(Notification.Action.Builder r0, android.app.RemoteInput r1) {
                return r0.addRemoteInput(r1);
            }

            static Notification.Action build(Notification.Action.Builder r0) {
                return r0.build();
            }

            static Notification.Action.Builder createActionBuilder(int r2, CharSequence r3, PendingIntent r4) {
                return new Notification.Action.Builder(r2, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4);
            }
        }

        static class Api21Impl {
            private Api21Impl() {
            }

            static Notification.Builder addPerson(Notification.Builder r0, String r1) {
                return r0.addPerson(r1);
            }

            static Notification.Builder setCategory(Notification.Builder r0, String r1) {
                return r0.setCategory(r1);
            }
        }

        static class Api23Impl {
            private Api23Impl() {
            }

            static Parcelable castToParcelable(Icon r0) {
                return r0;
            }

            static Notification.Action.Builder createActionBuilder(Icon r2, CharSequence r3, PendingIntent r4) {
                return new Notification.Action.Builder(r2, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4);
            }

            static void setLargeIcon(Notification.Builder r0, Icon r1) {
                r0.setLargeIcon(r1);
            }
        }

        static class Api24Impl {
            private Api24Impl() {
            }

            static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder r0, boolean r1) {
                return r0.setAllowGeneratedReplies(r1);
            }
        }

        static class Api28Impl {
            private Api28Impl() {
            }

            static Notification.Builder addPerson(Notification.Builder r0, android.app.Person r1) {
                return r0.addPerson(r1);
            }

            static Parcelable castToParcelable(android.app.Person r0) {
                return r0;
            }
        }

        static class Api31Impl {
            private Api31Impl() {
            }

            static Notification.CallStyle forIncomingCall(android.app.Person r0, PendingIntent r1, PendingIntent r2) {
                return Notification.CallStyle.forIncomingCall(r0, r1, r2);
            }

            static Notification.CallStyle forOngoingCall(android.app.Person r0, PendingIntent r1) {
                return Notification.CallStyle.forOngoingCall(r0, r1);
            }

            static Notification.CallStyle forScreeningCall(android.app.Person r0, PendingIntent r1, PendingIntent r2) {
                return Notification.CallStyle.forScreeningCall(r0, r1, r2);
            }

            static Notification.CallStyle setAnswerButtonColorHint(Notification.CallStyle r0, int r1) {
                return r0.setAnswerButtonColorHint(r1);
            }

            static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder r0, boolean r1) {
                return r0.setAuthenticationRequired(r1);
            }

            static Notification.CallStyle setDeclineButtonColorHint(Notification.CallStyle r0, int r1) {
                return r0.setDeclineButtonColorHint(r1);
            }

            static Notification.CallStyle setIsVideo(Notification.CallStyle r0, boolean r1) {
                return r0.setIsVideo(r1);
            }

            static Notification.CallStyle setVerificationIcon(Notification.CallStyle r0, Icon r1) {
                return r0.setVerificationIcon(r1);
            }

            static Notification.CallStyle setVerificationText(Notification.CallStyle r2, CharSequence r3) {
                return r2.setVerificationText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            }
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface CallType {
        }

        public CallStyle() {
        }

        private CallStyle(int r2, Person r3, PendingIntent r4, PendingIntent r5, PendingIntent r6) {
            if (r3 == null) goto L9;
            if (TextUtils.isEmpty(r3.getName()) == true) goto L9;
            this.mCallType = r2;
            this.mPerson = r3;
            this.mAnswerIntent = r6;
            this.mDeclineIntent = r5;
            this.mHangUpIntent = r4;
            return;
        L9:
            throw new IllegalArgumentException("person must have a non-empty a name");
        }

        public CallStyle(Builder r1) {
            setBuilder(r1);
        }

        public static CallStyle forIncomingCall(Person r7, PendingIntent r8, PendingIntent r9) {
            return new CallStyle(1, r7, null, (PendingIntent) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r8, "declineIntent is required"), PendingIntent.class, "com.obric.memorydata.plugin"), (PendingIntent) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r9, "answerIntent is required"), PendingIntent.class, "com.obric.memorydata.plugin"));
        }

        public static CallStyle forOngoingCall(Person r7, PendingIntent r8) {
            return new CallStyle(2, r7, (PendingIntent) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r8, "hangUpIntent is required"), PendingIntent.class, "com.obric.memorydata.plugin"), null, null);
        }

        public static CallStyle forScreeningCall(Person r7, PendingIntent r8, PendingIntent r9) {
            return new CallStyle(3, r7, (PendingIntent) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r8, "hangUpIntent is required"), PendingIntent.class, "com.obric.memorydata.plugin"), null, (PendingIntent) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r9, "answerIntent is required"), PendingIntent.class, "com.obric.memorydata.plugin"));
        }

        private String getDefaultText() {
            int r0 = this.mCallType;
            if (r0 != 1) goto L5;
            Resources r4 = ZeusTransformUtils.getResources(this.mBuilder.mContext, "com.obric.memorydata.plugin");
            int r1 = R.string.call_notification_incoming_text;
            String r2 = "call_notification_incoming_text";
        L12:
            return r4.getString(ZeusTransformUtils.mapRes(r1, TypedValues.Custom.S_STRING, r2));
        L5:
            if (r0 != 2) goto L7;
            r4 = ZeusTransformUtils.getResources(this.mBuilder.mContext, "com.obric.memorydata.plugin");
            r1 = R.string.call_notification_ongoing_text;
            r2 = "call_notification_ongoing_text";
            goto L12
        L7:
            if (r0 == 3) goto L10;
            return null;
        L10:
            r4 = ZeusTransformUtils.getResources(this.mBuilder.mContext, "com.obric.memorydata.plugin");
            r1 = R.string.call_notification_screening_text;
            r2 = "call_notification_screening_text";
            goto L12
        }

        private boolean isActionAddedByCallStyle(Action r1) {
            if (r1 != null) goto L4;
        L6:
            return false;
        L4:
            if (r1.getExtras().getBoolean(KEY_ACTION_PRIORITY) == false) goto L6;
            return true;
        }

        private Action makeAction(int r3, int r4, Integer r5, int r6, PendingIntent r7) {
            if (r5 != null) goto L4;
            r5 = Integer.valueOf(ContextCompat.getColor(this.mBuilder.mContext, r6));
        L4:
            SpannableStringBuilder r8 = new SpannableStringBuilder();
            r8.append(ZeusTransformUtils.getResources(this.mBuilder.mContext, "com.obric.memorydata.plugin").getString(r4));
            r8.setSpan(new ForegroundColorSpan(r5.intValue()), 0, r8.length(), 18);
            Action r2 = new Action.Builder(IconCompat.createWithResource(this.mBuilder.mContext, r3), r8, r7).build();
            r2.getExtras().putBoolean(KEY_ACTION_PRIORITY, true);
            return r2;
        }

        private Action makeAnswerAction() {
            int r0 = ZeusTransformUtils.mapRes(R.drawable.ic_call_answer_video_low, "drawable", "ic_call_answer_video_low");
            int r2 = ZeusTransformUtils.mapRes(R.drawable.ic_call_answer_low, "drawable", "ic_call_answer_low");
            if (Build.VERSION.SDK_INT < 21) goto L6;
            r0 = ZeusTransformUtils.mapRes(R.drawable.ic_call_answer_video, "drawable", "ic_call_answer_video");
            r2 = ZeusTransformUtils.mapRes(R.drawable.ic_call_answer, "drawable", "ic_call_answer");
        L6:
            if (this.mAnswerIntent != null) goto L8;
            return null;
        L8:
            boolean r1 = this.mIsVideo;
            if (r1 == false) goto L11;
            int r4 = r0;
        L13:
            if (r1 == false) goto L15;
            int r3 = R.string.call_notification_answer_video_action;
            String r5 = "call_notification_answer_video_action";
        L17:
            return makeAction(r4, ZeusTransformUtils.mapRes(r3, TypedValues.Custom.S_STRING, r5), this.mAnswerButtonColor, ZeusTransformUtils.mapRes(R.color.call_notification_answer_color, TypedValues.Custom.S_COLOR, "call_notification_answer_color"), this.mAnswerIntent);
        L15:
            r3 = R.string.call_notification_answer_action;
            r5 = "call_notification_answer_action";
            goto L17
        L11:
            r4 = r2;
            goto L13
        }

        private Action makeNegativeAction() {
            int r0 = ZeusTransformUtils.mapRes(R.drawable.ic_call_decline_low, "drawable", "ic_call_decline_low");
            if (Build.VERSION.SDK_INT < 21) goto L5;
            r0 = ZeusTransformUtils.mapRes(R.drawable.ic_call_decline, "drawable", "ic_call_decline");
        L5:
            int r2 = r0;
            if (this.mDeclineIntent != null) goto L10;
            int r1 = ZeusTransformUtils.mapRes(R.string.call_notification_hang_up_action, TypedValues.Custom.S_STRING, "call_notification_hang_up_action");
            Integer r4 = this.mDeclineButtonColor;
            int r5 = ZeusTransformUtils.mapRes(R.color.call_notification_decline_color, TypedValues.Custom.S_COLOR, "call_notification_decline_color");
            PendingIntent r6 = this.mHangUpIntent;
        L9:
            return makeAction(r2, r1, r4, r5, r6);
        L10:
            r1 = ZeusTransformUtils.mapRes(R.string.call_notification_decline_action, TypedValues.Custom.S_STRING, "call_notification_decline_action");
            r4 = this.mDeclineButtonColor;
            r5 = ZeusTransformUtils.mapRes(R.color.call_notification_decline_color, TypedValues.Custom.S_COLOR, "call_notification_decline_color");
            r6 = this.mDeclineIntent;
            goto L9
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void addCompatExtras(Bundle r3) {
            super.addCompatExtras(r3);
            r3.putInt(NotificationCompat.EXTRA_CALL_TYPE, this.mCallType);
            r3.putBoolean(NotificationCompat.EXTRA_CALL_IS_VIDEO, this.mIsVideo);
            if (this.mPerson == null) goto L10;
            if (Build.VERSION.SDK_INT < 28) goto L7;
            Parcelable r0 = Api28Impl.castToParcelable(this.mPerson.toAndroidPerson());
            String r1 = NotificationCompat.EXTRA_CALL_PERSON;
        L8:
            r3.putParcelable(r1, r0);
            goto L10
        L7:
            r0 = this.mPerson.toBundle();
            r1 = NotificationCompat.EXTRA_CALL_PERSON_COMPAT;
        L10:
            if (this.mVerificationIcon != null) goto L12;
        L16:
            r3.putCharSequence(NotificationCompat.EXTRA_VERIFICATION_TEXT, this.mVerificationText);
            r3.putParcelable(NotificationCompat.EXTRA_ANSWER_INTENT, this.mAnswerIntent);
            r3.putParcelable(NotificationCompat.EXTRA_DECLINE_INTENT, this.mDeclineIntent);
            r3.putParcelable(NotificationCompat.EXTRA_HANG_UP_INTENT, this.mHangUpIntent);
            Integer r2 = this.mAnswerButtonColor;
            if (r2 == null) goto L19;
            r3.putInt(NotificationCompat.EXTRA_ANSWER_COLOR, r2.intValue());
        L19:
            Integer r4 = this.mDeclineButtonColor;
            if (r4 == null) goto L23;
            r3.putInt(NotificationCompat.EXTRA_DECLINE_COLOR, r4.intValue());
            return;
        L23:
            return;
        L12:
            if (Build.VERSION.SDK_INT < 23) goto L14;
            Parcelable r5 = Api23Impl.castToParcelable(this.mVerificationIcon.toIcon(this.mBuilder.mContext));
            String r6 = NotificationCompat.EXTRA_VERIFICATION_ICON;
        L15:
            r3.putParcelable(r6, r5);
            goto L16
        L14:
            r5 = this.mVerificationIcon.toBundle();
            r6 = NotificationCompat.EXTRA_VERIFICATION_ICON_COMPAT;
            goto L15
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor r5) {
            NotificationBuilderWithBuilderAccessor r6 = (NotificationBuilderWithBuilderAccessor) ZeusTransformUtils.wrapperContextForParams(r5, NotificationBuilderWithBuilderAccessor.class, "com.obric.memorydata.plugin");
            CharSequence r1 = null;
            Notification.CallStyle r2 = null;
            r2 = null;
            r1 = null;
            if (Build.VERSION.SDK_INT < 31) goto L27;
            int r0 = this.mCallType;
            if (r0 != 1) goto L7;
            r2 = Api31Impl.forIncomingCall(this.mPerson.toAndroidPerson(), this.mDeclineIntent, this.mAnswerIntent);
        L16:
            if (r2 == null) goto L55;
            Api16Impl.setBuilder(r2, r6.getBuilder());
            Integer r7 = this.mAnswerButtonColor;
            if (r7 == null) goto L20;
            Api31Impl.setAnswerButtonColorHint(r2, r7.intValue());
        L20:
            Integer r8 = this.mDeclineButtonColor;
            if (r8 == null) goto L23;
            Api31Impl.setDeclineButtonColorHint(r2, r8.intValue());
        L23:
            Api31Impl.setVerificationText(r2, this.mVerificationText);
            IconCompat r9 = this.mVerificationIcon;
            if (r9 == null) goto L26;
            Api31Impl.setVerificationIcon(r2, r9.toIcon(this.mBuilder.mContext));
        L26:
            Api31Impl.setIsVideo(r2, this.mIsVideo);
            return;
        L55:
            return;
        L7:
            if (r0 != 2) goto L9;
            r2 = Api31Impl.forOngoingCall(this.mPerson.toAndroidPerson(), this.mHangUpIntent);
            goto L16
        L9:
            if (r0 != 3) goto L11;
            r2 = Api31Impl.forScreeningCall(this.mPerson.toAndroidPerson(), this.mHangUpIntent, this.mAnswerIntent);
            goto L16
        L11:
            if (Log.isLoggable(NotificationCompat.TAG, 3) == false) goto L16;
            Log.d(NotificationCompat.TAG, "Unrecognized call type in CallStyle: " + String.valueOf(this.mCallType));
            goto L16
        L27:
            Notification.Builder r10 = r6.getBuilder();
            Person r3 = this.mPerson;
            if (r3 == null) goto L30;
            CharSequence r4 = r3.getName();
        L31:
            r10.setContentTitle(r4);
            if (this.mBuilder.mExtras != null) goto L34;
        L36:
            if (r1 != null) goto L38;
            r1 = getDefaultText();
        L38:
            r10.setContentText(r1);
            if (this.mPerson == null) goto L52;
            if (Build.VERSION.SDK_INT < 23) goto L46;
            if (this.mPerson.getIcon() == null) goto L46;
            Api23Impl.setLargeIcon(r10, this.mPerson.getIcon().toIcon(this.mBuilder.mContext));
        L46:
            if (Build.VERSION.SDK_INT < 28) goto L49;
            Api28Impl.addPerson(r10, this.mPerson.toAndroidPerson());
            goto L52
        L49:
            if (Build.VERSION.SDK_INT < 21) goto L52;
            Api21Impl.addPerson(r10, this.mPerson.getUri());
        L52:
            if (Build.VERSION.SDK_INT < 21) goto L57;
            Api21Impl.setCategory(r10, NotificationCompat.CATEGORY_CALL);
            return;
        L57:
            return;
        L34:
            if (this.mBuilder.mExtras.containsKey(NotificationCompat.EXTRA_TEXT) == false) goto L36;
            r1 = this.mBuilder.mExtras.getCharSequence(NotificationCompat.EXTRA_TEXT);
            goto L36
        L30:
            r4 = null;
            goto L31
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public boolean displayCustomViewInline() {
            return true;
        }

        public ArrayList<Action> getActionsListWithSystemActions() {
            Action r0 = makeNegativeAction();
            Action r1 = makeAnswerAction();
            ArrayList<Action> r2 = new ArrayList(3);
            r2.add(r0);
            int r3 = 2;
            ArrayList<Action> r4 = this.mBuilder.mActions;
            if (r4 == null) goto L18;
            Iterator<Action> r5 = r4.iterator();
        L6:
            if (r5.hasNext() == false) goto L18;
            Action r6 = (Action) ZeusTransformUtils.preCheckCast(r5.next(), Action.class, "com.obric.memorydata.plugin");
            if (r6.isContextual() == false) goto L11;
            r2.add(r6);
        L15:
            if (r1 == null) goto L6;
            if (r3 != 1) goto L6;
            r2.add(r1);
            r3 = r3 - 1;
            goto L6
        L11:
            if (isActionAddedByCallStyle(r6) == true) goto L15;
            if (r3 <= 1) goto L15;
            r2.add(r6);
            r3 = r3 - 1;
        L18:
            if (r1 == null) goto L21;
            if (r3 < 1) goto L21;
            r2.add(r1);
        L21:
            return r2;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void restoreFromCompatExtras(Bundle r4) {
            super.restoreFromCompatExtras(r4);
            this.mCallType = r4.getInt(NotificationCompat.EXTRA_CALL_TYPE);
            this.mIsVideo = r4.getBoolean(NotificationCompat.EXTRA_CALL_IS_VIDEO);
            if (Build.VERSION.SDK_INT < 28) goto L8;
            if (r4.containsKey(NotificationCompat.EXTRA_CALL_PERSON) == false) goto L8;
            Person r0 = Person.fromAndroidPerson((android.app.Person) ZeusTransformUtils.preCheckCast(r4.getParcelable(NotificationCompat.EXTRA_CALL_PERSON), android.app.Person.class, "com.obric.memorydata.plugin"));
        L10:
            this.mPerson = r0;
        L12:
            if (Build.VERSION.SDK_INT < 23) goto L17;
            if (r4.containsKey(NotificationCompat.EXTRA_VERIFICATION_ICON) == false) goto L17;
            IconCompat r1 = IconCompat.createFromIcon((Icon) ZeusTransformUtils.preCheckCast(r4.getParcelable(NotificationCompat.EXTRA_VERIFICATION_ICON), Icon.class, "com.obric.memorydata.plugin"));
        L19:
            this.mVerificationIcon = r1;
        L20:
            this.mVerificationText = r4.getCharSequence(NotificationCompat.EXTRA_VERIFICATION_TEXT);
            this.mAnswerIntent = (PendingIntent) ZeusTransformUtils.preCheckCast(r4.getParcelable(NotificationCompat.EXTRA_ANSWER_INTENT), PendingIntent.class, "com.obric.memorydata.plugin");
            this.mDeclineIntent = (PendingIntent) ZeusTransformUtils.preCheckCast(r4.getParcelable(NotificationCompat.EXTRA_DECLINE_INTENT), PendingIntent.class, "com.obric.memorydata.plugin");
            this.mHangUpIntent = (PendingIntent) ZeusTransformUtils.preCheckCast(r4.getParcelable(NotificationCompat.EXTRA_HANG_UP_INTENT), PendingIntent.class, "com.obric.memorydata.plugin");
            Integer r2 = null;
            if (r4.containsKey(NotificationCompat.EXTRA_ANSWER_COLOR) == false) goto L23;
            Integer r3 = Integer.valueOf(r4.getInt(NotificationCompat.EXTRA_ANSWER_COLOR));
        L24:
            this.mAnswerButtonColor = r3;
            if (r4.containsKey(NotificationCompat.EXTRA_DECLINE_COLOR) == false) goto L27;
            r2 = Integer.valueOf(r4.getInt(NotificationCompat.EXTRA_DECLINE_COLOR));
        L27:
            this.mDeclineButtonColor = r2;
            return;
        L23:
            r3 = null;
        L17:
            if (r4.containsKey(NotificationCompat.EXTRA_VERIFICATION_ICON_COMPAT) == false) goto L20;
            r1 = IconCompat.createFromBundle(r4.getBundle(NotificationCompat.EXTRA_VERIFICATION_ICON_COMPAT));
        L8:
            if (r4.containsKey(NotificationCompat.EXTRA_CALL_PERSON_COMPAT) == false) goto L12;
            r0 = Person.fromBundle(r4.getBundle(NotificationCompat.EXTRA_CALL_PERSON_COMPAT));
            goto L10
        }

        public CallStyle setAnswerButtonColorHint(int r1) {
            this.mAnswerButtonColor = Integer.valueOf(r1);
            return this;
        }

        public CallStyle setDeclineButtonColorHint(int r1) {
            this.mDeclineButtonColor = Integer.valueOf(r1);
            return this;
        }

        public CallStyle setIsVideo(boolean r1) {
            this.mIsVideo = r1;
            return this;
        }

        public CallStyle setVerificationIcon(Bitmap r1) {
            this.mVerificationIcon = IconCompat.createWithBitmap(r1);
            return this;
        }

        public CallStyle setVerificationIcon(Icon r1) {
            if (r1 != null) goto L4;
            IconCompat r2 = null;
        L5:
            this.mVerificationIcon = r2;
            return this;
        L4:
            r2 = IconCompat.createFromIcon(r1);
            goto L5
        }

        public CallStyle setVerificationText(CharSequence r3) {
            this.mVerificationText = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            return this;
        }
    }

    public static final class CarExtender implements Extender {
        static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
        private static final String EXTRA_COLOR = "app_color";
        private static final String EXTRA_CONVERSATION = "car_conversation";
        static final String EXTRA_INVISIBLE_ACTIONS = "invisible_actions";
        private static final String EXTRA_LARGE_ICON = "large_icon";
        private static final String KEY_AUTHOR = "author";
        private static final String KEY_MESSAGES = "messages";
        private static final String KEY_ON_READ = "on_read";
        private static final String KEY_ON_REPLY = "on_reply";
        private static final String KEY_PARTICIPANTS = "participants";
        private static final String KEY_REMOTE_INPUT = "remote_input";
        private static final String KEY_TEXT = "text";
        private static final String KEY_TIMESTAMP = "timestamp";
        private int mColor;
        private Bitmap mLargeIcon;
        private UnreadConversation mUnreadConversation;

        static class Api20Impl {
            private Api20Impl() {
            }

            static android.app.RemoteInput.Builder addExtras(android.app.RemoteInput.Builder r0, Bundle r1) {
                return r0.addExtras(r1);
            }

            static android.app.RemoteInput build(android.app.RemoteInput.Builder r0) {
                return r0.build();
            }

            static Parcelable castToParcelable(android.app.RemoteInput r0) {
                return r0;
            }

            static android.app.RemoteInput.Builder createBuilder(String r1) {
                return new android.app.RemoteInput.Builder(r1);
            }

            static boolean getAllowFreeFormInput(android.app.RemoteInput r0) {
                return r0.getAllowFreeFormInput();
            }

            static CharSequence[] getChoices(android.app.RemoteInput r0) {
                return r0.getChoices();
            }

            static Bundle getExtras(android.app.RemoteInput r0) {
                return r0.getExtras();
            }

            static CharSequence getLabel(android.app.RemoteInput r0) {
                return r0.getLabel();
            }

            static String getResultKey(android.app.RemoteInput r0) {
                return r0.getResultKey();
            }

            static android.app.RemoteInput.Builder setAllowFreeFormInput(android.app.RemoteInput.Builder r0, boolean r1) {
                return r0.setAllowFreeFormInput(r1);
            }

            static android.app.RemoteInput.Builder setChoices(android.app.RemoteInput.Builder r0, CharSequence[] r1) {
                return r0.setChoices(r1);
            }

            static android.app.RemoteInput.Builder setLabel(android.app.RemoteInput.Builder r2, CharSequence r3) {
                return r2.setLabel((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            }
        }

        static class Api29Impl {
            private Api29Impl() {
            }

            static int getEditChoicesBeforeSending(android.app.RemoteInput r0) {
                return r0.getEditChoicesBeforeSending();
            }
        }

        @Deprecated
        public static class UnreadConversation {
            private final long mLatestTimestamp;
            private final String[] mMessages;
            private final String[] mParticipants;
            private final PendingIntent mReadPendingIntent;
            private final RemoteInput mRemoteInput;
            private final PendingIntent mReplyPendingIntent;

            public static class Builder {
                private long mLatestTimestamp;
                private final List<String> mMessages;
                private final String mParticipant;
                private PendingIntent mReadPendingIntent;
                private RemoteInput mRemoteInput;
                private PendingIntent mReplyPendingIntent;

                public Builder(String r2) {
                    this.mMessages = new ArrayList();
                    this.mParticipant = r2;
                }

                public Builder addMessage(String r2) {
                    if (r2 == null) goto L4;
                    this.mMessages.add(r2);
                L4:
                    return this;
                }

                public UnreadConversation build() {
                    List<String> r0 = this.mMessages;
                    return new UnreadConversation((String[]) ZeusTransformUtils.preCheckCast(r0.toArray(new String[r0.size()]), String[].class, "com.obric.memorydata.plugin"), this.mRemoteInput, this.mReplyPendingIntent, this.mReadPendingIntent, new String[]{this.mParticipant}, this.mLatestTimestamp);
                }

                public Builder setLatestTimestamp(long r1) {
                    this.mLatestTimestamp = r1;
                    return this;
                }

                public Builder setReadPendingIntent(PendingIntent r1) {
                    this.mReadPendingIntent = r1;
                    return this;
                }

                public Builder setReplyAction(PendingIntent r1, RemoteInput r2) {
                    this.mRemoteInput = r2;
                    this.mReplyPendingIntent = r1;
                    return this;
                }
            }

            UnreadConversation(String[] r1, RemoteInput r2, PendingIntent r3, PendingIntent r4, String[] r5, long r6) {
                this.mMessages = r1;
                this.mRemoteInput = r2;
                this.mReadPendingIntent = r4;
                this.mReplyPendingIntent = r3;
                this.mParticipants = r5;
                this.mLatestTimestamp = r6;
            }

            public long getLatestTimestamp() {
                return this.mLatestTimestamp;
            }

            public String[] getMessages() {
                return this.mMessages;
            }

            public String getParticipant() {
                String[] r1 = this.mParticipants;
                if (r1.length > 0) goto L7;
                return null;
            L7:
                return r1[0];
            }

            public String[] getParticipants() {
                return this.mParticipants;
            }

            public PendingIntent getReadPendingIntent() {
                return this.mReadPendingIntent;
            }

            public RemoteInput getRemoteInput() {
                return this.mRemoteInput;
            }

            public PendingIntent getReplyPendingIntent() {
                return this.mReplyPendingIntent;
            }
        }

        public CarExtender() {
            this.mColor = 0;
        }

        public CarExtender(Notification r5) {
            this.mColor = 0;
            if (Build.VERSION.SDK_INT >= 21) goto L6;
            return;
        L6:
            if (NotificationCompat.getExtras(r5) != null) goto L8;
            Bundle r6 = null;
        L9:
            if (r6 == null) goto L12;
            this.mLargeIcon = (Bitmap) ZeusTransformUtils.preCheckCast(r6.getParcelable(EXTRA_LARGE_ICON), Bitmap.class, "com.obric.memorydata.plugin");
            this.mColor = r6.getInt(EXTRA_COLOR, 0);
            this.mUnreadConversation = getUnreadConversationFromBundle(r6.getBundle(EXTRA_CONVERSATION));
            return;
        L12:
            return;
        L8:
            r6 = NotificationCompat.getExtras(r5).getBundle(EXTRA_CAR_EXTENDER);
            goto L9
        }

        private static Bundle getBundleForUnreadConversation(UnreadConversation r8) {
            Bundle r0 = new Bundle();
            int r2 = 0;
            if (r8.getParticipants() != null) goto L5;
        L7:
            String r1 = null;
        L8:
            int r3 = r8.getMessages().length;
            Parcelable[] r4 = new Parcelable[r3];
        L9:
            if (r2 >= r3) goto L11;
            Bundle r5 = new Bundle();
            r5.putString("text", r8.getMessages()[r2]);
            r5.putString(KEY_AUTHOR, r1);
            r4[r2] = r5;
            r2 = r2 + 1;
            goto L9
        L11:
            r0.putParcelableArray(KEY_MESSAGES, r4);
            RemoteInput r6 = r8.getRemoteInput();
            if (r6 == null) goto L14;
            android.app.RemoteInput.Builder r7 = Api20Impl.createBuilder(r6.getResultKey());
            Api20Impl.setLabel(r7, r6.getLabel());
            Api20Impl.setChoices(r7, r6.getChoices());
            Api20Impl.setAllowFreeFormInput(r7, r6.getAllowFreeFormInput());
            Api20Impl.addExtras(r7, r6.getExtras());
            r0.putParcelable(KEY_REMOTE_INPUT, Api20Impl.castToParcelable(Api20Impl.build(r7)));
        L14:
            r0.putParcelable(KEY_ON_REPLY, r8.getReplyPendingIntent());
            r0.putParcelable(KEY_ON_READ, r8.getReadPendingIntent());
            r0.putStringArray(KEY_PARTICIPANTS, r8.getParticipants());
            r0.putLong("timestamp", r8.getLatestTimestamp());
            return r0;
        L5:
            if (r8.getParticipants().length <= 1) goto L7;
            r1 = r8.getParticipants()[0];
            goto L8
        }

        private static UnreadConversation getUnreadConversationFromBundle(Bundle r22) {
            RemoteInput r1 = null;
            if (r22 != null) goto L5;
            return null;
        L5:
            Parcelable[] r2 = r22.getParcelableArray(KEY_MESSAGES);
            int r4 = 0;
            if (r2 == null) goto L20;
            int r6 = r2.length;
            String[] r7 = new String[r6];
            int r8 = 0;
        L8:
            if (r8 >= r6) goto L16;
            if (ZeusTransformUtils.instanceOf(r2[r8], Bundle.class) == false) goto L11;
            r7[r8] = ((Bundle) ZeusTransformUtils.preCheckCast(r2[r8], Bundle.class, "com.obric.memorydata.plugin")).getString("text");
            if (r7[r8] == null) goto L11;
            r8 = r8 + 1;
        L11:
            boolean r3 = false;
        L17:
            if (r3 == false) goto L19;
            String[] r9 = r7;
        L21:
            PendingIntent r12 = (PendingIntent) ZeusTransformUtils.preCheckCast(r22.getParcelable(KEY_ON_READ), PendingIntent.class, "com.obric.memorydata.plugin");
            PendingIntent r11 = (PendingIntent) ZeusTransformUtils.preCheckCast(r22.getParcelable(KEY_ON_REPLY), PendingIntent.class, "com.obric.memorydata.plugin");
            android.app.RemoteInput r5 = (android.app.RemoteInput) ZeusTransformUtils.preCheckCast(r22.getParcelable(KEY_REMOTE_INPUT), android.app.RemoteInput.class, "com.obric.memorydata.plugin");
            String[] r13 = r22.getStringArray(KEY_PARTICIPANTS);
            if (r13 != null) goto L24;
            return null;
        L24:
            if (r13.length != 1) goto L37;
            if (r5 == null) goto L32;
            String r15 = Api20Impl.getResultKey(r5);
            CharSequence r16 = Api20Impl.getLabel(r5);
            CharSequence[] r17 = Api20Impl.getChoices(r5);
            boolean r18 = Api20Impl.getAllowFreeFormInput(r5);
            if (Build.VERSION.SDK_INT < 29) goto L30;
            r4 = Api29Impl.getEditChoicesBeforeSending(r5);
        L30:
            r1 = new RemoteInput(r15, r16, r17, r18, r4, Api20Impl.getExtras(r5), null);
        L32:
            return new UnreadConversation(r9, r1, r11, r12, r13, r22.getLong("timestamp"));
        L37:
            return null;
        L19:
            return null;
        L16:
            r3 = true;
            goto L17
        L20:
            r9 = null;
            goto L21
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        public Builder extend(Builder r4) {
            if (Build.VERSION.SDK_INT >= 21) goto L5;
            return r4;
        L5:
            Bundle r0 = new Bundle();
            Bitmap r1 = this.mLargeIcon;
            if (r1 == null) goto L8;
            r0.putParcelable(EXTRA_LARGE_ICON, r1);
        L8:
            int r2 = this.mColor;
            if (r2 == 0) goto L11;
            r0.putInt(EXTRA_COLOR, r2);
        L11:
            UnreadConversation r3 = this.mUnreadConversation;
            if (r3 == null) goto L14;
            r0.putBundle(EXTRA_CONVERSATION, getBundleForUnreadConversation(r3));
        L14:
            r4.getExtras().putBundle(EXTRA_CAR_EXTENDER, r0);
            return r4;
        }

        public int getColor() {
            return this.mColor;
        }

        public Bitmap getLargeIcon() {
            return this.mLargeIcon;
        }

        @Deprecated
        public UnreadConversation getUnreadConversation() {
            return this.mUnreadConversation;
        }

        public CarExtender setColor(int r1) {
            this.mColor = r1;
            return this;
        }

        public CarExtender setLargeIcon(Bitmap r1) {
            this.mLargeIcon = r1;
            return this;
        }

        @Deprecated
        public CarExtender setUnreadConversation(UnreadConversation r1) {
            this.mUnreadConversation = r1;
            return this;
        }
    }

    public static class DecoratedCustomViewStyle extends Style {
        private static final int MAX_ACTION_BUTTONS = 3;
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";

        static class Api15Impl {
            private Api15Impl() {
            }

            static void setContentDescription(RemoteViews r2, int r3, CharSequence r4) {
                r2.setContentDescription(r3, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin"));
            }
        }

        static class Api16Impl {
            private Api16Impl() {
            }

            static Notification.Builder setStyle(Notification.Builder r2, Object r3) {
                return r2.setStyle((Notification.Style) ZeusTransformUtils.preCheckCast(r3, Notification.Style.class, "com.obric.memorydata.plugin"));
            }
        }

        static class Api24Impl {
            private Api24Impl() {
            }

            static Notification.DecoratedCustomViewStyle createDecoratedCustomViewStyle() {
                return new Notification.DecoratedCustomViewStyle();
            }
        }

        public DecoratedCustomViewStyle() {
        }

        private RemoteViews createRemoteViews(RemoteViews r11, boolean r12) {
            boolean r1 = true;
            int r2 = 0;
            RemoteViews r0 = applyStandardTemplate(true, ZeusTransformUtils.mapRes(R.layout.notification_template_custom_big, "layout", "notification_template_custom_big"), false);
            r0.removeAllViews(ZeusTransformUtils.mapRes(R.id.actions, OaidModel.KEY_ID, "actions"));
            List<Action> r3 = getNonContextualActions(this.mBuilder.mActions);
            if (r12 == false) goto L10;
            if (r3 == null) goto L10;
            int r13 = Math.min(r3.size(), 3);
            if (r13 <= 0) goto L10;
            int r6 = 0;
        L8:
            if (r6 >= r13) goto L11;
            r0.addView(ZeusTransformUtils.mapRes(R.id.actions, OaidModel.KEY_ID, "actions"), generateActionButton((Action) ZeusTransformUtils.preCheckCast(r3.get(r6), Action.class, "com.obric.memorydata.plugin")));
            r6 = r6 + 1;
        L11:
            if (r1 == true) goto L14;
            r2 = 8;
        L14:
            r0.setViewVisibility(ZeusTransformUtils.mapRes(R.id.actions, OaidModel.KEY_ID, "actions"), r2);
            r0.setViewVisibility(ZeusTransformUtils.mapRes(R.id.action_divider, OaidModel.KEY_ID, "action_divider"), r2);
            buildIntoRemoteViews(r0, r11);
            return r0;
        L10:
            r1 = false;
            goto L11
        }

        private RemoteViews generateActionButton(Action r9) {
            if (r9.actionIntent != null) goto L5;
            boolean r0 = true;
        L6:
            String r2 = this.mBuilder.mContext.getPackageName();
            if (r0 == false) goto L9;
            int r4 = R.layout.notification_action_tombstone;
            String r5 = "notification_action_tombstone";
        L10:
            RemoteViews r1 = new RemoteViews(r2, ZeusTransformUtils.mapRes(r4, "layout", r5));
            IconCompat r3 = r9.getIconCompat();
            if (r3 == null) goto L13;
            r1.setImageViewBitmap(ZeusTransformUtils.mapRes(R.id.action_image, OaidModel.KEY_ID, "action_image"), createColoredBitmap(r3, ZeusTransformUtils.mapRes(R.color.notification_action_color_filter, TypedValues.Custom.S_COLOR, "notification_action_color_filter")));
        L13:
            r1.setTextViewText(ZeusTransformUtils.mapRes(R.id.action_text, OaidModel.KEY_ID, "action_text"), r9.title);
            if (r0 == true) goto L17;
            r1.setOnClickPendingIntent(ZeusTransformUtils.mapRes(R.id.action_container, OaidModel.KEY_ID, "action_container"), r9.actionIntent);
        L17:
            if (Build.VERSION.SDK_INT < 15) goto L19;
            Api15Impl.setContentDescription(r1, ZeusTransformUtils.mapRes(R.id.action_container, OaidModel.KEY_ID, "action_container"), r9.title);
        L19:
            return r1;
        L9:
            r4 = R.layout.notification_action;
            r5 = "notification_action";
            goto L10
        L5:
            r0 = false;
            goto L6
        }

        private static List<Action> getNonContextualActions(List<Action> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L6;
            return null;
        L6:
            ArrayList r0 = new ArrayList();
            Iterator r6 = r5.iterator();
        L8:
            if (r6.hasNext() == false) goto L12;
            Action r2 = (Action) ZeusTransformUtils.preCheckCast(r6.next(), Action.class, "com.obric.memorydata.plugin");
            if (r2.isContextual() == true) goto L8;
            r0.add(r2);
            goto L8
        L12:
            return r0;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor r2) {
            NotificationBuilderWithBuilderAccessor r1 = (NotificationBuilderWithBuilderAccessor) ZeusTransformUtils.wrapperContextForParams(r2, NotificationBuilderWithBuilderAccessor.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT < 24) goto L6;
            Api16Impl.setStyle(r1.getBuilder(), Api24Impl.createDecoratedCustomViewStyle());
            return;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public boolean displayCustomViewInline() {
            return true;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r3) {
            NotificationBuilderWithBuilderAccessor r4 = (NotificationBuilderWithBuilderAccessor) ZeusTransformUtils.wrapperContextForParams(r3, NotificationBuilderWithBuilderAccessor.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT < 24) goto L5;
            return null;
        L5:
            RemoteViews r5 = this.mBuilder.getBigContentView();
            if (r5 != null) goto L9;
            r5 = this.mBuilder.getContentView();
        L9:
            if (r5 != null) goto L12;
            return null;
        L12:
            return createRemoteViews(r5, true);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r3) {
            NotificationBuilderWithBuilderAccessor r4 = (NotificationBuilderWithBuilderAccessor) ZeusTransformUtils.wrapperContextForParams(r3, NotificationBuilderWithBuilderAccessor.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT < 24) goto L6;
            return null;
        L6:
            if (this.mBuilder.getContentView() != null) goto L9;
            return null;
        L9:
            return createRemoteViews(this.mBuilder.getContentView(), false);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor r3) {
            NotificationBuilderWithBuilderAccessor r4 = (NotificationBuilderWithBuilderAccessor) ZeusTransformUtils.wrapperContextForParams(r3, NotificationBuilderWithBuilderAccessor.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT < 24) goto L5;
            return null;
        L5:
            RemoteViews r5 = this.mBuilder.getHeadsUpContentView();
            if (r5 == null) goto L8;
            RemoteViews r1 = r5;
        L9:
            if (r5 != null) goto L12;
            return null;
        L12:
            return createRemoteViews(r1, true);
        L8:
            r1 = this.mBuilder.getContentView();
            goto L9
        }
    }

    public interface Extender {
        Builder extend(Builder r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GroupAlertBehavior {
    }

    public static class InboxStyle extends Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$InboxStyle";
        private ArrayList<CharSequence> mTexts;

        static class Api16Impl {
            private Api16Impl() {
            }

            static Notification.InboxStyle addLine(Notification.InboxStyle r2, CharSequence r3) {
                return r2.addLine((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            }

            static Notification.InboxStyle createInboxStyle(Notification.Builder r1) {
                return new Notification.InboxStyle(r1);
            }

            static Notification.InboxStyle setBigContentTitle(Notification.InboxStyle r2, CharSequence r3) {
                return r2.setBigContentTitle((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            }

            static Notification.InboxStyle setSummaryText(Notification.InboxStyle r2, CharSequence r3) {
                return r2.setSummaryText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            }
        }

        public InboxStyle() {
            this.mTexts = new ArrayList();
        }

        public InboxStyle(Builder r2) {
            this.mTexts = new ArrayList();
            setBuilder(r2);
        }

        public InboxStyle addLine(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L5;
            this.mTexts.add(Builder.limitCharSequenceLength(r4));
        L5:
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor r4) {
            NotificationBuilderWithBuilderAccessor r5 = (NotificationBuilderWithBuilderAccessor) ZeusTransformUtils.wrapperContextForParams(r4, NotificationBuilderWithBuilderAccessor.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT < 16) goto L11;
            Notification.InboxStyle r6 = Api16Impl.setBigContentTitle(Api16Impl.createInboxStyle(r5.getBuilder()), this.mBigContentTitle);
            if (this.mSummaryTextSet == false) goto L7;
            Api16Impl.setSummaryText(r6, this.mSummaryText);
        L7:
            Iterator<CharSequence> r3 = this.mTexts.iterator();
        L9:
            if (r3.hasNext() == false) goto L13;
            Api16Impl.addLine(r6, (CharSequence) ZeusTransformUtils.preCheckCast(r3.next(), CharSequence.class, "com.obric.memorydata.plugin"));
            goto L9
        L13:
            return;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void clearCompatExtraKeys(Bundle r1) {
            super.clearCompatExtraKeys(r1);
            r1.remove(NotificationCompat.EXTRA_TEXT_LINES);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void restoreFromCompatExtras(Bundle r3) {
            super.restoreFromCompatExtras(r3);
            this.mTexts.clear();
            if (r3.containsKey(NotificationCompat.EXTRA_TEXT_LINES) == false) goto L6;
            Collections.addAll(this.mTexts, r3.getCharSequenceArray(NotificationCompat.EXTRA_TEXT_LINES));
            return;
        }

        public InboxStyle setBigContentTitle(CharSequence r3) {
            this.mBigContentTitle = Builder.limitCharSequenceLength((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public InboxStyle setSummaryText(CharSequence r3) {
            this.mSummaryText = Builder.limitCharSequenceLength((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            this.mSummaryTextSet = true;
            return this;
        }
    }

    public static class MessagingStyle extends Style {
        public static final int MAXIMUM_RETAINED_MESSAGES = 25;
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$MessagingStyle";
        private CharSequence mConversationTitle;
        private final List<Message> mHistoricMessages;
        private Boolean mIsGroupConversation;
        private final List<Message> mMessages;
        private Person mUser;

        static class Api16Impl {
            private Api16Impl() {
            }

            static Notification.BigTextStyle bigText(Notification.BigTextStyle r2, CharSequence r3) {
                return r2.bigText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            }

            static Notification.BigTextStyle createBigTextStyle(Notification.Builder r1) {
                return new Notification.BigTextStyle(r1);
            }

            static Notification.BigTextStyle setBigContentTitle(Notification.BigTextStyle r2, CharSequence r3) {
                return r2.setBigContentTitle((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            }

            static void setBuilder(Notification.Style r0, Notification.Builder r1) {
                r0.setBuilder(r1);
            }
        }

        static class Api24Impl {
            private Api24Impl() {
            }

            static Notification.MessagingStyle addMessage(Notification.MessagingStyle r0, Notification.MessagingStyle.Message r1) {
                return r0.addMessage(r1);
            }

            static Notification.MessagingStyle createMessagingStyle(CharSequence r2) {
                return new Notification.MessagingStyle((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"));
            }

            static Notification.MessagingStyle setConversationTitle(Notification.MessagingStyle r2, CharSequence r3) {
                return r2.setConversationTitle((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            }
        }

        static class Api26Impl {
            private Api26Impl() {
            }

            static Notification.MessagingStyle addHistoricMessage(Notification.MessagingStyle r0, Notification.MessagingStyle.Message r1) {
                return r0.addHistoricMessage(r1);
            }
        }

        static class Api28Impl {
            private Api28Impl() {
            }

            static Notification.MessagingStyle createMessagingStyle(android.app.Person r1) {
                return new Notification.MessagingStyle(r1);
            }

            static Notification.MessagingStyle setGroupConversation(Notification.MessagingStyle r0, boolean r1) {
                return r0.setGroupConversation(r1);
            }
        }

        public static final class Message {
            static final String KEY_DATA_MIME_TYPE = "type";
            static final String KEY_DATA_URI = "uri";
            static final String KEY_EXTRAS_BUNDLE = "extras";
            static final String KEY_NOTIFICATION_PERSON = "sender_person";
            static final String KEY_PERSON = "person";
            static final String KEY_SENDER = "sender";
            static final String KEY_TEXT = "text";
            static final String KEY_TIMESTAMP = "time";
            private String mDataMimeType;
            private Uri mDataUri;
            private Bundle mExtras;
            private final Person mPerson;
            private final CharSequence mText;
            private final long mTimestamp;

            static class Api24Impl {
                private Api24Impl() {
                }

                static Notification.MessagingStyle.Message createMessage(CharSequence r2, long r3, CharSequence r5) {
                    return new Notification.MessagingStyle.Message((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"), r3, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin"));
                }

                static Notification.MessagingStyle.Message setData(Notification.MessagingStyle.Message r0, String r1, Uri r2) {
                    return r0.setData(r1, r2);
                }
            }

            static class Api28Impl {
                private Api28Impl() {
                }

                static Parcelable castToParcelable(android.app.Person r0) {
                    return r0;
                }

                static Notification.MessagingStyle.Message createMessage(CharSequence r2, long r3, android.app.Person r5) {
                    return new Notification.MessagingStyle.Message((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"), r3, r5);
                }
            }

            public Message(CharSequence r3, long r4, Person r6) {
                CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
                this.mExtras = new Bundle();
                this.mText = r5;
                this.mTimestamp = r4;
                this.mPerson = r6;
            }

            @Deprecated
            public Message(CharSequence r3, long r4, CharSequence r6) {
                CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
                CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
                this(r5, r4, new Person.Builder().setName(r7).build());
            }

            static Bundle[] getBundleArrayForMessages(List<Message> r6) {
                List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
                Bundle[] r0 = new Bundle[r7.size()];
                int r2 = r7.size();
                int r3 = 0;
            L3:
                if (r3 >= r2) goto L5;
                r0[r3] = ((Message) ZeusTransformUtils.preCheckCast(r7.get(r3), Message.class, "com.obric.memorydata.plugin")).toBundle();
                r3 = r3 + 1;
                goto L3
            L5:
                return r0;
            }

            static Message getMessageFromBundle(Bundle r11) {
                if (r11.containsKey("text") == false) goto L30;
                if (r11.containsKey("time") == false) goto L30;
                if (r11.containsKey(KEY_PERSON) == false) goto L13;
                Person r3 = Person.fromBundle(r11.getBundle(KEY_PERSON));     // Catch: ClassCastException -> L31
            L21:
                Message r4 = new Message(r11.getCharSequence("text"), r11.getLong("time"), r3);     // Catch: ClassCastException -> L31
                if (r11.containsKey("type") == false) goto L27;
                if (r11.containsKey(KEY_DATA_URI) == false) goto L27;
                r4.setData(r11.getString("type"), (Uri) ZeusTransformUtils.preCheckCast(r11.getParcelable(KEY_DATA_URI), Uri.class, "com.obric.memorydata.plugin"));     // Catch: ClassCastException -> L31
            L27:
                if (r11.containsKey(KEY_EXTRAS_BUNDLE) == false) goto L29;
                r4.getExtras().putAll(r11.getBundle(KEY_EXTRAS_BUNDLE));     // Catch: ClassCastException -> L31
            L29:
                return r4;
            L13:
                if (r11.containsKey(KEY_NOTIFICATION_PERSON) == false) goto L18;
                if (Build.VERSION.SDK_INT < 28) goto L18;
                r3 = Person.fromAndroidPerson((android.app.Person) ZeusTransformUtils.preCheckCast(r11.getParcelable(KEY_NOTIFICATION_PERSON), android.app.Person.class, "com.obric.memorydata.plugin"));     // Catch: ClassCastException -> L31
            L18:
                if (r11.containsKey(KEY_SENDER) == false) goto L20;
                r3 = new Person.Builder().setName(r11.getCharSequence(KEY_SENDER)).build();     // Catch: ClassCastException -> L31
                goto L21
            L20:
                r3 = null;
            L30:
                return null;
            }

            static List<Message> getMessagesFromBundleArray(Parcelable[] r5) {
                ArrayList r0 = new ArrayList(r5.length);
                int r1 = 0;
            L4:
                if (r1 >= r5.length) goto L11;
                if (ZeusTransformUtils.instanceOf(r5[r1], Bundle.class) == false) goto L10;
                Message r2 = getMessageFromBundle((Bundle) ZeusTransformUtils.preCheckCast(r5[r1], Bundle.class, "com.obric.memorydata.plugin"));
                if (r2 == null) goto L10;
                r0.add(r2);
            L10:
                r1 = r1 + 1;
                goto L4
            L11:
                return r0;
            }

            private Bundle toBundle() {
                Bundle r0 = new Bundle();
                CharSequence r1 = this.mText;
                if (r1 == null) goto L5;
                r0.putCharSequence("text", r1);
            L5:
                r0.putLong("time", this.mTimestamp);
                Person r2 = this.mPerson;
                if (r2 == null) goto L11;
                r0.putCharSequence(KEY_SENDER, r2.getName());
                if (Build.VERSION.SDK_INT < 28) goto L10;
                r0.putParcelable(KEY_NOTIFICATION_PERSON, Api28Impl.castToParcelable(this.mPerson.toAndroidPerson()));
                goto L11
            L10:
                r0.putBundle(KEY_PERSON, this.mPerson.toBundle());
            L11:
                String r3 = this.mDataMimeType;
                if (r3 == null) goto L14;
                r0.putString("type", r3);
            L14:
                Uri r4 = this.mDataUri;
                if (r4 == null) goto L17;
                r0.putParcelable(KEY_DATA_URI, r4);
            L17:
                Bundle r5 = this.mExtras;
                if (r5 == null) goto L20;
                r0.putBundle(KEY_EXTRAS_BUNDLE, r5);
            L20:
                return r0;
            }

            public String getDataMimeType() {
                return this.mDataMimeType;
            }

            public Uri getDataUri() {
                return this.mDataUri;
            }

            public Bundle getExtras() {
                return this.mExtras;
            }

            public Person getPerson() {
                return this.mPerson;
            }

            @Deprecated
            public CharSequence getSender() {
                Person r0 = this.mPerson;
                if (r0 != null) goto L6;
                return null;
            L6:
                return r0.getName();
            }

            public CharSequence getText() {
                return this.mText;
            }

            public long getTimestamp() {
                return this.mTimestamp;
            }

            public Message setData(String r1, Uri r2) {
                this.mDataMimeType = r1;
                this.mDataUri = r2;
                return this;
            }

            Notification.MessagingStyle.Message toAndroidMessage() {
                Person r0 = getPerson();
                CharSequence r2 = null;
                android.app.Person r3 = null;
                if (Build.VERSION.SDK_INT < 28) goto L9;
                CharSequence r1 = getText();
                long r4 = getTimestamp();
                if (r0 == null) goto L8;
                r3 = r0.toAndroidPerson();
            L8:
                Notification.MessagingStyle.Message r5 = Api28Impl.createMessage(r1, r4, r3);
            L15:
                if (getDataMimeType() == null) goto L17;
                Api24Impl.setData(r5, getDataMimeType(), getDataUri());
            L17:
                return r5;
            L9:
                CharSequence r6 = getText();
                long r7 = getTimestamp();
                if (r0 == null) goto L13;
                r2 = r0.getName();
            L13:
                r5 = Api24Impl.createMessage(r6, r7, r2);
                goto L15
            }
        }

        MessagingStyle() {
            this.mMessages = new ArrayList();
            this.mHistoricMessages = new ArrayList();
        }

        public MessagingStyle(Person r2) {
            this.mMessages = new ArrayList();
            this.mHistoricMessages = new ArrayList();
            if (TextUtils.isEmpty(r2.getName()) == true) goto L7;
            this.mUser = r2;
            return;
        L7:
            throw new IllegalArgumentException("User's name must not be empty.");
        }

        @Deprecated
        public MessagingStyle(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            this.mMessages = new ArrayList();
            this.mHistoricMessages = new ArrayList();
            this.mUser = new Person.Builder().setName(r4).build();
        }

        public static MessagingStyle extractMessagingStyleFromNotification(Notification r2) {
            Style r3 = Style.extractStyleFromNotification(r2);
            if (ZeusTransformUtils.instanceOf(r3, MessagingStyle.class) == true) goto L5;
            return null;
        L5:
            return (MessagingStyle) ZeusTransformUtils.preCheckCast(r3, MessagingStyle.class, "com.obric.memorydata.plugin");
        }

        private Message findLatestIncomingMessage() {
            int r0 = this.mMessages.size();
        L3:
            r0 = r0 - 1;
            if (r0 < 0) goto L12;
            Message r1 = (Message) ZeusTransformUtils.preCheckCast(this.mMessages.get(r0), Message.class, "com.obric.memorydata.plugin");
            if (r1.getPerson() == null) goto L3;
            if (TextUtils.isEmpty(r1.getPerson().getName()) == true) goto L3;
            return r1;
        L12:
            if (this.mMessages.isEmpty() == true) goto L15;
            List<Message> r4 = this.mMessages;
            return (Message) ZeusTransformUtils.preCheckCast(r4.get(r4.size() - 1), Message.class, "com.obric.memorydata.plugin");
        L15:
            return null;
        }

        private boolean hasMessagesWithoutSender() {
            int r0 = this.mMessages.size() - 1;
        L3:
            if (r0 < 0) goto L10;
            Message r2 = (Message) ZeusTransformUtils.preCheckCast(this.mMessages.get(r0), Message.class, "com.obric.memorydata.plugin");
            if (r2.getPerson() == null) goto L9;
            if (r2.getPerson().getName() != null) goto L9;
            return true;
        L9:
            r0 = r0 - 1;
            goto L3
        L10:
            return false;
        }

        private TextAppearanceSpan makeFontColorSpan(int r7) {
            return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(r7), null);
        }

        private CharSequence makeMessageLine(Message r8) {
            BidiFormatter r0 = BidiFormatter.getInstance();
            SpannableStringBuilder r1 = new SpannableStringBuilder();
            if (Build.VERSION.SDK_INT < 21) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L8;
            int r3 = ViewCompat.MEASURED_STATE_MASK;
        L9:
            CharSequence r5 = "";
            if (r8.getPerson() != null) goto L12;
            CharSequence r4 = "";
        L14:
            if (TextUtils.isEmpty(r4) == false) goto L20;
            r4 = this.mUser.getName();
            if (r2 == false) goto L20;
            if (this.mBuilder.getColor() == 0) goto L20;
            r3 = this.mBuilder.getColor();
        L20:
            CharSequence r6 = r0.unicodeWrap(r4);
            r1.append(r6);
            r1.setSpan(makeFontColorSpan(r3), r1.length() - r6.length(), r1.length(), 33);
            if (r8.getText() == null) goto L24;
            r5 = r8.getText();
        L24:
            r1.append("  ").append(r0.unicodeWrap(r5));
            return r1;
        L12:
            r4 = r8.getPerson().getName();
            goto L14
        L8:
            r3 = -1;
            goto L9
        L5:
            r2 = false;
            goto L6
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void addCompatExtras(Bundle r3) {
            super.addCompatExtras(r3);
            r3.putCharSequence(NotificationCompat.EXTRA_SELF_DISPLAY_NAME, this.mUser.getName());
            r3.putBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER, this.mUser.toBundle());
            r3.putCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE, this.mConversationTitle);
            if (this.mConversationTitle == null) goto L8;
            if (this.mIsGroupConversation.booleanValue() == false) goto L8;
            r3.putCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE, this.mConversationTitle);
        L8:
            if (this.mMessages.isEmpty() == true) goto L11;
            r3.putParcelableArray(NotificationCompat.EXTRA_MESSAGES, Message.getBundleArrayForMessages(this.mMessages));
        L11:
            if (this.mHistoricMessages.isEmpty() == true) goto L13;
            r3.putParcelableArray(NotificationCompat.EXTRA_HISTORIC_MESSAGES, Message.getBundleArrayForMessages(this.mHistoricMessages));
        L13:
            Boolean r2 = this.mIsGroupConversation;
            if (r2 == null) goto L17;
            r3.putBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION, r2.booleanValue());
            return;
        }

        public MessagingStyle addHistoricMessage(Message r2) {
            if (r2 == null) goto L6;
            this.mHistoricMessages.add(r2);
            if (this.mHistoricMessages.size() <= 25) goto L6;
            this.mHistoricMessages.remove(0);
        L6:
            return this;
        }

        public MessagingStyle addMessage(Message r2) {
            if (r2 == null) goto L6;
            this.mMessages.add(r2);
            if (this.mMessages.size() <= 25) goto L6;
            this.mMessages.remove(0);
        L6:
            return this;
        }

        public MessagingStyle addMessage(CharSequence r3, long r4, Person r6) {
            addMessage(new Message((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4, r6));
            return this;
        }

        @Deprecated
        public MessagingStyle addMessage(CharSequence r4, long r5, CharSequence r7) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
            CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
            this.mMessages.add(new Message(r6, r5, new Person.Builder().setName(r8).build()));
            if (this.mMessages.size() <= 25) goto L5;
            this.mMessages.remove(0);
        L5:
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor r9) {
            NotificationBuilderWithBuilderAccessor r10 = (NotificationBuilderWithBuilderAccessor) ZeusTransformUtils.wrapperContextForParams(r9, NotificationBuilderWithBuilderAccessor.class, "com.obric.memorydata.plugin");
            setGroupConversation(isGroupConversation());
            if (Build.VERSION.SDK_INT >= 24) goto L5;
            Message r0 = findLatestIncomingMessage();
            if (this.mConversationTitle != null) goto L30;
        L33:
            if (r0 == null) goto L37;
            r10.getBuilder().setContentTitle("");
            if (r0.getPerson() == null) goto L37;
            Notification.Builder r2 = r10.getBuilder();
            CharSequence r3 = r0.getPerson().getName();
        L32:
            r2.setContentTitle(r3);
        L37:
            if (r0 == null) goto L44;
            Notification.Builder r4 = r10.getBuilder();
            if (this.mConversationTitle == null) goto L41;
            CharSequence r1 = makeMessageLine(r0);
        L42:
            r4.setContentText(r1);
            goto L44
        L41:
            r1 = r0.getText();
        L44:
            if (Build.VERSION.SDK_INT < 16) goto L70;
            SpannableStringBuilder r5 = new SpannableStringBuilder();
            if (this.mConversationTitle == null) goto L48;
        L51:
            boolean r6 = true;
        L52:
            int r7 = this.mMessages.size() - 1;
        L53:
            if (r7 < 0) goto L62;
            Message r8 = (Message) ZeusTransformUtils.preCheckCast(this.mMessages.get(r7), Message.class, "com.obric.memorydata.plugin");
            if (r6 == false) goto L57;
            CharSequence r11 = makeMessageLine(r8);
        L59:
            if (r7 == (this.mMessages.size() - 1)) goto L61;
            r5.insert(0, "\n");
        L61:
            r5.insert(0, r11);
            r7 = r7 - 1;
            goto L53
        L57:
            r11 = r8.getText();
            goto L59
        L62:
            Api16Impl.bigText(Api16Impl.setBigContentTitle(Api16Impl.createBigTextStyle(r10.getBuilder()), null), r5);
            return;
        L48:
            if (hasMessagesWithoutSender() == true) goto L51;
            r6 = false;
            goto L52
        L70:
            return;
        L30:
            if (this.mIsGroupConversation.booleanValue() == false) goto L33;
            r2 = r10.getBuilder();
            r3 = this.mConversationTitle;
            goto L32
        L5:
            if (Build.VERSION.SDK_INT < 28) goto L7;
            Notification.MessagingStyle r12 = Api28Impl.createMessagingStyle(this.mUser.toAndroidPerson());
        L8:
            Iterator<Message> r13 = this.mMessages.iterator();
        L10:
            if (r13.hasNext() == false) goto L13;
            Api24Impl.addMessage((Notification.MessagingStyle) ZeusTransformUtils.preCheckCast(r12, Notification.MessagingStyle.class, "com.obric.memorydata.plugin"), ((Message) ZeusTransformUtils.preCheckCast(r13.next(), Message.class, "com.obric.memorydata.plugin")).toAndroidMessage());
            goto L10
        L13:
            if (Build.VERSION.SDK_INT < 26) goto L19;
            Iterator<Message> r14 = this.mHistoricMessages.iterator();
        L16:
            if (r14.hasNext() == false) goto L19;
            Api26Impl.addHistoricMessage((Notification.MessagingStyle) ZeusTransformUtils.preCheckCast(r12, Notification.MessagingStyle.class, "com.obric.memorydata.plugin"), ((Message) ZeusTransformUtils.preCheckCast(r14.next(), Message.class, "com.obric.memorydata.plugin")).toAndroidMessage());
        L19:
            if (this.mIsGroupConversation.booleanValue() == false) goto L21;
        L22:
            Api24Impl.setConversationTitle((Notification.MessagingStyle) ZeusTransformUtils.preCheckCast(r12, Notification.MessagingStyle.class, "com.obric.memorydata.plugin"), this.mConversationTitle);
        L24:
            if (Build.VERSION.SDK_INT < 28) goto L26;
            Api28Impl.setGroupConversation((Notification.MessagingStyle) ZeusTransformUtils.preCheckCast(r12, Notification.MessagingStyle.class, "com.obric.memorydata.plugin"), this.mIsGroupConversation.booleanValue());
        L26:
            Api16Impl.setBuilder((Notification.Style) ZeusTransformUtils.preCheckCast(r12, Notification.Style.class, "com.obric.memorydata.plugin"), r10.getBuilder());
            return;
        L21:
            if (Build.VERSION.SDK_INT < 28) goto L24;
        L7:
            r12 = Api24Impl.createMessagingStyle(this.mUser.getName());
            goto L8
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void clearCompatExtraKeys(Bundle r1) {
            super.clearCompatExtraKeys(r1);
            r1.remove(NotificationCompat.EXTRA_MESSAGING_STYLE_USER);
            r1.remove(NotificationCompat.EXTRA_SELF_DISPLAY_NAME);
            r1.remove(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            r1.remove(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
            r1.remove(NotificationCompat.EXTRA_MESSAGES);
            r1.remove(NotificationCompat.EXTRA_HISTORIC_MESSAGES);
            r1.remove(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        public CharSequence getConversationTitle() {
            return this.mConversationTitle;
        }

        public List<Message> getHistoricMessages() {
            return this.mHistoricMessages;
        }

        public List<Message> getMessages() {
            return this.mMessages;
        }

        public Person getUser() {
            return this.mUser;
        }

        @Deprecated
        public CharSequence getUserDisplayName() {
            return this.mUser.getName();
        }

        public boolean isGroupConversation() {
            if (this.mBuilder != null) goto L5;
        L12:
            Boolean r3 = this.mIsGroupConversation;
            if (r3 != null) goto L15;
            return false;
        L15:
            return r3.booleanValue();
        L5:
            if (this.mBuilder.mContext.getApplicationInfo().targetSdkVersion >= 28) goto L12;
            if (this.mIsGroupConversation != null) goto L12;
            if (this.mConversationTitle == null) goto L16;
            return true;
        L16:
            return false;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void restoreFromCompatExtras(Bundle r3) {
            super.restoreFromCompatExtras(r3);
            this.mMessages.clear();
            if (r3.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER) == false) goto L5;
            Person r0 = Person.fromBundle(r3.getBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER));
        L6:
            this.mUser = r0;
            CharSequence r1 = r3.getCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            this.mConversationTitle = r1;
            if (r1 != null) goto L9;
            this.mConversationTitle = r3.getCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
        L9:
            Parcelable[] r2 = r3.getParcelableArray(NotificationCompat.EXTRA_MESSAGES);
            if (r2 == null) goto L12;
            this.mMessages.addAll(Message.getMessagesFromBundleArray(r2));
        L12:
            Parcelable[] r4 = r3.getParcelableArray(NotificationCompat.EXTRA_HISTORIC_MESSAGES);
            if (r4 == null) goto L16;
            this.mHistoricMessages.addAll(Message.getMessagesFromBundleArray(r4));
        L16:
            if (r3.containsKey(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION) == false) goto L19;
            this.mIsGroupConversation = Boolean.valueOf(r3.getBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION));
            return;
        L19:
            return;
        L5:
            r0 = new Person.Builder().setName(r3.getString(NotificationCompat.EXTRA_SELF_DISPLAY_NAME)).build();
            goto L6
        }

        public MessagingStyle setConversationTitle(CharSequence r3) {
            this.mConversationTitle = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            return this;
        }

        public MessagingStyle setGroupConversation(boolean r1) {
            this.mIsGroupConversation = Boolean.valueOf(r1);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NotificationVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ServiceNotificationBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StreamType {
    }

    public static abstract class Style {
        CharSequence mBigContentTitle;
        protected Builder mBuilder;
        CharSequence mSummaryText;
        boolean mSummaryTextSet;

        static class Api16Impl {
            private Api16Impl() {
            }

            static void setTextViewTextSize(RemoteViews r0, int r1, int r2, float r3) {
                r0.setTextViewTextSize(r1, r2, r3);
            }

            static void setViewPadding(RemoteViews r0, int r1, int r2, int r3, int r4, int r5) {
                r0.setViewPadding(r1, r2, r3, r4, r5);
            }
        }

        static class Api24Impl {
            private Api24Impl() {
            }

            static void setChronometerCountDown(RemoteViews r0, int r1, boolean r2) {
                r0.setChronometerCountDown(r1, r2);
            }
        }

        public Style() {
            this.mSummaryTextSet = false;
        }

        private int calculateTopPadding() {
            Resources r4 = ZeusTransformUtils.getResources(this.mBuilder.mContext, "com.obric.memorydata.plugin");
            int r0 = r4.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.notification_top_pad, "dimen", "notification_top_pad"));
            int r1 = r4.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.notification_top_pad_large_text, "dimen", "notification_top_pad_large_text"));
            float r5 = (constrain(r4.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return Math.round(((1.0f - r5) * r0) + (r5 * r1));
        }

        private static float constrain(float r1, float r2, float r3) {
            if (r1 >= r2) goto L6;
            return r2;
        L6:
            if (r1 > r3) goto L8;
            return r1;
        L8:
            return r3;
        }

        static Style constructCompatStyleByName(String r2) {
            if (r2 == null) goto L44;
            r2.hashCode();
            byte r0 = -1;
            switch(r2.hashCode()) {
                case -716705180: goto L27;
                case -171946061: goto L23;
                case 714386739: goto L19;
                case 912942987: goto L15;
                case 919595044: goto L11;
                case 2090799565: goto L7;
                default: goto L30;
            };
        L30:
            switch(r0) {
                case 0: goto L43;
                case 1: goto L41;
                case 2: goto L39;
                case 3: goto L37;
                case 4: goto L35;
                case 5: goto L33;
                default: goto L46;
            };
        L46:
            return null;
        L33:
            return new MessagingStyle();
        L35:
            return new BigTextStyle();
        L37:
            return new InboxStyle();
        L39:
            return new CallStyle();
        L41:
            return new BigPictureStyle();
        L43:
            return new DecoratedCustomViewStyle();
        L7:
            if (r2.equals("androidx.core.app.NotificationCompat$MessagingStyle") == false) goto L30;
            r0 = 5;
            goto L30
        L11:
            if (r2.equals("androidx.core.app.NotificationCompat$BigTextStyle") == false) goto L30;
            r0 = 4;
            goto L30
        L15:
            if (r2.equals("androidx.core.app.NotificationCompat$InboxStyle") == false) goto L30;
            r0 = 3;
            goto L30
        L19:
            if (r2.equals("androidx.core.app.NotificationCompat$CallStyle") == false) goto L30;
            r0 = 2;
            goto L30
        L23:
            if (r2.equals("androidx.core.app.NotificationCompat$BigPictureStyle") == false) goto L30;
            r0 = 1;
            goto L30
        L27:
            if (r2.equals("androidx.core.app.NotificationCompat$DecoratedCustomViewStyle") == false) goto L30;
            r0 = 0;
            goto L30
        L44:
            return null;
        }

        private static Style constructCompatStyleByPlatformName(String r3) {
            if (r3 != null) goto L6;
            return null;
        L6:
            if (Build.VERSION.SDK_INT >= 16) goto L8;
        L29:
            return null;
        L8:
            if (r3.equals(Notification.BigPictureStyle.class.getName()) == false) goto L12;
            return new BigPictureStyle();
        L12:
            if (r3.equals(Notification.BigTextStyle.class.getName()) == false) goto L16;
            return new BigTextStyle();
        L16:
            if (r3.equals(Notification.InboxStyle.class.getName()) == false) goto L20;
            return new InboxStyle();
        L20:
            if (Build.VERSION.SDK_INT < 24) goto L29;
            if (r3.equals(Notification.MessagingStyle.class.getName()) == false) goto L26;
            return new MessagingStyle();
        L26:
            if (r3.equals(Notification.DecoratedCustomViewStyle.class.getName()) == false) goto L29;
            return new DecoratedCustomViewStyle();
        }

        static Style constructCompatStyleForBundle(Bundle r1) {
            Style r0 = constructCompatStyleByName(r1.getString(NotificationCompat.EXTRA_COMPAT_TEMPLATE));
            if (r0 == null) goto L6;
            return r0;
        L6:
            if (r1.containsKey(NotificationCompat.EXTRA_SELF_DISPLAY_NAME) == true) goto L32;
            if (r1.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER) == true) goto L32;
            if (r1.containsKey(NotificationCompat.EXTRA_PICTURE) == true) goto L30;
            if (r1.containsKey(NotificationCompat.EXTRA_PICTURE_ICON) == true) goto L30;
            if (r1.containsKey(NotificationCompat.EXTRA_BIG_TEXT) == false) goto L20;
            return new BigTextStyle();
        L20:
            if (r1.containsKey(NotificationCompat.EXTRA_TEXT_LINES) == false) goto L24;
            return new InboxStyle();
        L24:
            if (r1.containsKey(NotificationCompat.EXTRA_CALL_TYPE) == false) goto L28;
            return new CallStyle();
        L28:
            return constructCompatStyleByPlatformName(r1.getString(NotificationCompat.EXTRA_TEMPLATE));
        L30:
            return new BigPictureStyle();
        L32:
            return new MessagingStyle();
        }

        static Style constructStyleForExtras(Bundle r2) {
            Style r0 = constructCompatStyleForBundle(r2);
            if (r0 != null) goto L8;
            return null;
        L8:
            r0.restoreFromCompatExtras(r2);     // Catch: ClassCastException -> L7
            return r0;
        L7:
            return null;
        }

        private Bitmap createColoredBitmap(int r2, int r3, int r4) {
            return createColoredBitmap(IconCompat.createWithResource(this.mBuilder.mContext, r2), r3, r4);
        }

        private Bitmap createColoredBitmap(IconCompat r3, int r4, int r5) {
            Drawable r2 = r3.loadDrawable(this.mBuilder.mContext);
            if (r5 != 0) goto L5;
            int r6 = r2.getIntrinsicWidth();
        L6:
            if (r5 != 0) goto L8;
            r5 = r2.getIntrinsicHeight();
        L8:
            Bitmap r0 = Bitmap.createBitmap(r6, r5, Bitmap.Config.ARGB_8888);
            r2.setBounds(0, 0, r6, r5);
            if (r4 == 0) goto L11;
            r2.mutate().setColorFilter(new PorterDuffColorFilter(r4, PorterDuff.Mode.SRC_IN));
        L11:
            r2.draw(new Canvas(r0));
            return r0;
        L5:
            r6 = r5;
            goto L6
        }

        private Bitmap createIconWithBackground(int r4, int r5, int r6, int r7) {
            int r0 = ZeusTransformUtils.mapRes(R.drawable.notification_icon_background, "drawable", "notification_icon_background");
            if (r7 != 0) goto L5;
            r7 = 0;
        L5:
            Bitmap r8 = createColoredBitmap(r0, r7, r5);
            Canvas r1 = new Canvas(r8);
            Drawable r3 = ZeusTransformUtils.getResources(this.mBuilder.mContext, "com.obric.memorydata.plugin").getDrawable(r4).mutate();
            r3.setFilterBitmap(true);
            int r9 = (r5 - r6) / 2;
            int r10 = r6 + r9;
            r3.setBounds(r9, r9, r10, r10);
            r3.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            r3.draw(r1);
            return r8;
        }

        public static Style extractStyleFromNotification(Notification r0) {
            Bundle r1 = NotificationCompat.getExtras(r0);
            if (r1 != null) goto L7;
            return null;
        L7:
            return constructStyleForExtras(r1);
        }

        private void hideNormalContent(RemoteViews r4) {
            r4.setViewVisibility(ZeusTransformUtils.mapRes(R.id.title, OaidModel.KEY_ID, "title"), 8);
            r4.setViewVisibility(ZeusTransformUtils.mapRes(R.id.text2, OaidModel.KEY_ID, "text2"), 8);
            r4.setViewVisibility(ZeusTransformUtils.mapRes(R.id.text, OaidModel.KEY_ID, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT), 8);
        }

        public void addCompatExtras(Bundle r3) {
            if (this.mSummaryTextSet == false) goto L5;
            r3.putCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT, this.mSummaryText);
        L5:
            CharSequence r0 = this.mBigContentTitle;
            if (r0 == null) goto L8;
            r3.putCharSequence(NotificationCompat.EXTRA_TITLE_BIG, r0);
        L8:
            String r2 = getClassName();
            if (r2 == null) goto L12;
            r3.putString(NotificationCompat.EXTRA_COMPAT_TEMPLATE, r2);
            return;
        }

        public void apply(NotificationBuilderWithBuilderAccessor r2) {
            NotificationBuilderWithBuilderAccessor r1 = (NotificationBuilderWithBuilderAccessor) ZeusTransformUtils.wrapperContextForParams(r2, NotificationBuilderWithBuilderAccessor.class, "com.obric.memorydata.plugin");
        }

        public RemoteViews applyStandardTemplate(boolean r18, int r19, boolean r20) {
            Resources r1 = ZeusTransformUtils.getResources(this.mBuilder.mContext, "com.obric.memorydata.plugin");
            RemoteViews r8 = new RemoteViews(this.mBuilder.mContext.getPackageName(), r19);
            boolean r9 = true;
            int r10 = 0;
            if (this.mBuilder.getPriority() >= (-1)) goto L5;
            boolean r2 = true;
        L7:
            if (Build.VERSION.SDK_INT < 16) goto L16;
            if (Build.VERSION.SDK_INT >= 21) goto L16;
            if (r2 == false) goto L13;
            r8.setInt(ZeusTransformUtils.mapRes(R.id.notification_background, OaidModel.KEY_ID, "notification_background"), "setBackgroundResource", ZeusTransformUtils.mapRes(R.drawable.notification_bg_low, "drawable", "notification_bg_low"));
            int r3 = ZeusTransformUtils.mapRes(R.id.icon, OaidModel.KEY_ID, "icon");
            int r4 = R.drawable.notification_template_icon_low_bg;
            String r14 = "notification_template_icon_low_bg";
        L14:
            r8.setInt(r3, "setBackgroundResource", ZeusTransformUtils.mapRes(r4, "drawable", r14));
            goto L16
        L13:
            r8.setInt(ZeusTransformUtils.mapRes(R.id.notification_background, OaidModel.KEY_ID, "notification_background"), "setBackgroundResource", ZeusTransformUtils.mapRes(R.drawable.notification_bg, "drawable", "notification_bg"));
            r3 = ZeusTransformUtils.mapRes(R.id.icon, OaidModel.KEY_ID, "icon");
            r4 = R.drawable.notification_template_icon_bg;
            r14 = "notification_template_icon_bg";
        L16:
            if (this.mBuilder.mLargeIcon != null) goto L18;
            if (r18 == true) goto L31;
        L37:
            if (this.mBuilder.mContentTitle == null) goto L40;
            r8.setTextViewText(ZeusTransformUtils.mapRes(R.id.title, OaidModel.KEY_ID, "title"), this.mBuilder.mContentTitle);
        L40:
            if (this.mBuilder.mContentText == null) goto L42;
            r8.setTextViewText(ZeusTransformUtils.mapRes(R.id.text, OaidModel.KEY_ID, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT), this.mBuilder.mContentText);
            boolean r5 = true;
        L44:
            if (Build.VERSION.SDK_INT < 21) goto L46;
        L48:
            boolean r6 = false;
        L50:
            if (this.mBuilder.mContentInfo == null) goto L55;
            int r7 = ZeusTransformUtils.mapRes(R.id.info, OaidModel.KEY_ID, "info");
            CharSequence r11 = this.mBuilder.mContentInfo;
        L52:
            r8.setTextViewText(r7, r11);
        L53:
            r8.setViewVisibility(ZeusTransformUtils.mapRes(R.id.info, OaidModel.KEY_ID, "info"), 0);
            boolean r15 = true;
            boolean r16 = true;
        L62:
            if (this.mBuilder.mSubText != null) goto L64;
        L69:
            boolean r12 = false;
        L70:
            if (r12 == false) goto L77;
            if (Build.VERSION.SDK_INT < 16) goto L77;
            if (r20 == false) goto L75;
            Api16Impl.setTextViewTextSize(r8, ZeusTransformUtils.mapRes(R.id.text, OaidModel.KEY_ID, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT), 0, r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.notification_subtext_size, "dimen", "notification_subtext_size")));
        L75:
            Api16Impl.setViewPadding(r8, ZeusTransformUtils.mapRes(R.id.line1, OaidModel.KEY_ID, "line1"), 0, 0, 0, 0);
        L77:
            if (this.mBuilder.getWhenIfShowing() != 0) goto L79;
            r9 = r16;
        L89:
            int r0 = ZeusTransformUtils.mapRes(R.id.right_side, OaidModel.KEY_ID, "right_side");
            if (r9 == false) goto L92;
            int r13 = 0;
        L93:
            r8.setViewVisibility(r0, r13);
            int r17 = ZeusTransformUtils.mapRes(R.id.line3, OaidModel.KEY_ID, "line3");
            if (r15 == true) goto L97;
            r10 = 8;
        L97:
            r8.setViewVisibility(r17, r10);
            return r8;
        L92:
            r13 = 8;
            goto L93
        L79:
            if (this.mBuilder.mUseChronometer == true) goto L81;
        L87:
            r8.setViewVisibility(ZeusTransformUtils.mapRes(R.id.time, OaidModel.KEY_ID, OaidModel.KEY_TIME), 0);
            r8.setLong(ZeusTransformUtils.mapRes(R.id.time, OaidModel.KEY_ID, OaidModel.KEY_TIME), "setTime", this.mBuilder.getWhenIfShowing());
            goto L89
        L81:
            if (Build.VERSION.SDK_INT < 16) goto L87;
            r8.setViewVisibility(ZeusTransformUtils.mapRes(R.id.chronometer, OaidModel.KEY_ID, "chronometer"), 0);
            r8.setLong(ZeusTransformUtils.mapRes(R.id.chronometer, OaidModel.KEY_ID, "chronometer"), "setBase", this.mBuilder.getWhenIfShowing() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
            r8.setBoolean(ZeusTransformUtils.mapRes(R.id.chronometer, OaidModel.KEY_ID, "chronometer"), "setStarted", true);
            if (this.mBuilder.mChronometerCountDown == false) goto L89;
            if (Build.VERSION.SDK_INT < 24) goto L89;
            Api24Impl.setChronometerCountDown(r8, ZeusTransformUtils.mapRes(R.id.chronometer, OaidModel.KEY_ID, "chronometer"), this.mBuilder.mChronometerCountDown);
            goto L89
        L64:
            if (Build.VERSION.SDK_INT < 16) goto L69;
            r8.setTextViewText(ZeusTransformUtils.mapRes(R.id.text, OaidModel.KEY_ID, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT), this.mBuilder.mSubText);
            if (this.mBuilder.mContentText == null) goto L68;
            r8.setTextViewText(ZeusTransformUtils.mapRes(R.id.text2, OaidModel.KEY_ID, "text2"), this.mBuilder.mContentText);
            r8.setViewVisibility(ZeusTransformUtils.mapRes(R.id.text2, OaidModel.KEY_ID, "text2"), 0);
            r12 = true;
            goto L70
        L68:
            r8.setViewVisibility(ZeusTransformUtils.mapRes(R.id.text2, OaidModel.KEY_ID, "text2"), 8);
            goto L69
        L55:
            if (this.mBuilder.mNumber > 0) goto L57;
            r8.setViewVisibility(ZeusTransformUtils.mapRes(R.id.info, OaidModel.KEY_ID, "info"), 8);
            r15 = r5;
            r16 = r6;
            goto L62
        L57:
            if (this.mBuilder.mNumber <= r1.getInteger(ZeusTransformUtils.mapRes(R.integer.status_bar_notification_info_maxnum, TypedValues.Custom.S_INT, "status_bar_notification_info_maxnum"))) goto L59;
            r7 = ZeusTransformUtils.mapRes(R.id.info, OaidModel.KEY_ID, "info");
            r11 = r1.getString(ZeusTransformUtils.mapRes(R.string.status_bar_notification_info_overflow, TypedValues.Custom.S_STRING, "status_bar_notification_info_overflow"));
            goto L52
        L59:
            r8.setTextViewText(ZeusTransformUtils.mapRes(R.id.info, OaidModel.KEY_ID, "info"), NumberFormat.getIntegerInstance().format(this.mBuilder.mNumber));
            goto L53
        L46:
            if (this.mBuilder.mLargeIcon == null) goto L48;
            r6 = true;
            goto L50
        L42:
            r5 = false;
            goto L44
        L31:
            if (this.mBuilder.mNotification.icon == 0) goto L37;
            r8.setViewVisibility(ZeusTransformUtils.mapRes(R.id.icon, OaidModel.KEY_ID, "icon"), 0);
            if (Build.VERSION.SDK_INT < 21) goto L35;
            r8.setImageViewBitmap(ZeusTransformUtils.mapRes(R.id.icon, OaidModel.KEY_ID, "icon"), createIconWithBackground(this.mBuilder.mNotification.icon, r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.notification_large_icon_width, "dimen", "notification_large_icon_width")) - r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.notification_big_circle_margin, "dimen", "notification_big_circle_margin")), r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.notification_small_icon_size_as_large, "dimen", "notification_small_icon_size_as_large")), this.mBuilder.getColor()));
            goto L37
        L35:
            r8.setImageViewBitmap(ZeusTransformUtils.mapRes(R.id.icon, OaidModel.KEY_ID, "icon"), createColoredBitmap(this.mBuilder.mNotification.icon, -1));
            goto L37
        L18:
            if (Build.VERSION.SDK_INT < 16) goto L20;
            r8.setViewVisibility(ZeusTransformUtils.mapRes(R.id.icon, OaidModel.KEY_ID, "icon"), 0);
            r8.setImageViewBitmap(ZeusTransformUtils.mapRes(R.id.icon, OaidModel.KEY_ID, "icon"), createColoredBitmap(this.mBuilder.mLargeIcon, 0));
        L21:
            if (r18 == false) goto L37;
            if (this.mBuilder.mNotification.icon == 0) goto L37;
            int r21 = r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.notification_right_icon_size, "dimen", "notification_right_icon_size"));
            int r22 = r21 - (r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.notification_small_icon_background_padding, "dimen", "notification_small_icon_background_padding")) * 2);
            if (Build.VERSION.SDK_INT < 21) goto L27;
            r8.setImageViewBitmap(ZeusTransformUtils.mapRes(R.id.right_icon, OaidModel.KEY_ID, "right_icon"), createIconWithBackground(this.mBuilder.mNotification.icon, r21, r22, this.mBuilder.getColor()));
        L28:
            r8.setViewVisibility(ZeusTransformUtils.mapRes(R.id.right_icon, OaidModel.KEY_ID, "right_icon"), 0);
            goto L37
        L27:
            r8.setImageViewBitmap(ZeusTransformUtils.mapRes(R.id.right_icon, OaidModel.KEY_ID, "right_icon"), createColoredBitmap(this.mBuilder.mNotification.icon, -1));
            goto L28
        L20:
            r8.setViewVisibility(ZeusTransformUtils.mapRes(R.id.icon, OaidModel.KEY_ID, "icon"), 8);
            goto L21
        L5:
            r2 = false;
            goto L7
        }

        public Notification build() {
            Builder r0 = this.mBuilder;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.build();
        }

        public void buildIntoRemoteViews(RemoteViews r9, RemoteViews r10) {
            hideNormalContent(r9);
            r9.removeAllViews(ZeusTransformUtils.mapRes(R.id.notification_main_column, OaidModel.KEY_ID, "notification_main_column"));
            r9.addView(ZeusTransformUtils.mapRes(R.id.notification_main_column, OaidModel.KEY_ID, "notification_main_column"), r10.clone());
            r9.setViewVisibility(ZeusTransformUtils.mapRes(R.id.notification_main_column, OaidModel.KEY_ID, "notification_main_column"), 0);
            if (Build.VERSION.SDK_INT < 21) goto L6;
            Api16Impl.setViewPadding(r9, ZeusTransformUtils.mapRes(R.id.notification_main_column_container, OaidModel.KEY_ID, "notification_main_column_container"), 0, calculateTopPadding(), 0, 0);
            return;
        }

        public void clearCompatExtraKeys(Bundle r1) {
            r1.remove(NotificationCompat.EXTRA_SUMMARY_TEXT);
            r1.remove(NotificationCompat.EXTRA_TITLE_BIG);
            r1.remove(NotificationCompat.EXTRA_COMPAT_TEMPLATE);
        }

        public Bitmap createColoredBitmap(int r2, int r3) {
            return createColoredBitmap(r2, r3, 0);
        }

        Bitmap createColoredBitmap(IconCompat r2, int r3) {
            return createColoredBitmap(r2, r3, 0);
        }

        public boolean displayCustomViewInline() {
            return false;
        }

        public String getClassName() {
            return null;
        }

        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r2) {
            NotificationBuilderWithBuilderAccessor r1 = (NotificationBuilderWithBuilderAccessor) ZeusTransformUtils.wrapperContextForParams(r2, NotificationBuilderWithBuilderAccessor.class, "com.obric.memorydata.plugin");
            return null;
        }

        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r2) {
            NotificationBuilderWithBuilderAccessor r1 = (NotificationBuilderWithBuilderAccessor) ZeusTransformUtils.wrapperContextForParams(r2, NotificationBuilderWithBuilderAccessor.class, "com.obric.memorydata.plugin");
            return null;
        }

        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor r2) {
            NotificationBuilderWithBuilderAccessor r1 = (NotificationBuilderWithBuilderAccessor) ZeusTransformUtils.wrapperContextForParams(r2, NotificationBuilderWithBuilderAccessor.class, "com.obric.memorydata.plugin");
            return null;
        }

        public void restoreFromCompatExtras(Bundle r3) {
            if (r3.containsKey(NotificationCompat.EXTRA_SUMMARY_TEXT) == false) goto L5;
            this.mSummaryText = r3.getCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT);
            this.mSummaryTextSet = true;
        L5:
            this.mBigContentTitle = r3.getCharSequence(NotificationCompat.EXTRA_TITLE_BIG);
        }

        public void setBuilder(Builder r2) {
            if (this.mBuilder == r2) goto L8;
            this.mBuilder = r2;
            if (r2 == null) goto L9;
            r2.setStyle(this);
            return;
        L9:
            return;
        }
    }

    public static final class TvExtender implements Extender {
        static final String EXTRA_CHANNEL_ID = "channel_id";
        static final String EXTRA_CONTENT_INTENT = "content_intent";
        static final String EXTRA_DELETE_INTENT = "delete_intent";
        private static final String EXTRA_FLAGS = "flags";
        static final String EXTRA_SUPPRESS_SHOW_OVER_APPS = "suppressShowOverApps";
        static final String EXTRA_TV_EXTENDER = "android.tv.EXTENSIONS";
        private static final int FLAG_AVAILABLE_ON_TV = 1;
        private static final String TAG = "TvExtender";
        private String mChannelId;
        private PendingIntent mContentIntent;
        private PendingIntent mDeleteIntent;
        private int mFlags;
        private boolean mSuppressShowOverApps;

        public TvExtender() {
            this.mFlags = 1;
        }

        public TvExtender(Notification r4) {
            if (Build.VERSION.SDK_INT >= 26) goto L6;
            return;
        L6:
            if (r4.extras != null) goto L8;
            Bundle r5 = null;
        L9:
            if (r5 == null) goto L12;
            this.mFlags = r5.getInt(EXTRA_FLAGS);
            this.mChannelId = r5.getString("channel_id");
            this.mSuppressShowOverApps = r5.getBoolean(EXTRA_SUPPRESS_SHOW_OVER_APPS);
            this.mContentIntent = (PendingIntent) ZeusTransformUtils.preCheckCast(r5.getParcelable(EXTRA_CONTENT_INTENT), PendingIntent.class, "com.obric.memorydata.plugin");
            this.mDeleteIntent = (PendingIntent) ZeusTransformUtils.preCheckCast(r5.getParcelable(EXTRA_DELETE_INTENT), PendingIntent.class, "com.obric.memorydata.plugin");
            return;
        L12:
            return;
        L8:
            r5 = r4.extras.getBundle(EXTRA_TV_EXTENDER);
            goto L9
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        public Builder extend(Builder r4) {
            if (Build.VERSION.SDK_INT >= 26) goto L5;
            return r4;
        L5:
            Bundle r0 = new Bundle();
            r0.putInt(EXTRA_FLAGS, this.mFlags);
            r0.putString("channel_id", this.mChannelId);
            r0.putBoolean(EXTRA_SUPPRESS_SHOW_OVER_APPS, this.mSuppressShowOverApps);
            PendingIntent r1 = this.mContentIntent;
            if (r1 == null) goto L8;
            r0.putParcelable(EXTRA_CONTENT_INTENT, r1);
        L8:
            PendingIntent r3 = this.mDeleteIntent;
            if (r3 == null) goto L11;
            r0.putParcelable(EXTRA_DELETE_INTENT, r3);
        L11:
            r4.getExtras().putBundle(EXTRA_TV_EXTENDER, r0);
            return r4;
        }

        public String getChannelId() {
            return this.mChannelId;
        }

        public PendingIntent getContentIntent() {
            return this.mContentIntent;
        }

        public PendingIntent getDeleteIntent() {
            return this.mDeleteIntent;
        }

        public boolean isAvailableOnTv() {
            if ((this.mFlags & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean isSuppressShowOverApps() {
            return this.mSuppressShowOverApps;
        }

        public TvExtender setChannelId(String r1) {
            this.mChannelId = r1;
            return this;
        }

        public TvExtender setContentIntent(PendingIntent r1) {
            this.mContentIntent = r1;
            return this;
        }

        public TvExtender setDeleteIntent(PendingIntent r1) {
            this.mDeleteIntent = r1;
            return this;
        }

        public TvExtender setSuppressShowOverApps(boolean r1) {
            this.mSuppressShowOverApps = r1;
            return this;
        }
    }

    public static final class WearableExtender implements Extender {
        private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
        private static final int DEFAULT_FLAGS = 1;
        private static final int DEFAULT_GRAVITY = 80;
        private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
        private static final int FLAG_BIG_PICTURE_AMBIENT = 32;
        private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
        private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
        private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
        private static final int FLAG_HINT_HIDE_ICON = 2;
        private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
        private static final int FLAG_START_SCROLL_BOTTOM = 8;
        private static final String KEY_ACTIONS = "actions";
        private static final String KEY_BACKGROUND = "background";
        private static final String KEY_BRIDGE_TAG = "bridgeTag";
        private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
        private static final String KEY_CONTENT_ICON = "contentIcon";
        private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
        private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
        private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
        private static final String KEY_DISMISSAL_ID = "dismissalId";
        private static final String KEY_DISPLAY_INTENT = "displayIntent";
        private static final String KEY_FLAGS = "flags";
        private static final String KEY_GRAVITY = "gravity";
        private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
        private static final String KEY_PAGES = "pages";

        @Deprecated
        public static final int SCREEN_TIMEOUT_LONG = -1;

        @Deprecated
        public static final int SCREEN_TIMEOUT_SHORT = 0;

        @Deprecated
        public static final int SIZE_DEFAULT = 0;

        @Deprecated
        public static final int SIZE_FULL_SCREEN = 5;

        @Deprecated
        public static final int SIZE_LARGE = 4;

        @Deprecated
        public static final int SIZE_MEDIUM = 3;

        @Deprecated
        public static final int SIZE_SMALL = 2;

        @Deprecated
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;
        private ArrayList<Action> mActions;
        private Bitmap mBackground;
        private String mBridgeTag;
        private int mContentActionIndex;
        private int mContentIcon;
        private int mContentIconGravity;
        private int mCustomContentHeight;
        private int mCustomSizePreset;
        private String mDismissalId;
        private PendingIntent mDisplayIntent;
        private int mFlags;
        private int mGravity;
        private int mHintScreenTimeout;
        private ArrayList<Notification> mPages;

        static class Api20Impl {
            private Api20Impl() {
            }

            static Notification.Action.Builder addExtras(Notification.Action.Builder r0, Bundle r1) {
                return r0.addExtras(r1);
            }

            static Notification.Action.Builder addRemoteInput(Notification.Action.Builder r0, android.app.RemoteInput r1) {
                return r0.addRemoteInput(r1);
            }

            static Notification.Action build(Notification.Action.Builder r0) {
                return r0.build();
            }

            static Notification.Action.Builder createBuilder(int r2, CharSequence r3, PendingIntent r4) {
                return new Notification.Action.Builder(r2, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4);
            }

            public static Action getActionCompatFromAction(ArrayList<Parcelable> r1, int r2) {
                return NotificationCompat.getActionCompatFromAction((Notification.Action) ZeusTransformUtils.preCheckCast(r1.get(r2), Notification.Action.class, "com.obric.memorydata.plugin"));
            }
        }

        static class Api23Impl {
            private Api23Impl() {
            }

            static Notification.Action.Builder createBuilder(Icon r2, CharSequence r3, PendingIntent r4) {
                return new Notification.Action.Builder(r2, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4);
            }
        }

        static class Api24Impl {
            private Api24Impl() {
            }

            static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder r0, boolean r1) {
                return r0.setAllowGeneratedReplies(r1);
            }
        }

        static class Api31Impl {
            private Api31Impl() {
            }

            static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder r0, boolean r1) {
                return r0.setAuthenticationRequired(r1);
            }
        }

        public WearableExtender() {
            this.mActions = new ArrayList();
            this.mFlags = 1;
            this.mPages = new ArrayList();
            this.mContentIconGravity = 8388613;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = 80;
        }

        public WearableExtender(Notification r14) {
            this.mActions = new ArrayList();
            this.mFlags = 1;
            this.mPages = new ArrayList();
            this.mContentIconGravity = 8388613;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = 80;
            Bundle r15 = NotificationCompat.getExtras(r14);
            if (r15 == null) goto L5;
            Bundle r16 = r15.getBundle(EXTRA_WEARABLE_EXTENSIONS);
        L6:
            if (r16 == null) goto L29;
            ArrayList r5 = r16.getParcelableArrayList(KEY_ACTIONS);
            if (Build.VERSION.SDK_INT < 16) goto L20;
            if (r5 == null) goto L20;
            int r6 = r5.size();
            Action[] r9 = new Action[r6];
            int r10 = 0;
        L11:
            if (r10 >= r6) goto L19;
            if (Build.VERSION.SDK_INT < 20) goto L16;
            r9[r10] = Api20Impl.getActionCompatFromAction(r5, r10);
        L18:
            r10 = r10 + 1;
            goto L11
        L16:
            if (Build.VERSION.SDK_INT < 16) goto L18;
            r9[r10] = NotificationCompatJellybean.getActionFromBundle((Bundle) ZeusTransformUtils.preCheckCast(r5.get(r10), Bundle.class, "com.obric.memorydata.plugin"));
            goto L18
        L19:
            Collections.addAll(this.mActions, r9);
        L20:
            this.mFlags = r16.getInt(KEY_FLAGS, 1);
            this.mDisplayIntent = (PendingIntent) ZeusTransformUtils.preCheckCast(r16.getParcelable(KEY_DISPLAY_INTENT), PendingIntent.class, "com.obric.memorydata.plugin");
            Notification[] r0 = NotificationCompat.getNotificationArrayFromBundle(r16, KEY_PAGES);
            if (r0 == null) goto L23;
            Collections.addAll(this.mPages, r0);
        L23:
            this.mBackground = (Bitmap) ZeusTransformUtils.preCheckCast(r16.getParcelable("background"), Bitmap.class, "com.obric.memorydata.plugin");
            this.mContentIcon = r16.getInt(KEY_CONTENT_ICON);
            this.mContentIconGravity = r16.getInt(KEY_CONTENT_ICON_GRAVITY, 8388613);
            this.mContentActionIndex = r16.getInt(KEY_CONTENT_ACTION_INDEX, -1);
            this.mCustomSizePreset = r16.getInt(KEY_CUSTOM_SIZE_PRESET, 0);
            this.mCustomContentHeight = r16.getInt(KEY_CUSTOM_CONTENT_HEIGHT);
            this.mGravity = r16.getInt(KEY_GRAVITY, 80);
            this.mHintScreenTimeout = r16.getInt(KEY_HINT_SCREEN_TIMEOUT);
            this.mDismissalId = r16.getString(KEY_DISMISSAL_ID);
            this.mBridgeTag = r16.getString(KEY_BRIDGE_TAG);
            return;
        L29:
            return;
        L5:
            r16 = null;
            goto L6
        }

        private static Notification.Action getActionFromActionCompat(Action r5) {
            int r1 = 0;
            if (Build.VERSION.SDK_INT < 23) goto L9;
            IconCompat r0 = r5.getIconCompat();
            if (r0 != null) goto L7;
            Icon r2 = null;
        L8:
            Notification.Action.Builder r3 = Api23Impl.createBuilder(r2, r5.getTitle(), r5.getActionIntent());
        L17:
            if (r5.getExtras() == null) goto L19;
            Bundle r4 = new Bundle(r5.getExtras());
        L20:
            r4.putBoolean("android.support.allowGeneratedReplies", r5.getAllowGeneratedReplies());
            if (Build.VERSION.SDK_INT < 24) goto L24;
            Api24Impl.setAllowGeneratedReplies(r3, r5.getAllowGeneratedReplies());
        L24:
            if (Build.VERSION.SDK_INT < 31) goto L26;
            Api31Impl.setAuthenticationRequired(r3, r5.isAuthenticationRequired());
        L26:
            Api20Impl.addExtras(r3, r4);
            RemoteInput[] r6 = r5.getRemoteInputs();
            if (r6 == null) goto L32;
            android.app.RemoteInput[] r7 = RemoteInput.fromCompat(r6);
            int r8 = r7.length;
        L29:
            if (r1 >= r8) goto L32;
            Api20Impl.addRemoteInput(r3, r7[r1]);
            r1 = r1 + 1;
        L32:
            return Api20Impl.build(r3);
        L19:
            r4 = new Bundle();
            goto L20
        L7:
            r2 = r0.toIcon();
            goto L8
        L9:
            IconCompat r9 = r5.getIconCompat();
            if (r9 != null) goto L12;
        L14:
            int r10 = 0;
        L15:
            r3 = Api20Impl.createBuilder(r10, r5.getTitle(), r5.getActionIntent());
            goto L17
        L12:
            if (r9.getType() != 2) goto L14;
            r10 = r9.getResId();
            goto L15
        }

        private void setFlag(int r1, boolean r2) {
            if (r2 == false) goto L4;
            int r3 = r1 | this.mFlags;
        L5:
            this.mFlags = r3;
            return;
        L4:
            int r4 = this.mFlags;
            r3 = (~r1) & r4;
            goto L5
        }

        public WearableExtender addAction(Action r2) {
            this.mActions.add(r2);
            return this;
        }

        public WearableExtender addActions(List<Action> r3) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            this.mActions.addAll(r4);
            return this;
        }

        @Deprecated
        public WearableExtender addPage(Notification r2) {
            this.mPages.add(r2);
            return this;
        }

        @Deprecated
        public WearableExtender addPages(List<Notification> r3) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            this.mPages.addAll(r4);
            return this;
        }

        public WearableExtender clearActions() {
            this.mActions.clear();
            return this;
        }

        @Deprecated
        public WearableExtender clearPages() {
            this.mPages.clear();
            return this;
        }

        public WearableExtender clone() {
            WearableExtender r0 = new WearableExtender();
            r0.mActions = new ArrayList(this.mActions);
            r0.mFlags = this.mFlags;
            r0.mDisplayIntent = this.mDisplayIntent;
            r0.mPages = new ArrayList(this.mPages);
            r0.mBackground = this.mBackground;
            r0.mContentIcon = this.mContentIcon;
            r0.mContentIconGravity = this.mContentIconGravity;
            r0.mContentActionIndex = this.mContentActionIndex;
            r0.mCustomSizePreset = this.mCustomSizePreset;
            r0.mCustomContentHeight = this.mCustomContentHeight;
            r0.mGravity = this.mGravity;
            r0.mHintScreenTimeout = this.mHintScreenTimeout;
            r0.mDismissalId = this.mDismissalId;
            r0.mBridgeTag = this.mBridgeTag;
            return r0;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m40clone() {
            return clone();
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        public Builder extend(Builder r10) {
            Bundle r0 = new Bundle();
            if (this.mActions.isEmpty() == false) goto L5;
        L18:
            int r1 = this.mFlags;
            if (r1 == 1) goto L21;
            r0.putInt(KEY_FLAGS, r1);
        L21:
            PendingIntent r2 = this.mDisplayIntent;
            if (r2 == null) goto L25;
            r0.putParcelable(KEY_DISPLAY_INTENT, r2);
        L25:
            if (this.mPages.isEmpty() == true) goto L27;
            ArrayList<Notification> r3 = this.mPages;
            r0.putParcelableArray(KEY_PAGES, (Parcelable[]) ZeusTransformUtils.preCheckCast(r3.toArray(new Notification[r3.size()]), Parcelable[].class, "com.obric.memorydata.plugin"));
        L27:
            Bitmap r4 = this.mBackground;
            if (r4 == null) goto L30;
            r0.putParcelable("background", r4);
        L30:
            int r5 = this.mContentIcon;
            if (r5 == 0) goto L33;
            r0.putInt(KEY_CONTENT_ICON, r5);
        L33:
            int r6 = this.mContentIconGravity;
            if (r6 == 8388613) goto L36;
            r0.putInt(KEY_CONTENT_ICON_GRAVITY, r6);
        L36:
            int r7 = this.mContentActionIndex;
            if (r7 == (-1)) goto L39;
            r0.putInt(KEY_CONTENT_ACTION_INDEX, r7);
        L39:
            int r8 = this.mCustomSizePreset;
            if (r8 == 0) goto L42;
            r0.putInt(KEY_CUSTOM_SIZE_PRESET, r8);
        L42:
            int r9 = this.mCustomContentHeight;
            if (r9 == 0) goto L45;
            r0.putInt(KEY_CUSTOM_CONTENT_HEIGHT, r9);
        L45:
            int r11 = this.mGravity;
            if (r11 == 80) goto L48;
            r0.putInt(KEY_GRAVITY, r11);
        L48:
            int r12 = this.mHintScreenTimeout;
            if (r12 == 0) goto L51;
            r0.putInt(KEY_HINT_SCREEN_TIMEOUT, r12);
        L51:
            String r13 = this.mDismissalId;
            if (r13 == null) goto L54;
            r0.putString(KEY_DISMISSAL_ID, r13);
        L54:
            String r14 = this.mBridgeTag;
            if (r14 == null) goto L57;
            r0.putString(KEY_BRIDGE_TAG, r14);
        L57:
            r10.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, r0);
            return r10;
        L5:
            if (Build.VERSION.SDK_INT < 16) goto L16;
            ArrayList<? extends Parcelable> r15 = new ArrayList(this.mActions.size());
            Iterator<Action> r16 = this.mActions.iterator();
        L8:
            if (r16.hasNext() == false) goto L17;
            Action r17 = (Action) ZeusTransformUtils.preCheckCast(r16.next(), Action.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT >= 20) goto L11;
            if (Build.VERSION.SDK_INT < 16) goto L8;
            Parcelable r18 = NotificationCompatJellybean.getBundleForAction(r17);
        L12:
            r15.add(r18);
            goto L8
        L11:
            r18 = getActionFromActionCompat(r17);
        L17:
            r0.putParcelableArrayList(KEY_ACTIONS, r15);
            goto L18
        L16:
            r15 = null;
            goto L17
        }

        public List<Action> getActions() {
            return this.mActions;
        }

        @Deprecated
        public Bitmap getBackground() {
            return this.mBackground;
        }

        public String getBridgeTag() {
            return this.mBridgeTag;
        }

        public int getContentAction() {
            return this.mContentActionIndex;
        }

        @Deprecated
        public int getContentIcon() {
            return this.mContentIcon;
        }

        @Deprecated
        public int getContentIconGravity() {
            return this.mContentIconGravity;
        }

        public boolean getContentIntentAvailableOffline() {
            if ((this.mFlags & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Deprecated
        public int getCustomContentHeight() {
            return this.mCustomContentHeight;
        }

        @Deprecated
        public int getCustomSizePreset() {
            return this.mCustomSizePreset;
        }

        public String getDismissalId() {
            return this.mDismissalId;
        }

        @Deprecated
        public PendingIntent getDisplayIntent() {
            return this.mDisplayIntent;
        }

        @Deprecated
        public int getGravity() {
            return this.mGravity;
        }

        @Deprecated
        public boolean getHintAmbientBigPicture() {
            if ((this.mFlags & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Deprecated
        public boolean getHintAvoidBackgroundClipping() {
            if ((this.mFlags & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean getHintContentIntentLaunchesActivity() {
            if ((this.mFlags & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Deprecated
        public boolean getHintHideIcon() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Deprecated
        public int getHintScreenTimeout() {
            return this.mHintScreenTimeout;
        }

        @Deprecated
        public boolean getHintShowBackgroundOnly() {
            if ((this.mFlags & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Deprecated
        public List<Notification> getPages() {
            return this.mPages;
        }

        public boolean getStartScrollBottom() {
            if ((this.mFlags & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Deprecated
        public WearableExtender setBackground(Bitmap r1) {
            this.mBackground = r1;
            return this;
        }

        public WearableExtender setBridgeTag(String r1) {
            this.mBridgeTag = r1;
            return this;
        }

        public WearableExtender setContentAction(int r1) {
            this.mContentActionIndex = r1;
            return this;
        }

        @Deprecated
        public WearableExtender setContentIcon(int r1) {
            this.mContentIcon = r1;
            return this;
        }

        @Deprecated
        public WearableExtender setContentIconGravity(int r1) {
            this.mContentIconGravity = r1;
            return this;
        }

        public WearableExtender setContentIntentAvailableOffline(boolean r2) {
            setFlag(1, r2);
            return this;
        }

        @Deprecated
        public WearableExtender setCustomContentHeight(int r1) {
            this.mCustomContentHeight = r1;
            return this;
        }

        @Deprecated
        public WearableExtender setCustomSizePreset(int r1) {
            this.mCustomSizePreset = r1;
            return this;
        }

        public WearableExtender setDismissalId(String r1) {
            this.mDismissalId = r1;
            return this;
        }

        @Deprecated
        public WearableExtender setDisplayIntent(PendingIntent r1) {
            this.mDisplayIntent = r1;
            return this;
        }

        @Deprecated
        public WearableExtender setGravity(int r1) {
            this.mGravity = r1;
            return this;
        }

        @Deprecated
        public WearableExtender setHintAmbientBigPicture(boolean r2) {
            setFlag(32, r2);
            return this;
        }

        @Deprecated
        public WearableExtender setHintAvoidBackgroundClipping(boolean r2) {
            setFlag(16, r2);
            return this;
        }

        public WearableExtender setHintContentIntentLaunchesActivity(boolean r2) {
            setFlag(64, r2);
            return this;
        }

        @Deprecated
        public WearableExtender setHintHideIcon(boolean r2) {
            setFlag(2, r2);
            return this;
        }

        @Deprecated
        public WearableExtender setHintScreenTimeout(int r1) {
            this.mHintScreenTimeout = r1;
            return this;
        }

        @Deprecated
        public WearableExtender setHintShowBackgroundOnly(boolean r2) {
            setFlag(4, r2);
            return this;
        }

        public WearableExtender setStartScrollBottom(boolean r2) {
            setFlag(8, r2);
            return this;
        }
    }

    @Deprecated
    public NotificationCompat() {
    }

    public static Action getAction(Notification r3, int r4) {
        if (Build.VERSION.SDK_INT >= 20) goto L5;
        Bundle r2 = null;
        if (Build.VERSION.SDK_INT < 19) goto L14;
        Notification.Action r0 = r3.actions[r4];
        SparseArray r5 = r3.extras.getSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
        if (r5 == null) goto L12;
        r2 = (Bundle) ZeusTransformUtils.preCheckCast(r5.get(r4), Bundle.class, "com.obric.memorydata.plugin");
    L12:
        return NotificationCompatJellybean.readAction(r0.icon, r0.title, r0.actionIntent, r2);
    L14:
        if (Build.VERSION.SDK_INT >= 16) goto L16;
        return null;
    L16:
        return NotificationCompatJellybean.getAction(r3, r4);
    L5:
        return getActionCompatFromAction(r3.actions[r4]);
    }

    static Action getActionCompatFromAction(Notification.Action r19) {
        android.app.RemoteInput[] r1 = Api20Impl.getRemoteInputs(r19);
        IconCompat r3 = null;
        boolean r4 = false;
        if (r1 != null) goto L5;
        RemoteInput[] r12 = null;
    L15:
        if (Build.VERSION.SDK_INT >= 24) goto L17;
        boolean r2 = Api20Impl.getExtras(r19).getBoolean("android.support.allowGeneratedReplies");
    L24:
        boolean r14 = r2;
        boolean r16 = Api20Impl.getExtras(r19).getBoolean("android.support.action.showsUserInterface", true);
        if (Build.VERSION.SDK_INT < 28) goto L27;
        int r5 = Api28Impl.getSemanticAction(r19);
    L28:
        int r15 = r5;
        if (Build.VERSION.SDK_INT < 29) goto L31;
        boolean r17 = Api29Impl.isContextual(r19);
    L33:
        if (Build.VERSION.SDK_INT < 31) goto L35;
        r4 = Api31Impl.isAuthenticationRequired(r19);
    L35:
        boolean r18 = r4;
        if (Build.VERSION.SDK_INT < 23) goto L50;
        if (Api23Impl.getIcon(r19) != null) goto L44;
        if (r19.icon == 0) goto L44;
        return new Action(r19.icon, r19.title, r19.actionIntent, Api20Impl.getExtras(r19), r12, null, r14, r15, r16, r17, r18);
    L44:
        if (Api23Impl.getIcon(r19) == null) goto L48;
        r3 = IconCompat.createFromIconOrNullIfZeroResId(Api23Impl.getIcon(r19));
    L48:
        return new Action(r3, r19.title, r19.actionIntent, Api20Impl.getExtras(r19), r12, null, r14, r15, r16, r17, r18);
    L50:
        return new Action(r19.icon, r19.title, r19.actionIntent, Api20Impl.getExtras(r19), r12, null, r14, r15, r16, r17, r18);
    L31:
        r17 = false;
        goto L33
    L27:
        r5 = Api20Impl.getExtras(r19).getInt("android.support.action.semanticAction", 0);
        goto L28
    L17:
        if (Api20Impl.getExtras(r19).getBoolean("android.support.allowGeneratedReplies") == false) goto L19;
    L22:
        r2 = true;
        goto L24
    L19:
        if (Api24Impl.getAllowGeneratedReplies(r19) == true) goto L22;
        r2 = false;
        goto L24
    L5:
        RemoteInput[] r6 = new RemoteInput[r1.length];
        int r7 = 0;
    L7:
        if (r7 >= r1.length) goto L13;
        android.app.RemoteInput r8 = r1[r7];
        String r9 = Api20Impl.getResultKey(r8);
        CharSequence r10 = Api20Impl.getLabel(r8);
        CharSequence[] r11 = Api20Impl.getChoices(r8);
        boolean r13 = Api20Impl.getAllowFreeFormInput(r8);
        if (Build.VERSION.SDK_INT < 29) goto L11;
        int r110 = Api29Impl.getEditChoicesBeforeSending(r8);
    L12:
        r6[r7] = new RemoteInput(r9, r10, r11, r13, r110, Api20Impl.getExtras(r8), null);
        r7 = r7 + 1;
        goto L7
    L11:
        r110 = 0;
        goto L12
    L13:
        r12 = r6;
        goto L15
    }

    public static int getActionCount(Notification r3) {
        if (Build.VERSION.SDK_INT < 19) goto L9;
        if (r3.actions != null) goto L7;
        return 0;
    L7:
        return r3.actions.length;
    L9:
        if (Build.VERSION.SDK_INT >= 16) goto L11;
        return 0;
    L11:
        return NotificationCompatJellybean.getActionCount(r3);
    }

    public static boolean getAllowSystemGeneratedContextualActions(Notification r2) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return false;
    L5:
        return Api29Impl.getAllowSystemGeneratedContextualActions(r2);
    }

    public static boolean getAutoCancel(Notification r0) {
        if ((r0.flags & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static int getBadgeIconType(Notification r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return 0;
    L5:
        return Api26Impl.getBadgeIconType(r2);
    }

    public static BubbleMetadata getBubbleMetadata(Notification r2) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return null;
    L5:
        return BubbleMetadata.fromPlatform(Api29Impl.getBubbleMetadata(r2));
    }

    public static String getCategory(Notification r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return r2.category;
    }

    public static String getChannelId(Notification r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return Api26Impl.getChannelId(r2);
    }

    public static int getColor(Notification r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return 0;
    L5:
        return r2.color;
    }

    public static CharSequence getContentInfo(Notification r1) {
        return r1.extras.getCharSequence(EXTRA_INFO_TEXT);
    }

    public static CharSequence getContentText(Notification r1) {
        return r1.extras.getCharSequence(EXTRA_TEXT);
    }

    public static CharSequence getContentTitle(Notification r1) {
        return r1.extras.getCharSequence(EXTRA_TITLE);
    }

    public static Bundle getExtras(Notification r2) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return r2.extras;
    L7:
        if (Build.VERSION.SDK_INT >= 16) goto L9;
        return null;
    L9:
        return NotificationCompatJellybean.getExtras(r2);
    }

    public static String getGroup(Notification r3) {
        if (Build.VERSION.SDK_INT < 20) goto L7;
        return Api20Impl.getGroup(r3);
    L7:
        if (Build.VERSION.SDK_INT < 19) goto L12;
        Bundle r4 = r3.extras;
    L10:
        return r4.getString(NotificationCompatExtras.EXTRA_GROUP_KEY);
    L12:
        if (Build.VERSION.SDK_INT < 16) goto L14;
        r4 = NotificationCompatJellybean.getExtras(r3);
        goto L10
    L14:
        return null;
    }

    public static int getGroupAlertBehavior(Notification r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return 0;
    L5:
        return Api26Impl.getGroupAlertBehavior(r2);
    }

    static boolean getHighPriority(Notification r0) {
        if ((r0.flags & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static List<Action> getInvisibleActions(Notification r3) {
        ArrayList r0 = new ArrayList();
        if (Build.VERSION.SDK_INT < 19) goto L13;
        Bundle r4 = r3.extras.getBundle("android.car.EXTENSIONS");
        if (r4 != null) goto L7;
        return r0;
    L7:
        Bundle r5 = r4.getBundle("invisible_actions");
        if (r5 == null) goto L13;
        int r1 = 0;
    L11:
        if (r1 >= r5.size()) goto L13;
        r0.add(NotificationCompatJellybean.getActionFromBundle(r5.getBundle(Integer.toString(r1))));
        r1 = r1 + 1;
    L13:
        return r0;
    }

    public static boolean getLocalOnly(Notification r4) {
        if (Build.VERSION.SDK_INT < 20) goto L9;
        if ((r4.flags & 256) == 0) goto L17;
        return true;
    L17:
        return false;
    L9:
        if (Build.VERSION.SDK_INT < 19) goto L14;
        Bundle r5 = r4.extras;
    L12:
        return r5.getBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
    L14:
        if (Build.VERSION.SDK_INT < 16) goto L16;
        r5 = NotificationCompatJellybean.getExtras(r4);
        goto L12
    L16:
        return false;
    }

    public static LocusIdCompat getLocusId(Notification r3) {
        if (Build.VERSION.SDK_INT < 29) goto L9;
        LocusId r4 = Api29Impl.getLocusId(r3);
        if (r4 != null) goto L8;
        return null;
    L8:
        return LocusIdCompat.toLocusIdCompat(r4);
    L9:
        return null;
    }

    static Notification[] getNotificationArrayFromBundle(Bundle r6, String r7) {
        Parcelable[] r0 = r6.getParcelableArray(r7);
        if ((r0 instanceof Notification[]) == true) goto L13;
        if (r0 == null) goto L13;
        Notification[] r1 = new Notification[r0.length];
        int r3 = 0;
    L8:
        if (r3 >= r0.length) goto L10;
        r1[r3] = (Notification) ZeusTransformUtils.preCheckCast(r0[r3], Notification.class, "com.obric.memorydata.plugin");
        r3 = r3 + 1;
        goto L8
    L10:
        r6.putParcelableArray(r7, r1);
        return r1;
    L13:
        return (Notification[]) ZeusTransformUtils.preCheckCast(r0, Notification[].class, "com.obric.memorydata.plugin");
    }

    public static boolean getOngoing(Notification r0) {
        if ((r0.flags & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean getOnlyAlertOnce(Notification r0) {
        if ((r0.flags & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static List<Person> getPeople(Notification r5) {
        ArrayList r0 = new ArrayList();
        if (Build.VERSION.SDK_INT < 28) goto L13;
        ArrayList r6 = r5.extras.getParcelableArrayList(EXTRA_PEOPLE_LIST);
        if (r6 != null) goto L7;
    L21:
        return r0;
    L7:
        if (r6.isEmpty() == true) goto L21;
        Iterator r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L21;
        r0.add(Person.fromAndroidPerson((android.app.Person) ZeusTransformUtils.preCheckCast(r7.next(), android.app.Person.class, "com.obric.memorydata.plugin")));
        goto L10
    L13:
        if (Build.VERSION.SDK_INT < 19) goto L21;
        String[] r8 = r5.extras.getStringArray(EXTRA_PEOPLE);
        if (r8 == null) goto L21;
        if (r8.length == 0) goto L21;
        int r1 = r8.length;
        int r2 = 0;
    L19:
        if (r2 >= r1) goto L21;
        String r3 = r8[r2];
        r0.add(new Person.Builder().setUri(r3).build());
        r2 = r2 + 1;
        goto L19
    }

    public static Notification getPublicVersion(Notification r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return r2.publicVersion;
    }

    public static CharSequence getSettingsText(Notification r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return Api26Impl.getSettingsText(r2);
    }

    public static String getShortcutId(Notification r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return Api26Impl.getShortcutId(r2);
    }

    public static boolean getShowWhen(Notification r1) {
        return r1.extras.getBoolean(EXTRA_SHOW_WHEN);
    }

    public static String getSortKey(Notification r3) {
        if (Build.VERSION.SDK_INT < 20) goto L7;
        return Api20Impl.getSortKey(r3);
    L7:
        if (Build.VERSION.SDK_INT < 19) goto L12;
        Bundle r4 = r3.extras;
    L10:
        return r4.getString(NotificationCompatExtras.EXTRA_SORT_KEY);
    L12:
        if (Build.VERSION.SDK_INT < 16) goto L14;
        r4 = NotificationCompatJellybean.getExtras(r3);
        goto L10
    L14:
        return null;
    }

    public static CharSequence getSubText(Notification r1) {
        return r1.extras.getCharSequence(EXTRA_SUB_TEXT);
    }

    public static long getTimeoutAfter(Notification r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return 0;
    L5:
        return Api26Impl.getTimeoutAfter(r2);
    }

    public static boolean getUsesChronometer(Notification r1) {
        return r1.extras.getBoolean(EXTRA_SHOW_CHRONOMETER);
    }

    public static int getVisibility(Notification r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return 0;
    L5:
        return r2.visibility;
    }

    public static boolean isGroupSummary(Notification r4) {
        if (Build.VERSION.SDK_INT < 20) goto L9;
        if ((r4.flags & 512) == 0) goto L17;
        return true;
    L17:
        return false;
    L9:
        if (Build.VERSION.SDK_INT < 19) goto L14;
        Bundle r5 = r4.extras;
    L12:
        return r5.getBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
    L14:
        if (Build.VERSION.SDK_INT < 16) goto L16;
        r5 = NotificationCompatJellybean.getExtras(r4);
        goto L12
    L16:
        return false;
    }

    public static Bitmap reduceLargeIconSize(Context r8, Bitmap r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L5;
    L14:
        return r9;
    L5:
        if (Build.VERSION.SDK_INT >= 27) goto L14;
        Resources r11 = ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin");
        int r0 = r11.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.compat_notification_large_icon_max_width, "dimen", "compat_notification_large_icon_max_width"));
        int r12 = r11.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.compat_notification_large_icon_max_height, "dimen", "compat_notification_large_icon_max_height"));
        if (r9.getWidth() <= r0) goto L10;
    L12:
        double r1 = Math.min(((double) r0) / ((double) Math.max(1, r9.getWidth())), ((double) r12) / ((double) Math.max(1, r9.getHeight())));
        return Bitmap.createScaledBitmap(r9, (int) Math.ceil(((double) r9.getWidth()) * r1), (int) Math.ceil(((double) r9.getHeight()) * r1), true);
    L10:
        if (r9.getHeight() > r12) goto L12;
        return r9;
    }
}
