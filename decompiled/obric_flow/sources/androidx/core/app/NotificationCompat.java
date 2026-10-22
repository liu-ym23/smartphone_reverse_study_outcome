package androidx.core.app;

import ai.j0;
import android.annotation.SuppressLint;
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
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
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

    @ColorInt
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_ANSWER_COLOR = "android.answerColor";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_ANSWER_INTENT = "android.answerIntent";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_BIG_TEXT = "android.bigText";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CALL_IS_VIDEO = "android.callIsVideo";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CALL_PERSON = "android.callPerson";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CALL_PERSON_COMPAT = "android.callPersonCompat";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CALL_TYPE = "android.callType";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CHANNEL_GROUP_ID = "android.intent.extra.CHANNEL_GROUP_ID";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CHANNEL_ID = "android.intent.extra.CHANNEL_ID";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_COLORIZED = "android.colorized";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_COMPAT_TEMPLATE = "androidx.core.app.extra.COMPAT_TEMPLATE";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_DECLINE_COLOR = "android.declineColor";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_DECLINE_INTENT = "android.declineIntent";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_HANG_UP_INTENT = "android.hangUpIntent";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_HISTORIC_MESSAGES = "android.messages.historic";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_INFO_TEXT = "android.infoText";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_MESSAGES = "android.messages";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_NOTIFICATION_ID = "android.intent.extra.NOTIFICATION_ID";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_NOTIFICATION_TAG = "android.intent.extra.NOTIFICATION_TAG";

    @SuppressLint({"ActionValue"})
    @Deprecated
    public static final String EXTRA_PEOPLE = "android.people";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PEOPLE_LIST = "android.people.list";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PICTURE = "android.picture";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PICTURE_CONTENT_DESCRIPTION = "android.pictureContentDescription";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PICTURE_ICON = "android.pictureIcon";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PROGRESS = "android.progress";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED = "android.showBigPictureWhenCollapsed";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SMALL_ICON = "android.icon";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SUB_TEXT = "android.subText";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TEMPLATE = "android.template";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TEXT = "android.text";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TEXT_LINES = "android.textLines";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TITLE = "android.title";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TITLE_BIG = "android.title.big";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_VERIFICATION_ICON = "android.verificationIcon";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_VERIFICATION_ICON_COMPAT = "android.verificationIconCompat";

    @SuppressLint({"ActionValue"})
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

    @SuppressLint({"ActionValue"})
    public static final String INTENT_CATEGORY_NOTIFICATION_PREFERENCES = "android.intent.category.NOTIFICATION_PREFERENCES";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
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
    public static /* synthetic */ class AnonymousClass1 {
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

        @Nullable
        public PendingIntent actionIntent;

        @Deprecated
        public int icon;
        private boolean mAllowGeneratedReplies;
        private boolean mAuthenticationRequired;
        private final RemoteInput[] mDataOnlyRemoteInputs;
        final Bundle mExtras;

        @Nullable
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

            @RequiresApi(20)
            public static class Api20Impl {
                private Api20Impl() {
                }

                @DoNotInline
                public static Bundle getExtras(Notification.Action r5) {
                    return r5.getExtras();
                }

                @DoNotInline
                public static android.app.RemoteInput[] getRemoteInputs(Notification.Action r5) {
                    return r5.getRemoteInputs();
                }
            }

            @RequiresApi(23)
            public static class Api23Impl {
                private Api23Impl() {
                }

                @DoNotInline
                public static Icon getIcon(Notification.Action r5) {
                    return r5.getIcon();
                }
            }

            @RequiresApi(24)
            public static class Api24Impl {
                private Api24Impl() {
                }

                @DoNotInline
                public static boolean getAllowGeneratedReplies(Notification.Action r5) {
                    return r5.getAllowGeneratedReplies();
                }
            }

            @RequiresApi(28)
            public static class Api28Impl {
                private Api28Impl() {
                }

                @DoNotInline
                public static int getSemanticAction(Notification.Action r5) {
                    return r5.getSemanticAction();
                }
            }

            @RequiresApi(29)
            public static class Api29Impl {
                private Api29Impl() {
                }

                @DoNotInline
                public static boolean isContextual(Notification.Action r5) {
                    return r5.isContextual();
                }
            }

            @RequiresApi(31)
            public static class Api31Impl {
                private Api31Impl() {
                }

                @DoNotInline
                public static boolean isAuthenticationRequired(Notification.Action r5) {
                    return r5.isAuthenticationRequired();
                }
            }

            public Builder(@Nullable IconCompat r12, @Nullable CharSequence r13, @Nullable PendingIntent r14) {
                this(r12, r13, r14, new Bundle(), null, true, 0, true, false, false);
            }

            private void checkContextualActionNullFields() {
                if (this.mIsContextual == true) goto L6;
                return;
            L6:
                if (this.mIntent == null) goto L9;
                return;
            L9:
                throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
            }

            @NonNull
            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
            public static Builder fromAndroidAction(@NonNull Notification.Action r5) {
                if (Api23Impl.getIcon(r5) == null) goto L5;
                Builder r10 = new Builder(IconCompat.createFromIconOrNullIfZeroResId(Api23Impl.getIcon(r5)), r5.title, r5.actionIntent);
            L6:
                android.app.RemoteInput[] r11 = Api20Impl.getRemoteInputs(r5);
                if (r11 != null) goto L9;
            L13:
                r10.mAllowGeneratedReplies = Api24Impl.getAllowGeneratedReplies(r5);
                r10.setSemanticAction(Api28Impl.getSemanticAction(r5));
                r10.setContextual(Api29Impl.isContextual(r5));
                r10.setAuthenticationRequired(Api31Impl.isAuthenticationRequired(r5));
                r10.addExtras(Api20Impl.getExtras(r5));
                return r10;
            L9:
                if (r11.length == 0) goto L13;
                int r12 = r11.length;
                int r13 = 0;
            L11:
                if (r13 >= r12) goto L13;
                r10.addRemoteInput(RemoteInput.fromPlatform(r11[r13]));
                r13 = r13 + 1;
                goto L11
            L5:
                r10 = new Builder(r5.icon, r5.title, r5.actionIntent);
                goto L6
            }

            @NonNull
            public Builder addExtras(@Nullable Bundle r5) {
                if (r5 == null) goto L4;
                this.mExtras.putAll(r5);
            L4:
                return this;
            }

            @NonNull
            public Builder addRemoteInput(@Nullable RemoteInput r5) {
                if (this.mRemoteInputs != null) goto L5;
                this.mRemoteInputs = new ArrayList();
            L5:
                if (r5 == null) goto L7;
                this.mRemoteInputs.add(r5);
            L7:
                return this;
            }

            @NonNull
            public Action build() {
                checkContextualActionNullFields();
                ArrayList r5 = new ArrayList();
                ArrayList r10 = new ArrayList();
                ArrayList<RemoteInput> r11 = this.mRemoteInputs;
                if (r11 == null) goto L11;
                Iterator<RemoteInput> r12 = r11.iterator();
            L6:
                if (r12.hasNext() == false) goto L11;
                RemoteInput r13 = r12.next();
                if (r13.isDataOnly() == true) goto L9;
                r10.add(r13);
                goto L6
            L9:
                r5.add(r13);
            L11:
                RemoteInput[] r14 = null;
                if (r5.isEmpty() == false) goto L14;
                RemoteInput[] r15 = null;
            L16:
                if (r10.isEmpty() == true) goto L20;
                r14 = (RemoteInput[]) r10.toArray(new RemoteInput[r10.size()]);
            L20:
                return new Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, r14, r15, this.mAllowGeneratedReplies, this.mSemanticAction, this.mShowsUserInterface, this.mIsContextual, this.mAuthenticationRequired);
            L14:
                r15 = (RemoteInput[]) r5.toArray(new RemoteInput[r5.size()]);
                goto L16
            }

            @NonNull
            public Builder extend(@NonNull Extender r5) {
                r5.extend(this);
                return this;
            }

            @NonNull
            public Bundle getExtras() {
                return this.mExtras;
            }

            @NonNull
            public Builder setAllowGeneratedReplies(boolean r5) {
                this.mAllowGeneratedReplies = r5;
                return this;
            }

            @NonNull
            public Builder setAuthenticationRequired(boolean r5) {
                this.mAuthenticationRequired = r5;
                return this;
            }

            @NonNull
            public Builder setContextual(boolean r5) {
                this.mIsContextual = r5;
                return this;
            }

            @NonNull
            public Builder setSemanticAction(int r5) {
                this.mSemanticAction = r5;
                return this;
            }

            @NonNull
            public Builder setShowsUserInterface(boolean r5) {
                this.mShowsUserInterface = r5;
                return this;
            }

            public Builder(int r13, @Nullable CharSequence r14, @Nullable PendingIntent r15) {
                IconCompat r5 = null;
                if (r13 != 0) goto L5;
            L4:
                IconCompat r10 = r5;
                this(r10, r14, r15, new Bundle(), null, true, 0, true, false, false);
                return;
            L5:
                r5 = IconCompat.createWithResource(null, "", r13);
                goto L4
            }

            public Builder(@NonNull Action r12) {
                this(r12.getIconCompat(), r12.title, r12.actionIntent, new Bundle(r12.mExtras), r12.getRemoteInputs(), r12.getAllowGeneratedReplies(), r12.getSemanticAction(), r12.mShowsUserInterface, r12.isContextual(), r12.isAuthenticationRequired());
            }

            private Builder(@Nullable IconCompat r5, @Nullable CharSequence r10, @Nullable PendingIntent r11, @NonNull Bundle r12, @Nullable RemoteInput[] r13, boolean r14, int r15, boolean r16, boolean r17, boolean r18) {
                this.mAllowGeneratedReplies = true;
                this.mShowsUserInterface = true;
                this.mIcon = r5;
                this.mTitle = Builder.limitCharSequenceLength(r10);
                this.mIntent = r11;
                this.mExtras = r12;
                if (r13 != null) goto L5;
                ArrayList<RemoteInput> r19 = null;
            L6:
                this.mRemoteInputs = r19;
                this.mAllowGeneratedReplies = r14;
                this.mSemanticAction = r15;
                this.mShowsUserInterface = r16;
                this.mIsContextual = r17;
                this.mAuthenticationRequired = r18;
                return;
            L5:
                r19 = new ArrayList(Arrays.asList(r13));
                goto L6
            }
        }

        public interface Extender {
            @NonNull
            Builder extend(@NonNull Builder r5);
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

            private void setFlag(int r5, boolean r10) {
                if (r10 == false) goto L4;
                this.mFlags = r5 | this.mFlags;
                return;
            L4:
                int r11 = this.mFlags;
                this.mFlags = (~r5) & r11;
            }

            @NonNull
            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m47clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // androidx.core.app.NotificationCompat.Action.Extender
            @NonNull
            public Builder extend(@NonNull Builder r5) {
                Bundle r10 = new Bundle();
                int r11 = this.mFlags;
                if (r11 == 1) goto L5;
                r10.putInt("flags", r11);
            L5:
                CharSequence r12 = this.mInProgressLabel;
                if (r12 == null) goto L8;
                r10.putCharSequence(KEY_IN_PROGRESS_LABEL, r12);
            L8:
                CharSequence r13 = this.mConfirmLabel;
                if (r13 == null) goto L11;
                r10.putCharSequence(KEY_CONFIRM_LABEL, r13);
            L11:
                CharSequence r14 = this.mCancelLabel;
                if (r14 == null) goto L14;
                r10.putCharSequence(KEY_CANCEL_LABEL, r14);
            L14:
                r5.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, r10);
                return r5;
            }

            @Nullable
            @Deprecated
            public CharSequence getCancelLabel() {
                return this.mCancelLabel;
            }

            @Nullable
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

            @Nullable
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

            @NonNull
            public WearableExtender setAvailableOffline(boolean r5) {
                setFlag(1, r5);
                return this;
            }

            @NonNull
            @Deprecated
            public WearableExtender setCancelLabel(@Nullable CharSequence r5) {
                this.mCancelLabel = r5;
                return this;
            }

            @NonNull
            @Deprecated
            public WearableExtender setConfirmLabel(@Nullable CharSequence r5) {
                this.mConfirmLabel = r5;
                return this;
            }

            @NonNull
            public WearableExtender setHintDisplayActionInline(boolean r5) {
                setFlag(4, r5);
                return this;
            }

            @NonNull
            public WearableExtender setHintLaunchesActivity(boolean r5) {
                setFlag(2, r5);
                return this;
            }

            @NonNull
            @Deprecated
            public WearableExtender setInProgressLabel(@Nullable CharSequence r5) {
                this.mInProgressLabel = r5;
                return this;
            }

            @NonNull
            public WearableExtender clone() {
                WearableExtender r5 = new WearableExtender();
                r5.mFlags = this.mFlags;
                r5.mInProgressLabel = this.mInProgressLabel;
                r5.mConfirmLabel = this.mConfirmLabel;
                r5.mCancelLabel = this.mCancelLabel;
                return r5;
            }

            public WearableExtender(@NonNull Action r5) {
                this.mFlags = 1;
                Bundle r10 = r5.getExtras().getBundle(EXTRA_WEARABLE_EXTENSIONS);
                if (r10 == null) goto L6;
                this.mFlags = r10.getInt("flags", 1);
                this.mInProgressLabel = r10.getCharSequence(KEY_IN_PROGRESS_LABEL);
                this.mConfirmLabel = r10.getCharSequence(KEY_CONFIRM_LABEL);
                this.mCancelLabel = r10.getCharSequence(KEY_CANCEL_LABEL);
                return;
            }
        }

        public Action(int r5, @Nullable CharSequence r10, @Nullable PendingIntent r11) {
            IconCompat r12 = null;
            if (r5 == 0) goto L6;
            r12 = IconCompat.createWithResource(null, "", r5);
        L6:
            this(r12, r10, r11);
        }

        @Nullable
        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public boolean getAllowGeneratedReplies() {
            return this.mAllowGeneratedReplies;
        }

        @Nullable
        public RemoteInput[] getDataOnlyRemoteInputs() {
            return this.mDataOnlyRemoteInputs;
        }

        @NonNull
        public Bundle getExtras() {
            return this.mExtras;
        }

        @Deprecated
        public int getIcon() {
            return this.icon;
        }

        @Nullable
        public IconCompat getIconCompat() {
            if (this.mIcon != null) goto L8;
            int r5 = this.icon;
            if (r5 == 0) goto L8;
            this.mIcon = IconCompat.createWithResource(null, "", r5);
        L8:
            return this.mIcon;
        }

        @Nullable
        public RemoteInput[] getRemoteInputs() {
            return this.mRemoteInputs;
        }

        public int getSemanticAction() {
            return this.mSemanticAction;
        }

        public boolean getShowsUserInterface() {
            return this.mShowsUserInterface;
        }

        @Nullable
        public CharSequence getTitle() {
            return this.title;
        }

        public boolean isAuthenticationRequired() {
            return this.mAuthenticationRequired;
        }

        public boolean isContextual() {
            return this.mIsContextual;
        }

        public Action(@Nullable IconCompat r13, @Nullable CharSequence r14, @Nullable PendingIntent r15) {
            this(r13, r14, r15, new Bundle(), null, null, true, 0, true, false, false);
        }

        public Action(int r15, @Nullable CharSequence r16, @Nullable PendingIntent r17, @Nullable Bundle r18, @Nullable RemoteInput[] r19, @Nullable RemoteInput[] r20, boolean r21, int r22, boolean r23, boolean r24, boolean r25) {
            IconCompat r5 = null;
            if (r15 == 0) goto L6;
            r5 = IconCompat.createWithResource(null, "", r15);
        L6:
            this(r5, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
        }

        public Action(@Nullable IconCompat r5, @Nullable CharSequence r10, @Nullable PendingIntent r11, @Nullable Bundle r12, @Nullable RemoteInput[] r13, @Nullable RemoteInput[] r14, boolean r15, int r16, boolean r17, boolean r18, boolean r19) {
            this.mShowsUserInterface = true;
            this.mIcon = r5;
            if (r5 != null) goto L5;
        L7:
            this.title = Builder.limitCharSequenceLength(r10);
            this.actionIntent = r11;
            if (r12 != null) goto L11;
            r12 = new Bundle();
        L11:
            this.mExtras = r12;
            this.mRemoteInputs = r13;
            this.mDataOnlyRemoteInputs = r14;
            this.mAllowGeneratedReplies = r15;
            this.mSemanticAction = r16;
            this.mShowsUserInterface = r17;
            this.mIsContextual = r18;
            this.mAuthenticationRequired = r19;
            return;
        L5:
            if (r5.getType() != 2) goto L7;
            this.icon = r5.getResId();
            goto L7
        }
    }

    @RequiresApi(20)
    public static class Api20Impl {
        private Api20Impl() {
        }

        @DoNotInline
        public static boolean getAllowFreeFormInput(android.app.RemoteInput r5) {
            return r5.getAllowFreeFormInput();
        }

        @DoNotInline
        public static CharSequence[] getChoices(android.app.RemoteInput r5) {
            return r5.getChoices();
        }

        @DoNotInline
        public static Bundle getExtras(Notification.Action r5) {
            return r5.getExtras();
        }

        @DoNotInline
        public static String getGroup(Notification r5) {
            return r5.getGroup();
        }

        @DoNotInline
        public static CharSequence getLabel(android.app.RemoteInput r5) {
            return r5.getLabel();
        }

        @DoNotInline
        public static android.app.RemoteInput[] getRemoteInputs(Notification.Action r5) {
            return r5.getRemoteInputs();
        }

        @DoNotInline
        public static String getResultKey(android.app.RemoteInput r5) {
            return r5.getResultKey();
        }

        @DoNotInline
        public static String getSortKey(Notification r5) {
            return r5.getSortKey();
        }

        @DoNotInline
        public static Bundle getExtras(android.app.RemoteInput r5) {
            return r5.getExtras();
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static Icon getIcon(Notification.Action r5) {
            return r5.getIcon();
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static boolean getAllowGeneratedReplies(Notification.Action r5) {
            return r5.getAllowGeneratedReplies();
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static int getBadgeIconType(Notification r5) {
            return r5.getBadgeIconType();
        }

        @DoNotInline
        public static String getChannelId(Notification r5) {
            return r5.getChannelId();
        }

        @DoNotInline
        public static int getGroupAlertBehavior(Notification r5) {
            return r5.getGroupAlertBehavior();
        }

        @DoNotInline
        public static CharSequence getSettingsText(Notification r5) {
            return r5.getSettingsText();
        }

        @DoNotInline
        public static String getShortcutId(Notification r5) {
            return r5.getShortcutId();
        }

        @DoNotInline
        public static long getTimeoutAfter(Notification r5) {
            return r5.getTimeoutAfter();
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static int getSemanticAction(Notification.Action r5) {
            return r5.getSemanticAction();
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static boolean getAllowSystemGeneratedContextualActions(Notification r5) {
            return r5.getAllowSystemGeneratedContextualActions();
        }

        @DoNotInline
        public static Notification.BubbleMetadata getBubbleMetadata(Notification r5) {
            return r5.getBubbleMetadata();
        }

        @DoNotInline
        public static int getEditChoicesBeforeSending(android.app.RemoteInput r5) {
            return r5.getEditChoicesBeforeSending();
        }

        @DoNotInline
        public static LocusId getLocusId(Notification r5) {
            return r5.getLocusId();
        }

        @DoNotInline
        public static boolean isContextual(Notification.Action r5) {
            return r5.isContextual();
        }
    }

    @RequiresApi(31)
    public static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static boolean isAuthenticationRequired(Notification.Action r5) {
            return r5.isAuthenticationRequired();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface BadgeIconType {
    }

    public static class BigPictureStyle extends Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigPictureStyle";
        private IconCompat mBigLargeIcon;
        private boolean mBigLargeIconSet;
        private CharSequence mPictureContentDescription;
        private IconCompat mPictureIcon;
        private boolean mShowBigPictureWhenCollapsed;

        @RequiresApi(23)
        public static class Api23Impl {
            private Api23Impl() {
            }

            @RequiresApi(23)
            public static void setBigLargeIcon(Notification.BigPictureStyle r5, Icon r10) {
                r5.bigLargeIcon(r10);
            }
        }

        @RequiresApi(31)
        public static class Api31Impl {
            private Api31Impl() {
            }

            @RequiresApi(31)
            public static void setBigPicture(Notification.BigPictureStyle r5, Icon r10) {
                r5.bigPicture(r10);
            }

            @RequiresApi(31)
            public static void setContentDescription(Notification.BigPictureStyle r5, CharSequence r10) {
                r5.setContentDescription(r10);
            }

            @RequiresApi(31)
            public static void showBigPictureWhenCollapsed(Notification.BigPictureStyle r5, boolean r10) {
                r5.showBigPictureWhenCollapsed(r10);
            }
        }

        public BigPictureStyle() {
        }

        @Nullable
        private static IconCompat asIconCompat(@Nullable Parcelable r5) {
            if (r5 != null) goto L4;
            return null;
        L4:
            if ((r5 instanceof Icon) == false) goto L8;
            return IconCompat.createFromIcon((Icon) r5);
        L8:
            if ((r5 instanceof Bitmap) == true) goto L10;
            return null;
        L10:
            return IconCompat.createWithBitmap((Bitmap) r5);
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static IconCompat getPictureIcon(@Nullable Bundle r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            Parcelable r10 = r5.getParcelable(NotificationCompat.EXTRA_PICTURE);
            if (r10 == null) goto L10;
            return asIconCompat(r10);
        L10:
            return asIconCompat(r5.getParcelable(NotificationCompat.EXTRA_PICTURE_ICON));
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r5) {
            Notification.BigPictureStyle r10 = new Notification.BigPictureStyle(r5.getBuilder()).setBigContentTitle(this.mBigContentTitle);
            Context r11 = null;
            if (this.mPictureIcon == null) goto L10;
            if ((r5 instanceof NotificationCompatBuilder) == false) goto L7;
            Context r12 = ((NotificationCompatBuilder) r5).getContext();
        L8:
            Api31Impl.setBigPicture(r10, this.mPictureIcon.toIcon(r12));
            goto L10
        L7:
            r12 = null;
        L10:
            if (this.mBigLargeIconSet == false) goto L19;
            if (this.mBigLargeIcon != null) goto L15;
            r10.bigLargeIcon(null);
            goto L19
        L15:
            if ((r5 instanceof NotificationCompatBuilder) == false) goto L17;
            r11 = ((NotificationCompatBuilder) r5).getContext();
        L17:
            Api23Impl.setBigLargeIcon(r10, this.mBigLargeIcon.toIcon(r11));
        L19:
            if (this.mSummaryTextSet == false) goto L21;
            r10.setSummaryText(this.mSummaryText);
        L21:
            Api31Impl.showBigPictureWhenCollapsed(r10, this.mShowBigPictureWhenCollapsed);
            Api31Impl.setContentDescription(r10, this.mPictureContentDescription);
        }

        @NonNull
        public BigPictureStyle bigLargeIcon(@Nullable Bitmap r5) {
            if (r5 != null) goto L4;
            IconCompat r10 = null;
        L5:
            this.mBigLargeIcon = r10;
            this.mBigLargeIconSet = true;
            return this;
        L4:
            r10 = IconCompat.createWithBitmap(r5);
            goto L5
        }

        @NonNull
        public BigPictureStyle bigPicture(@Nullable Bitmap r5) {
            if (r5 != null) goto L4;
            IconCompat r10 = null;
        L5:
            this.mPictureIcon = r10;
            return this;
        L4:
            r10 = IconCompat.createWithBitmap(r5);
            goto L5
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@NonNull Bundle r5) {
            super.clearCompatExtraKeys(r5);
            r5.remove(NotificationCompat.EXTRA_LARGE_ICON_BIG);
            r5.remove(NotificationCompat.EXTRA_PICTURE);
            r5.remove(NotificationCompat.EXTRA_PICTURE_ICON);
            r5.remove(NotificationCompat.EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@NonNull Bundle r5) {
            super.restoreFromCompatExtras(r5);
            if (r5.containsKey(NotificationCompat.EXTRA_LARGE_ICON_BIG) == false) goto L5;
            this.mBigLargeIcon = asIconCompat(r5.getParcelable(NotificationCompat.EXTRA_LARGE_ICON_BIG));
            this.mBigLargeIconSet = true;
        L5:
            this.mPictureIcon = getPictureIcon(r5);
            this.mShowBigPictureWhenCollapsed = r5.getBoolean(NotificationCompat.EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED);
        }

        @NonNull
        public BigPictureStyle setBigContentTitle(@Nullable CharSequence r5) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(r5);
            return this;
        }

        @NonNull
        @RequiresApi(31)
        public BigPictureStyle setContentDescription(@Nullable CharSequence r5) {
            this.mPictureContentDescription = r5;
            return this;
        }

        @NonNull
        public BigPictureStyle setSummaryText(@Nullable CharSequence r5) {
            this.mSummaryText = Builder.limitCharSequenceLength(r5);
            this.mSummaryTextSet = true;
            return this;
        }

        @NonNull
        @RequiresApi(31)
        public BigPictureStyle showBigPictureWhenCollapsed(boolean r5) {
            this.mShowBigPictureWhenCollapsed = r5;
            return this;
        }

        public BigPictureStyle(@Nullable Builder r5) {
            setBuilder(r5);
        }

        @NonNull
        @RequiresApi(31)
        public BigPictureStyle bigPicture(@Nullable Icon r5) {
            this.mPictureIcon = IconCompat.createFromIcon(r5);
            return this;
        }

        @NonNull
        @RequiresApi(23)
        public BigPictureStyle bigLargeIcon(@Nullable Icon r5) {
            if (r5 != null) goto L4;
            IconCompat r10 = null;
        L5:
            this.mBigLargeIcon = r10;
            this.mBigLargeIconSet = true;
            return this;
        L4:
            r10 = IconCompat.createFromIcon(r5);
            goto L5
        }
    }

    public static class BigTextStyle extends Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigTextStyle";
        private CharSequence mBigText;

        public BigTextStyle() {
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(@NonNull Bundle r5) {
            super.addCompatExtras(r5);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r5) {
            Notification.BigTextStyle r10 = new Notification.BigTextStyle(r5.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigText(this.mBigText);
            if (this.mSummaryTextSet == false) goto L6;
            r10.setSummaryText(this.mSummaryText);
            return;
        }

        @NonNull
        public BigTextStyle bigText(@Nullable CharSequence r5) {
            this.mBigText = Builder.limitCharSequenceLength(r5);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@NonNull Bundle r5) {
            super.clearCompatExtraKeys(r5);
            r5.remove(NotificationCompat.EXTRA_BIG_TEXT);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@NonNull Bundle r5) {
            super.restoreFromCompatExtras(r5);
            this.mBigText = r5.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
        }

        @NonNull
        public BigTextStyle setBigContentTitle(@Nullable CharSequence r5) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(r5);
            return this;
        }

        @NonNull
        public BigTextStyle setSummaryText(@Nullable CharSequence r5) {
            this.mSummaryText = Builder.limitCharSequenceLength(r5);
            this.mSummaryTextSet = true;
            return this;
        }

        public BigTextStyle(@Nullable Builder r5) {
            setBuilder(r5);
        }
    }

    public static final class BubbleMetadata {
        private static final int FLAG_AUTO_EXPAND_BUBBLE = 1;
        private static final int FLAG_SUPPRESS_NOTIFICATION = 2;
        private PendingIntent mDeleteIntent;
        private int mDesiredHeight;

        @DimenRes
        private int mDesiredHeightResId;
        private int mFlags;
        private IconCompat mIcon;
        private PendingIntent mPendingIntent;
        private String mShortcutId;

        @RequiresApi(29)
        public static class Api29Impl {
            private Api29Impl() {
            }

            @Nullable
            @RequiresApi(29)
            public static BubbleMetadata fromPlatform(@Nullable Notification.BubbleMetadata r5) {
                if (r5 != null) goto L6;
                return null;
            L6:
                if (r5.getIntent() != null) goto L8;
                return null;
            L8:
                Builder r10 = new Builder(r5.getIntent(), IconCompat.createFromIcon(r5.getIcon())).setAutoExpandBubble(r5.getAutoExpandBubble()).setDeleteIntent(r5.getDeleteIntent()).setSuppressNotification(r5.isNotificationSuppressed());
                if (r5.getDesiredHeight() == 0) goto L12;
                r10.setDesiredHeight(r5.getDesiredHeight());
            L12:
                if (r5.getDesiredHeightResId() == 0) goto L15;
                r10.setDesiredHeightResId(r5.getDesiredHeightResId());
            L15:
                return r10.build();
            }

            @Nullable
            @RequiresApi(29)
            public static Notification.BubbleMetadata toPlatform(@Nullable BubbleMetadata r5) {
                if (r5 != null) goto L6;
                return null;
            L6:
                if (r5.getIntent() != null) goto L8;
                return null;
            L8:
                Notification.BubbleMetadata.Builder r10 = new Notification.BubbleMetadata.Builder().setIcon(r5.getIcon().toIcon()).setIntent(r5.getIntent()).setDeleteIntent(r5.getDeleteIntent()).setAutoExpandBubble(r5.getAutoExpandBubble()).setSuppressNotification(r5.isNotificationSuppressed());
                if (r5.getDesiredHeight() == 0) goto L12;
                r10.setDesiredHeight(r5.getDesiredHeight());
            L12:
                if (r5.getDesiredHeightResId() == 0) goto L15;
                r10.setDesiredHeightResId(r5.getDesiredHeightResId());
            L15:
                return r10.build();
            }
        }

        @RequiresApi(30)
        public static class Api30Impl {
            private Api30Impl() {
            }

            @Nullable
            @RequiresApi(30)
            public static BubbleMetadata fromPlatform(@Nullable Notification.BubbleMetadata r5) {
                if (r5 != null) goto L6;
                return null;
            L6:
                if (r5.getShortcutId() == null) goto L8;
                Builder r10 = new Builder(r5.getShortcutId());
            L9:
                r10.setAutoExpandBubble(r5.getAutoExpandBubble()).setDeleteIntent(r5.getDeleteIntent()).setSuppressNotification(r5.isNotificationSuppressed());
                if (r5.getDesiredHeight() == 0) goto L13;
                r10.setDesiredHeight(r5.getDesiredHeight());
            L13:
                if (r5.getDesiredHeightResId() == 0) goto L16;
                r10.setDesiredHeightResId(r5.getDesiredHeightResId());
            L16:
                return r10.build();
            L8:
                r10 = new Builder(r5.getIntent(), IconCompat.createFromIcon(r5.getIcon()));
                goto L9
            }

            @Nullable
            @RequiresApi(30)
            public static Notification.BubbleMetadata toPlatform(@Nullable BubbleMetadata r5) {
                if (r5 != null) goto L6;
                return null;
            L6:
                if (r5.getShortcutId() == null) goto L8;
                Notification.BubbleMetadata.Builder r10 = new Notification.BubbleMetadata.Builder(r5.getShortcutId());
            L9:
                r10.setDeleteIntent(r5.getDeleteIntent()).setAutoExpandBubble(r5.getAutoExpandBubble()).setSuppressNotification(r5.isNotificationSuppressed());
                if (r5.getDesiredHeight() == 0) goto L13;
                r10.setDesiredHeight(r5.getDesiredHeight());
            L13:
                if (r5.getDesiredHeightResId() == 0) goto L16;
                r10.setDesiredHeightResId(r5.getDesiredHeightResId());
            L16:
                return r10.build();
            L8:
                r10 = new Notification.BubbleMetadata.Builder(r5.getIntent(), r5.getIcon().toIcon());
                goto L9
            }
        }

        public static final class Builder {
            private PendingIntent mDeleteIntent;
            private int mDesiredHeight;

            @DimenRes
            private int mDesiredHeightResId;
            private int mFlags;
            private IconCompat mIcon;
            private PendingIntent mPendingIntent;
            private String mShortcutId;

            @Deprecated
            public Builder() {
            }

            @NonNull
            private Builder setFlag(int r5, boolean r10) {
                if (r10 == false) goto L4;
                this.mFlags = r5 | this.mFlags;
            L5:
                return this;
            L4:
                int r11 = this.mFlags;
                this.mFlags = (~r5) & r11;
                goto L5
            }

            @NonNull
            public BubbleMetadata build() {
                String r10 = this.mShortcutId;
                if (r10 == null) goto L5;
            L9:
                if (r10 == null) goto L11;
            L15:
                BubbleMetadata r11 = new BubbleMetadata(this.mPendingIntent, this.mDeleteIntent, this.mIcon, this.mDesiredHeight, this.mDesiredHeightResId, this.mFlags, r10, null);
                r11.setFlags(this.mFlags);
                return r11;
            L11:
                if (this.mIcon != null) goto L15;
                throw new NullPointerException("Must supply an icon or shortcut for the bubble");
            L5:
                if (this.mPendingIntent != null) goto L9;
                throw new NullPointerException("Must supply pending intent or shortcut to bubble");
            }

            @NonNull
            public Builder setAutoExpandBubble(boolean r5) {
                setFlag(1, r5);
                return this;
            }

            @NonNull
            public Builder setDeleteIntent(@Nullable PendingIntent r5) {
                this.mDeleteIntent = r5;
                return this;
            }

            @NonNull
            public Builder setDesiredHeight(@Dimension(unit = 0) int r5) {
                this.mDesiredHeight = Math.max(r5, 0);
                this.mDesiredHeightResId = 0;
                return this;
            }

            @NonNull
            public Builder setDesiredHeightResId(@DimenRes int r5) {
                this.mDesiredHeightResId = r5;
                this.mDesiredHeight = 0;
                return this;
            }

            @NonNull
            public Builder setIcon(@NonNull IconCompat r5) {
                if (this.mShortcutId != null) goto L10;
                if (r5 == null) goto L8;
                this.mIcon = r5;
                return this;
            L8:
                throw new NullPointerException("Bubbles require non-null icon");
            L10:
                throw new IllegalStateException("Created as a shortcut bubble, cannot set an Icon. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
            }

            @NonNull
            public Builder setIntent(@NonNull PendingIntent r5) {
                if (this.mShortcutId != null) goto L10;
                if (r5 == null) goto L8;
                this.mPendingIntent = r5;
                return this;
            L8:
                throw new NullPointerException("Bubble requires non-null pending intent");
            L10:
                throw new IllegalStateException("Created as a shortcut bubble, cannot set a PendingIntent. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
            }

            @NonNull
            public Builder setSuppressNotification(boolean r5) {
                setFlag(2, r5);
                return this;
            }

            @RequiresApi(30)
            public Builder(@NonNull String r5) {
                if (TextUtils.isEmpty(r5) == true) goto L7;
                this.mShortcutId = r5;
                return;
            L7:
                throw new NullPointerException("Bubble requires a non-null shortcut id");
            }

            public Builder(@NonNull PendingIntent r5, @NonNull IconCompat r10) {
                if (r5 == null) goto L10;
                if (r10 == null) goto L8;
                this.mPendingIntent = r5;
                this.mIcon = r10;
                return;
            L8:
                throw new NullPointerException("Bubbles require non-null icon");
            L10:
                throw new NullPointerException("Bubble requires non-null pending intent");
            }
        }

        public /* synthetic */ BubbleMetadata(PendingIntent r5, PendingIntent r10, IconCompat r11, int r12, int r13, int r14, String r15, AnonymousClass1 r16) {
            this(r5, r10, r11, r12, r13, r14, r15);
        }

        @Nullable
        public static BubbleMetadata fromPlatform(@Nullable Notification.BubbleMetadata r5) {
            if (r5 != null) goto L6;
            return null;
        L6:
            return Api30Impl.fromPlatform(r5);
        }

        @Nullable
        public static Notification.BubbleMetadata toPlatform(@Nullable BubbleMetadata r5) {
            if (r5 != null) goto L6;
            return null;
        L6:
            return Api30Impl.toPlatform(r5);
        }

        public boolean getAutoExpandBubble() {
            if ((this.mFlags & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Nullable
        public PendingIntent getDeleteIntent() {
            return this.mDeleteIntent;
        }

        @Dimension(unit = 0)
        public int getDesiredHeight() {
            return this.mDesiredHeight;
        }

        @DimenRes
        public int getDesiredHeightResId() {
            return this.mDesiredHeightResId;
        }

        @Nullable
        @SuppressLint({"InvalidNullConversion"})
        public IconCompat getIcon() {
            return this.mIcon;
        }

        @Nullable
        @SuppressLint({"InvalidNullConversion"})
        public PendingIntent getIntent() {
            return this.mPendingIntent;
        }

        @Nullable
        public String getShortcutId() {
            return this.mShortcutId;
        }

        public boolean isNotificationSuppressed() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void setFlags(int r5) {
            this.mFlags = r5;
        }

        private BubbleMetadata(@Nullable PendingIntent r5, @Nullable PendingIntent r10, @Nullable IconCompat r11, int r12, @DimenRes int r13, int r14, @Nullable String r15) {
            this.mPendingIntent = r5;
            this.mIcon = r11;
            this.mDesiredHeight = r12;
            this.mDesiredHeightResId = r13;
            this.mDeleteIntent = r10;
            this.mFlags = r14;
            this.mShortcutId = r15;
        }
    }

    public static class Builder {
        private static final int MAX_CHARSEQUENCE_LENGTH = 5120;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
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

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
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

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
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

        @RequiresApi(21)
        public static class Api21Impl {
            private Api21Impl() {
            }

            @DoNotInline
            public static AudioAttributes build(AudioAttributes.Builder r5) {
                return r5.build();
            }

            @DoNotInline
            public static AudioAttributes.Builder createBuilder() {
                return new AudioAttributes.Builder();
            }

            @DoNotInline
            public static AudioAttributes.Builder setContentType(AudioAttributes.Builder r5, int r10) {
                return r5.setContentType(r10);
            }

            @DoNotInline
            public static AudioAttributes.Builder setLegacyStreamType(AudioAttributes.Builder r5, int r10) {
                return r5.setLegacyStreamType(r10);
            }

            @DoNotInline
            public static AudioAttributes.Builder setUsage(AudioAttributes.Builder r5, int r10) {
                return r5.setUsage(r10);
            }
        }

        @RequiresApi(23)
        public static class Api23Impl {
            private Api23Impl() {
            }

            @DoNotInline
            public static Icon getLargeIcon(Notification r5) {
                return r5.getLargeIcon();
            }

            @DoNotInline
            public static Icon getSmallIcon(Notification r5) {
                return r5.getSmallIcon();
            }
        }

        @RequiresApi(24)
        public static class Api24Impl {
            private Api24Impl() {
            }

            @DoNotInline
            public static RemoteViews createBigContentView(Notification.Builder r5) {
                return r5.createHeadsUpContentView();
            }

            @DoNotInline
            public static RemoteViews createContentView(Notification.Builder r5) {
                return r5.createContentView();
            }

            @DoNotInline
            public static RemoteViews createHeadsUpContentView(Notification.Builder r5) {
                return r5.createHeadsUpContentView();
            }

            @DoNotInline
            public static Notification.Builder recoverBuilder(Context r5, Notification r10) {
                return Notification.Builder.recoverBuilder(r5, r10);
            }
        }

        public Builder(@NonNull Context r10, @NonNull Notification r11) {
            this(r10, NotificationCompat.getChannelId(r11));
            Bundle r12 = r11.extras;
            Style r5 = Style.extractStyleFromNotification(r11);
            setContentTitle(NotificationCompat.getContentTitle(r11)).setContentText(NotificationCompat.getContentText(r11)).setContentInfo(NotificationCompat.getContentInfo(r11)).setSubText(NotificationCompat.getSubText(r11)).setSettingsText(NotificationCompat.getSettingsText(r11)).setStyle(r5).setGroup(NotificationCompat.getGroup(r11)).setGroupSummary(NotificationCompat.isGroupSummary(r11)).setLocusId(NotificationCompat.getLocusId(r11)).setWhen(r11.when).setShowWhen(NotificationCompat.getShowWhen(r11)).setUsesChronometer(NotificationCompat.getUsesChronometer(r11)).setAutoCancel(NotificationCompat.getAutoCancel(r11)).setOnlyAlertOnce(NotificationCompat.getOnlyAlertOnce(r11)).setOngoing(NotificationCompat.getOngoing(r11)).setLocalOnly(NotificationCompat.getLocalOnly(r11)).setLargeIcon(r11.largeIcon).setBadgeIconType(NotificationCompat.getBadgeIconType(r11)).setCategory(NotificationCompat.getCategory(r11)).setBubbleMetadata(NotificationCompat.getBubbleMetadata(r11)).setNumber(r11.number).setTicker(r11.tickerText).setContentIntent(r11.contentIntent).setDeleteIntent(r11.deleteIntent).setFullScreenIntent(r11.fullScreenIntent, NotificationCompat.getHighPriority(r11)).setSound(r11.sound, r11.audioStreamType).setVibrate(r11.vibrate).setLights(r11.ledARGB, r11.ledOnMS, r11.ledOffMS).setDefaults(r11.defaults).setPriority(r11.priority).setColor(NotificationCompat.getColor(r11)).setVisibility(NotificationCompat.getVisibility(r11)).setPublicVersion(NotificationCompat.getPublicVersion(r11)).setSortKey(NotificationCompat.getSortKey(r11)).setTimeoutAfter(NotificationCompat.getTimeoutAfter(r11)).setShortcutId(NotificationCompat.getShortcutId(r11)).setProgress(r12.getInt(NotificationCompat.EXTRA_PROGRESS_MAX), r12.getInt(NotificationCompat.EXTRA_PROGRESS), r12.getBoolean(NotificationCompat.EXTRA_PROGRESS_INDETERMINATE)).setAllowSystemGeneratedContextualActions(NotificationCompat.getAllowSystemGeneratedContextualActions(r11)).setSmallIcon(r11.icon, r11.iconLevel).addExtras(getExtrasWithoutDuplicateData(r11, r5));
            this.mSmallIcon = Api23Impl.getSmallIcon(r11);
            Icon r13 = Api23Impl.getLargeIcon(r11);
            if (r13 == null) goto L5;
            this.mLargeIcon = IconCompat.createFromIcon(r13);
        L5:
            Notification.Action[] r14 = r11.actions;
            int r15 = 0;
            if (r14 != null) goto L8;
        L12:
            List<Action> r16 = NotificationCompat.getInvisibleActions(r11);
            if (r16.isEmpty() == true) goto L18;
            Iterator<Action> r17 = r16.iterator();
        L16:
            if (r17.hasNext() == false) goto L18;
            addInvisibleAction(r17.next());
        L18:
            String[] r18 = r11.extras.getStringArray(NotificationCompat.EXTRA_PEOPLE);
            if (r18 != null) goto L21;
        L25:
            ArrayList r19 = r11.extras.getParcelableArrayList(NotificationCompat.EXTRA_PEOPLE_LIST);
            if (r19 == null) goto L34;
            if (r19.isEmpty() == true) goto L34;
            Iterator r20 = r19.iterator();
        L31:
            if (r20.hasNext() == false) goto L34;
            addPerson(Person.fromAndroidPerson((android.app.Person) r20.next()));
        L34:
            if (r12.containsKey(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN) == false) goto L37;
            setChronometerCountDown(r12.getBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN));
        L37:
            if (r12.containsKey(NotificationCompat.EXTRA_COLORIZED) == false) goto L44;
            setColorized(r12.getBoolean(NotificationCompat.EXTRA_COLORIZED));
            return;
        L44:
            return;
        L21:
            if (r18.length == 0) goto L25;
            int r21 = r18.length;
        L23:
            if (r15 >= r21) goto L25;
            addPerson(r18[r15]);
            r15 = r15 + 1;
            goto L23
        L8:
            if (r14.length == 0) goto L12;
            int r22 = r14.length;
            int r23 = 0;
        L10:
            if (r23 >= r22) goto L12;
            addAction(Action.Builder.fromAndroidAction(r14[r23]).build());
            r23 = r23 + 1;
            goto L10
        }

        @Nullable
        private static Bundle getExtrasWithoutDuplicateData(@NonNull Notification r5, @Nullable Style r10) {
            if (r5.extras != null) goto L6;
            return null;
        L6:
            Bundle r11 = new Bundle(r5.extras);
            r11.remove(NotificationCompat.EXTRA_TITLE);
            r11.remove(NotificationCompat.EXTRA_TEXT);
            r11.remove(NotificationCompat.EXTRA_INFO_TEXT);
            r11.remove(NotificationCompat.EXTRA_SUB_TEXT);
            r11.remove(NotificationCompat.EXTRA_CHANNEL_ID);
            r11.remove(NotificationCompat.EXTRA_CHANNEL_GROUP_ID);
            r11.remove(NotificationCompat.EXTRA_SHOW_WHEN);
            r11.remove(NotificationCompat.EXTRA_PROGRESS);
            r11.remove(NotificationCompat.EXTRA_PROGRESS_MAX);
            r11.remove(NotificationCompat.EXTRA_PROGRESS_INDETERMINATE);
            r11.remove(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN);
            r11.remove(NotificationCompat.EXTRA_COLORIZED);
            r11.remove(NotificationCompat.EXTRA_PEOPLE_LIST);
            r11.remove(NotificationCompat.EXTRA_PEOPLE);
            r11.remove(NotificationCompatExtras.EXTRA_SORT_KEY);
            r11.remove(NotificationCompatExtras.EXTRA_GROUP_KEY);
            r11.remove(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
            r11.remove(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
            r11.remove(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
            Bundle r12 = r11.getBundle("android.car.EXTENSIONS");
            if (r12 == null) goto L9;
            Bundle r13 = new Bundle(r12);
            r13.remove("invisible_actions");
            r11.putBundle("android.car.EXTENSIONS", r13);
        L9:
            if (r10 == null) goto L11;
            r10.clearCompatExtraKeys(r11);
        L11:
            return r11;
        }

        @Nullable
        public static CharSequence limitCharSequenceLength(@Nullable CharSequence r5) {
            if (r5 != null) goto L5;
            return r5;
        L5:
            if (r5.length() > MAX_CHARSEQUENCE_LENGTH) goto L7;
            return r5;
        L7:
            return r5.subSequence(0, MAX_CHARSEQUENCE_LENGTH);
        }

        private void setFlag(int r5, boolean r10) {
            if (r10 == false) goto L4;
            Notification r11 = this.mNotification;
            r11.flags = r5 | r11.flags;
            return;
        L4:
            Notification r12 = this.mNotification;
            int r13 = r12.flags;
            r12.flags = (~r5) & r13;
        }

        private boolean useExistingRemoteView() {
            Style r5 = this.mStyle;
            if (r5 != null) goto L5;
        L8:
            return true;
        L5:
            if (r5.displayCustomViewInline() == false) goto L8;
            return false;
        }

        @NonNull
        public Builder addAction(int r5, @Nullable CharSequence r10, @Nullable PendingIntent r11) {
            this.mActions.add(new Action(r5, r10, r11));
            return this;
        }

        @NonNull
        public Builder addExtras(@Nullable Bundle r5) {
            if (r5 == null) goto L7;
            Bundle r10 = this.mExtras;
            if (r10 != null) goto L6;
            this.mExtras = new Bundle(r5);
            goto L7
        L6:
            r10.putAll(r5);
        L7:
            return this;
        }

        @NonNull
        @RequiresApi(21)
        public Builder addInvisibleAction(int r5, @Nullable CharSequence r10, @Nullable PendingIntent r11) {
            this.mInvisibleActions.add(new Action(r5, r10, r11));
            return this;
        }

        @NonNull
        @Deprecated
        public Builder addPerson(@Nullable String r5) {
            if (r5 != null) goto L4;
        L6:
            return this;
        L4:
            if (r5.isEmpty() == true) goto L6;
            this.mPeople.add(r5);
            goto L6
        }

        @NonNull
        public Notification build() {
            return new NotificationCompatBuilder(this).build();
        }

        @NonNull
        public Builder clearActions() {
            this.mActions.clear();
            return this;
        }

        @NonNull
        public Builder clearInvisibleActions() {
            this.mInvisibleActions.clear();
            Bundle r5 = this.mExtras.getBundle("android.car.EXTENSIONS");
            if (r5 == null) goto L5;
            Bundle r10 = new Bundle(r5);
            r10.remove("invisible_actions");
            this.mExtras.putBundle("android.car.EXTENSIONS", r10);
        L5:
            return this;
        }

        @NonNull
        public Builder clearPeople() {
            this.mPersonList.clear();
            this.mPeople.clear();
            return this;
        }

        @Nullable
        @SuppressLint({"BuilderSetStyle"})
        public RemoteViews createBigContentView() {
            if (this.mBigContentView != null) goto L5;
        L8:
            NotificationCompatBuilder r5 = new NotificationCompatBuilder(this);
            Style r10 = this.mStyle;
            if (r10 == null) goto L13;
            RemoteViews r11 = r10.makeBigContentView(r5);
            if (r11 == null) goto L13;
            return r11;
        L13:
            Notification r12 = r5.build();
            return Api24Impl.createBigContentView(Api24Impl.recoverBuilder(this.mContext, r12));
        L5:
            if (useExistingRemoteView() == false) goto L8;
            return this.mBigContentView;
        }

        @Nullable
        @SuppressLint({"BuilderSetStyle"})
        public RemoteViews createContentView() {
            if (this.mContentView != null) goto L5;
        L8:
            NotificationCompatBuilder r5 = new NotificationCompatBuilder(this);
            Style r10 = this.mStyle;
            if (r10 == null) goto L13;
            RemoteViews r11 = r10.makeContentView(r5);
            if (r11 == null) goto L13;
            return r11;
        L13:
            Notification r12 = r5.build();
            return Api24Impl.createContentView(Api24Impl.recoverBuilder(this.mContext, r12));
        L5:
            if (useExistingRemoteView() == false) goto L8;
            return this.mContentView;
        }

        @Nullable
        @SuppressLint({"BuilderSetStyle"})
        public RemoteViews createHeadsUpContentView() {
            if (this.mHeadsUpContentView != null) goto L5;
        L8:
            NotificationCompatBuilder r5 = new NotificationCompatBuilder(this);
            Style r10 = this.mStyle;
            if (r10 == null) goto L13;
            RemoteViews r11 = r10.makeHeadsUpContentView(r5);
            if (r11 == null) goto L13;
            return r11;
        L13:
            Notification r12 = r5.build();
            return Api24Impl.createHeadsUpContentView(Api24Impl.recoverBuilder(this.mContext, r12));
        L5:
            if (useExistingRemoteView() == false) goto L8;
            return this.mHeadsUpContentView;
        }

        @NonNull
        public Builder extend(@NonNull Extender r5) {
            r5.extend(this);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getBigContentView() {
            return this.mBigContentView;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public BubbleMetadata getBubbleMetadata() {
            return this.mBubbleMetadata;
        }

        @ColorInt
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getColor() {
            return this.mColor;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getContentView() {
            return this.mContentView;
        }

        @NonNull
        public Bundle getExtras() {
            if (this.mExtras != null) goto L6;
            this.mExtras = new Bundle();
        L6:
            return this.mExtras;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getForegroundServiceBehavior() {
            return this.mFgsDeferBehavior;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getHeadsUpContentView() {
            return this.mHeadsUpContentView;
        }

        @NonNull
        @Deprecated
        public Notification getNotification() {
            return build();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getPriority() {
            return this.mPriority;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public long getWhenIfShowing() {
            if (this.mShowWhen == true) goto L7;
            return 0;
        L7:
            return this.mNotification.when;
        }

        @NonNull
        public Builder setAllowSystemGeneratedContextualActions(boolean r5) {
            this.mAllowSystemGeneratedContextualActions = r5;
            return this;
        }

        @NonNull
        public Builder setAutoCancel(boolean r5) {
            setFlag(16, r5);
            return this;
        }

        @NonNull
        public Builder setBadgeIconType(int r5) {
            this.mBadgeIcon = r5;
            return this;
        }

        @NonNull
        public Builder setBubbleMetadata(@Nullable BubbleMetadata r5) {
            this.mBubbleMetadata = r5;
            return this;
        }

        @NonNull
        public Builder setCategory(@Nullable String r5) {
            this.mCategory = r5;
            return this;
        }

        @NonNull
        public Builder setChannelId(@NonNull String r5) {
            this.mChannelId = r5;
            return this;
        }

        @NonNull
        @RequiresApi(24)
        public Builder setChronometerCountDown(boolean r5) {
            this.mChronometerCountDown = r5;
            getExtras().putBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN, r5);
            return this;
        }

        @NonNull
        public Builder setColor(@ColorInt int r5) {
            this.mColor = r5;
            return this;
        }

        @NonNull
        public Builder setColorized(boolean r5) {
            this.mColorized = r5;
            this.mColorizedSet = true;
            return this;
        }

        @NonNull
        public Builder setContent(@Nullable RemoteViews r5) {
            this.mNotification.contentView = r5;
            return this;
        }

        @NonNull
        public Builder setContentInfo(@Nullable CharSequence r5) {
            this.mContentInfo = limitCharSequenceLength(r5);
            return this;
        }

        @NonNull
        public Builder setContentIntent(@Nullable PendingIntent r5) {
            this.mContentIntent = r5;
            return this;
        }

        @NonNull
        public Builder setContentText(@Nullable CharSequence r5) {
            this.mContentText = limitCharSequenceLength(r5);
            return this;
        }

        @NonNull
        public Builder setContentTitle(@Nullable CharSequence r5) {
            this.mContentTitle = limitCharSequenceLength(r5);
            return this;
        }

        @NonNull
        public Builder setCustomBigContentView(@Nullable RemoteViews r5) {
            this.mBigContentView = r5;
            return this;
        }

        @NonNull
        public Builder setCustomContentView(@Nullable RemoteViews r5) {
            this.mContentView = r5;
            return this;
        }

        @NonNull
        public Builder setCustomHeadsUpContentView(@Nullable RemoteViews r5) {
            this.mHeadsUpContentView = r5;
            return this;
        }

        @NonNull
        public Builder setDefaults(int r5) {
            Notification r10 = this.mNotification;
            r10.defaults = r5;
            if ((r5 & 4) == 0) goto L5;
            r10.flags |= 1;
        L5:
            return this;
        }

        @NonNull
        public Builder setDeleteIntent(@Nullable PendingIntent r5) {
            this.mNotification.deleteIntent = r5;
            return this;
        }

        @NonNull
        public Builder setExtras(@Nullable Bundle r5) {
            this.mExtras = r5;
            return this;
        }

        @NonNull
        public Builder setForegroundServiceBehavior(int r5) {
            this.mFgsDeferBehavior = r5;
            return this;
        }

        @NonNull
        public Builder setFullScreenIntent(@Nullable PendingIntent r5, boolean r10) {
            this.mFullScreenIntent = r5;
            setFlag(128, r10);
            return this;
        }

        @NonNull
        public Builder setGroup(@Nullable String r5) {
            this.mGroupKey = r5;
            return this;
        }

        @NonNull
        public Builder setGroupAlertBehavior(int r5) {
            this.mGroupAlertBehavior = r5;
            return this;
        }

        @NonNull
        public Builder setGroupSummary(boolean r5) {
            this.mGroupSummary = r5;
            return this;
        }

        @NonNull
        public Builder setLargeIcon(@Nullable Bitmap r5) {
            if (r5 != null) goto L4;
            IconCompat r10 = null;
        L5:
            this.mLargeIcon = r10;
            return this;
        L4:
            r10 = IconCompat.createWithBitmap(NotificationCompat.reduceLargeIconSize(this.mContext, r5));
            goto L5
        }

        @NonNull
        public Builder setLights(@ColorInt int r5, int r10, int r11) {
            Notification r12 = this.mNotification;
            r12.ledARGB = r5;
            r12.ledOnMS = r10;
            r12.ledOffMS = r11;
            if (r10 == 0) goto L6;
            if (r11 == 0) goto L6;
            int r13 = 1;
        L7:
            r12.flags = r13 | (r12.flags & (-2));
            return this;
        L6:
            r13 = 0;
            goto L7
        }

        @NonNull
        public Builder setLocalOnly(boolean r5) {
            this.mLocalOnly = r5;
            return this;
        }

        @NonNull
        public Builder setLocusId(@Nullable LocusIdCompat r5) {
            this.mLocusId = r5;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setNotificationSilent() {
            this.mSilent = true;
            return this;
        }

        @NonNull
        public Builder setNumber(int r5) {
            this.mNumber = r5;
            return this;
        }

        @NonNull
        public Builder setOngoing(boolean r5) {
            setFlag(2, r5);
            return this;
        }

        @NonNull
        public Builder setOnlyAlertOnce(boolean r5) {
            setFlag(8, r5);
            return this;
        }

        @NonNull
        public Builder setPriority(int r5) {
            this.mPriority = r5;
            return this;
        }

        @NonNull
        public Builder setProgress(int r5, int r10, boolean r11) {
            this.mProgressMax = r5;
            this.mProgress = r10;
            this.mProgressIndeterminate = r11;
            return this;
        }

        @NonNull
        public Builder setPublicVersion(@Nullable Notification r5) {
            this.mPublicVersion = r5;
            return this;
        }

        @NonNull
        public Builder setRemoteInputHistory(@Nullable CharSequence[] r5) {
            this.mRemoteInputHistory = r5;
            return this;
        }

        @NonNull
        public Builder setSettingsText(@Nullable CharSequence r5) {
            this.mSettingsText = limitCharSequenceLength(r5);
            return this;
        }

        @NonNull
        public Builder setShortcutId(@Nullable String r5) {
            this.mShortcutId = r5;
            return this;
        }

        @NonNull
        public Builder setShortcutInfo(@Nullable ShortcutInfoCompat r5) {
            if (r5 != null) goto L4;
            return this;
        L4:
            this.mShortcutId = r5.getId();
            if (this.mLocusId != null) goto L13;
            if (r5.getLocusId() == null) goto L10;
            this.mLocusId = r5.getLocusId();
            goto L13
        L10:
            if (r5.getId() == null) goto L13;
            this.mLocusId = new LocusIdCompat(r5.getId());
        L13:
            if (this.mContentTitle != null) goto L15;
            setContentTitle(r5.getShortLabel());
        L15:
            return this;
        }

        @NonNull
        public Builder setShowWhen(boolean r5) {
            this.mShowWhen = r5;
            return this;
        }

        @NonNull
        public Builder setSilent(boolean r5) {
            this.mSilent = r5;
            return this;
        }

        @NonNull
        @RequiresApi(23)
        public Builder setSmallIcon(@NonNull IconCompat r5) {
            this.mSmallIcon = r5.toIcon(this.mContext);
            return this;
        }

        @NonNull
        public Builder setSortKey(@Nullable String r5) {
            this.mSortKey = r5;
            return this;
        }

        @NonNull
        public Builder setSound(@Nullable Uri r5) {
            Notification r10 = this.mNotification;
            r10.sound = r5;
            r10.audioStreamType = -1;
            AudioAttributes.Builder r11 = Api21Impl.setUsage(Api21Impl.setContentType(Api21Impl.createBuilder(), 4), 5);
            Notification r12 = this.mNotification;
            r12.audioAttributes = Api21Impl.build(r11);
            return this;
        }

        @NonNull
        public Builder setStyle(@Nullable Style r5) {
            if (this.mStyle == r5) goto L7;
            this.mStyle = r5;
            if (r5 == null) goto L7;
            r5.setBuilder(this);
        L7:
            return this;
        }

        @NonNull
        public Builder setSubText(@Nullable CharSequence r5) {
            this.mSubText = limitCharSequenceLength(r5);
            return this;
        }

        @NonNull
        public Builder setTicker(@Nullable CharSequence r5) {
            Notification r10 = this.mNotification;
            r10.tickerText = limitCharSequenceLength(r5);
            return this;
        }

        @NonNull
        public Builder setTimeoutAfter(long r5) {
            this.mTimeout = r5;
            return this;
        }

        @NonNull
        public Builder setUsesChronometer(boolean r5) {
            this.mUseChronometer = r5;
            return this;
        }

        @NonNull
        public Builder setVibrate(@Nullable long[] r5) {
            this.mNotification.vibrate = r5;
            return this;
        }

        @NonNull
        public Builder setVisibility(int r5) {
            this.mVisibility = r5;
            return this;
        }

        @NonNull
        public Builder setWhen(long r5) {
            this.mNotification.when = r5;
            return this;
        }

        @NonNull
        public Builder addAction(@Nullable Action r5) {
            if (r5 == null) goto L4;
            this.mActions.add(r5);
        L4:
            return this;
        }

        @NonNull
        @RequiresApi(21)
        public Builder addInvisibleAction(@Nullable Action r5) {
            if (r5 == null) goto L4;
            this.mInvisibleActions.add(r5);
        L4:
            return this;
        }

        @NonNull
        public Builder setSmallIcon(int r5) {
            this.mNotification.icon = r5;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setTicker(@Nullable CharSequence r5, @Nullable RemoteViews r10) {
            Notification r11 = this.mNotification;
            r11.tickerText = limitCharSequenceLength(r5);
            this.mTickerView = r10;
            return this;
        }

        @NonNull
        public Builder addPerson(@Nullable Person r5) {
            if (r5 == null) goto L4;
            this.mPersonList.add(r5);
        L4:
            return this;
        }

        @NonNull
        public Builder setSmallIcon(int r5, int r10) {
            Notification r11 = this.mNotification;
            r11.icon = r5;
            r11.iconLevel = r10;
            return this;
        }

        @NonNull
        @RequiresApi(23)
        public Builder setLargeIcon(@Nullable Icon r5) {
            if (r5 != null) goto L4;
            IconCompat r10 = null;
        L5:
            this.mLargeIcon = r10;
            return this;
        L4:
            r10 = IconCompat.createFromIcon(r5);
            goto L5
        }

        @NonNull
        public Builder setSound(@Nullable Uri r5, int r10) {
            Notification r11 = this.mNotification;
            r11.sound = r5;
            r11.audioStreamType = r10;
            AudioAttributes.Builder r12 = Api21Impl.setLegacyStreamType(Api21Impl.setContentType(Api21Impl.createBuilder(), 4), r10);
            Notification r13 = this.mNotification;
            r13.audioAttributes = Api21Impl.build(r12);
            return this;
        }

        public Builder(@NonNull Context r5, @NonNull String r10) {
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
            Notification r11 = new Notification();
            this.mNotification = r11;
            this.mContext = r5;
            this.mChannelId = r10;
            r11.when = System.currentTimeMillis();
            this.mNotification.audioStreamType = -1;
            this.mPriority = 0;
            this.mPeople = new ArrayList();
            this.mAllowSystemGeneratedContextualActions = true;
        }

        @Deprecated
        public Builder(@NonNull Context r5) {
            this(r5, null);
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

        @RequiresApi(20)
        public static class Api20Impl {
            private Api20Impl() {
            }

            @DoNotInline
            public static Notification.Action.Builder addExtras(Notification.Action.Builder r5, Bundle r10) {
                return r5.addExtras(r10);
            }

            @DoNotInline
            public static Notification.Action.Builder addRemoteInput(Notification.Action.Builder r5, android.app.RemoteInput r10) {
                return r5.addRemoteInput(r10);
            }

            @DoNotInline
            public static Notification.Action build(Notification.Action.Builder r5) {
                return r5.build();
            }

            @DoNotInline
            public static Notification.Action.Builder createActionBuilder(int r5, CharSequence r10, PendingIntent r11) {
                return new Notification.Action.Builder(r5, r10, r11);
            }
        }

        @RequiresApi(21)
        public static class Api21Impl {
            private Api21Impl() {
            }

            @DoNotInline
            public static Notification.Builder addPerson(Notification.Builder r5, String r10) {
                return r5.addPerson(r10);
            }

            @DoNotInline
            public static Notification.Builder setCategory(Notification.Builder r5, String r10) {
                return r5.setCategory(r10);
            }
        }

        @RequiresApi(23)
        public static class Api23Impl {
            private Api23Impl() {
            }

            @DoNotInline
            public static Parcelable castToParcelable(Icon r5) {
                return r5;
            }

            @DoNotInline
            public static Notification.Action.Builder createActionBuilder(Icon r5, CharSequence r10, PendingIntent r11) {
                return new Notification.Action.Builder(r5, r10, r11);
            }

            @DoNotInline
            public static void setLargeIcon(Notification.Builder r5, Icon r10) {
                r5.setLargeIcon(r10);
            }
        }

        @RequiresApi(24)
        public static class Api24Impl {
            private Api24Impl() {
            }

            @DoNotInline
            public static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder r5, boolean r10) {
                return r5.setAllowGeneratedReplies(r10);
            }
        }

        @RequiresApi(28)
        public static class Api28Impl {
            private Api28Impl() {
            }

            @DoNotInline
            public static Notification.Builder addPerson(Notification.Builder r5, android.app.Person r10) {
                return r5.addPerson(r10);
            }

            @DoNotInline
            public static Parcelable castToParcelable(android.app.Person r5) {
                return r5;
            }
        }

        @RequiresApi(31)
        public static class Api31Impl {
            private Api31Impl() {
            }

            @DoNotInline
            public static Notification.CallStyle forIncomingCall(@NonNull android.app.Person r5, @NonNull PendingIntent r10, @NonNull PendingIntent r11) {
                return Notification.CallStyle.forIncomingCall(r5, r10, r11);
            }

            @DoNotInline
            public static Notification.CallStyle forOngoingCall(@NonNull android.app.Person r5, @NonNull PendingIntent r10) {
                return Notification.CallStyle.forOngoingCall(r5, r10);
            }

            @DoNotInline
            public static Notification.CallStyle forScreeningCall(@NonNull android.app.Person r5, @NonNull PendingIntent r10, @NonNull PendingIntent r11) {
                return Notification.CallStyle.forScreeningCall(r5, r10, r11);
            }

            @DoNotInline
            public static Notification.CallStyle setAnswerButtonColorHint(Notification.CallStyle r5, @ColorInt int r10) {
                return r5.setAnswerButtonColorHint(r10);
            }

            @DoNotInline
            public static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder r5, boolean r10) {
                return r5.setAuthenticationRequired(r10);
            }

            @DoNotInline
            public static Notification.CallStyle setDeclineButtonColorHint(Notification.CallStyle r5, @ColorInt int r10) {
                return r5.setDeclineButtonColorHint(r10);
            }

            @DoNotInline
            public static Notification.CallStyle setIsVideo(Notification.CallStyle r5, boolean r10) {
                return r5.setIsVideo(r10);
            }

            @DoNotInline
            public static Notification.CallStyle setVerificationIcon(Notification.CallStyle r5, @Nullable Icon r10) {
                return r5.setVerificationIcon(r10);
            }

            @DoNotInline
            public static Notification.CallStyle setVerificationText(Notification.CallStyle r5, @Nullable CharSequence r10) {
                return r5.setVerificationText(r10);
            }
        }

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public @interface CallType {
        }

        public CallStyle() {
        }

        @NonNull
        public static CallStyle forIncomingCall(@NonNull Person r10, @NonNull PendingIntent r11, @NonNull PendingIntent r12) {
            Objects.requireNonNull(r11, "declineIntent is required");
            Objects.requireNonNull(r12, "answerIntent is required");
            return new CallStyle(1, r10, null, r11, r12);
        }

        @NonNull
        public static CallStyle forOngoingCall(@NonNull Person r10, @NonNull PendingIntent r11) {
            Objects.requireNonNull(r11, "hangUpIntent is required");
            return new CallStyle(2, r10, r11, null, null);
        }

        @NonNull
        public static CallStyle forScreeningCall(@NonNull Person r10, @NonNull PendingIntent r11, @NonNull PendingIntent r12) {
            Objects.requireNonNull(r11, "hangUpIntent is required");
            Objects.requireNonNull(r12, "answerIntent is required");
            return new CallStyle(3, r10, r11, null, r12);
        }

        @Nullable
        private String getDefaultText() {
            int r5 = this.mCallType;
            if (r5 == 1) goto L15;
            if (r5 == 2) goto L13;
            if (r5 == 3) goto L11;
            return null;
        L11:
            return this.mBuilder.mContext.getResources().getString(R.string.call_notification_screening_text);
        L13:
            return this.mBuilder.mContext.getResources().getString(R.string.call_notification_ongoing_text);
        L15:
            return this.mBuilder.mContext.getResources().getString(R.string.call_notification_incoming_text);
        }

        private boolean isActionAddedByCallStyle(Action r5) {
            if (r5 != null) goto L4;
        L6:
            return false;
        L4:
            if (r5.getExtras().getBoolean(KEY_ACTION_PRIORITY) == false) goto L6;
            return true;
        }

        @NonNull
        @RequiresApi(20)
        private Action makeAction(int r5, int r10, Integer r11, int r12, PendingIntent r13) {
            if (r11 != null) goto L4;
            r11 = Integer.valueOf(ContextCompat.getColor(this.mBuilder.mContext, r12));
        L4:
            SpannableStringBuilder r14 = new SpannableStringBuilder();
            r14.append(this.mBuilder.mContext.getResources().getString(r10));
            r14.setSpan(new ForegroundColorSpan(r11.intValue()), 0, r14.length(), 18);
            Action r15 = new Action.Builder(IconCompat.createWithResource(this.mBuilder.mContext, r5), r14, r13).build();
            r15.getExtras().putBoolean(KEY_ACTION_PRIORITY, true);
            return r15;
        }

        @Nullable
        @RequiresApi(20)
        private Action makeAnswerAction() {
            int r5 = R.drawable.ic_call_answer_video;
            int r10 = R.drawable.ic_call_answer;
            PendingIntent r11 = this.mAnswerIntent;
            if (r11 != null) goto L5;
            return null;
        L5:
            boolean r12 = this.mIsVideo;
            if (r12 == false) goto L8;
            int r13 = r5;
        L9:
            if (r12 == false) goto L12;
            int r14 = R.string.call_notification_answer_video_action;
        L11:
            int r15 = r14;
            return makeAction(r13, r15, this.mAnswerButtonColor, R.color.call_notification_answer_color, r11);
        L12:
            r14 = R.string.call_notification_answer_action;
            goto L11
        L8:
            r13 = r10;
            goto L9
        }

        @NonNull
        @RequiresApi(20)
        private Action makeNegativeAction() {
            int r5 = R.drawable.ic_call_decline;
            PendingIntent r10 = this.mDeclineIntent;
            if (r10 != null) goto L7;
            return makeAction(r5, R.string.call_notification_hang_up_action, this.mDeclineButtonColor, R.color.call_notification_decline_color, this.mHangUpIntent);
        L7:
            return makeAction(r5, R.string.call_notification_decline_action, this.mDeclineButtonColor, R.color.call_notification_decline_color, r10);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(@NonNull Bundle r5) {
            super.addCompatExtras(r5);
            r5.putInt(NotificationCompat.EXTRA_CALL_TYPE, this.mCallType);
            r5.putBoolean(NotificationCompat.EXTRA_CALL_IS_VIDEO, this.mIsVideo);
            Person r10 = this.mPerson;
            if (r10 == null) goto L5;
            r5.putParcelable(NotificationCompat.EXTRA_CALL_PERSON, Api28Impl.castToParcelable(r10.toAndroidPerson()));
        L5:
            IconCompat r11 = this.mVerificationIcon;
            if (r11 == null) goto L8;
            r5.putParcelable(NotificationCompat.EXTRA_VERIFICATION_ICON, Api23Impl.castToParcelable(r11.toIcon(this.mBuilder.mContext)));
        L8:
            r5.putCharSequence(NotificationCompat.EXTRA_VERIFICATION_TEXT, this.mVerificationText);
            r5.putParcelable(NotificationCompat.EXTRA_ANSWER_INTENT, this.mAnswerIntent);
            r5.putParcelable(NotificationCompat.EXTRA_DECLINE_INTENT, this.mDeclineIntent);
            r5.putParcelable(NotificationCompat.EXTRA_HANG_UP_INTENT, this.mHangUpIntent);
            Integer r12 = this.mAnswerButtonColor;
            if (r12 == null) goto L11;
            r5.putInt(NotificationCompat.EXTRA_ANSWER_COLOR, r12.intValue());
        L11:
            Integer r13 = this.mDeclineButtonColor;
            if (r13 == null) goto L15;
            r5.putInt(NotificationCompat.EXTRA_DECLINE_COLOR, r13.intValue());
            return;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r5) {
            int r10 = this.mCallType;
            if (r10 != 1) goto L5;
            Notification.CallStyle r11 = Api31Impl.forIncomingCall(this.mPerson.toAndroidPerson(), this.mDeclineIntent, this.mAnswerIntent);
        L15:
            if (r11 == null) goto L27;
            r11.setBuilder(r5.getBuilder());
            Integer r12 = this.mAnswerButtonColor;
            if (r12 == null) goto L19;
            Api31Impl.setAnswerButtonColorHint(r11, r12.intValue());
        L19:
            Integer r13 = this.mDeclineButtonColor;
            if (r13 == null) goto L22;
            Api31Impl.setDeclineButtonColorHint(r11, r13.intValue());
        L22:
            Api31Impl.setVerificationText(r11, this.mVerificationText);
            IconCompat r14 = this.mVerificationIcon;
            if (r14 == null) goto L25;
            Api31Impl.setVerificationIcon(r11, r14.toIcon(this.mBuilder.mContext));
        L25:
            Api31Impl.setIsVideo(r11, this.mIsVideo);
            return;
        L27:
            return;
        L5:
            if (r10 != 2) goto L7;
            r11 = Api31Impl.forOngoingCall(this.mPerson.toAndroidPerson(), this.mHangUpIntent);
            goto L15
        L7:
            if (r10 != 3) goto L9;
            r11 = Api31Impl.forScreeningCall(this.mPerson.toAndroidPerson(), this.mHangUpIntent, this.mAnswerIntent);
            goto L15
        L9:
            if (Log.isLoggable(NotificationCompat.TAG, 3) == false) goto L11;
            Log.d(NotificationCompat.TAG, "Unrecognized call type in CallStyle: " + String.valueOf(this.mCallType));
        L11:
            r11 = null;
            goto L15
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean displayCustomViewInline() {
            return true;
        }

        @NonNull
        @RequiresApi(20)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public ArrayList<Action> getActionsListWithSystemActions() {
            Action r5 = makeNegativeAction();
            Action r10 = makeAnswerAction();
            ArrayList<Action> r11 = new ArrayList(3);
            r11.add(r5);
            ArrayList<Action> r12 = this.mBuilder.mActions;
            int r13 = 2;
            if (r12 == null) goto L18;
            Iterator<Action> r14 = r12.iterator();
        L6:
            if (r14.hasNext() == false) goto L18;
            Action r15 = r14.next();
            if (r15.isContextual() == false) goto L11;
            r11.add(r15);
        L15:
            if (r10 == null) goto L6;
            if (r13 != 1) goto L6;
            r11.add(r10);
            r13 = r13 - 1;
            goto L6
        L11:
            if (isActionAddedByCallStyle(r15) == true) goto L15;
            if (r13 <= 1) goto L15;
            r11.add(r15);
            r13 = r13 - 1;
        L18:
            if (r10 == null) goto L21;
            if (r13 < 1) goto L21;
            r11.add(r10);
        L21:
            return r11;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@NonNull Bundle r5) {
            super.restoreFromCompatExtras(r5);
            this.mCallType = r5.getInt(NotificationCompat.EXTRA_CALL_TYPE);
            this.mIsVideo = r5.getBoolean(NotificationCompat.EXTRA_CALL_IS_VIDEO);
            if (r5.containsKey(NotificationCompat.EXTRA_CALL_PERSON) == false) goto L6;
            this.mPerson = Person.fromAndroidPerson((android.app.Person) r5.getParcelable(NotificationCompat.EXTRA_CALL_PERSON));
        L9:
            if (r5.containsKey(NotificationCompat.EXTRA_VERIFICATION_ICON) == false) goto L12;
            this.mVerificationIcon = IconCompat.createFromIcon((Icon) r5.getParcelable(NotificationCompat.EXTRA_VERIFICATION_ICON));
        L14:
            this.mVerificationText = r5.getCharSequence(NotificationCompat.EXTRA_VERIFICATION_TEXT);
            this.mAnswerIntent = (PendingIntent) r5.getParcelable(NotificationCompat.EXTRA_ANSWER_INTENT);
            this.mDeclineIntent = (PendingIntent) r5.getParcelable(NotificationCompat.EXTRA_DECLINE_INTENT);
            this.mHangUpIntent = (PendingIntent) r5.getParcelable(NotificationCompat.EXTRA_HANG_UP_INTENT);
            Integer r10 = null;
            if (r5.containsKey(NotificationCompat.EXTRA_ANSWER_COLOR) == false) goto L17;
            Integer r11 = Integer.valueOf(r5.getInt(NotificationCompat.EXTRA_ANSWER_COLOR));
        L18:
            this.mAnswerButtonColor = r11;
            if (r5.containsKey(NotificationCompat.EXTRA_DECLINE_COLOR) == false) goto L21;
            r10 = Integer.valueOf(r5.getInt(NotificationCompat.EXTRA_DECLINE_COLOR));
        L21:
            this.mDeclineButtonColor = r10;
            return;
        L17:
            r11 = null;
            goto L18
        L12:
            if (r5.containsKey(NotificationCompat.EXTRA_VERIFICATION_ICON_COMPAT) == false) goto L14;
            this.mVerificationIcon = IconCompat.createFromBundle(r5.getBundle(NotificationCompat.EXTRA_VERIFICATION_ICON_COMPAT));
            goto L14
        L6:
            if (r5.containsKey(NotificationCompat.EXTRA_CALL_PERSON_COMPAT) == false) goto L9;
            this.mPerson = Person.fromBundle(r5.getBundle(NotificationCompat.EXTRA_CALL_PERSON_COMPAT));
            goto L9
        }

        @NonNull
        public CallStyle setAnswerButtonColorHint(@ColorInt int r5) {
            this.mAnswerButtonColor = Integer.valueOf(r5);
            return this;
        }

        @NonNull
        public CallStyle setDeclineButtonColorHint(@ColorInt int r5) {
            this.mDeclineButtonColor = Integer.valueOf(r5);
            return this;
        }

        @NonNull
        public CallStyle setIsVideo(boolean r5) {
            this.mIsVideo = r5;
            return this;
        }

        @NonNull
        @RequiresApi(23)
        public CallStyle setVerificationIcon(@Nullable Icon r5) {
            if (r5 != null) goto L4;
            IconCompat r10 = null;
        L5:
            this.mVerificationIcon = r10;
            return this;
        L4:
            r10 = IconCompat.createFromIcon(r5);
            goto L5
        }

        @NonNull
        public CallStyle setVerificationText(@Nullable CharSequence r5) {
            this.mVerificationText = r5;
            return this;
        }

        public CallStyle(@Nullable Builder r5) {
            setBuilder(r5);
        }

        @NonNull
        public CallStyle setVerificationIcon(@Nullable Bitmap r5) {
            this.mVerificationIcon = IconCompat.createWithBitmap(r5);
            return this;
        }

        private CallStyle(int r5, @NonNull Person r10, @Nullable PendingIntent r11, @Nullable PendingIntent r12, @Nullable PendingIntent r13) {
            if (r10 == null) goto L9;
            if (TextUtils.isEmpty(r10.getName()) == true) goto L9;
            this.mCallType = r5;
            this.mPerson = r10;
            this.mAnswerIntent = r13;
            this.mDeclineIntent = r12;
            this.mHangUpIntent = r11;
            return;
        L9:
            throw new IllegalArgumentException("person must have a non-empty a name");
        }
    }

    public static final class CarExtender implements Extender {

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
        private static final String EXTRA_COLOR = "app_color";
        private static final String EXTRA_CONVERSATION = "car_conversation";

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
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

        @RequiresApi(20)
        public static class Api20Impl {
            private Api20Impl() {
            }

            @DoNotInline
            public static android.app.RemoteInput.Builder addExtras(android.app.RemoteInput.Builder r5, Bundle r10) {
                return r5.addExtras(r10);
            }

            @DoNotInline
            public static android.app.RemoteInput build(android.app.RemoteInput.Builder r5) {
                return r5.build();
            }

            @DoNotInline
            public static Parcelable castToParcelable(android.app.RemoteInput r5) {
                return r5;
            }

            @DoNotInline
            public static android.app.RemoteInput.Builder createBuilder(String r5) {
                return new android.app.RemoteInput.Builder(r5);
            }

            @DoNotInline
            public static boolean getAllowFreeFormInput(android.app.RemoteInput r5) {
                return r5.getAllowFreeFormInput();
            }

            @DoNotInline
            public static CharSequence[] getChoices(android.app.RemoteInput r5) {
                return r5.getChoices();
            }

            @DoNotInline
            public static Bundle getExtras(android.app.RemoteInput r5) {
                return r5.getExtras();
            }

            @DoNotInline
            public static CharSequence getLabel(android.app.RemoteInput r5) {
                return r5.getLabel();
            }

            @DoNotInline
            public static String getResultKey(android.app.RemoteInput r5) {
                return r5.getResultKey();
            }

            @DoNotInline
            public static android.app.RemoteInput.Builder setAllowFreeFormInput(android.app.RemoteInput.Builder r5, boolean r10) {
                return r5.setAllowFreeFormInput(r10);
            }

            @DoNotInline
            public static android.app.RemoteInput.Builder setChoices(android.app.RemoteInput.Builder r5, CharSequence[] r10) {
                return r5.setChoices(r10);
            }

            @DoNotInline
            public static android.app.RemoteInput.Builder setLabel(android.app.RemoteInput.Builder r5, CharSequence r10) {
                return r5.setLabel(r10);
            }
        }

        @RequiresApi(29)
        public static class Api29Impl {
            private Api29Impl() {
            }

            @DoNotInline
            public static int getEditChoicesBeforeSending(android.app.RemoteInput r5) {
                return r5.getEditChoicesBeforeSending();
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

                public Builder(@NonNull String r5) {
                    this.mMessages = new ArrayList();
                    this.mParticipant = r5;
                }

                @NonNull
                public Builder addMessage(@Nullable String r5) {
                    if (r5 == null) goto L4;
                    this.mMessages.add(r5);
                L4:
                    return this;
                }

                @NonNull
                public UnreadConversation build() {
                    List<String> r5 = this.mMessages;
                    String[] r10 = (String[]) r5.toArray(new String[r5.size()]);
                    String[] r11 = {this.mParticipant};
                    return new UnreadConversation(r10, this.mRemoteInput, this.mReplyPendingIntent, this.mReadPendingIntent, r11, this.mLatestTimestamp);
                }

                @NonNull
                public Builder setLatestTimestamp(long r5) {
                    this.mLatestTimestamp = r5;
                    return this;
                }

                @NonNull
                public Builder setReadPendingIntent(@Nullable PendingIntent r5) {
                    this.mReadPendingIntent = r5;
                    return this;
                }

                @NonNull
                public Builder setReplyAction(@Nullable PendingIntent r5, @Nullable RemoteInput r10) {
                    this.mRemoteInput = r10;
                    this.mReplyPendingIntent = r5;
                    return this;
                }
            }

            public UnreadConversation(@Nullable String[] r5, @Nullable RemoteInput r10, @Nullable PendingIntent r11, @Nullable PendingIntent r12, @Nullable String[] r13, long r14) {
                this.mMessages = r5;
                this.mRemoteInput = r10;
                this.mReadPendingIntent = r12;
                this.mReplyPendingIntent = r11;
                this.mParticipants = r13;
                this.mLatestTimestamp = r14;
            }

            public long getLatestTimestamp() {
                return this.mLatestTimestamp;
            }

            @Nullable
            public String[] getMessages() {
                return this.mMessages;
            }

            @Nullable
            public String getParticipant() {
                String[] r5 = this.mParticipants;
                if (r5.length > 0) goto L7;
                return null;
            L7:
                return r5[0];
            }

            @Nullable
            public String[] getParticipants() {
                return this.mParticipants;
            }

            @Nullable
            public PendingIntent getReadPendingIntent() {
                return this.mReadPendingIntent;
            }

            @Nullable
            public RemoteInput getRemoteInput() {
                return this.mRemoteInput;
            }

            @Nullable
            public PendingIntent getReplyPendingIntent() {
                return this.mReplyPendingIntent;
            }
        }

        public CarExtender() {
            this.mColor = 0;
        }

        @RequiresApi(21)
        private static Bundle getBundleForUnreadConversation(@NonNull UnreadConversation r10) {
            Bundle r5 = new Bundle();
            int r11 = 0;
            if (r10.getParticipants() != null) goto L5;
        L7:
            String r12 = null;
        L8:
            int r13 = r10.getMessages().length;
            Parcelable[] r14 = new Parcelable[r13];
        L9:
            if (r11 >= r13) goto L11;
            Bundle r15 = new Bundle();
            r15.putString("text", r10.getMessages()[r11]);
            r15.putString(KEY_AUTHOR, r12);
            r14[r11] = r15;
            r11 = r11 + 1;
            goto L9
        L11:
            r5.putParcelableArray(KEY_MESSAGES, r14);
            RemoteInput r16 = r10.getRemoteInput();
            if (r16 == null) goto L14;
            android.app.RemoteInput.Builder r17 = Api20Impl.createBuilder(r16.getResultKey());
            Api20Impl.setLabel(r17, r16.getLabel());
            Api20Impl.setChoices(r17, r16.getChoices());
            Api20Impl.setAllowFreeFormInput(r17, r16.getAllowFreeFormInput());
            Api20Impl.addExtras(r17, r16.getExtras());
            r5.putParcelable(KEY_REMOTE_INPUT, Api20Impl.castToParcelable(Api20Impl.build(r17)));
        L14:
            r5.putParcelable(KEY_ON_REPLY, r10.getReplyPendingIntent());
            r5.putParcelable(KEY_ON_READ, r10.getReadPendingIntent());
            r5.putStringArray(KEY_PARTICIPANTS, r10.getParticipants());
            r5.putLong(KEY_TIMESTAMP, r10.getLatestTimestamp());
            return r5;
        L5:
            if (r10.getParticipants().length <= 1) goto L7;
            r12 = r10.getParticipants()[0];
            goto L8
        }

        @RequiresApi(21)
        private static UnreadConversation getUnreadConversationFromBundle(@Nullable Bundle r20) {
            RemoteInput r5 = null;
            if (r20 != null) goto L5;
            return null;
        L5:
            Parcelable[] r10 = r20.getParcelableArray(KEY_MESSAGES);
            if (r10 == null) goto L17;
            int r11 = r10.length;
            String[] r12 = new String[r11];
            int r13 = 0;
        L8:
            if (r13 >= r11) goto L16;
            Parcelable r14 = r10[r13];
            if ((r14 instanceof Bundle) == false) goto L14;
            String r15 = ((Bundle) r14).getString("text");
            r12[r13] = r15;
            if (r15 == null) goto L14;
            r13 = r13 + 1;
        L14:
            return null;
        L16:
            String[] r16 = r12;
        L18:
            PendingIntent r17 = (PendingIntent) r20.getParcelable(KEY_ON_READ);
            PendingIntent r18 = (PendingIntent) r20.getParcelable(KEY_ON_REPLY);
            android.app.RemoteInput r19 = (android.app.RemoteInput) r20.getParcelable(KEY_REMOTE_INPUT);
            String[] r110 = r20.getStringArray(KEY_PARTICIPANTS);
            if (r110 != null) goto L21;
            return null;
        L21:
            if (r110.length != 1) goto L31;
            if (r19 == null) goto L26;
            r5 = new RemoteInput(Api20Impl.getResultKey(r19), Api20Impl.getLabel(r19), Api20Impl.getChoices(r19), Api20Impl.getAllowFreeFormInput(r19), Api29Impl.getEditChoicesBeforeSending(r19), Api20Impl.getExtras(r19), null);
        L26:
            return new UnreadConversation(r16, r5, r18, r17, r110, r20.getLong(KEY_TIMESTAMP));
        L31:
            return null;
        L17:
            r16 = null;
            goto L18
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        @NonNull
        public Builder extend(@NonNull Builder r5) {
            Bundle r10 = new Bundle();
            Bitmap r11 = this.mLargeIcon;
            if (r11 == null) goto L5;
            r10.putParcelable(EXTRA_LARGE_ICON, r11);
        L5:
            int r12 = this.mColor;
            if (r12 == 0) goto L8;
            r10.putInt(EXTRA_COLOR, r12);
        L8:
            UnreadConversation r13 = this.mUnreadConversation;
            if (r13 == null) goto L11;
            r10.putBundle(EXTRA_CONVERSATION, getBundleForUnreadConversation(r13));
        L11:
            r5.getExtras().putBundle(EXTRA_CAR_EXTENDER, r10);
            return r5;
        }

        @ColorInt
        public int getColor() {
            return this.mColor;
        }

        @Nullable
        public Bitmap getLargeIcon() {
            return this.mLargeIcon;
        }

        @Nullable
        @Deprecated
        public UnreadConversation getUnreadConversation() {
            return this.mUnreadConversation;
        }

        @NonNull
        public CarExtender setColor(@ColorInt int r5) {
            this.mColor = r5;
            return this;
        }

        @NonNull
        public CarExtender setLargeIcon(@Nullable Bitmap r5) {
            this.mLargeIcon = r5;
            return this;
        }

        @NonNull
        @Deprecated
        public CarExtender setUnreadConversation(@Nullable UnreadConversation r5) {
            this.mUnreadConversation = r5;
            return this;
        }

        public CarExtender(@NonNull Notification r5) {
            this.mColor = 0;
            if (NotificationCompat.getExtras(r5) != null) goto L5;
            Bundle r10 = null;
        L6:
            if (r10 == null) goto L9;
            this.mLargeIcon = (Bitmap) r10.getParcelable(EXTRA_LARGE_ICON);
            this.mColor = r10.getInt(EXTRA_COLOR, 0);
            this.mUnreadConversation = getUnreadConversationFromBundle(r10.getBundle(EXTRA_CONVERSATION));
            return;
        L9:
            return;
        L5:
            r10 = NotificationCompat.getExtras(r5).getBundle(EXTRA_CAR_EXTENDER);
            goto L6
        }
    }

    public static class DecoratedCustomViewStyle extends Style {
        private static final int MAX_ACTION_BUTTONS = 3;
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";

        @RequiresApi(24)
        public static class Api24Impl {
            private Api24Impl() {
            }

            @DoNotInline
            public static Notification.Style createDecoratedCustomViewStyle() {
                return new Notification.DecoratedCustomViewStyle();
            }
        }

        public DecoratedCustomViewStyle() {
        }

        private RemoteViews createRemoteViews(RemoteViews r10, boolean r11) {
            int r5 = 0;
            RemoteViews r12 = applyStandardTemplate(true, R.layout.notification_template_custom_big, false);
            r12.removeAllViews(R.id.actions);
            List<Action> r13 = getNonContextualActions(this.mBuilder.mActions);
            if (r11 == false) goto L10;
            if (r13 == null) goto L10;
            int r14 = Math.min(r13.size(), 3);
            if (r14 <= 0) goto L10;
            int r15 = 0;
        L8:
            if (r15 >= r14) goto L11;
            r12.addView(R.id.actions, generateActionButton(r13.get(r15)));
            r15 = r15 + 1;
        L11:
            r12.setViewVisibility(R.id.actions, r5);
            r12.setViewVisibility(R.id.action_divider, r5);
            buildIntoRemoteViews(r12, r10);
            return r12;
        L10:
            r5 = 8;
            goto L11
        }

        private RemoteViews generateActionButton(Action r10) {
            if (r10.actionIntent != null) goto L5;
            boolean r5 = true;
        L6:
            String r11 = this.mBuilder.mContext.getPackageName();
            if (r5 == false) goto L9;
            int r12 = R.layout.notification_action_tombstone;
        L10:
            RemoteViews r13 = new RemoteViews(r11, r12);
            IconCompat r14 = r10.getIconCompat();
            if (r14 == null) goto L13;
            r13.setImageViewBitmap(R.id.action_image, createColoredBitmap(r14, R.color.notification_action_color_filter));
        L13:
            r13.setTextViewText(R.id.action_text, r10.title);
            if (r5 == true) goto L16;
            r13.setOnClickPendingIntent(R.id.action_container, r10.actionIntent);
        L16:
            r13.setContentDescription(R.id.action_container, r10.title);
            return r13;
        L9:
            r12 = R.layout.notification_action;
            goto L10
        L5:
            r5 = false;
            goto L6
        }

        private static List<Action> getNonContextualActions(List<Action> r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            ArrayList r10 = new ArrayList();
            Iterator<Action> r11 = r5.iterator();
        L7:
            if (r11.hasNext() == false) goto L11;
            Action r12 = r11.next();
            if (r12.isContextual() == true) goto L7;
            r10.add(r12);
            goto L7
        L11:
            return r10;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r5) {
            r5.getBuilder().setStyle(Api24Impl.createDecoratedCustomViewStyle());
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean displayCustomViewInline() {
            return true;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r5) {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r5) {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor r5) {
            return null;
        }
    }

    public interface Extender {
        @NonNull
        Builder extend(@NonNull Builder r5);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface GroupAlertBehavior {
    }

    public static class InboxStyle extends Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$InboxStyle";
        private ArrayList<CharSequence> mTexts;

        public InboxStyle() {
            this.mTexts = new ArrayList();
        }

        @NonNull
        public InboxStyle addLine(@Nullable CharSequence r5) {
            if (r5 == null) goto L4;
            this.mTexts.add(Builder.limitCharSequenceLength(r5));
        L4:
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r5) {
            Notification.InboxStyle r10 = new Notification.InboxStyle(r5.getBuilder()).setBigContentTitle(this.mBigContentTitle);
            if (this.mSummaryTextSet == false) goto L5;
            r10.setSummaryText(this.mSummaryText);
        L5:
            Iterator<CharSequence> r11 = this.mTexts.iterator();
        L7:
            if (r11.hasNext() == false) goto L9;
            r10.addLine(r11.next());
            goto L7
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@NonNull Bundle r5) {
            super.clearCompatExtraKeys(r5);
            r5.remove(NotificationCompat.EXTRA_TEXT_LINES);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@NonNull Bundle r5) {
            super.restoreFromCompatExtras(r5);
            this.mTexts.clear();
            if (r5.containsKey(NotificationCompat.EXTRA_TEXT_LINES) == false) goto L6;
            Collections.addAll(this.mTexts, r5.getCharSequenceArray(NotificationCompat.EXTRA_TEXT_LINES));
            return;
        }

        @NonNull
        public InboxStyle setBigContentTitle(@Nullable CharSequence r5) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(r5);
            return this;
        }

        @NonNull
        public InboxStyle setSummaryText(@Nullable CharSequence r5) {
            this.mSummaryText = Builder.limitCharSequenceLength(r5);
            this.mSummaryTextSet = true;
            return this;
        }

        public InboxStyle(@Nullable Builder r5) {
            this.mTexts = new ArrayList();
            setBuilder(r5);
        }
    }

    public static class MessagingStyle extends Style {
        public static final int MAXIMUM_RETAINED_MESSAGES = 25;
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$MessagingStyle";

        @Nullable
        private CharSequence mConversationTitle;
        private final List<Message> mHistoricMessages;

        @Nullable
        private Boolean mIsGroupConversation;
        private final List<Message> mMessages;
        private Person mUser;

        @RequiresApi(24)
        public static class Api24Impl {
            private Api24Impl() {
            }

            @DoNotInline
            public static Notification.MessagingStyle addMessage(Notification.MessagingStyle r5, Notification.MessagingStyle.Message r10) {
                return r5.addMessage(r10);
            }

            @DoNotInline
            public static Notification.MessagingStyle createMessagingStyle(CharSequence r5) {
                return new Notification.MessagingStyle(r5);
            }

            @DoNotInline
            public static Notification.MessagingStyle setConversationTitle(Notification.MessagingStyle r5, CharSequence r10) {
                return r5.setConversationTitle(r10);
            }
        }

        @RequiresApi(26)
        public static class Api26Impl {
            private Api26Impl() {
            }

            @DoNotInline
            public static Notification.MessagingStyle addHistoricMessage(Notification.MessagingStyle r5, Notification.MessagingStyle.Message r10) {
                return r5.addHistoricMessage(r10);
            }
        }

        @RequiresApi(28)
        public static class Api28Impl {
            private Api28Impl() {
            }

            @DoNotInline
            public static Notification.MessagingStyle createMessagingStyle(android.app.Person r5) {
                return new Notification.MessagingStyle(r5);
            }

            @DoNotInline
            public static Notification.MessagingStyle setGroupConversation(Notification.MessagingStyle r5, boolean r10) {
                return r5.setGroupConversation(r10);
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

            @Nullable
            private String mDataMimeType;

            @Nullable
            private Uri mDataUri;
            private Bundle mExtras;

            @Nullable
            private final Person mPerson;
            private final CharSequence mText;
            private final long mTimestamp;

            @RequiresApi(24)
            public static class Api24Impl {
                private Api24Impl() {
                }

                @DoNotInline
                public static Notification.MessagingStyle.Message createMessage(CharSequence r5, long r10, CharSequence r11) {
                    return new Notification.MessagingStyle.Message(r5, r10, r11);
                }

                @DoNotInline
                public static Notification.MessagingStyle.Message setData(Notification.MessagingStyle.Message r5, String r10, Uri r11) {
                    return r5.setData(r10, r11);
                }
            }

            @RequiresApi(28)
            public static class Api28Impl {
                private Api28Impl() {
                }

                @DoNotInline
                public static Parcelable castToParcelable(android.app.Person r5) {
                    return r5;
                }

                @DoNotInline
                public static Notification.MessagingStyle.Message createMessage(CharSequence r5, long r10, android.app.Person r11) {
                    return new Notification.MessagingStyle.Message(r5, r10, r11);
                }
            }

            public Message(@Nullable CharSequence r5, long r10, @Nullable Person r11) {
                this.mExtras = new Bundle();
                this.mText = r5;
                this.mTimestamp = r10;
                this.mPerson = r11;
            }

            @NonNull
            public static Bundle[] getBundleArrayForMessages(@NonNull List<Message> r5) {
                Bundle[] r10 = new Bundle[r5.size()];
                int r11 = r5.size();
                int r12 = 0;
            L3:
                if (r12 >= r11) goto L5;
                r10[r12] = r5.get(r12).toBundle();
                r12 = r12 + 1;
                goto L3
            L5:
                return r10;
            }

            @Nullable
            public static Message getMessageFromBundle(@NonNull Bundle r10) {
                if (r10.containsKey("text") == false) goto L27;
                if (r10.containsKey(KEY_TIMESTAMP) == false) goto L27;
                if (r10.containsKey(KEY_PERSON) == false) goto L12;
                Person r5 = Person.fromBundle(r10.getBundle(KEY_PERSON));     // Catch: ClassCastException -> L28
            L18:
                Message r11 = new Message(r10.getCharSequence("text"), r10.getLong(KEY_TIMESTAMP), r5);     // Catch: ClassCastException -> L28
                if (r10.containsKey("type") == false) goto L24;
                if (r10.containsKey("uri") == false) goto L24;
                r11.setData(r10.getString("type"), (Uri) r10.getParcelable("uri"));     // Catch: ClassCastException -> L28
            L24:
                if (r10.containsKey(KEY_EXTRAS_BUNDLE) == false) goto L26;
                r11.getExtras().putAll(r10.getBundle(KEY_EXTRAS_BUNDLE));     // Catch: ClassCastException -> L28
            L26:
                return r11;
            L12:
                if (r10.containsKey(KEY_NOTIFICATION_PERSON) == false) goto L15;
                r5 = Person.fromAndroidPerson((android.app.Person) r10.getParcelable(KEY_NOTIFICATION_PERSON));     // Catch: ClassCastException -> L28
                goto L18
            L15:
                if (r10.containsKey(KEY_SENDER) == false) goto L17;
                r5 = new Person.Builder().setName(r10.getCharSequence(KEY_SENDER)).build();     // Catch: ClassCastException -> L28
                goto L18
            L17:
                r5 = null;
            L27:
                return null;
            }

            @NonNull
            public static List<Message> getMessagesFromBundleArray(@NonNull Parcelable[] r5) {
                ArrayList r10 = new ArrayList(r5.length);
                int r11 = 0;
            L4:
                if (r11 >= r5.length) goto L11;
                Parcelable r12 = r5[r11];
                if ((r12 instanceof Bundle) == false) goto L10;
                Message r13 = getMessageFromBundle((Bundle) r12);
                if (r13 == null) goto L10;
                r10.add(r13);
            L10:
                r11 = r11 + 1;
                goto L4
            L11:
                return r10;
            }

            @NonNull
            private Bundle toBundle() {
                Bundle r5 = new Bundle();
                CharSequence r10 = this.mText;
                if (r10 == null) goto L5;
                r5.putCharSequence("text", r10);
            L5:
                r5.putLong(KEY_TIMESTAMP, this.mTimestamp);
                Person r11 = this.mPerson;
                if (r11 == null) goto L8;
                r5.putCharSequence(KEY_SENDER, r11.getName());
                r5.putParcelable(KEY_NOTIFICATION_PERSON, Api28Impl.castToParcelable(this.mPerson.toAndroidPerson()));
            L8:
                String r12 = this.mDataMimeType;
                if (r12 == null) goto L11;
                r5.putString("type", r12);
            L11:
                Uri r13 = this.mDataUri;
                if (r13 == null) goto L14;
                r5.putParcelable("uri", r13);
            L14:
                Bundle r14 = this.mExtras;
                if (r14 == null) goto L17;
                r5.putBundle(KEY_EXTRAS_BUNDLE, r14);
            L17:
                return r5;
            }

            @Nullable
            public String getDataMimeType() {
                return this.mDataMimeType;
            }

            @Nullable
            public Uri getDataUri() {
                return this.mDataUri;
            }

            @NonNull
            public Bundle getExtras() {
                return this.mExtras;
            }

            @Nullable
            public Person getPerson() {
                return this.mPerson;
            }

            @Nullable
            @Deprecated
            public CharSequence getSender() {
                Person r5 = this.mPerson;
                if (r5 != null) goto L6;
                return null;
            L6:
                return r5.getName();
            }

            @Nullable
            public CharSequence getText() {
                return this.mText;
            }

            public long getTimestamp() {
                return this.mTimestamp;
            }

            @NonNull
            public Message setData(@Nullable String r5, @Nullable Uri r10) {
                this.mDataMimeType = r5;
                this.mDataUri = r10;
                return this;
            }

            @NonNull
            @RequiresApi(24)
            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
            public Notification.MessagingStyle.Message toAndroidMessage() {
                Person r5 = getPerson();
                CharSequence r10 = getText();
                long r11 = getTimestamp();
                if (r5 != null) goto L5;
                android.app.Person r12 = null;
            L6:
                Notification.MessagingStyle.Message r13 = Api28Impl.createMessage(r10, r11, r12);
                if (getDataMimeType() == null) goto L9;
                Api24Impl.setData(r13, getDataMimeType(), getDataUri());
            L9:
                return r13;
            L5:
                r12 = r5.toAndroidPerson();
                goto L6
            }

            @Deprecated
            public Message(@Nullable CharSequence r5, long r10, @Nullable CharSequence r11) {
                this(r5, r10, new Person.Builder().setName(r11).build());
            }
        }

        public MessagingStyle() {
            this.mMessages = new ArrayList();
            this.mHistoricMessages = new ArrayList();
        }

        @Nullable
        public static MessagingStyle extractMessagingStyleFromNotification(@NonNull Notification r5) {
            Style r10 = Style.extractStyleFromNotification(r5);
            if ((r10 instanceof MessagingStyle) == true) goto L5;
            return null;
        L5:
            return (MessagingStyle) r10;
        }

        @Nullable
        private Message findLatestIncomingMessage() {
            int r5 = this.mMessages.size() - 1;
        L3:
            if (r5 < 0) goto L11;
            Message r10 = this.mMessages.get(r5);
            if (r10.getPerson() == null) goto L9;
            if (TextUtils.isEmpty(r10.getPerson().getName()) == true) goto L9;
            return r10;
        L9:
            r5 = r5 - 1;
            goto L3
        L11:
            if (this.mMessages.isEmpty() == false) goto L13;
            return null;
        L13:
            return (Message) j0.e(this.mMessages, 1);
        }

        private boolean hasMessagesWithoutSender() {
            int r5 = this.mMessages.size() - 1;
        L3:
            if (r5 < 0) goto L10;
            Message r10 = this.mMessages.get(r5);
            if (r10.getPerson() == null) goto L9;
            if (r10.getPerson().getName() != null) goto L9;
            return true;
        L9:
            r5 = r5 - 1;
            goto L3
        L10:
            return false;
        }

        @NonNull
        private TextAppearanceSpan makeFontColorSpan(int r10) {
            return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(r10), null);
        }

        private CharSequence makeMessageLine(@NonNull Message r10) {
            BidiFormatter r5 = BidiFormatter.getInstance();
            SpannableStringBuilder r11 = new SpannableStringBuilder();
            CharSequence r12 = "";
            if (r10.getPerson() != null) goto L5;
            CharSequence r13 = "";
        L6:
            boolean r14 = TextUtils.isEmpty(r13);
            int r15 = ViewCompat.MEASURED_STATE_MASK;
            if (r14 == false) goto L11;
            r13 = this.mUser.getName();
            if (this.mBuilder.getColor() == 0) goto L11;
            r15 = this.mBuilder.getColor();
        L11:
            CharSequence r16 = r5.unicodeWrap(r13);
            r11.append(r16);
            r11.setSpan(makeFontColorSpan(r15), r11.length() - r16.length(), r11.length(), 33);
            if (r10.getText() == null) goto L15;
            r12 = r10.getText();
        L15:
            r11.append("  ").append(r5.unicodeWrap(r12));
            return r11;
        L5:
            r13 = r10.getPerson().getName();
            goto L6
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void addCompatExtras(@NonNull Bundle r5) {
            super.addCompatExtras(r5);
            r5.putCharSequence(NotificationCompat.EXTRA_SELF_DISPLAY_NAME, this.mUser.getName());
            r5.putBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER, this.mUser.toBundle());
            r5.putCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE, this.mConversationTitle);
            if (this.mConversationTitle == null) goto L8;
            if (this.mIsGroupConversation.booleanValue() == false) goto L8;
            r5.putCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE, this.mConversationTitle);
        L8:
            if (this.mMessages.isEmpty() == true) goto L11;
            r5.putParcelableArray(NotificationCompat.EXTRA_MESSAGES, Message.getBundleArrayForMessages(this.mMessages));
        L11:
            if (this.mHistoricMessages.isEmpty() == true) goto L13;
            r5.putParcelableArray(NotificationCompat.EXTRA_HISTORIC_MESSAGES, Message.getBundleArrayForMessages(this.mHistoricMessages));
        L13:
            Boolean r10 = this.mIsGroupConversation;
            if (r10 == null) goto L17;
            r5.putBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION, r10.booleanValue());
            return;
        }

        @NonNull
        public MessagingStyle addHistoricMessage(@Nullable Message r5) {
            if (r5 == null) goto L6;
            this.mHistoricMessages.add(r5);
            if (this.mHistoricMessages.size() <= 25) goto L6;
            this.mHistoricMessages.remove(0);
        L6:
            return this;
        }

        @NonNull
        @Deprecated
        public MessagingStyle addMessage(@Nullable CharSequence r5, long r10, @Nullable CharSequence r11) {
            this.mMessages.add(new Message(r5, r10, new Person.Builder().setName(r11).build()));
            if (this.mMessages.size() <= 25) goto L5;
            this.mMessages.remove(0);
        L5:
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r5) {
            setGroupConversation(isGroupConversation());
            Notification.MessagingStyle r10 = Api28Impl.createMessagingStyle(this.mUser.toAndroidPerson());
            Iterator<Message> r11 = this.mMessages.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            Api24Impl.addMessage(r10, r11.next().toAndroidMessage());
            goto L4
        L6:
            Iterator<Message> r12 = this.mHistoricMessages.iterator();
        L8:
            if (r12.hasNext() == false) goto L10;
            Api26Impl.addHistoricMessage(r10, r12.next().toAndroidMessage());
            goto L8
        L10:
            this.mIsGroupConversation.booleanValue();
            Api24Impl.setConversationTitle(r10, this.mConversationTitle);
            Api28Impl.setGroupConversation(r10, this.mIsGroupConversation.booleanValue());
            r10.setBuilder(r5.getBuilder());
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@NonNull Bundle r5) {
            super.clearCompatExtraKeys(r5);
            r5.remove(NotificationCompat.EXTRA_MESSAGING_STYLE_USER);
            r5.remove(NotificationCompat.EXTRA_SELF_DISPLAY_NAME);
            r5.remove(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            r5.remove(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
            r5.remove(NotificationCompat.EXTRA_MESSAGES);
            r5.remove(NotificationCompat.EXTRA_HISTORIC_MESSAGES);
            r5.remove(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Nullable
        public CharSequence getConversationTitle() {
            return this.mConversationTitle;
        }

        @NonNull
        public List<Message> getHistoricMessages() {
            return this.mHistoricMessages;
        }

        @NonNull
        public List<Message> getMessages() {
            return this.mMessages;
        }

        @NonNull
        public Person getUser() {
            return this.mUser;
        }

        @Nullable
        @Deprecated
        public CharSequence getUserDisplayName() {
            return this.mUser.getName();
        }

        public boolean isGroupConversation() {
            Builder r5 = this.mBuilder;
            if (r5 != null) goto L5;
        L12:
            Boolean r10 = this.mIsGroupConversation;
            if (r10 != null) goto L15;
            return false;
        L15:
            return r10.booleanValue();
        L5:
            if (r5.mContext.getApplicationInfo().targetSdkVersion >= 28) goto L12;
            if (this.mIsGroupConversation != null) goto L12;
            if (this.mConversationTitle == null) goto L16;
            return true;
        L16:
            return false;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@NonNull Bundle r5) {
            super.restoreFromCompatExtras(r5);
            this.mMessages.clear();
            if (r5.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER) == false) goto L5;
            this.mUser = Person.fromBundle(r5.getBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER));
        L6:
            CharSequence r10 = r5.getCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            this.mConversationTitle = r10;
            if (r10 != null) goto L9;
            this.mConversationTitle = r5.getCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
        L9:
            Parcelable[] r11 = r5.getParcelableArray(NotificationCompat.EXTRA_MESSAGES);
            if (r11 == null) goto L12;
            this.mMessages.addAll(Message.getMessagesFromBundleArray(r11));
        L12:
            Parcelable[] r12 = r5.getParcelableArray(NotificationCompat.EXTRA_HISTORIC_MESSAGES);
            if (r12 == null) goto L16;
            this.mHistoricMessages.addAll(Message.getMessagesFromBundleArray(r12));
        L16:
            if (r5.containsKey(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION) == false) goto L19;
            this.mIsGroupConversation = Boolean.valueOf(r5.getBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION));
            return;
        L19:
            return;
        L5:
            this.mUser = new Person.Builder().setName(r5.getString(NotificationCompat.EXTRA_SELF_DISPLAY_NAME)).build();
            goto L6
        }

        @NonNull
        public MessagingStyle setConversationTitle(@Nullable CharSequence r5) {
            this.mConversationTitle = r5;
            return this;
        }

        @NonNull
        public MessagingStyle setGroupConversation(boolean r5) {
            this.mIsGroupConversation = Boolean.valueOf(r5);
            return this;
        }

        @Deprecated
        public MessagingStyle(@NonNull CharSequence r5) {
            this.mMessages = new ArrayList();
            this.mHistoricMessages = new ArrayList();
            this.mUser = new Person.Builder().setName(r5).build();
        }

        @NonNull
        public MessagingStyle addMessage(@Nullable CharSequence r5, long r10, @Nullable Person r11) {
            addMessage(new Message(r5, r10, r11));
            return this;
        }

        @NonNull
        public MessagingStyle addMessage(@Nullable Message r5) {
            if (r5 == null) goto L6;
            this.mMessages.add(r5);
            if (this.mMessages.size() <= 25) goto L6;
            this.mMessages.remove(0);
        L6:
            return this;
        }

        public MessagingStyle(@NonNull Person r5) {
            this.mMessages = new ArrayList();
            this.mHistoricMessages = new ArrayList();
            if (TextUtils.isEmpty(r5.getName()) == true) goto L7;
            this.mUser = r5;
            return;
        L7:
            throw new IllegalArgumentException("User's name must not be empty.");
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface NotificationVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ServiceNotificationBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface StreamType {
    }

    public static abstract class Style {
        CharSequence mBigContentTitle;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected Builder mBuilder;
        CharSequence mSummaryText;
        boolean mSummaryTextSet;

        @RequiresApi(24)
        public static class Api24Impl {
            private Api24Impl() {
            }

            @DoNotInline
            public static void setChronometerCountDown(RemoteViews r5, int r10, boolean r11) {
                r5.setChronometerCountDown(r10, r11);
            }
        }

        public Style() {
            this.mSummaryTextSet = false;
        }

        private int calculateTopPadding() {
            Resources r5 = this.mBuilder.mContext.getResources();
            int r10 = r5.getDimensionPixelSize(R.dimen.notification_top_pad);
            int r11 = r5.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
            float r12 = (constrain(r5.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return Math.round((r12 * r11) + ((1.0f - r12) * r10));
        }

        private static float constrain(float r5, float r10, float r11) {
            if (r5 >= r10) goto L6;
            return r10;
        L6:
            if (r5 > r11) goto L8;
            return r5;
        L8:
            return r11;
        }

        @Nullable
        public static Style constructCompatStyleByName(@Nullable String r5) {
            if (r5 == null) goto L44;
            byte r10 = -1;
            switch(r5.hashCode()) {
                case -716705180: goto L27;
                case -171946061: goto L23;
                case 714386739: goto L19;
                case 912942987: goto L15;
                case 919595044: goto L11;
                case 2090799565: goto L7;
                default: goto L30;
            };
        L30:
            switch(r10) {
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
            if (r5.equals("androidx.core.app.NotificationCompat$MessagingStyle") == false) goto L30;
            r10 = 5;
            goto L30
        L11:
            if (r5.equals("androidx.core.app.NotificationCompat$BigTextStyle") == false) goto L30;
            r10 = 4;
            goto L30
        L15:
            if (r5.equals("androidx.core.app.NotificationCompat$InboxStyle") == false) goto L30;
            r10 = 3;
            goto L30
        L19:
            if (r5.equals("androidx.core.app.NotificationCompat$CallStyle") == false) goto L30;
            r10 = 2;
            goto L30
        L23:
            if (r5.equals("androidx.core.app.NotificationCompat$BigPictureStyle") == false) goto L30;
            r10 = 1;
            goto L30
        L27:
            if (r5.equals("androidx.core.app.NotificationCompat$DecoratedCustomViewStyle") == false) goto L30;
            r10 = 0;
            goto L30
        L44:
            return null;
        }

        @Nullable
        private static Style constructCompatStyleByPlatformName(@Nullable String r5) {
            if (r5 != null) goto L6;
            return null;
        L6:
            if (r5.equals(Notification.BigPictureStyle.class.getName()) == false) goto L10;
            return new BigPictureStyle();
        L10:
            if (r5.equals(Notification.BigTextStyle.class.getName()) == false) goto L14;
            return new BigTextStyle();
        L14:
            if (r5.equals(Notification.InboxStyle.class.getName()) == false) goto L18;
            return new InboxStyle();
        L18:
            if (r5.equals(Notification.MessagingStyle.class.getName()) == false) goto L22;
            return new MessagingStyle();
        L22:
            if (r5.equals(Notification.DecoratedCustomViewStyle.class.getName()) == true) goto L24;
            return null;
        L24:
            return new DecoratedCustomViewStyle();
        }

        @Nullable
        public static Style constructCompatStyleForBundle(@NonNull Bundle r5) {
            Style r10 = constructCompatStyleByName(r5.getString(NotificationCompat.EXTRA_COMPAT_TEMPLATE));
            if (r10 == null) goto L6;
            return r10;
        L6:
            if (r5.containsKey(NotificationCompat.EXTRA_SELF_DISPLAY_NAME) == true) goto L32;
            if (r5.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER) == true) goto L32;
            if (r5.containsKey(NotificationCompat.EXTRA_PICTURE) == true) goto L30;
            if (r5.containsKey(NotificationCompat.EXTRA_PICTURE_ICON) == true) goto L30;
            if (r5.containsKey(NotificationCompat.EXTRA_BIG_TEXT) == false) goto L20;
            return new BigTextStyle();
        L20:
            if (r5.containsKey(NotificationCompat.EXTRA_TEXT_LINES) == false) goto L24;
            return new InboxStyle();
        L24:
            if (r5.containsKey(NotificationCompat.EXTRA_CALL_TYPE) == false) goto L28;
            return new CallStyle();
        L28:
            return constructCompatStyleByPlatformName(r5.getString(NotificationCompat.EXTRA_TEMPLATE));
        L30:
            return new BigPictureStyle();
        L32:
            return new MessagingStyle();
        }

        @Nullable
        public static Style constructStyleForExtras(@NonNull Bundle r5) {
            Style r10 = constructCompatStyleForBundle(r5);
            if (r10 != null) goto L8;
            return null;
        L8:
            r10.restoreFromCompatExtras(r5);     // Catch: ClassCastException -> L7
            return r10;
        L7:
            return null;
        }

        private Bitmap createIconWithBackground(int r5, int r10, int r11, int r12) {
            int r13 = R.drawable.notification_icon_background;
            if (r12 != 0) goto L5;
            r12 = 0;
        L5:
            Bitmap r14 = createColoredBitmap(r13, r12, r10);
            Canvas r15 = new Canvas(r14);
            Drawable r16 = this.mBuilder.mContext.getResources().getDrawable(r5).mutate();
            r16.setFilterBitmap(true);
            int r17 = (r10 - r11) / 2;
            int r18 = r11 + r17;
            r16.setBounds(r17, r17, r18, r18);
            r16.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            r16.draw(r15);
            return r14;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static Style extractStyleFromNotification(@NonNull Notification r5) {
            Bundle r10 = NotificationCompat.getExtras(r5);
            if (r10 != null) goto L7;
            return null;
        L7:
            return constructStyleForExtras(r10);
        }

        private void hideNormalContent(RemoteViews r5) {
            r5.setViewVisibility(R.id.title, 8);
            r5.setViewVisibility(R.id.text2, 8);
            r5.setViewVisibility(R.id.text, 8);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(@NonNull Bundle r5) {
            if (this.mSummaryTextSet == false) goto L5;
            r5.putCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT, this.mSummaryText);
        L5:
            CharSequence r10 = this.mBigContentTitle;
            if (r10 == null) goto L8;
            r5.putCharSequence(NotificationCompat.EXTRA_TITLE_BIG, r10);
        L8:
            String r11 = getClassName();
            if (r11 == null) goto L12;
            r5.putString(NotificationCompat.EXTRA_COMPAT_TEMPLATE, r11);
            return;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r5) {
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews applyStandardTemplate(boolean r12, int r13, boolean r14) {
            Resources r5 = this.mBuilder.mContext.getResources();
            RemoteViews r10 = new RemoteViews(this.mBuilder.mContext.getPackageName(), r13);
            this.mBuilder.getPriority();
            Builder r15 = this.mBuilder;
            int r11 = 0;
            if (r15.mLargeIcon == null) goto L9;
            r10.setViewVisibility(R.id.icon, 0);
            r10.setImageViewBitmap(R.id.icon, createColoredBitmap(this.mBuilder.mLargeIcon, 0));
            if (r12 == true) goto L7;
        L13:
            CharSequence r16 = this.mBuilder.mContentTitle;
            if (r16 == null) goto L16;
            r10.setTextViewText(R.id.title, r16);
        L16:
            CharSequence r17 = this.mBuilder.mContentText;
            boolean r18 = true;
            if (r17 == null) goto L19;
            r10.setTextViewText(R.id.text, r17);
            boolean r19 = true;
        L20:
            Builder r20 = this.mBuilder;
            CharSequence r21 = r20.mContentInfo;
            if (r21 == null) goto L25;
            r10.setTextViewText(R.id.info, r21);
            r10.setViewVisibility(R.id.info, 0);
        L23:
            r19 = true;
            boolean r110 = true;
        L32:
            CharSequence r22 = this.mBuilder.mSubText;
            if (r22 == null) goto L42;
            r10.setTextViewText(R.id.text, r22);
            CharSequence r23 = this.mBuilder.mContentText;
            if (r23 == null) goto L40;
            r10.setTextViewText(R.id.text2, r23);
            r10.setViewVisibility(R.id.text2, 0);
            if (r14 == false) goto L39;
            r10.setTextViewTextSize(R.id.text, 0, r5.getDimensionPixelSize(R.dimen.notification_subtext_size));
        L39:
            r10.setViewPadding(R.id.line1, 0, 0, 0, 0);
            goto L42
        L40:
            r10.setViewVisibility(R.id.text2, 8);
        L42:
            if (this.mBuilder.getWhenIfShowing() != 0) goto L44;
            r18 = r110;
        L50:
            int r111 = R.id.right_side;
            if (r18 == false) goto L53;
            int r112 = 0;
        L54:
            r10.setViewVisibility(r111, r112);
            int r113 = R.id.line3;
            if (r19 == true) goto L58;
            r11 = 8;
        L58:
            r10.setViewVisibility(r113, r11);
            return r10;
        L53:
            r112 = 8;
            goto L54
        L44:
            if (this.mBuilder.mUseChronometer == false) goto L48;
            r10.setViewVisibility(R.id.chronometer, 0);
            r10.setLong(R.id.chronometer, "setBase", (SystemClock.elapsedRealtime() - System.currentTimeMillis()) + this.mBuilder.getWhenIfShowing());
            r10.setBoolean(R.id.chronometer, "setStarted", true);
            boolean r114 = this.mBuilder.mChronometerCountDown;
            if (r114 == false) goto L50;
            Api24Impl.setChronometerCountDown(r10, R.id.chronometer, r114);
            goto L50
        L48:
            r10.setViewVisibility(R.id.time, 0);
            r10.setLong(R.id.time, "setTime", this.mBuilder.getWhenIfShowing());
            goto L50
        L25:
            if (r20.mNumber > 0) goto L27;
            r10.setViewVisibility(R.id.info, 8);
            r110 = false;
            goto L32
        L27:
            if (this.mBuilder.mNumber <= r5.getInteger(R.integer.status_bar_notification_info_maxnum)) goto L29;
            r10.setTextViewText(R.id.info, r5.getString(R.string.status_bar_notification_info_overflow));
        L30:
            r10.setViewVisibility(R.id.info, 0);
            goto L23
        L29:
            r10.setTextViewText(R.id.info, NumberFormat.getIntegerInstance().format(this.mBuilder.mNumber));
            goto L30
        L19:
            r19 = false;
            goto L20
        L7:
            if (this.mBuilder.mNotification.icon == 0) goto L13;
            int r115 = r5.getDimensionPixelSize(R.dimen.notification_right_icon_size);
            int r116 = r115 - (r5.getDimensionPixelSize(R.dimen.notification_small_icon_background_padding) * 2);
            Builder r24 = this.mBuilder;
            r10.setImageViewBitmap(R.id.right_icon, createIconWithBackground(r24.mNotification.icon, r115, r116, r24.getColor()));
            r10.setViewVisibility(R.id.right_icon, 0);
            goto L13
        L9:
            if (r12 == false) goto L13;
            if (r15.mNotification.icon == 0) goto L13;
            r10.setViewVisibility(R.id.icon, 0);
            int r117 = r5.getDimensionPixelSize(R.dimen.notification_large_icon_width) - r5.getDimensionPixelSize(R.dimen.notification_big_circle_margin);
            int r118 = r5.getDimensionPixelSize(R.dimen.notification_small_icon_size_as_large);
            Builder r25 = this.mBuilder;
            r10.setImageViewBitmap(R.id.icon, createIconWithBackground(r25.mNotification.icon, r117, r118, r25.getColor()));
            goto L13
        }

        @Nullable
        public Notification build() {
            Builder r5 = this.mBuilder;
            if (r5 != null) goto L7;
            return null;
        L7:
            return r5.build();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void buildIntoRemoteViews(RemoteViews r10, RemoteViews r11) {
            hideNormalContent(r10);
            r10.removeAllViews(R.id.notification_main_column);
            r10.addView(R.id.notification_main_column, r11.clone());
            r10.setViewVisibility(R.id.notification_main_column, 0);
            int r5 = calculateTopPadding();
            r10.setViewPadding(R.id.notification_main_column_container, 0, r5, 0, 0);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@NonNull Bundle r5) {
            r5.remove(NotificationCompat.EXTRA_SUMMARY_TEXT);
            r5.remove(NotificationCompat.EXTRA_TITLE_BIG);
            r5.remove(NotificationCompat.EXTRA_COMPAT_TEMPLATE);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Bitmap createColoredBitmap(int r5, int r10) {
            return createColoredBitmap(r5, r10, 0);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean displayCustomViewInline() {
            return false;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String getClassName() {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r5) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r5) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor r5) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@NonNull Bundle r5) {
            if (r5.containsKey(NotificationCompat.EXTRA_SUMMARY_TEXT) == false) goto L5;
            this.mSummaryText = r5.getCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT);
            this.mSummaryTextSet = true;
        L5:
            this.mBigContentTitle = r5.getCharSequence(NotificationCompat.EXTRA_TITLE_BIG);
        }

        public void setBuilder(@Nullable Builder r5) {
            if (this.mBuilder == r5) goto L8;
            this.mBuilder = r5;
            if (r5 == null) goto L9;
            r5.setStyle(this);
            return;
        L9:
            return;
        }

        public Bitmap createColoredBitmap(@NonNull IconCompat r5, int r10) {
            return createColoredBitmap(r5, r10, 0);
        }

        private Bitmap createColoredBitmap(int r5, int r10, int r11) {
            return createColoredBitmap(IconCompat.createWithResource(this.mBuilder.mContext, r5), r10, r11);
        }

        private Bitmap createColoredBitmap(@NonNull IconCompat r5, int r10, int r11) {
            Drawable r12 = r5.loadDrawable(this.mBuilder.mContext);
            if (r11 != 0) goto L5;
            int r13 = r12.getIntrinsicWidth();
        L6:
            if (r11 != 0) goto L8;
            r11 = r12.getIntrinsicHeight();
        L8:
            Bitmap r14 = Bitmap.createBitmap(r13, r11, Bitmap.Config.ARGB_8888);
            r12.setBounds(0, 0, r13, r11);
            if (r10 == 0) goto L11;
            r12.mutate().setColorFilter(new PorterDuffColorFilter(r10, PorterDuff.Mode.SRC_IN));
        L11:
            r12.draw(new Canvas(r14));
            return r14;
        L5:
            r13 = r11;
            goto L6
        }
    }

    public static final class TvExtender implements Extender {
        static final String EXTRA_CHANNEL_ID = "channel_id";
        static final String EXTRA_CONTENT_INTENT = "content_intent";
        static final String EXTRA_DELETE_INTENT = "delete_intent";

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        private static final String EXTRA_FLAGS = "flags";
        static final String EXTRA_SUPPRESS_SHOW_OVER_APPS = "suppressShowOverApps";

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
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

        @Override // androidx.core.app.NotificationCompat.Extender
        @NonNull
        public Builder extend(@NonNull Builder r5) {
            Bundle r10 = new Bundle();
            r10.putInt("flags", this.mFlags);
            r10.putString("channel_id", this.mChannelId);
            r10.putBoolean(EXTRA_SUPPRESS_SHOW_OVER_APPS, this.mSuppressShowOverApps);
            PendingIntent r11 = this.mContentIntent;
            if (r11 == null) goto L5;
            r10.putParcelable(EXTRA_CONTENT_INTENT, r11);
        L5:
            PendingIntent r12 = this.mDeleteIntent;
            if (r12 == null) goto L8;
            r10.putParcelable(EXTRA_DELETE_INTENT, r12);
        L8:
            r5.getExtras().putBundle(EXTRA_TV_EXTENDER, r10);
            return r5;
        }

        @Nullable
        public String getChannelId() {
            return this.mChannelId;
        }

        @Nullable
        public PendingIntent getContentIntent() {
            return this.mContentIntent;
        }

        @Nullable
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

        @NonNull
        public TvExtender setChannelId(@Nullable String r5) {
            this.mChannelId = r5;
            return this;
        }

        @NonNull
        public TvExtender setContentIntent(@Nullable PendingIntent r5) {
            this.mContentIntent = r5;
            return this;
        }

        @NonNull
        public TvExtender setDeleteIntent(@Nullable PendingIntent r5) {
            this.mDeleteIntent = r5;
            return this;
        }

        @NonNull
        public TvExtender setSuppressShowOverApps(boolean r5) {
            this.mSuppressShowOverApps = r5;
            return this;
        }

        public TvExtender(@NonNull Notification r5) {
            Bundle r10 = r5.extras;
            if (r10 != null) goto L5;
            Bundle r11 = null;
        L6:
            if (r11 == null) goto L9;
            this.mFlags = r11.getInt("flags");
            this.mChannelId = r11.getString("channel_id");
            this.mSuppressShowOverApps = r11.getBoolean(EXTRA_SUPPRESS_SHOW_OVER_APPS);
            this.mContentIntent = (PendingIntent) r11.getParcelable(EXTRA_CONTENT_INTENT);
            this.mDeleteIntent = (PendingIntent) r11.getParcelable(EXTRA_DELETE_INTENT);
            return;
        L9:
            return;
        L5:
            r11 = r10.getBundle(EXTRA_TV_EXTENDER);
            goto L6
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

        @RequiresApi(20)
        public static class Api20Impl {
            private Api20Impl() {
            }

            @DoNotInline
            public static Notification.Action.Builder addExtras(Notification.Action.Builder r5, Bundle r10) {
                return r5.addExtras(r10);
            }

            @DoNotInline
            public static Notification.Action.Builder addRemoteInput(Notification.Action.Builder r5, android.app.RemoteInput r10) {
                return r5.addRemoteInput(r10);
            }

            @DoNotInline
            public static Notification.Action build(Notification.Action.Builder r5) {
                return r5.build();
            }

            @DoNotInline
            public static Notification.Action.Builder createBuilder(int r5, CharSequence r10, PendingIntent r11) {
                return new Notification.Action.Builder(r5, r10, r11);
            }

            @DoNotInline
            public static Action getActionCompatFromAction(ArrayList<Parcelable> r5, int r10) {
                return NotificationCompat.getActionCompatFromAction((Notification.Action) r5.get(r10));
            }
        }

        @RequiresApi(23)
        public static class Api23Impl {
            private Api23Impl() {
            }

            @DoNotInline
            public static Notification.Action.Builder createBuilder(Icon r5, CharSequence r10, PendingIntent r11) {
                return new Notification.Action.Builder(r5, r10, r11);
            }
        }

        @RequiresApi(24)
        public static class Api24Impl {
            private Api24Impl() {
            }

            @DoNotInline
            public static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder r5, boolean r10) {
                return r5.setAllowGeneratedReplies(r10);
            }
        }

        @RequiresApi(31)
        public static class Api31Impl {
            private Api31Impl() {
            }

            @DoNotInline
            public static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder r5, boolean r10) {
                return r5.setAuthenticationRequired(r10);
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

        @RequiresApi(20)
        private static Notification.Action getActionFromActionCompat(Action r5) {
            IconCompat r10 = r5.getIconCompat();
            if (r10 != null) goto L5;
            Icon r11 = null;
        L6:
            Notification.Action.Builder r12 = Api23Impl.createBuilder(r11, r5.getTitle(), r5.getActionIntent());
            if (r5.getExtras() == null) goto L9;
            Bundle r13 = new Bundle(r5.getExtras());
        L10:
            r13.putBoolean("android.support.allowGeneratedReplies", r5.getAllowGeneratedReplies());
            Api24Impl.setAllowGeneratedReplies(r12, r5.getAllowGeneratedReplies());
            Api31Impl.setAuthenticationRequired(r12, r5.isAuthenticationRequired());
            Api20Impl.addExtras(r12, r13);
            RemoteInput[] r14 = r5.getRemoteInputs();
            if (r14 == null) goto L16;
            android.app.RemoteInput[] r15 = RemoteInput.fromCompat(r14);
            int r16 = r15.length;
            int r17 = 0;
        L13:
            if (r17 >= r16) goto L16;
            Api20Impl.addRemoteInput(r12, r15[r17]);
            r17 = r17 + 1;
        L16:
            return Api20Impl.build(r12);
        L9:
            r13 = new Bundle();
            goto L10
        L5:
            r11 = r10.toIcon();
            goto L6
        }

        private void setFlag(int r5, boolean r10) {
            if (r10 == false) goto L4;
            this.mFlags = r5 | this.mFlags;
            return;
        L4:
            int r11 = this.mFlags;
            this.mFlags = (~r5) & r11;
        }

        @NonNull
        public WearableExtender addAction(@NonNull Action r5) {
            this.mActions.add(r5);
            return this;
        }

        @NonNull
        public WearableExtender addActions(@NonNull List<Action> r5) {
            this.mActions.addAll(r5);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender addPage(@NonNull Notification r5) {
            this.mPages.add(r5);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender addPages(@NonNull List<Notification> r5) {
            this.mPages.addAll(r5);
            return this;
        }

        @NonNull
        public WearableExtender clearActions() {
            this.mActions.clear();
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender clearPages() {
            this.mPages.clear();
            return this;
        }

        @NonNull
        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m48clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        @NonNull
        public Builder extend(@NonNull Builder r5) {
            Bundle r10 = new Bundle();
            if (this.mActions.isEmpty() == true) goto L9;
            ArrayList<? extends Parcelable> r11 = new ArrayList(this.mActions.size());
            Iterator<Action> r12 = this.mActions.iterator();
        L6:
            if (r12.hasNext() == false) goto L8;
            r11.add(getActionFromActionCompat(r12.next()));
            goto L6
        L8:
            r10.putParcelableArrayList(KEY_ACTIONS, r11);
        L9:
            int r13 = this.mFlags;
            if (r13 == 1) goto L12;
            r10.putInt("flags", r13);
        L12:
            PendingIntent r14 = this.mDisplayIntent;
            if (r14 == null) goto L16;
            r10.putParcelable(KEY_DISPLAY_INTENT, r14);
        L16:
            if (this.mPages.isEmpty() == true) goto L18;
            ArrayList<Notification> r15 = this.mPages;
            r10.putParcelableArray(KEY_PAGES, (Parcelable[]) r15.toArray(new Notification[r15.size()]));
        L18:
            Bitmap r16 = this.mBackground;
            if (r16 == null) goto L21;
            r10.putParcelable(KEY_BACKGROUND, r16);
        L21:
            int r17 = this.mContentIcon;
            if (r17 == 0) goto L24;
            r10.putInt(KEY_CONTENT_ICON, r17);
        L24:
            int r18 = this.mContentIconGravity;
            if (r18 == 8388613) goto L27;
            r10.putInt(KEY_CONTENT_ICON_GRAVITY, r18);
        L27:
            int r19 = this.mContentActionIndex;
            if (r19 == (-1)) goto L30;
            r10.putInt(KEY_CONTENT_ACTION_INDEX, r19);
        L30:
            int r20 = this.mCustomSizePreset;
            if (r20 == 0) goto L33;
            r10.putInt(KEY_CUSTOM_SIZE_PRESET, r20);
        L33:
            int r21 = this.mCustomContentHeight;
            if (r21 == 0) goto L36;
            r10.putInt(KEY_CUSTOM_CONTENT_HEIGHT, r21);
        L36:
            int r22 = this.mGravity;
            if (r22 == 80) goto L39;
            r10.putInt(KEY_GRAVITY, r22);
        L39:
            int r23 = this.mHintScreenTimeout;
            if (r23 == 0) goto L42;
            r10.putInt(KEY_HINT_SCREEN_TIMEOUT, r23);
        L42:
            String r24 = this.mDismissalId;
            if (r24 == null) goto L45;
            r10.putString(KEY_DISMISSAL_ID, r24);
        L45:
            String r25 = this.mBridgeTag;
            if (r25 == null) goto L48;
            r10.putString(KEY_BRIDGE_TAG, r25);
        L48:
            r5.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, r10);
            return r5;
        }

        @NonNull
        public List<Action> getActions() {
            return this.mActions;
        }

        @Nullable
        @Deprecated
        public Bitmap getBackground() {
            return this.mBackground;
        }

        @Nullable
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

        @Nullable
        public String getDismissalId() {
            return this.mDismissalId;
        }

        @Nullable
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

        @NonNull
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

        @NonNull
        @Deprecated
        public WearableExtender setBackground(@Nullable Bitmap r5) {
            this.mBackground = r5;
            return this;
        }

        @NonNull
        public WearableExtender setBridgeTag(@Nullable String r5) {
            this.mBridgeTag = r5;
            return this;
        }

        @NonNull
        public WearableExtender setContentAction(int r5) {
            this.mContentActionIndex = r5;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setContentIcon(int r5) {
            this.mContentIcon = r5;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setContentIconGravity(int r5) {
            this.mContentIconGravity = r5;
            return this;
        }

        @NonNull
        public WearableExtender setContentIntentAvailableOffline(boolean r5) {
            setFlag(1, r5);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setCustomContentHeight(int r5) {
            this.mCustomContentHeight = r5;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setCustomSizePreset(int r5) {
            this.mCustomSizePreset = r5;
            return this;
        }

        @NonNull
        public WearableExtender setDismissalId(@Nullable String r5) {
            this.mDismissalId = r5;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setDisplayIntent(@Nullable PendingIntent r5) {
            this.mDisplayIntent = r5;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setGravity(int r5) {
            this.mGravity = r5;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintAmbientBigPicture(boolean r5) {
            setFlag(32, r5);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintAvoidBackgroundClipping(boolean r5) {
            setFlag(16, r5);
            return this;
        }

        @NonNull
        public WearableExtender setHintContentIntentLaunchesActivity(boolean r5) {
            setFlag(64, r5);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintHideIcon(boolean r5) {
            setFlag(2, r5);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintScreenTimeout(int r5) {
            this.mHintScreenTimeout = r5;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintShowBackgroundOnly(boolean r5) {
            setFlag(4, r5);
            return this;
        }

        @NonNull
        public WearableExtender setStartScrollBottom(boolean r5) {
            setFlag(8, r5);
            return this;
        }

        @NonNull
        public WearableExtender clone() {
            WearableExtender r5 = new WearableExtender();
            r5.mActions = new ArrayList(this.mActions);
            r5.mFlags = this.mFlags;
            r5.mDisplayIntent = this.mDisplayIntent;
            r5.mPages = new ArrayList(this.mPages);
            r5.mBackground = this.mBackground;
            r5.mContentIcon = this.mContentIcon;
            r5.mContentIconGravity = this.mContentIconGravity;
            r5.mContentActionIndex = this.mContentActionIndex;
            r5.mCustomSizePreset = this.mCustomSizePreset;
            r5.mCustomContentHeight = this.mCustomContentHeight;
            r5.mGravity = this.mGravity;
            r5.mHintScreenTimeout = this.mHintScreenTimeout;
            r5.mDismissalId = this.mDismissalId;
            r5.mBridgeTag = this.mBridgeTag;
            return r5;
        }

        public WearableExtender(@NonNull Notification r11) {
            this.mActions = new ArrayList();
            this.mFlags = 1;
            this.mPages = new ArrayList();
            this.mContentIconGravity = 8388613;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = 80;
            Bundle r12 = NotificationCompat.getExtras(r11);
            if (r12 == null) goto L5;
            Bundle r13 = r12.getBundle(EXTRA_WEARABLE_EXTENSIONS);
        L6:
            if (r13 == null) goto L19;
            ArrayList r5 = r13.getParcelableArrayList(KEY_ACTIONS);
            if (r5 == null) goto L13;
            int r10 = r5.size();
            Action[] r14 = new Action[r10];
            int r15 = 0;
        L10:
            if (r15 >= r10) goto L12;
            r14[r15] = Api20Impl.getActionCompatFromAction(r5, r15);
            r15 = r15 + 1;
            goto L10
        L12:
            Collections.addAll(this.mActions, r14);
        L13:
            this.mFlags = r13.getInt("flags", 1);
            this.mDisplayIntent = (PendingIntent) r13.getParcelable(KEY_DISPLAY_INTENT);
            Notification[] r16 = NotificationCompat.getNotificationArrayFromBundle(r13, KEY_PAGES);
            if (r16 == null) goto L16;
            Collections.addAll(this.mPages, r16);
        L16:
            this.mBackground = (Bitmap) r13.getParcelable(KEY_BACKGROUND);
            this.mContentIcon = r13.getInt(KEY_CONTENT_ICON);
            this.mContentIconGravity = r13.getInt(KEY_CONTENT_ICON_GRAVITY, 8388613);
            this.mContentActionIndex = r13.getInt(KEY_CONTENT_ACTION_INDEX, -1);
            this.mCustomSizePreset = r13.getInt(KEY_CUSTOM_SIZE_PRESET, 0);
            this.mCustomContentHeight = r13.getInt(KEY_CUSTOM_CONTENT_HEIGHT);
            this.mGravity = r13.getInt(KEY_GRAVITY, 80);
            this.mHintScreenTimeout = r13.getInt(KEY_HINT_SCREEN_TIMEOUT);
            this.mDismissalId = r13.getString(KEY_DISMISSAL_ID);
            this.mBridgeTag = r13.getString(KEY_BRIDGE_TAG);
            return;
        L19:
            return;
        L5:
            r13 = null;
            goto L6
        }
    }

    @Deprecated
    public NotificationCompat() {
    }

    @Nullable
    public static Action getAction(@NonNull Notification r5, int r10) {
        return getActionCompatFromAction(r5.actions[r10]);
    }

    @NonNull
    @RequiresApi(20)
    public static Action getActionCompatFromAction(@NonNull Notification.Action r18) {
        android.app.RemoteInput[] r5 = Api20Impl.getRemoteInputs(r18);
        IconCompat r10 = null;
        if (r5 != null) goto L5;
        RemoteInput[] r11 = null;
    L11:
        if (Api20Impl.getExtras(r18).getBoolean("android.support.allowGeneratedReplies") == false) goto L13;
    L16:
        boolean r13 = true;
    L17:
        boolean r15 = Api20Impl.getExtras(r18).getBoolean("android.support.action.showsUserInterface", true);
        int r14 = Api28Impl.getSemanticAction(r18);
        boolean r16 = Api29Impl.isContextual(r18);
        boolean r17 = Api31Impl.isAuthenticationRequired(r18);
        if (Api23Impl.getIcon(r18) != null) goto L24;
        int r12 = r18.icon;
        if (r12 == 0) goto L24;
        return new Action(r12, r18.title, r18.actionIntent, Api20Impl.getExtras(r18), r11, null, r13, r14, r15, r16, r17);
    L24:
        if (Api23Impl.getIcon(r18) == null) goto L28;
        r10 = IconCompat.createFromIconOrNullIfZeroResId(Api23Impl.getIcon(r18));
    L28:
        return new Action(r10, r18.title, r18.actionIntent, Api20Impl.getExtras(r18), r11, null, r13, r14, r15, r16, r17);
    L13:
        if (Api24Impl.getAllowGeneratedReplies(r18) == true) goto L16;
        r13 = false;
        goto L17
    L5:
        RemoteInput[] r19 = new RemoteInput[r5.length];
        int r20 = 0;
    L7:
        if (r20 >= r5.length) goto L9;
        android.app.RemoteInput r21 = r5[r20];
        r19[r20] = new RemoteInput(Api20Impl.getResultKey(r21), Api20Impl.getLabel(r21), Api20Impl.getChoices(r21), Api20Impl.getAllowFreeFormInput(r21), Api29Impl.getEditChoicesBeforeSending(r21), Api20Impl.getExtras(r21), null);
        r20 = r20 + 1;
        goto L7
    L9:
        r11 = r19;
        goto L11
    }

    public static int getActionCount(@NonNull Notification r5) {
        Notification.Action[] r10 = r5.actions;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.length;
    }

    public static boolean getAllowSystemGeneratedContextualActions(@NonNull Notification r5) {
        return Api29Impl.getAllowSystemGeneratedContextualActions(r5);
    }

    public static boolean getAutoCancel(@NonNull Notification r5) {
        if ((r5.flags & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static int getBadgeIconType(@NonNull Notification r5) {
        return Api26Impl.getBadgeIconType(r5);
    }

    @Nullable
    public static BubbleMetadata getBubbleMetadata(@NonNull Notification r5) {
        return BubbleMetadata.fromPlatform(Api29Impl.getBubbleMetadata(r5));
    }

    @Nullable
    public static String getCategory(@NonNull Notification r5) {
        return r5.category;
    }

    @Nullable
    public static String getChannelId(@NonNull Notification r5) {
        return Api26Impl.getChannelId(r5);
    }

    public static int getColor(@NonNull Notification r5) {
        return r5.color;
    }

    @Nullable
    public static CharSequence getContentInfo(@NonNull Notification r5) {
        return r5.extras.getCharSequence(EXTRA_INFO_TEXT);
    }

    @Nullable
    public static CharSequence getContentText(@NonNull Notification r5) {
        return r5.extras.getCharSequence(EXTRA_TEXT);
    }

    @Nullable
    public static CharSequence getContentTitle(@NonNull Notification r5) {
        return r5.extras.getCharSequence(EXTRA_TITLE);
    }

    @Nullable
    public static Bundle getExtras(@NonNull Notification r5) {
        return r5.extras;
    }

    @Nullable
    public static String getGroup(@NonNull Notification r5) {
        return Api20Impl.getGroup(r5);
    }

    public static int getGroupAlertBehavior(@NonNull Notification r5) {
        return Api26Impl.getGroupAlertBehavior(r5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static boolean getHighPriority(@NonNull Notification r5) {
        if ((r5.flags & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @NonNull
    @RequiresApi(21)
    public static List<Action> getInvisibleActions(@NonNull Notification r5) {
        ArrayList r10 = new ArrayList();
        Bundle r11 = r5.extras.getBundle("android.car.EXTENSIONS");
        if (r11 != null) goto L5;
        return r10;
    L5:
        Bundle r12 = r11.getBundle("invisible_actions");
        if (r12 == null) goto L11;
        int r13 = 0;
    L9:
        if (r13 >= r12.size()) goto L11;
        r10.add(NotificationCompatJellybean.getActionFromBundle(r12.getBundle(Integer.toString(r13))));
        r13 = r13 + 1;
    L11:
        return r10;
    }

    public static boolean getLocalOnly(@NonNull Notification r5) {
        if ((r5.flags & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Nullable
    public static LocusIdCompat getLocusId(@NonNull Notification r5) {
        LocusId r10 = Api29Impl.getLocusId(r5);
        if (r10 != null) goto L6;
        return null;
    L6:
        return LocusIdCompat.toLocusIdCompat(r10);
    }

    @NonNull
    public static Notification[] getNotificationArrayFromBundle(@NonNull Bundle r5, @NonNull String r10) {
        Parcelable[] r11 = r5.getParcelableArray(r10);
        if ((r11 instanceof Notification[]) == true) goto L13;
        if (r11 == null) goto L13;
        Notification[] r12 = new Notification[r11.length];
        int r13 = 0;
    L8:
        if (r13 >= r11.length) goto L10;
        r12[r13] = (Notification) r11[r13];
        r13 = r13 + 1;
        goto L8
    L10:
        r5.putParcelableArray(r10, r12);
        return r12;
    L13:
        return (Notification[]) r11;
    }

    public static boolean getOngoing(@NonNull Notification r5) {
        if ((r5.flags & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean getOnlyAlertOnce(@NonNull Notification r5) {
        if ((r5.flags & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @NonNull
    public static List<Person> getPeople(@NonNull Notification r5) {
        ArrayList r10 = new ArrayList();
        ArrayList r11 = r5.extras.getParcelableArrayList(EXTRA_PEOPLE_LIST);
        if (r11 != null) goto L5;
    L10:
        return r10;
    L5:
        if (r11.isEmpty() == true) goto L10;
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        r10.add(Person.fromAndroidPerson((android.app.Person) r12.next()));
        goto L8
    }

    @Nullable
    public static Notification getPublicVersion(@NonNull Notification r5) {
        return r5.publicVersion;
    }

    @Nullable
    public static CharSequence getSettingsText(@NonNull Notification r5) {
        return Api26Impl.getSettingsText(r5);
    }

    @Nullable
    public static String getShortcutId(@NonNull Notification r5) {
        return Api26Impl.getShortcutId(r5);
    }

    public static boolean getShowWhen(@NonNull Notification r5) {
        return r5.extras.getBoolean(EXTRA_SHOW_WHEN);
    }

    @Nullable
    public static String getSortKey(@NonNull Notification r5) {
        return Api20Impl.getSortKey(r5);
    }

    @Nullable
    public static CharSequence getSubText(@NonNull Notification r5) {
        return r5.extras.getCharSequence(EXTRA_SUB_TEXT);
    }

    public static long getTimeoutAfter(@NonNull Notification r5) {
        return Api26Impl.getTimeoutAfter(r5);
    }

    public static boolean getUsesChronometer(@NonNull Notification r5) {
        return r5.extras.getBoolean(EXTRA_SHOW_CHRONOMETER);
    }

    public static int getVisibility(@NonNull Notification r5) {
        return r5.visibility;
    }

    public static boolean isGroupSummary(@NonNull Notification r5) {
        if ((r5.flags & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Nullable
    public static Bitmap reduceLargeIconSize(@NonNull Context r5, @Nullable Bitmap r10) {
        return r10;
    }
}
