package androidx.core.app;

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
            static class Api20Impl {
                private Api20Impl() {
                }

                @DoNotInline
                static android.app.RemoteInput[] getRemoteInputs(Notification.Action r10) {
                    return r10.getRemoteInputs();
                }
            }

            @RequiresApi(23)
            static class Api23Impl {
                private Api23Impl() {
                }

                @DoNotInline
                static Icon getIcon(Notification.Action r10) {
                    return r10.getIcon();
                }
            }

            @RequiresApi(24)
            static class Api24Impl {
                private Api24Impl() {
                }

                @DoNotInline
                static boolean getAllowGeneratedReplies(Notification.Action r10) {
                    return r10.getAllowGeneratedReplies();
                }
            }

            @RequiresApi(28)
            static class Api28Impl {
                private Api28Impl() {
                }

                @DoNotInline
                static int getSemanticAction(Notification.Action r10) {
                    return r10.getSemanticAction();
                }
            }

            @RequiresApi(29)
            static class Api29Impl {
                private Api29Impl() {
                }

                @DoNotInline
                static boolean isContextual(Notification.Action r10) {
                    return r10.isContextual();
                }
            }

            @RequiresApi(31)
            static class Api31Impl {
                private Api31Impl() {
                }

                @DoNotInline
                static boolean isAuthenticationRequired(Notification.Action r10) {
                    return r10.isAuthenticationRequired();
                }
            }

            public Builder(int r13, @Nullable CharSequence r14, @Nullable PendingIntent r15) {
                IconCompat r10 = null;
                if (r13 == 0) goto L6;
                r10 = IconCompat.createWithResource(null, "", r13);
            L6:
                this(r10, r14, r15, new Bundle(), null, true, 0, true, false, false);
            }

            public Builder(@NonNull Action r12) {
                this(r12.getIconCompat(), r12.title, r12.actionIntent, new Bundle(r12.mExtras), r12.getRemoteInputs(), r12.getAllowGeneratedReplies(), r12.getSemanticAction(), r12.mShowsUserInterface, r12.isContextual(), r12.isAuthenticationRequired());
            }

            public Builder(@Nullable IconCompat r12, @Nullable CharSequence r13, @Nullable PendingIntent r14) {
                this(r12, r13, r14, new Bundle(), null, true, 0, true, false, false);
            }

            private Builder(@Nullable IconCompat r10, @Nullable CharSequence r11, @Nullable PendingIntent r12, @NonNull Bundle r13, @Nullable RemoteInput[] r14, boolean r15, int r16, boolean r17, boolean r18, boolean r19) {
                this.mAllowGeneratedReplies = true;
                this.mShowsUserInterface = true;
                this.mIcon = r10;
                this.mTitle = Builder.limitCharSequenceLength(r11);
                this.mIntent = r12;
                this.mExtras = r13;
                if (r14 != null) goto L5;
                ArrayList<RemoteInput> r20 = null;
            L6:
                this.mRemoteInputs = r20;
                this.mAllowGeneratedReplies = r15;
                this.mSemanticAction = r16;
                this.mShowsUserInterface = r17;
                this.mIsContextual = r18;
                this.mAuthenticationRequired = r19;
                return;
            L5:
                r20 = new ArrayList(Arrays.asList(r14));
                goto L6
            }

            private void checkContextualActionNullFields() {
                if (this.mIsContextual == true) goto L5;
                return;
            L5:
                Objects.requireNonNull(this.mIntent, "Contextual Actions must contain a valid PendingIntent");
            }

            @NonNull
            @RequiresApi(19)
            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
            public static Builder fromAndroidAction(@NonNull Notification.Action r10) {
                int r11 = Build.VERSION.SDK_INT;
                if (r11 >= 23) goto L5;
            L7:
                Builder r12 = new Builder(r10.icon, r10.title, r10.actionIntent);
            L9:
                if (r11 < 20) goto L17;
                android.app.RemoteInput[] r13 = Api20Impl.getRemoteInputs(r10);
                if (r13 == null) goto L17;
                if (r13.length == 0) goto L17;
                int r14 = r13.length;
                int r15 = 0;
            L15:
                if (r15 >= r14) goto L17;
                r12.addRemoteInput(RemoteInput.fromPlatform(r13[r15]));
                r15 = r15 + 1;
            L17:
                int r16 = Build.VERSION.SDK_INT;
                if (r16 < 24) goto L21;
                r12.mAllowGeneratedReplies = Api24Impl.getAllowGeneratedReplies(r10);
            L21:
                if (r16 < 28) goto L24;
                r12.setSemanticAction(Api28Impl.getSemanticAction(r10));
            L24:
                if (r16 < 29) goto L27;
                r12.setContextual(Api29Impl.isContextual(r10));
            L27:
                if (r16 < 31) goto L29;
                r12.setAuthenticationRequired(Api31Impl.isAuthenticationRequired(r10));
            L29:
                return r12;
            L5:
                if (Api23Impl.getIcon(r10) == null) goto L7;
                r12 = new Builder(IconCompat.createFromIconOrNullIfZeroResId(Api23Impl.getIcon(r10)), r10.title, r10.actionIntent);
                goto L9
            }

            @NonNull
            public Builder addExtras(@Nullable Bundle r10) {
                if (r10 == null) goto L4;
                this.mExtras.putAll(r10);
            L4:
                return this;
            }

            @NonNull
            public Builder addRemoteInput(@Nullable RemoteInput r10) {
                if (this.mRemoteInputs != null) goto L5;
                this.mRemoteInputs = new ArrayList();
            L5:
                if (r10 == null) goto L7;
                this.mRemoteInputs.add(r10);
            L7:
                return this;
            }

            @NonNull
            public Action build() {
                checkContextualActionNullFields();
                ArrayList r10 = new ArrayList();
                ArrayList r11 = new ArrayList();
                ArrayList<RemoteInput> r12 = this.mRemoteInputs;
                if (r12 == null) goto L11;
                Iterator<RemoteInput> r13 = r12.iterator();
            L6:
                if (r13.hasNext() == false) goto L11;
                RemoteInput r14 = r13.next();
                if (r14.isDataOnly() == true) goto L9;
                r11.add(r14);
                goto L6
            L9:
                r10.add(r14);
            L11:
                RemoteInput[] r15 = null;
                if (r10.isEmpty() == false) goto L14;
                RemoteInput[] r16 = null;
            L16:
                if (r11.isEmpty() == true) goto L20;
                r15 = (RemoteInput[]) r11.toArray(new RemoteInput[r11.size()]);
            L20:
                return new Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, r15, r16, this.mAllowGeneratedReplies, this.mSemanticAction, this.mShowsUserInterface, this.mIsContextual, this.mAuthenticationRequired);
            L14:
                r16 = (RemoteInput[]) r10.toArray(new RemoteInput[r10.size()]);
                goto L16
            }

            @NonNull
            public Builder extend(@NonNull Extender r10) {
                r10.extend(this);
                return this;
            }

            @NonNull
            public Bundle getExtras() {
                return this.mExtras;
            }

            @NonNull
            public Builder setAllowGeneratedReplies(boolean r10) {
                this.mAllowGeneratedReplies = r10;
                return this;
            }

            @NonNull
            public Builder setAuthenticationRequired(boolean r10) {
                this.mAuthenticationRequired = r10;
                return this;
            }

            @NonNull
            public Builder setContextual(boolean r10) {
                this.mIsContextual = r10;
                return this;
            }

            @NonNull
            public Builder setSemanticAction(int r10) {
                this.mSemanticAction = r10;
                return this;
            }

            @NonNull
            public Builder setShowsUserInterface(boolean r10) {
                this.mShowsUserInterface = r10;
                return this;
            }
        }

        public interface Extender {
            @NonNull
            Builder extend(@NonNull Builder r10);
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

            public WearableExtender(@NonNull Action r10) {
                this.mFlags = 1;
                Bundle r11 = r10.getExtras().getBundle(EXTRA_WEARABLE_EXTENSIONS);
                if (r11 == null) goto L6;
                this.mFlags = r11.getInt(KEY_FLAGS, 1);
                this.mInProgressLabel = r11.getCharSequence(KEY_IN_PROGRESS_LABEL);
                this.mConfirmLabel = r11.getCharSequence(KEY_CONFIRM_LABEL);
                this.mCancelLabel = r11.getCharSequence(KEY_CANCEL_LABEL);
                return;
            }

            private void setFlag(int r10, boolean r11) {
                if (r11 == false) goto L4;
                int r12 = r10 | this.mFlags;
            L5:
                this.mFlags = r12;
                return;
            L4:
                int r13 = this.mFlags;
                r12 = (~r10) & r13;
                goto L5
            }

            @NonNull
            public WearableExtender clone() {
                WearableExtender r10 = new WearableExtender();
                r10.mFlags = this.mFlags;
                r10.mInProgressLabel = this.mInProgressLabel;
                r10.mConfirmLabel = this.mConfirmLabel;
                r10.mCancelLabel = this.mCancelLabel;
                return r10;
            }

            @NonNull
            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m6clone() {
                return clone();
            }

            @Override // androidx.core.app.NotificationCompat.Action.Extender
            @NonNull
            public Builder extend(@NonNull Builder r10) {
                Bundle r11 = new Bundle();
                int r12 = this.mFlags;
                if (r12 == 1) goto L5;
                r11.putInt(KEY_FLAGS, r12);
            L5:
                CharSequence r13 = this.mInProgressLabel;
                if (r13 == null) goto L8;
                r11.putCharSequence(KEY_IN_PROGRESS_LABEL, r13);
            L8:
                CharSequence r14 = this.mConfirmLabel;
                if (r14 == null) goto L11;
                r11.putCharSequence(KEY_CONFIRM_LABEL, r14);
            L11:
                CharSequence r15 = this.mCancelLabel;
                if (r15 == null) goto L14;
                r11.putCharSequence(KEY_CANCEL_LABEL, r15);
            L14:
                r10.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, r11);
                return r10;
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
            public WearableExtender setAvailableOffline(boolean r10) {
                setFlag(1, r10);
                return this;
            }

            @NonNull
            @Deprecated
            public WearableExtender setCancelLabel(@Nullable CharSequence r10) {
                this.mCancelLabel = r10;
                return this;
            }

            @NonNull
            @Deprecated
            public WearableExtender setConfirmLabel(@Nullable CharSequence r10) {
                this.mConfirmLabel = r10;
                return this;
            }

            @NonNull
            public WearableExtender setHintDisplayActionInline(boolean r10) {
                setFlag(4, r10);
                return this;
            }

            @NonNull
            public WearableExtender setHintLaunchesActivity(boolean r10) {
                setFlag(2, r10);
                return this;
            }

            @NonNull
            @Deprecated
            public WearableExtender setInProgressLabel(@Nullable CharSequence r10) {
                this.mInProgressLabel = r10;
                return this;
            }
        }

        public Action(int r10, @Nullable CharSequence r11, @Nullable PendingIntent r12) {
            IconCompat r13 = null;
            if (r10 == 0) goto L6;
            r13 = IconCompat.createWithResource(null, "", r10);
        L6:
            this(r13, r11, r12);
        }

        Action(int r15, @Nullable CharSequence r16, @Nullable PendingIntent r17, @Nullable Bundle r18, @Nullable RemoteInput[] r19, @Nullable RemoteInput[] r20, boolean r21, int r22, boolean r23, boolean r24, boolean r25) {
            IconCompat r10 = null;
            if (r15 == 0) goto L6;
            r10 = IconCompat.createWithResource(null, "", r15);
        L6:
            this(r10, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
        }

        public Action(@Nullable IconCompat r13, @Nullable CharSequence r14, @Nullable PendingIntent r15) {
            this(r13, r14, r15, new Bundle(), null, null, true, 0, true, false, false);
        }

        Action(@Nullable IconCompat r10, @Nullable CharSequence r11, @Nullable PendingIntent r12, @Nullable Bundle r13, @Nullable RemoteInput[] r14, @Nullable RemoteInput[] r15, boolean r16, int r17, boolean r18, boolean r19, boolean r110) {
            this.mShowsUserInterface = true;
            this.mIcon = r10;
            if (r10 != null) goto L5;
        L7:
            this.title = Builder.limitCharSequenceLength(r11);
            this.actionIntent = r12;
            if (r13 != null) goto L11;
            r13 = new Bundle();
        L11:
            this.mExtras = r13;
            this.mRemoteInputs = r14;
            this.mDataOnlyRemoteInputs = r15;
            this.mAllowGeneratedReplies = r16;
            this.mSemanticAction = r17;
            this.mShowsUserInterface = r18;
            this.mIsContextual = r19;
            this.mAuthenticationRequired = r110;
            return;
        L5:
            if (r10.getType() != 2) goto L7;
            this.icon = r10.getResId();
            goto L7
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
            int r10 = this.icon;
            if (r10 == 0) goto L8;
            this.mIcon = IconCompat.createWithResource(null, "", r10);
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
    }

    @RequiresApi(20)
    static class Api20Impl {
        private Api20Impl() {
        }

        @DoNotInline
        static boolean getAllowFreeFormInput(android.app.RemoteInput r10) {
            return r10.getAllowFreeFormInput();
        }

        @DoNotInline
        static CharSequence[] getChoices(android.app.RemoteInput r10) {
            return r10.getChoices();
        }

        @DoNotInline
        static Bundle getExtras(Notification.Action r10) {
            return r10.getExtras();
        }

        @DoNotInline
        static Bundle getExtras(android.app.RemoteInput r10) {
            return r10.getExtras();
        }

        @DoNotInline
        static String getGroup(Notification r10) {
            return r10.getGroup();
        }

        @DoNotInline
        static CharSequence getLabel(android.app.RemoteInput r10) {
            return r10.getLabel();
        }

        @DoNotInline
        static android.app.RemoteInput[] getRemoteInputs(Notification.Action r10) {
            return r10.getRemoteInputs();
        }

        @DoNotInline
        static String getResultKey(android.app.RemoteInput r10) {
            return r10.getResultKey();
        }

        @DoNotInline
        static String getSortKey(Notification r10) {
            return r10.getSortKey();
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static Icon getIcon(Notification.Action r10) {
            return r10.getIcon();
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static boolean getAllowGeneratedReplies(Notification.Action r10) {
            return r10.getAllowGeneratedReplies();
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static int getBadgeIconType(Notification r10) {
            return r10.getBadgeIconType();
        }

        @DoNotInline
        static String getChannelId(Notification r10) {
            return r10.getChannelId();
        }

        @DoNotInline
        static int getGroupAlertBehavior(Notification r10) {
            return r10.getGroupAlertBehavior();
        }

        @DoNotInline
        static CharSequence getSettingsText(Notification r10) {
            return r10.getSettingsText();
        }

        @DoNotInline
        static String getShortcutId(Notification r10) {
            return r10.getShortcutId();
        }

        @DoNotInline
        static long getTimeoutAfter(Notification r10) {
            return r10.getTimeoutAfter();
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static int getSemanticAction(Notification.Action r10) {
            return r10.getSemanticAction();
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static boolean getAllowSystemGeneratedContextualActions(Notification r10) {
            return r10.getAllowSystemGeneratedContextualActions();
        }

        @DoNotInline
        static Notification.BubbleMetadata getBubbleMetadata(Notification r10) {
            return r10.getBubbleMetadata();
        }

        @DoNotInline
        static int getEditChoicesBeforeSending(android.app.RemoteInput r10) {
            return r10.getEditChoicesBeforeSending();
        }

        @DoNotInline
        static LocusId getLocusId(Notification r10) {
            return r10.getLocusId();
        }

        @DoNotInline
        static boolean isContextual(Notification.Action r10) {
            return r10.isContextual();
        }
    }

    @RequiresApi(31)
    static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static boolean isAuthenticationRequired(Notification.Action r10) {
            return r10.isAuthenticationRequired();
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

        @RequiresApi(16)
        private static class Api16Impl {
            private Api16Impl() {
            }

            @DoNotInline
            static Notification.BigPictureStyle bigPicture(Notification.BigPictureStyle r10, Bitmap r11) {
                return r10.bigPicture(r11);
            }

            @DoNotInline
            static Notification.BigPictureStyle createBigPictureStyle(Notification.Builder r10) {
                return new Notification.BigPictureStyle(r10);
            }

            @DoNotInline
            static Notification.BigPictureStyle setBigContentTitle(Notification.BigPictureStyle r10, CharSequence r11) {
                return r10.setBigContentTitle(r11);
            }

            @RequiresApi(16)
            static void setBigLargeIcon(Notification.BigPictureStyle r10, Bitmap r11) {
                r10.bigLargeIcon(r11);
            }

            @RequiresApi(16)
            static void setSummaryText(Notification.BigPictureStyle r10, CharSequence r11) {
                r10.setSummaryText(r11);
            }
        }

        @RequiresApi(23)
        private static class Api23Impl {
            private Api23Impl() {
            }

            @RequiresApi(23)
            static void setBigLargeIcon(Notification.BigPictureStyle r10, Icon r11) {
                r10.bigLargeIcon(r11);
            }
        }

        @RequiresApi(31)
        private static class Api31Impl {
            private Api31Impl() {
            }

            @RequiresApi(31)
            static void setBigPicture(Notification.BigPictureStyle r10, Icon r11) {
                r10.bigPicture(r11);
            }

            @RequiresApi(31)
            static void setContentDescription(Notification.BigPictureStyle r10, CharSequence r11) {
                r10.setContentDescription(r11);
            }

            @RequiresApi(31)
            static void showBigPictureWhenCollapsed(Notification.BigPictureStyle r10, boolean r11) {
                r10.showBigPictureWhenCollapsed(r11);
            }
        }

        public BigPictureStyle() {
        }

        public BigPictureStyle(@Nullable Builder r10) {
            setBuilder(r10);
        }

        @Nullable
        private static IconCompat asIconCompat(@Nullable Parcelable r10) {
            if (r10 != null) goto L4;
            return null;
        L4:
            if (Build.VERSION.SDK_INT < 23) goto L10;
            if ((r10 instanceof Icon) == false) goto L10;
            return IconCompat.createFromIcon((Icon) r10);
        L10:
            if ((r10 instanceof Bitmap) == true) goto L12;
            return null;
        L12:
            return IconCompat.createWithBitmap((Bitmap) r10);
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static IconCompat getPictureIcon(@Nullable Bundle r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            Parcelable r11 = r10.getParcelable(NotificationCompat.EXTRA_PICTURE);
            if (r11 == null) goto L10;
            return asIconCompat(r11);
        L10:
            return asIconCompat(r10.getParcelable(NotificationCompat.EXTRA_PICTURE_ICON));
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r10) {
            int r11 = Build.VERSION.SDK_INT;
            if (r11 < 16) goto L35;
            Notification.BigPictureStyle r12 = Api16Impl.setBigContentTitle(Api16Impl.createBigPictureStyle(r10.getBuilder()), this.mBigContentTitle);
            IconCompat r13 = this.mPictureIcon;
            Context r14 = null;
            if (r13 == null) goto L16;
            if (r11 < 31) goto L13;
            if ((r10 instanceof NotificationCompatBuilder) == false) goto L10;
            Context r15 = ((NotificationCompatBuilder) r10).getContext();
        L11:
            Api31Impl.setBigPicture(r12, this.mPictureIcon.toIcon(r15));
            goto L16
        L10:
            r15 = null;
            goto L11
        L13:
            if (r13.getType() != 1) goto L16;
            r12 = Api16Impl.bigPicture(r12, this.mPictureIcon.getBitmap());
        L16:
            if (this.mBigLargeIconSet == false) goto L30;
            IconCompat r16 = this.mBigLargeIcon;
            if (r16 != null) goto L21;
        L19:
            Api16Impl.setBigLargeIcon(r12, null);
            goto L30
        L21:
            if (r11 < 23) goto L27;
            if ((r10 instanceof NotificationCompatBuilder) == false) goto L25;
            r14 = ((NotificationCompatBuilder) r10).getContext();
        L25:
            Api23Impl.setBigLargeIcon(r12, this.mBigLargeIcon.toIcon(r14));
            goto L30
        L27:
            if (r16.getType() != 1) goto L19;
            Api16Impl.setBigLargeIcon(r12, this.mBigLargeIcon.getBitmap());
        L30:
            if (this.mSummaryTextSet == false) goto L32;
            Api16Impl.setSummaryText(r12, this.mSummaryText);
        L32:
            if (r11 < 31) goto L36;
            Api31Impl.showBigPictureWhenCollapsed(r12, this.mShowBigPictureWhenCollapsed);
            Api31Impl.setContentDescription(r12, this.mPictureContentDescription);
            return;
        L36:
            return;
        }

        @NonNull
        public BigPictureStyle bigLargeIcon(@Nullable Bitmap r10) {
            if (r10 != null) goto L4;
            IconCompat r11 = null;
        L5:
            this.mBigLargeIcon = r11;
            this.mBigLargeIconSet = true;
            return this;
        L4:
            r11 = IconCompat.createWithBitmap(r10);
            goto L5
        }

        @NonNull
        @RequiresApi(23)
        public BigPictureStyle bigLargeIcon(@Nullable Icon r10) {
            if (r10 != null) goto L4;
            IconCompat r11 = null;
        L5:
            this.mBigLargeIcon = r11;
            this.mBigLargeIconSet = true;
            return this;
        L4:
            r11 = IconCompat.createFromIcon(r10);
            goto L5
        }

        @NonNull
        public BigPictureStyle bigPicture(@Nullable Bitmap r10) {
            if (r10 != null) goto L4;
            IconCompat r11 = null;
        L5:
            this.mPictureIcon = r11;
            return this;
        L4:
            r11 = IconCompat.createWithBitmap(r10);
            goto L5
        }

        @NonNull
        @RequiresApi(31)
        public BigPictureStyle bigPicture(@Nullable Icon r10) {
            this.mPictureIcon = IconCompat.createFromIcon(r10);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected void clearCompatExtraKeys(@NonNull Bundle r10) {
            super.clearCompatExtraKeys(r10);
            r10.remove(NotificationCompat.EXTRA_LARGE_ICON_BIG);
            r10.remove(NotificationCompat.EXTRA_PICTURE);
            r10.remove(NotificationCompat.EXTRA_PICTURE_ICON);
            r10.remove(NotificationCompat.EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected void restoreFromCompatExtras(@NonNull Bundle r10) {
            super.restoreFromCompatExtras(r10);
            if (r10.containsKey(NotificationCompat.EXTRA_LARGE_ICON_BIG) == false) goto L5;
            this.mBigLargeIcon = asIconCompat(r10.getParcelable(NotificationCompat.EXTRA_LARGE_ICON_BIG));
            this.mBigLargeIconSet = true;
        L5:
            this.mPictureIcon = getPictureIcon(r10);
            this.mShowBigPictureWhenCollapsed = r10.getBoolean(NotificationCompat.EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED);
        }

        @NonNull
        public BigPictureStyle setBigContentTitle(@Nullable CharSequence r10) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(r10);
            return this;
        }

        @NonNull
        @RequiresApi(31)
        public BigPictureStyle setContentDescription(@Nullable CharSequence r10) {
            this.mPictureContentDescription = r10;
            return this;
        }

        @NonNull
        public BigPictureStyle setSummaryText(@Nullable CharSequence r10) {
            this.mSummaryText = Builder.limitCharSequenceLength(r10);
            this.mSummaryTextSet = true;
            return this;
        }

        @NonNull
        @RequiresApi(31)
        public BigPictureStyle showBigPictureWhenCollapsed(boolean r10) {
            this.mShowBigPictureWhenCollapsed = r10;
            return this;
        }
    }

    public static class BigTextStyle extends Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigTextStyle";
        private CharSequence mBigText;

        @RequiresApi(16)
        static class Api16Impl {
            private Api16Impl() {
            }

            @DoNotInline
            static Notification.BigTextStyle bigText(Notification.BigTextStyle r10, CharSequence r11) {
                return r10.bigText(r11);
            }

            @DoNotInline
            static Notification.BigTextStyle createBigTextStyle(Notification.Builder r10) {
                return new Notification.BigTextStyle(r10);
            }

            @DoNotInline
            static Notification.BigTextStyle setBigContentTitle(Notification.BigTextStyle r10, CharSequence r11) {
                return r10.setBigContentTitle(r11);
            }

            @DoNotInline
            static Notification.BigTextStyle setSummaryText(Notification.BigTextStyle r10, CharSequence r11) {
                return r10.setSummaryText(r11);
            }
        }

        public BigTextStyle() {
        }

        public BigTextStyle(@Nullable Builder r10) {
            setBuilder(r10);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(@NonNull Bundle r10) {
            super.addCompatExtras(r10);
            if (Build.VERSION.SDK_INT >= 21) goto L6;
            r10.putCharSequence(NotificationCompat.EXTRA_BIG_TEXT, this.mBigText);
            return;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r10) {
            if (Build.VERSION.SDK_INT < 16) goto L8;
            Notification.BigTextStyle r11 = Api16Impl.bigText(Api16Impl.setBigContentTitle(Api16Impl.createBigTextStyle(r10.getBuilder()), this.mBigContentTitle), this.mBigText);
            if (this.mSummaryTextSet == false) goto L9;
            Api16Impl.setSummaryText(r11, this.mSummaryText);
            return;
        L9:
            return;
        }

        @NonNull
        public BigTextStyle bigText(@Nullable CharSequence r10) {
            this.mBigText = Builder.limitCharSequenceLength(r10);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected void clearCompatExtraKeys(@NonNull Bundle r10) {
            super.clearCompatExtraKeys(r10);
            r10.remove(NotificationCompat.EXTRA_BIG_TEXT);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected void restoreFromCompatExtras(@NonNull Bundle r10) {
            super.restoreFromCompatExtras(r10);
            this.mBigText = r10.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
        }

        @NonNull
        public BigTextStyle setBigContentTitle(@Nullable CharSequence r10) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(r10);
            return this;
        }

        @NonNull
        public BigTextStyle setSummaryText(@Nullable CharSequence r10) {
            this.mSummaryText = Builder.limitCharSequenceLength(r10);
            this.mSummaryTextSet = true;
            return this;
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
        private static class Api29Impl {
            private Api29Impl() {
            }

            @Nullable
            @RequiresApi(29)
            static BubbleMetadata fromPlatform(@Nullable Notification.BubbleMetadata r10) {
                if (r10 != null) goto L6;
                return null;
            L6:
                if (r10.getIntent() != null) goto L8;
                return null;
            L8:
                Builder r11 = new Builder(r10.getIntent(), IconCompat.createFromIcon(r10.getIcon())).setAutoExpandBubble(r10.getAutoExpandBubble()).setDeleteIntent(r10.getDeleteIntent()).setSuppressNotification(r10.isNotificationSuppressed());
                if (r10.getDesiredHeight() == 0) goto L12;
                r11.setDesiredHeight(r10.getDesiredHeight());
            L12:
                if (r10.getDesiredHeightResId() == 0) goto L15;
                r11.setDesiredHeightResId(r10.getDesiredHeightResId());
            L15:
                return r11.build();
            }

            @Nullable
            @RequiresApi(29)
            static Notification.BubbleMetadata toPlatform(@Nullable BubbleMetadata r10) {
                if (r10 != null) goto L6;
                return null;
            L6:
                if (r10.getIntent() != null) goto L8;
                return null;
            L8:
                Notification.BubbleMetadata.Builder r11 = new Notification.BubbleMetadata.Builder().setIcon(r10.getIcon().toIcon()).setIntent(r10.getIntent()).setDeleteIntent(r10.getDeleteIntent()).setAutoExpandBubble(r10.getAutoExpandBubble()).setSuppressNotification(r10.isNotificationSuppressed());
                if (r10.getDesiredHeight() == 0) goto L12;
                r11.setDesiredHeight(r10.getDesiredHeight());
            L12:
                if (r10.getDesiredHeightResId() == 0) goto L15;
                r11.setDesiredHeightResId(r10.getDesiredHeightResId());
            L15:
                return r11.build();
            }
        }

        @RequiresApi(30)
        private static class Api30Impl {
            private Api30Impl() {
            }

            @Nullable
            @RequiresApi(30)
            static BubbleMetadata fromPlatform(@Nullable Notification.BubbleMetadata r10) {
                if (r10 != null) goto L6;
                return null;
            L6:
                if (r10.getShortcutId() == null) goto L8;
                Builder r11 = new Builder(r10.getShortcutId());
            L9:
                r11.setAutoExpandBubble(r10.getAutoExpandBubble()).setDeleteIntent(r10.getDeleteIntent()).setSuppressNotification(r10.isNotificationSuppressed());
                if (r10.getDesiredHeight() == 0) goto L13;
                r11.setDesiredHeight(r10.getDesiredHeight());
            L13:
                if (r10.getDesiredHeightResId() == 0) goto L16;
                r11.setDesiredHeightResId(r10.getDesiredHeightResId());
            L16:
                return r11.build();
            L8:
                r11 = new Builder(r10.getIntent(), IconCompat.createFromIcon(r10.getIcon()));
                goto L9
            }

            @Nullable
            @RequiresApi(30)
            static Notification.BubbleMetadata toPlatform(@Nullable BubbleMetadata r10) {
                if (r10 != null) goto L6;
                return null;
            L6:
                if (r10.getShortcutId() == null) goto L8;
                Notification.BubbleMetadata.Builder r11 = new Notification.BubbleMetadata.Builder(r10.getShortcutId());
            L9:
                r11.setDeleteIntent(r10.getDeleteIntent()).setAutoExpandBubble(r10.getAutoExpandBubble()).setSuppressNotification(r10.isNotificationSuppressed());
                if (r10.getDesiredHeight() == 0) goto L13;
                r11.setDesiredHeight(r10.getDesiredHeight());
            L13:
                if (r10.getDesiredHeightResId() == 0) goto L16;
                r11.setDesiredHeightResId(r10.getDesiredHeightResId());
            L16:
                return r11.build();
            L8:
                r11 = new Notification.BubbleMetadata.Builder(r10.getIntent(), r10.getIcon().toIcon());
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

            public Builder(@NonNull PendingIntent r10, @NonNull IconCompat r11) {
                Objects.requireNonNull(r10, "Bubble requires non-null pending intent");
                Objects.requireNonNull(r11, "Bubbles require non-null icon");
                this.mPendingIntent = r10;
                this.mIcon = r11;
            }

            @RequiresApi(30)
            public Builder(@NonNull String r10) {
                if (TextUtils.isEmpty(r10) == true) goto L7;
                this.mShortcutId = r10;
                return;
            L7:
                throw new NullPointerException("Bubble requires a non-null shortcut id");
            }

            @NonNull
            private Builder setFlag(int r10, boolean r11) {
                if (r11 == false) goto L4;
                int r12 = r10 | this.mFlags;
            L5:
                this.mFlags = r12;
                return this;
            L4:
                int r13 = this.mFlags;
                r12 = (~r10) & r13;
                goto L5
            }

            @NonNull
            @SuppressLint({"SyntheticAccessor"})
            public BubbleMetadata build() {
                String r10 = this.mShortcutId;
                if (r10 != null) goto L5;
                Objects.requireNonNull(this.mPendingIntent, "Must supply pending intent or shortcut to bubble");
            L5:
                if (r10 != null) goto L7;
                Objects.requireNonNull(this.mIcon, "Must supply an icon or shortcut for the bubble");
            L7:
                BubbleMetadata r11 = new BubbleMetadata(this.mPendingIntent, this.mDeleteIntent, this.mIcon, this.mDesiredHeight, this.mDesiredHeightResId, this.mFlags, r10, null);
                r11.setFlags(this.mFlags);
                return r11;
            }

            @NonNull
            public Builder setAutoExpandBubble(boolean r10) {
                setFlag(1, r10);
                return this;
            }

            @NonNull
            public Builder setDeleteIntent(@Nullable PendingIntent r10) {
                this.mDeleteIntent = r10;
                return this;
            }

            @NonNull
            public Builder setDesiredHeight(@Dimension(unit = 0) int r10) {
                this.mDesiredHeight = Math.max(r10, 0);
                this.mDesiredHeightResId = 0;
                return this;
            }

            @NonNull
            public Builder setDesiredHeightResId(@DimenRes int r10) {
                this.mDesiredHeightResId = r10;
                this.mDesiredHeight = 0;
                return this;
            }

            @NonNull
            public Builder setIcon(@NonNull IconCompat r10) {
                if (this.mShortcutId != null) goto L7;
                Objects.requireNonNull(r10, "Bubbles require non-null icon");
                this.mIcon = r10;
                return this;
            L7:
                throw new IllegalStateException("Created as a shortcut bubble, cannot set an Icon. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
            }

            @NonNull
            public Builder setIntent(@NonNull PendingIntent r10) {
                if (this.mShortcutId != null) goto L7;
                Objects.requireNonNull(r10, "Bubble requires non-null pending intent");
                this.mPendingIntent = r10;
                return this;
            L7:
                throw new IllegalStateException("Created as a shortcut bubble, cannot set a PendingIntent. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
            }

            @NonNull
            public Builder setSuppressNotification(boolean r10) {
                setFlag(2, r10);
                return this;
            }
        }

        private BubbleMetadata(@Nullable PendingIntent r10, @Nullable PendingIntent r11, @Nullable IconCompat r12, int r13, @DimenRes int r14, int r15, @Nullable String r16) {
            this.mPendingIntent = r10;
            this.mIcon = r12;
            this.mDesiredHeight = r13;
            this.mDesiredHeightResId = r14;
            this.mDeleteIntent = r11;
            this.mFlags = r15;
            this.mShortcutId = r16;
        }

        /* synthetic */ BubbleMetadata(PendingIntent r10, PendingIntent r11, IconCompat r12, int r13, int r14, int r15, String r16, AnonymousClass1 r17) {
            this(r10, r11, r12, r13, r14, r15, r16);
        }

        @Nullable
        public static BubbleMetadata fromPlatform(@Nullable Notification.BubbleMetadata r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            int r11 = Build.VERSION.SDK_INT;
            if (r11 < 30) goto L10;
            return Api30Impl.fromPlatform(r10);
        L10:
            if (r11 == 29) goto L12;
            return null;
        L12:
            return Api29Impl.fromPlatform(r10);
        }

        @Nullable
        public static Notification.BubbleMetadata toPlatform(@Nullable BubbleMetadata r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            int r11 = Build.VERSION.SDK_INT;
            if (r11 < 30) goto L10;
            return Api30Impl.toPlatform(r10);
        L10:
            if (r11 == 29) goto L12;
            return null;
        L12:
            return Api29Impl.toPlatform(r10);
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
        public void setFlags(int r10) {
            this.mFlags = r10;
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
        Bitmap mLargeIcon;
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
        static class Api21Impl {
            private Api21Impl() {
            }

            @DoNotInline
            static AudioAttributes build(AudioAttributes.Builder r10) {
                return r10.build();
            }

            @DoNotInline
            static AudioAttributes.Builder createBuilder() {
                return new AudioAttributes.Builder();
            }

            @DoNotInline
            static AudioAttributes.Builder setContentType(AudioAttributes.Builder r10, int r11) {
                return r10.setContentType(r11);
            }

            @DoNotInline
            static AudioAttributes.Builder setLegacyStreamType(AudioAttributes.Builder r10, int r11) {
                return r10.setLegacyStreamType(r11);
            }

            @DoNotInline
            static AudioAttributes.Builder setUsage(AudioAttributes.Builder r10, int r11) {
                return r10.setUsage(r11);
            }
        }

        @RequiresApi(23)
        static class Api23Impl {
            private Api23Impl() {
            }

            @DoNotInline
            static Icon getSmallIcon(Notification r10) {
                return r10.getSmallIcon();
            }
        }

        @RequiresApi(24)
        static class Api24Impl {
            private Api24Impl() {
            }

            @DoNotInline
            static RemoteViews createBigContentView(Notification.Builder r10) {
                return r10.createHeadsUpContentView();
            }

            @DoNotInline
            static RemoteViews createContentView(Notification.Builder r10) {
                return r10.createContentView();
            }

            @DoNotInline
            static RemoteViews createHeadsUpContentView(Notification.Builder r10) {
                return r10.createHeadsUpContentView();
            }

            @DoNotInline
            static Notification.Builder recoverBuilder(Context r10, Notification r11) {
                return Notification.Builder.recoverBuilder(r10, r11);
            }
        }

        @Deprecated
        public Builder(@NonNull Context r10) {
            this(r10, null);
        }

        @RequiresApi(19)
        public Builder(@NonNull Context r10, @NonNull Notification r11) {
            this(r10, NotificationCompat.getChannelId(r11));
            Bundle r12 = r11.extras;
            Style r13 = Style.extractStyleFromNotification(r11);
            setContentTitle(NotificationCompat.getContentTitle(r11)).setContentText(NotificationCompat.getContentText(r11)).setContentInfo(NotificationCompat.getContentInfo(r11)).setSubText(NotificationCompat.getSubText(r11)).setSettingsText(NotificationCompat.getSettingsText(r11)).setStyle(r13).setContentIntent(r11.contentIntent).setGroup(NotificationCompat.getGroup(r11)).setGroupSummary(NotificationCompat.isGroupSummary(r11)).setLocusId(NotificationCompat.getLocusId(r11)).setWhen(r11.when).setShowWhen(NotificationCompat.getShowWhen(r11)).setUsesChronometer(NotificationCompat.getUsesChronometer(r11)).setAutoCancel(NotificationCompat.getAutoCancel(r11)).setOnlyAlertOnce(NotificationCompat.getOnlyAlertOnce(r11)).setOngoing(NotificationCompat.getOngoing(r11)).setLocalOnly(NotificationCompat.getLocalOnly(r11)).setLargeIcon(r11.largeIcon).setBadgeIconType(NotificationCompat.getBadgeIconType(r11)).setCategory(NotificationCompat.getCategory(r11)).setBubbleMetadata(NotificationCompat.getBubbleMetadata(r11)).setNumber(r11.number).setTicker(r11.tickerText).setContentIntent(r11.contentIntent).setDeleteIntent(r11.deleteIntent).setFullScreenIntent(r11.fullScreenIntent, NotificationCompat.getHighPriority(r11)).setSound(r11.sound, r11.audioStreamType).setVibrate(r11.vibrate).setLights(r11.ledARGB, r11.ledOnMS, r11.ledOffMS).setDefaults(r11.defaults).setPriority(r11.priority).setColor(NotificationCompat.getColor(r11)).setVisibility(NotificationCompat.getVisibility(r11)).setPublicVersion(NotificationCompat.getPublicVersion(r11)).setSortKey(NotificationCompat.getSortKey(r11)).setTimeoutAfter(NotificationCompat.getTimeoutAfter(r11)).setShortcutId(NotificationCompat.getShortcutId(r11)).setProgress(r12.getInt(NotificationCompat.EXTRA_PROGRESS_MAX), r12.getInt(NotificationCompat.EXTRA_PROGRESS), r12.getBoolean(NotificationCompat.EXTRA_PROGRESS_INDETERMINATE)).setAllowSystemGeneratedContextualActions(NotificationCompat.getAllowSystemGeneratedContextualActions(r11)).setSmallIcon(r11.icon, r11.iconLevel).addExtras(getExtrasWithoutDuplicateData(r11, r13));
            if (Build.VERSION.SDK_INT < 23) goto L5;
            this.mSmallIcon = Api23Impl.getSmallIcon(r11);
        L5:
            Notification.Action[] r14 = r11.actions;
            int r15 = 0;
            if (r14 == null) goto L13;
            if (r14.length == 0) goto L13;
            int r16 = r14.length;
            int r17 = 0;
        L10:
            if (r17 >= r16) goto L13;
            addAction(Action.Builder.fromAndroidAction(r14[r17]).build());
            r17 = r17 + 1;
        L13:
            if (Build.VERSION.SDK_INT < 21) goto L20;
            List<Action> r18 = NotificationCompat.getInvisibleActions(r11);
            if (r18.isEmpty() == true) goto L20;
            Iterator<Action> r19 = r18.iterator();
        L18:
            if (r19.hasNext() == false) goto L20;
            addInvisibleAction(r19.next());
        L20:
            String[] r20 = r11.extras.getStringArray(NotificationCompat.EXTRA_PEOPLE);
            if (r20 == null) goto L28;
            if (r20.length == 0) goto L28;
            int r21 = r20.length;
        L25:
            if (r15 >= r21) goto L28;
            addPerson(r20[r15]);
            r15 = r15 + 1;
        L28:
            if (Build.VERSION.SDK_INT < 28) goto L37;
            ArrayList r22 = r11.extras.getParcelableArrayList(NotificationCompat.EXTRA_PEOPLE_LIST);
            if (r22 == null) goto L37;
            if (r22.isEmpty() == true) goto L37;
            Iterator r23 = r22.iterator();
        L35:
            if (r23.hasNext() == false) goto L37;
            addPerson(Person.fromAndroidPerson((android.app.Person) r23.next()));
        L37:
            int r24 = Build.VERSION.SDK_INT;
            if (r24 < 24) goto L43;
            if (r12.containsKey(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN) == false) goto L43;
            setChronometerCountDown(r12.getBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN));
        L43:
            if (r24 >= 26) goto L45;
            return;
        L45:
            if (r12.containsKey(NotificationCompat.EXTRA_COLORIZED) == false) goto L53;
            setColorized(r12.getBoolean(NotificationCompat.EXTRA_COLORIZED));
            return;
        }

        public Builder(@NonNull Context r10, @NonNull String r11) {
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
            Notification r12 = new Notification();
            this.mNotification = r12;
            this.mContext = r10;
            this.mChannelId = r11;
            r12.when = System.currentTimeMillis();
            this.mNotification.audioStreamType = -1;
            this.mPriority = 0;
            this.mPeople = new ArrayList();
            this.mAllowSystemGeneratedContextualActions = true;
        }

        @Nullable
        @RequiresApi(19)
        private static Bundle getExtrasWithoutDuplicateData(@NonNull Notification r10, @Nullable Style r11) {
            if (r10.extras != null) goto L6;
            return null;
        L6:
            Bundle r12 = new Bundle(r10.extras);
            r12.remove(NotificationCompat.EXTRA_TITLE);
            r12.remove(NotificationCompat.EXTRA_TEXT);
            r12.remove(NotificationCompat.EXTRA_INFO_TEXT);
            r12.remove(NotificationCompat.EXTRA_SUB_TEXT);
            r12.remove(NotificationCompat.EXTRA_CHANNEL_ID);
            r12.remove(NotificationCompat.EXTRA_CHANNEL_GROUP_ID);
            r12.remove(NotificationCompat.EXTRA_SHOW_WHEN);
            r12.remove(NotificationCompat.EXTRA_PROGRESS);
            r12.remove(NotificationCompat.EXTRA_PROGRESS_MAX);
            r12.remove(NotificationCompat.EXTRA_PROGRESS_INDETERMINATE);
            r12.remove(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN);
            r12.remove(NotificationCompat.EXTRA_COLORIZED);
            r12.remove(NotificationCompat.EXTRA_PEOPLE_LIST);
            r12.remove(NotificationCompat.EXTRA_PEOPLE);
            r12.remove(NotificationCompatExtras.EXTRA_SORT_KEY);
            r12.remove(NotificationCompatExtras.EXTRA_GROUP_KEY);
            r12.remove(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
            r12.remove(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
            r12.remove(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
            Bundle r13 = r12.getBundle("android.car.EXTENSIONS");
            if (r13 == null) goto L9;
            Bundle r14 = new Bundle(r13);
            r14.remove("invisible_actions");
            r12.putBundle("android.car.EXTENSIONS", r14);
        L9:
            if (r11 == null) goto L11;
            r11.clearCompatExtraKeys(r12);
        L11:
            return r12;
        }

        @Nullable
        protected static CharSequence limitCharSequenceLength(@Nullable CharSequence r10) {
            if (r10 != null) goto L5;
            return r10;
        L5:
            if (r10.length() > MAX_CHARSEQUENCE_LENGTH) goto L7;
            return r10;
        L7:
            return r10.subSequence(0, MAX_CHARSEQUENCE_LENGTH);
        }

        @Nullable
        private Bitmap reduceLargeIconSize(@Nullable Bitmap r10) {
            if (r10 != null) goto L4;
        L13:
            return r10;
        L4:
            if (Build.VERSION.SDK_INT >= 27) goto L13;
            Resources r11 = this.mContext.getResources();
            int r12 = r11.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
            int r13 = r11.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
            if (r10.getWidth() <= r12) goto L9;
        L11:
            double r14 = Math.min(((double) r12) / ((double) Math.max(1, r10.getWidth())), ((double) r13) / ((double) Math.max(1, r10.getHeight())));
            return Bitmap.createScaledBitmap(r10, (int) Math.ceil(((double) r10.getWidth()) * r14), (int) Math.ceil(((double) r10.getHeight()) * r14), true);
        L9:
            if (r10.getHeight() > r13) goto L11;
            return r10;
        }

        private void setFlag(int r10, boolean r11) {
            Notification r12 = this.mNotification;
            if (r11 == false) goto L5;
            int r13 = r10 | r12.flags;
        L6:
            r12.flags = r13;
            return;
        L5:
            int r14 = r12.flags;
            r13 = (~r10) & r14;
            goto L6
        }

        private boolean useExistingRemoteView() {
            Style r10 = this.mStyle;
            if (r10 != null) goto L5;
        L8:
            return true;
        L5:
            if (r10.displayCustomViewInline() == false) goto L8;
            return false;
        }

        @NonNull
        public Builder addAction(int r10, @Nullable CharSequence r11, @Nullable PendingIntent r12) {
            this.mActions.add(new Action(r10, r11, r12));
            return this;
        }

        @NonNull
        public Builder addAction(@Nullable Action r10) {
            if (r10 == null) goto L4;
            this.mActions.add(r10);
        L4:
            return this;
        }

        @NonNull
        public Builder addExtras(@Nullable Bundle r10) {
            if (r10 == null) goto L7;
            Bundle r11 = this.mExtras;
            if (r11 != null) goto L6;
            this.mExtras = new Bundle(r10);
            goto L7
        L6:
            r11.putAll(r10);
        L7:
            return this;
        }

        @NonNull
        @RequiresApi(21)
        public Builder addInvisibleAction(int r10, @Nullable CharSequence r11, @Nullable PendingIntent r12) {
            this.mInvisibleActions.add(new Action(r10, r11, r12));
            return this;
        }

        @NonNull
        @RequiresApi(21)
        public Builder addInvisibleAction(@Nullable Action r10) {
            if (r10 == null) goto L4;
            this.mInvisibleActions.add(r10);
        L4:
            return this;
        }

        @NonNull
        public Builder addPerson(@Nullable Person r10) {
            if (r10 == null) goto L4;
            this.mPersonList.add(r10);
        L4:
            return this;
        }

        @NonNull
        @Deprecated
        public Builder addPerson(@Nullable String r10) {
            if (r10 != null) goto L4;
        L6:
            return this;
        L4:
            if (r10.isEmpty() == true) goto L6;
            this.mPeople.add(r10);
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
            Bundle r10 = this.mExtras.getBundle("android.car.EXTENSIONS");
            if (r10 == null) goto L5;
            Bundle r11 = new Bundle(r10);
            r11.remove("invisible_actions");
            this.mExtras.putBundle("android.car.EXTENSIONS", r11);
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
            int r10 = Build.VERSION.SDK_INT;
            if (r10 >= 16) goto L7;
            return null;
        L7:
            if (this.mBigContentView != null) goto L9;
        L12:
            NotificationCompatBuilder r11 = new NotificationCompatBuilder(this);
            Style r12 = this.mStyle;
            if (r12 == null) goto L17;
            RemoteViews r13 = r12.makeBigContentView(r11);
            if (r13 == null) goto L17;
            return r13;
        L17:
            Notification r14 = r11.build();
            if (r10 < 24) goto L22;
            return Api24Impl.createBigContentView(Api24Impl.recoverBuilder(this.mContext, r14));
        L22:
            return r14.bigContentView;
        L9:
            if (useExistingRemoteView() == false) goto L12;
            return this.mBigContentView;
        }

        @Nullable
        @SuppressLint({"BuilderSetStyle"})
        public RemoteViews createContentView() {
            if (this.mContentView != null) goto L5;
        L8:
            NotificationCompatBuilder r10 = new NotificationCompatBuilder(this);
            Style r11 = this.mStyle;
            if (r11 == null) goto L13;
            RemoteViews r12 = r11.makeContentView(r10);
            if (r12 == null) goto L13;
            return r12;
        L13:
            Notification r13 = r10.build();
            if (Build.VERSION.SDK_INT < 24) goto L18;
            return Api24Impl.createContentView(Api24Impl.recoverBuilder(this.mContext, r13));
        L18:
            return r13.contentView;
        L5:
            if (useExistingRemoteView() == false) goto L8;
            return this.mContentView;
        }

        @Nullable
        @SuppressLint({"BuilderSetStyle"})
        public RemoteViews createHeadsUpContentView() {
            int r10 = Build.VERSION.SDK_INT;
            if (r10 >= 21) goto L7;
            return null;
        L7:
            if (this.mHeadsUpContentView != null) goto L9;
        L12:
            NotificationCompatBuilder r11 = new NotificationCompatBuilder(this);
            Style r12 = this.mStyle;
            if (r12 == null) goto L17;
            RemoteViews r13 = r12.makeHeadsUpContentView(r11);
            if (r13 == null) goto L17;
            return r13;
        L17:
            Notification r14 = r11.build();
            if (r10 < 24) goto L22;
            return Api24Impl.createHeadsUpContentView(Api24Impl.recoverBuilder(this.mContext, r14));
        L22:
            return r14.headsUpContentView;
        L9:
            if (useExistingRemoteView() == false) goto L12;
            return this.mHeadsUpContentView;
        }

        @NonNull
        public Builder extend(@NonNull Extender r10) {
            r10.extend(this);
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
        public Builder setAllowSystemGeneratedContextualActions(boolean r10) {
            this.mAllowSystemGeneratedContextualActions = r10;
            return this;
        }

        @NonNull
        public Builder setAutoCancel(boolean r10) {
            setFlag(16, r10);
            return this;
        }

        @NonNull
        public Builder setBadgeIconType(int r10) {
            this.mBadgeIcon = r10;
            return this;
        }

        @NonNull
        public Builder setBubbleMetadata(@Nullable BubbleMetadata r10) {
            this.mBubbleMetadata = r10;
            return this;
        }

        @NonNull
        public Builder setCategory(@Nullable String r10) {
            this.mCategory = r10;
            return this;
        }

        @NonNull
        public Builder setChannelId(@NonNull String r10) {
            this.mChannelId = r10;
            return this;
        }

        @NonNull
        @RequiresApi(24)
        public Builder setChronometerCountDown(boolean r10) {
            this.mChronometerCountDown = r10;
            getExtras().putBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN, r10);
            return this;
        }

        @NonNull
        public Builder setColor(@ColorInt int r10) {
            this.mColor = r10;
            return this;
        }

        @NonNull
        public Builder setColorized(boolean r10) {
            this.mColorized = r10;
            this.mColorizedSet = true;
            return this;
        }

        @NonNull
        public Builder setContent(@Nullable RemoteViews r10) {
            this.mNotification.contentView = r10;
            return this;
        }

        @NonNull
        public Builder setContentInfo(@Nullable CharSequence r10) {
            this.mContentInfo = limitCharSequenceLength(r10);
            return this;
        }

        @NonNull
        public Builder setContentIntent(@Nullable PendingIntent r10) {
            this.mContentIntent = r10;
            return this;
        }

        @NonNull
        public Builder setContentText(@Nullable CharSequence r10) {
            this.mContentText = limitCharSequenceLength(r10);
            return this;
        }

        @NonNull
        public Builder setContentTitle(@Nullable CharSequence r10) {
            this.mContentTitle = limitCharSequenceLength(r10);
            return this;
        }

        @NonNull
        public Builder setCustomBigContentView(@Nullable RemoteViews r10) {
            this.mBigContentView = r10;
            return this;
        }

        @NonNull
        public Builder setCustomContentView(@Nullable RemoteViews r10) {
            this.mContentView = r10;
            return this;
        }

        @NonNull
        public Builder setCustomHeadsUpContentView(@Nullable RemoteViews r10) {
            this.mHeadsUpContentView = r10;
            return this;
        }

        @NonNull
        public Builder setDefaults(int r10) {
            Notification r11 = this.mNotification;
            r11.defaults = r10;
            if ((r10 & 4) == 0) goto L5;
            r11.flags |= 1;
        L5:
            return this;
        }

        @NonNull
        public Builder setDeleteIntent(@Nullable PendingIntent r10) {
            this.mNotification.deleteIntent = r10;
            return this;
        }

        @NonNull
        public Builder setExtras(@Nullable Bundle r10) {
            this.mExtras = r10;
            return this;
        }

        @NonNull
        public Builder setForegroundServiceBehavior(int r10) {
            this.mFgsDeferBehavior = r10;
            return this;
        }

        @NonNull
        public Builder setFullScreenIntent(@Nullable PendingIntent r10, boolean r11) {
            this.mFullScreenIntent = r10;
            setFlag(128, r11);
            return this;
        }

        @NonNull
        public Builder setGroup(@Nullable String r10) {
            this.mGroupKey = r10;
            return this;
        }

        @NonNull
        public Builder setGroupAlertBehavior(int r10) {
            this.mGroupAlertBehavior = r10;
            return this;
        }

        @NonNull
        public Builder setGroupSummary(boolean r10) {
            this.mGroupSummary = r10;
            return this;
        }

        @NonNull
        public Builder setLargeIcon(@Nullable Bitmap r10) {
            this.mLargeIcon = reduceLargeIconSize(r10);
            return this;
        }

        @NonNull
        public Builder setLights(@ColorInt int r10, int r11, int r12) {
            Notification r13 = this.mNotification;
            r13.ledARGB = r10;
            r13.ledOnMS = r11;
            r13.ledOffMS = r12;
            if (r11 == 0) goto L6;
            if (r12 == 0) goto L6;
            int r14 = 1;
        L7:
            r13.flags = r14 | (r13.flags & (-2));
            return this;
        L6:
            r14 = 0;
            goto L7
        }

        @NonNull
        public Builder setLocalOnly(boolean r10) {
            this.mLocalOnly = r10;
            return this;
        }

        @NonNull
        public Builder setLocusId(@Nullable LocusIdCompat r10) {
            this.mLocusId = r10;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setNotificationSilent() {
            this.mSilent = true;
            return this;
        }

        @NonNull
        public Builder setNumber(int r10) {
            this.mNumber = r10;
            return this;
        }

        @NonNull
        public Builder setOngoing(boolean r10) {
            setFlag(2, r10);
            return this;
        }

        @NonNull
        public Builder setOnlyAlertOnce(boolean r10) {
            setFlag(8, r10);
            return this;
        }

        @NonNull
        public Builder setPriority(int r10) {
            this.mPriority = r10;
            return this;
        }

        @NonNull
        public Builder setProgress(int r10, int r11, boolean r12) {
            this.mProgressMax = r10;
            this.mProgress = r11;
            this.mProgressIndeterminate = r12;
            return this;
        }

        @NonNull
        public Builder setPublicVersion(@Nullable Notification r10) {
            this.mPublicVersion = r10;
            return this;
        }

        @NonNull
        public Builder setRemoteInputHistory(@Nullable CharSequence[] r10) {
            this.mRemoteInputHistory = r10;
            return this;
        }

        @NonNull
        public Builder setSettingsText(@Nullable CharSequence r10) {
            this.mSettingsText = limitCharSequenceLength(r10);
            return this;
        }

        @NonNull
        public Builder setShortcutId(@Nullable String r10) {
            this.mShortcutId = r10;
            return this;
        }

        @NonNull
        public Builder setShortcutInfo(@Nullable ShortcutInfoCompat r10) {
            if (r10 != null) goto L4;
            return this;
        L4:
            this.mShortcutId = r10.getId();
            if (this.mLocusId != null) goto L14;
            if (r10.getLocusId() == null) goto L11;
            LocusIdCompat r11 = r10.getLocusId();
        L9:
            this.mLocusId = r11;
            goto L14
        L11:
            if (r10.getId() == null) goto L14;
            r11 = new LocusIdCompat(r10.getId());
        L14:
            if (this.mContentTitle != null) goto L16;
            setContentTitle(r10.getShortLabel());
        L16:
            return this;
        }

        @NonNull
        public Builder setShowWhen(boolean r10) {
            this.mShowWhen = r10;
            return this;
        }

        @NonNull
        public Builder setSilent(boolean r10) {
            this.mSilent = r10;
            return this;
        }

        @NonNull
        public Builder setSmallIcon(int r10) {
            this.mNotification.icon = r10;
            return this;
        }

        @NonNull
        public Builder setSmallIcon(int r10, int r11) {
            Notification r12 = this.mNotification;
            r12.icon = r10;
            r12.iconLevel = r11;
            return this;
        }

        @NonNull
        @RequiresApi(23)
        public Builder setSmallIcon(@NonNull IconCompat r10) {
            this.mSmallIcon = r10.toIcon(this.mContext);
            return this;
        }

        @NonNull
        public Builder setSortKey(@Nullable String r10) {
            this.mSortKey = r10;
            return this;
        }

        @NonNull
        public Builder setSound(@Nullable Uri r10) {
            Notification r11 = this.mNotification;
            r11.sound = r10;
            r11.audioStreamType = -1;
            if (Build.VERSION.SDK_INT < 21) goto L5;
            AudioAttributes.Builder r12 = Api21Impl.setUsage(Api21Impl.setContentType(Api21Impl.createBuilder(), 4), 5);
            Notification r13 = this.mNotification;
            r13.audioAttributes = Api21Impl.build(r12);
        L5:
            return this;
        }

        @NonNull
        public Builder setSound(@Nullable Uri r10, int r11) {
            Notification r12 = this.mNotification;
            r12.sound = r10;
            r12.audioStreamType = r11;
            if (Build.VERSION.SDK_INT < 21) goto L5;
            AudioAttributes.Builder r13 = Api21Impl.setLegacyStreamType(Api21Impl.setContentType(Api21Impl.createBuilder(), 4), r11);
            Notification r14 = this.mNotification;
            r14.audioAttributes = Api21Impl.build(r13);
        L5:
            return this;
        }

        @NonNull
        public Builder setStyle(@Nullable Style r10) {
            if (this.mStyle == r10) goto L7;
            this.mStyle = r10;
            if (r10 == null) goto L7;
            r10.setBuilder(this);
        L7:
            return this;
        }

        @NonNull
        public Builder setSubText(@Nullable CharSequence r10) {
            this.mSubText = limitCharSequenceLength(r10);
            return this;
        }

        @NonNull
        public Builder setTicker(@Nullable CharSequence r10) {
            Notification r11 = this.mNotification;
            r11.tickerText = limitCharSequenceLength(r10);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setTicker(@Nullable CharSequence r10, @Nullable RemoteViews r11) {
            Notification r12 = this.mNotification;
            r12.tickerText = limitCharSequenceLength(r10);
            this.mTickerView = r11;
            return this;
        }

        @NonNull
        public Builder setTimeoutAfter(long r10) {
            this.mTimeout = r10;
            return this;
        }

        @NonNull
        public Builder setUsesChronometer(boolean r10) {
            this.mUseChronometer = r10;
            return this;
        }

        @NonNull
        public Builder setVibrate(@Nullable long[] r10) {
            this.mNotification.vibrate = r10;
            return this;
        }

        @NonNull
        public Builder setVisibility(int r10) {
            this.mVisibility = r10;
            return this;
        }

        @NonNull
        public Builder setWhen(long r10) {
            this.mNotification.when = r10;
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

        @RequiresApi(16)
        static class Api16Impl {
            private Api16Impl() {
            }

            @DoNotInline
            static void setBuilder(Notification.CallStyle r10, Notification.Builder r11) {
                r10.setBuilder(r11);
            }
        }

        @RequiresApi(20)
        static class Api20Impl {
            private Api20Impl() {
            }

            @DoNotInline
            static Notification.Builder addAction(Notification.Builder r10, Notification.Action r11) {
                return r10.addAction(r11);
            }

            @DoNotInline
            static Notification.Action.Builder addExtras(Notification.Action.Builder r10, Bundle r11) {
                return r10.addExtras(r11);
            }

            @DoNotInline
            static Notification.Action.Builder addRemoteInput(Notification.Action.Builder r10, android.app.RemoteInput r11) {
                return r10.addRemoteInput(r11);
            }

            @DoNotInline
            static Notification.Action build(Notification.Action.Builder r10) {
                return r10.build();
            }

            @DoNotInline
            static Notification.Action.Builder createActionBuilder(int r10, CharSequence r11, PendingIntent r12) {
                return new Notification.Action.Builder(r10, r11, r12);
            }
        }

        @RequiresApi(21)
        static class Api21Impl {
            private Api21Impl() {
            }

            @DoNotInline
            static Notification.Builder addPerson(Notification.Builder r10, String r11) {
                return r10.addPerson(r11);
            }

            @DoNotInline
            static Notification.Builder setCategory(Notification.Builder r10, String r11) {
                return r10.setCategory(r11);
            }
        }

        @RequiresApi(23)
        static class Api23Impl {
            private Api23Impl() {
            }

            @DoNotInline
            static Notification.Action.Builder createActionBuilder(Icon r10, CharSequence r11, PendingIntent r12) {
                return new Notification.Action.Builder(r10, r11, r12);
            }

            @DoNotInline
            static void setLargeIcon(Notification.Builder r10, Icon r11) {
                r10.setLargeIcon(r11);
            }
        }

        @RequiresApi(24)
        static class Api24Impl {
            private Api24Impl() {
            }

            @DoNotInline
            static Notification.Builder clearActions(Notification.Builder r10) {
                return r10.setActions(new Notification.Action[0]);
            }

            @DoNotInline
            static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder r10, boolean r11) {
                return r10.setAllowGeneratedReplies(r11);
            }
        }

        @RequiresApi(28)
        static class Api28Impl {
            private Api28Impl() {
            }

            @DoNotInline
            static Notification.Builder addPerson(Notification.Builder r10, android.app.Person r11) {
                return r10.addPerson(r11);
            }
        }

        @RequiresApi(31)
        static class Api31Impl {
            private Api31Impl() {
            }

            @DoNotInline
            static Notification.CallStyle forIncomingCall(@NonNull android.app.Person r10, @NonNull PendingIntent r11, @NonNull PendingIntent r12) {
                return Notification.CallStyle.forIncomingCall(r10, r11, r12);
            }

            @DoNotInline
            static Notification.CallStyle forOngoingCall(@NonNull android.app.Person r10, @NonNull PendingIntent r11) {
                return Notification.CallStyle.forOngoingCall(r10, r11);
            }

            @DoNotInline
            static Notification.CallStyle forScreeningCall(@NonNull android.app.Person r10, @NonNull PendingIntent r11, @NonNull PendingIntent r12) {
                return Notification.CallStyle.forScreeningCall(r10, r11, r12);
            }

            @DoNotInline
            static Notification.CallStyle setAnswerButtonColorHint(Notification.CallStyle r10, @ColorInt int r11) {
                return r10.setAnswerButtonColorHint(r11);
            }

            @DoNotInline
            static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder r10, boolean r11) {
                return r10.setAuthenticationRequired(r11);
            }

            @DoNotInline
            static Notification.CallStyle setDeclineButtonColorHint(Notification.CallStyle r10, @ColorInt int r11) {
                return r10.setDeclineButtonColorHint(r11);
            }

            @DoNotInline
            static Notification.CallStyle setIsVideo(Notification.CallStyle r10, boolean r11) {
                return r10.setIsVideo(r11);
            }

            @DoNotInline
            static Notification.CallStyle setVerificationIcon(Notification.CallStyle r10, @Nullable Icon r11) {
                return r10.setVerificationIcon(r11);
            }

            @DoNotInline
            static Notification.CallStyle setVerificationText(Notification.CallStyle r10, @Nullable CharSequence r11) {
                return r10.setVerificationText(r11);
            }
        }

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public @interface CallType {
        }

        public CallStyle() {
        }

        private CallStyle(int r10, @NonNull Person r11, @Nullable PendingIntent r12, @Nullable PendingIntent r13, @Nullable PendingIntent r14) {
            if (r11 == null) goto L9;
            if (TextUtils.isEmpty(r11.getName()) == true) goto L9;
            this.mCallType = r10;
            this.mPerson = r11;
            this.mAnswerIntent = r14;
            this.mDeclineIntent = r13;
            this.mHangUpIntent = r12;
            return;
        L9:
            throw new IllegalArgumentException("person must have a non-empty a name");
        }

        public CallStyle(@Nullable Builder r10) {
            setBuilder(r10);
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

        @RequiresApi(20)
        private static Notification.Action getActionFromActionCompat(Action r10) {
            int r11 = Build.VERSION.SDK_INT;
            int r12 = 0;
            if (r11 < 23) goto L9;
            IconCompat r13 = r10.getIconCompat();
            if (r13 != null) goto L7;
            Icon r14 = null;
        L8:
            Notification.Action.Builder r15 = Api23Impl.createActionBuilder(r14, r10.getTitle(), r10.getActionIntent());
        L17:
            if (r10.getExtras() == null) goto L19;
            Bundle r16 = new Bundle(r10.getExtras());
        L20:
            r16.putBoolean("android.support.allowGeneratedReplies", r10.getAllowGeneratedReplies());
            if (r11 < 24) goto L24;
            Api24Impl.setAllowGeneratedReplies(r15, r10.getAllowGeneratedReplies());
        L24:
            if (r11 < 31) goto L26;
            Api31Impl.setAuthenticationRequired(r15, r10.isAuthenticationRequired());
        L26:
            Api20Impl.addExtras(r15, r16);
            RemoteInput[] r17 = r10.getRemoteInputs();
            if (r17 == null) goto L32;
            android.app.RemoteInput[] r18 = RemoteInput.fromCompat(r17);
            int r19 = r18.length;
        L29:
            if (r12 >= r19) goto L32;
            Api20Impl.addRemoteInput(r15, r18[r12]);
            r12 = r12 + 1;
        L32:
            return Api20Impl.build(r15);
        L19:
            r16 = new Bundle();
            goto L20
        L7:
            r14 = r13.toIcon();
            goto L8
        L9:
            IconCompat r20 = r10.getIconCompat();
            if (r20 != null) goto L12;
        L14:
            int r21 = 0;
        L15:
            r15 = Api20Impl.createActionBuilder(r21, r10.getTitle(), r10.getActionIntent());
            goto L17
        L12:
            if (r20.getType() != 2) goto L14;
            r21 = r20.getResId();
            goto L15
        }

        @Nullable
        private String getDefaultText() {
            int r10 = this.mCallType;
            if (r10 != 1) goto L5;
            Resources r11 = this.mBuilder.mContext.getResources();
            int r12 = R.string.call_notification_incoming_text;
        L12:
            return r11.getString(r12);
        L5:
            if (r10 != 2) goto L7;
            r11 = this.mBuilder.mContext.getResources();
            r12 = R.string.call_notification_ongoing_text;
            goto L12
        L7:
            if (r10 == 3) goto L10;
            return null;
        L10:
            r11 = this.mBuilder.mContext.getResources();
            r12 = R.string.call_notification_screening_text;
            goto L12
        }

        private boolean isActionAddedByCallStyle(Action r10) {
            if (r10 != null) goto L4;
        L6:
            return false;
        L4:
            if (r10.getExtras().getBoolean(KEY_ACTION_PRIORITY) == false) goto L6;
            return true;
        }

        @NonNull
        @RequiresApi(20)
        private Action makeAction(int r10, int r11, Integer r12, int r13, PendingIntent r14) {
            if (r12 != null) goto L4;
            r12 = Integer.valueOf(ContextCompat.getColor(this.mBuilder.mContext, r13));
        L4:
            SpannableStringBuilder r15 = new SpannableStringBuilder();
            r15.append(this.mBuilder.mContext.getResources().getString(r11));
            r15.setSpan(new ForegroundColorSpan(r12.intValue()), 0, r15.length(), 18);
            Action r16 = new Action.Builder(IconCompat.createWithResource(this.mBuilder.mContext, r10), r15, r14).build();
            r16.getExtras().putBoolean(KEY_ACTION_PRIORITY, true);
            return r16;
        }

        @Nullable
        @RequiresApi(20)
        private Action makeAnswerAction() {
            int r10 = R.drawable.ic_call_answer_video_low;
            int r11 = R.drawable.ic_call_answer_low;
            if (Build.VERSION.SDK_INT < 21) goto L5;
            r10 = R.drawable.ic_call_answer_video;
            r11 = R.drawable.ic_call_answer;
        L5:
            PendingIntent r12 = this.mAnswerIntent;
            if (r12 != null) goto L8;
            return null;
        L8:
            boolean r13 = this.mIsVideo;
            if (r13 == false) goto L11;
            int r14 = r10;
        L12:
            if (r13 == false) goto L14;
            int r15 = R.string.call_notification_answer_video_action;
        L16:
            return makeAction(r14, r15, this.mAnswerButtonColor, R.color.call_notification_answer_color, r12);
        L14:
            r15 = R.string.call_notification_answer_action;
            goto L16
        L11:
            r14 = r11;
            goto L12
        }

        @NonNull
        @RequiresApi(20)
        private Action makeNegativeAction() {
            int r10 = R.drawable.ic_call_decline_low;
            if (Build.VERSION.SDK_INT < 21) goto L5;
            r10 = R.drawable.ic_call_decline;
        L5:
            int r11 = r10;
            PendingIntent r12 = this.mDeclineIntent;
            if (r12 != null) goto L10;
            int r13 = R.string.call_notification_hang_up_action;
            Integer r14 = this.mDeclineButtonColor;
            int r15 = R.color.call_notification_decline_color;
            r12 = this.mHangUpIntent;
        L9:
            return makeAction(r11, r13, r14, r15, r12);
        L10:
            r13 = R.string.call_notification_decline_action;
            r14 = this.mDeclineButtonColor;
            r15 = R.color.call_notification_decline_color;
            goto L9
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(@NonNull Bundle r10) {
            super.addCompatExtras(r10);
            r10.putInt(NotificationCompat.EXTRA_CALL_TYPE, this.mCallType);
            r10.putBoolean(NotificationCompat.EXTRA_CALL_IS_VIDEO, this.mIsVideo);
            Person r11 = this.mPerson;
            if (r11 != null) goto L5;
        L9:
            IconCompat r12 = this.mVerificationIcon;
            if (r12 != null) goto L12;
        L16:
            r10.putCharSequence(NotificationCompat.EXTRA_VERIFICATION_TEXT, this.mVerificationText);
            r10.putParcelable(NotificationCompat.EXTRA_ANSWER_INTENT, this.mAnswerIntent);
            r10.putParcelable(NotificationCompat.EXTRA_DECLINE_INTENT, this.mDeclineIntent);
            r10.putParcelable(NotificationCompat.EXTRA_HANG_UP_INTENT, this.mHangUpIntent);
            Integer r13 = this.mAnswerButtonColor;
            if (r13 == null) goto L19;
            r10.putInt(NotificationCompat.EXTRA_ANSWER_COLOR, r13.intValue());
        L19:
            Integer r14 = this.mDeclineButtonColor;
            if (r14 == null) goto L23;
            r10.putInt(NotificationCompat.EXTRA_DECLINE_COLOR, r14.intValue());
            return;
        L23:
            return;
        L12:
            if (Build.VERSION.SDK_INT < 23) goto L14;
            Parcelable r15 = r12.toIcon(this.mBuilder.mContext);
            String r16 = NotificationCompat.EXTRA_VERIFICATION_ICON;
        L15:
            r10.putParcelable(r16, r15);
            goto L16
        L14:
            r15 = r12.toBundle();
            r16 = NotificationCompat.EXTRA_VERIFICATION_ICON_COMPAT;
            goto L15
        L5:
            if (Build.VERSION.SDK_INT < 28) goto L7;
            Parcelable r17 = r11.toAndroidPerson();
            String r18 = NotificationCompat.EXTRA_CALL_PERSON;
        L8:
            r10.putParcelable(r18, r17);
            goto L9
        L7:
            r17 = r11.toBundle();
            r18 = NotificationCompat.EXTRA_CALL_PERSON_COMPAT;
            goto L8
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r10) {
            int r11 = Build.VERSION.SDK_INT;
            CharSequence r12 = null;
            Notification.CallStyle r13 = null;
            r13 = null;
            r12 = null;
            if (r11 < 31) goto L27;
            int r14 = this.mCallType;
            if (r14 != 1) goto L7;
            r13 = Api31Impl.forIncomingCall(this.mPerson.toAndroidPerson(), this.mDeclineIntent, this.mAnswerIntent);
        L16:
            if (r13 == null) goto L64;
            Api24Impl.clearActions(r10.getBuilder());
            Api16Impl.setBuilder(r13, r10.getBuilder());
            Integer r15 = this.mAnswerButtonColor;
            if (r15 == null) goto L20;
            Api31Impl.setAnswerButtonColorHint(r13, r15.intValue());
        L20:
            Integer r16 = this.mDeclineButtonColor;
            if (r16 == null) goto L23;
            Api31Impl.setDeclineButtonColorHint(r13, r16.intValue());
        L23:
            Api31Impl.setVerificationText(r13, this.mVerificationText);
            IconCompat r17 = this.mVerificationIcon;
            if (r17 == null) goto L26;
            Api31Impl.setVerificationIcon(r13, r17.toIcon(this.mBuilder.mContext));
        L26:
            Api31Impl.setIsVideo(r13, this.mIsVideo);
            return;
        L64:
            return;
        L7:
            if (r14 != 2) goto L9;
            r13 = Api31Impl.forOngoingCall(this.mPerson.toAndroidPerson(), this.mHangUpIntent);
            goto L16
        L9:
            if (r14 != 3) goto L11;
            r13 = Api31Impl.forScreeningCall(this.mPerson.toAndroidPerson(), this.mHangUpIntent, this.mAnswerIntent);
            goto L16
        L11:
            if (Log.isLoggable(NotificationCompat.TAG, 3) == false) goto L16;
            Log.d(NotificationCompat.TAG, "Unrecognized call type in CallStyle: " + String.valueOf(this.mCallType));
            goto L16
        L27:
            Notification.Builder r18 = r10.getBuilder();
            Person r19 = this.mPerson;
            if (r19 == null) goto L30;
            CharSequence r20 = r19.getName();
        L31:
            r18.setContentTitle(r20);
            Bundle r21 = this.mBuilder.mExtras;
            if (r21 != null) goto L34;
        L36:
            if (r12 != null) goto L38;
            r12 = getDefaultText();
        L38:
            r18.setContentText(r12);
            Person r22 = this.mPerson;
            if (r22 == null) goto L51;
            if (r11 < 23) goto L46;
            if (r22.getIcon() == null) goto L46;
            Api23Impl.setLargeIcon(r18, this.mPerson.getIcon().toIcon(this.mBuilder.mContext));
        L46:
            if (r11 < 28) goto L48;
            Api28Impl.addPerson(r18, this.mPerson.toAndroidPerson());
            goto L51
        L48:
            if (r11 < 21) goto L51;
            Api21Impl.addPerson(r18, this.mPerson.getUri());
        L51:
            if (r11 < 20) goto L60;
            ArrayList<Action> r23 = getActionsListWithSystemActions();
            if (r11 < 24) goto L55;
            Api24Impl.clearActions(r18);
        L55:
            Iterator<Action> r24 = r23.iterator();
        L57:
            if (r24.hasNext() == false) goto L60;
            Api20Impl.addAction(r18, getActionFromActionCompat(r24.next()));
        L60:
            if (Build.VERSION.SDK_INT < 21) goto L66;
            Api21Impl.setCategory(r18, NotificationCompat.CATEGORY_CALL);
            return;
        L66:
            return;
        L34:
            if (r21.containsKey(NotificationCompat.EXTRA_TEXT) == false) goto L36;
            r12 = this.mBuilder.mExtras.getCharSequence(NotificationCompat.EXTRA_TEXT);
            goto L36
        L30:
            r20 = null;
            goto L31
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
            Action r10 = makeNegativeAction();
            Action r11 = makeAnswerAction();
            ArrayList<Action> r12 = new ArrayList(3);
            r12.add(r10);
            int r13 = 2;
            ArrayList<Action> r14 = this.mBuilder.mActions;
            if (r14 == null) goto L18;
            Iterator<Action> r15 = r14.iterator();
        L6:
            if (r15.hasNext() == false) goto L18;
            Action r16 = r15.next();
            if (r16.isContextual() == false) goto L11;
            r12.add(r16);
        L15:
            if (r11 == null) goto L6;
            if (r13 != 1) goto L6;
            r12.add(r11);
            r13 = r13 - 1;
            goto L6
        L11:
            if (isActionAddedByCallStyle(r16) == true) goto L15;
            if (r13 <= 1) goto L15;
            r12.add(r16);
            r13 = r13 - 1;
        L18:
            if (r11 == null) goto L21;
            if (r13 < 1) goto L21;
            r12.add(r11);
        L21:
            return r12;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected void restoreFromCompatExtras(@NonNull Bundle r10) {
            super.restoreFromCompatExtras(r10);
            this.mCallType = r10.getInt(NotificationCompat.EXTRA_CALL_TYPE);
            this.mIsVideo = r10.getBoolean(NotificationCompat.EXTRA_CALL_IS_VIDEO);
            int r11 = Build.VERSION.SDK_INT;
            if (r11 < 28) goto L8;
            if (r10.containsKey(NotificationCompat.EXTRA_CALL_PERSON) == false) goto L8;
            Person r12 = Person.fromAndroidPerson((android.app.Person) r10.getParcelable(NotificationCompat.EXTRA_CALL_PERSON));
        L10:
            this.mPerson = r12;
        L12:
            if (r11 < 23) goto L17;
            if (r10.containsKey(NotificationCompat.EXTRA_VERIFICATION_ICON) == false) goto L17;
            IconCompat r13 = IconCompat.createFromIcon((Icon) r10.getParcelable(NotificationCompat.EXTRA_VERIFICATION_ICON));
        L19:
            this.mVerificationIcon = r13;
        L20:
            this.mVerificationText = r10.getCharSequence(NotificationCompat.EXTRA_VERIFICATION_TEXT);
            this.mAnswerIntent = (PendingIntent) r10.getParcelable(NotificationCompat.EXTRA_ANSWER_INTENT);
            this.mDeclineIntent = (PendingIntent) r10.getParcelable(NotificationCompat.EXTRA_DECLINE_INTENT);
            this.mHangUpIntent = (PendingIntent) r10.getParcelable(NotificationCompat.EXTRA_HANG_UP_INTENT);
            Integer r14 = null;
            if (r10.containsKey(NotificationCompat.EXTRA_ANSWER_COLOR) == false) goto L23;
            Integer r15 = Integer.valueOf(r10.getInt(NotificationCompat.EXTRA_ANSWER_COLOR));
        L24:
            this.mAnswerButtonColor = r15;
            if (r10.containsKey(NotificationCompat.EXTRA_DECLINE_COLOR) == false) goto L27;
            r14 = Integer.valueOf(r10.getInt(NotificationCompat.EXTRA_DECLINE_COLOR));
        L27:
            this.mDeclineButtonColor = r14;
            return;
        L23:
            r15 = null;
        L17:
            if (r10.containsKey(NotificationCompat.EXTRA_VERIFICATION_ICON_COMPAT) == false) goto L20;
            r13 = IconCompat.createFromBundle(r10.getBundle(NotificationCompat.EXTRA_VERIFICATION_ICON_COMPAT));
        L8:
            if (r10.containsKey(NotificationCompat.EXTRA_CALL_PERSON_COMPAT) == false) goto L12;
            r12 = Person.fromBundle(r10.getBundle(NotificationCompat.EXTRA_CALL_PERSON_COMPAT));
            goto L10
        }

        @NonNull
        public CallStyle setAnswerButtonColorHint(@ColorInt int r10) {
            this.mAnswerButtonColor = Integer.valueOf(r10);
            return this;
        }

        @NonNull
        public CallStyle setDeclineButtonColorHint(@ColorInt int r10) {
            this.mDeclineButtonColor = Integer.valueOf(r10);
            return this;
        }

        @NonNull
        public CallStyle setIsVideo(boolean r10) {
            this.mIsVideo = r10;
            return this;
        }

        @NonNull
        public CallStyle setVerificationIcon(@Nullable Bitmap r10) {
            this.mVerificationIcon = IconCompat.createWithBitmap(r10);
            return this;
        }

        @NonNull
        @RequiresApi(23)
        public CallStyle setVerificationIcon(@Nullable Icon r10) {
            if (r10 != null) goto L4;
            IconCompat r11 = null;
        L5:
            this.mVerificationIcon = r11;
            return this;
        L4:
            r11 = IconCompat.createFromIcon(r10);
            goto L5
        }

        @NonNull
        public CallStyle setVerificationText(@Nullable CharSequence r10) {
            this.mVerificationText = r10;
            return this;
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
        static class Api20Impl {
            private Api20Impl() {
            }

            @DoNotInline
            static android.app.RemoteInput.Builder addExtras(android.app.RemoteInput.Builder r10, Bundle r11) {
                return r10.addExtras(r11);
            }

            @DoNotInline
            static android.app.RemoteInput build(android.app.RemoteInput.Builder r10) {
                return r10.build();
            }

            @DoNotInline
            static android.app.RemoteInput.Builder createBuilder(String r10) {
                return new android.app.RemoteInput.Builder(r10);
            }

            @DoNotInline
            static boolean getAllowFreeFormInput(android.app.RemoteInput r10) {
                return r10.getAllowFreeFormInput();
            }

            @DoNotInline
            static CharSequence[] getChoices(android.app.RemoteInput r10) {
                return r10.getChoices();
            }

            @DoNotInline
            static Bundle getExtras(android.app.RemoteInput r10) {
                return r10.getExtras();
            }

            @DoNotInline
            static CharSequence getLabel(android.app.RemoteInput r10) {
                return r10.getLabel();
            }

            @DoNotInline
            static String getResultKey(android.app.RemoteInput r10) {
                return r10.getResultKey();
            }

            @DoNotInline
            static android.app.RemoteInput.Builder setAllowFreeFormInput(android.app.RemoteInput.Builder r10, boolean r11) {
                return r10.setAllowFreeFormInput(r11);
            }

            @DoNotInline
            static android.app.RemoteInput.Builder setChoices(android.app.RemoteInput.Builder r10, CharSequence[] r11) {
                return r10.setChoices(r11);
            }

            @DoNotInline
            static android.app.RemoteInput.Builder setLabel(android.app.RemoteInput.Builder r10, CharSequence r11) {
                return r10.setLabel(r11);
            }
        }

        @RequiresApi(29)
        static class Api29Impl {
            private Api29Impl() {
            }

            @DoNotInline
            static int getEditChoicesBeforeSending(android.app.RemoteInput r10) {
                return r10.getEditChoicesBeforeSending();
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

                public Builder(@NonNull String r10) {
                    this.mMessages = new ArrayList();
                    this.mParticipant = r10;
                }

                @NonNull
                public Builder addMessage(@Nullable String r10) {
                    if (r10 == null) goto L4;
                    this.mMessages.add(r10);
                L4:
                    return this;
                }

                @NonNull
                public UnreadConversation build() {
                    List<String> r10 = this.mMessages;
                    return new UnreadConversation((String[]) r10.toArray(new String[r10.size()]), this.mRemoteInput, this.mReplyPendingIntent, this.mReadPendingIntent, new String[]{this.mParticipant}, this.mLatestTimestamp);
                }

                @NonNull
                public Builder setLatestTimestamp(long r10) {
                    this.mLatestTimestamp = r10;
                    return this;
                }

                @NonNull
                public Builder setReadPendingIntent(@Nullable PendingIntent r10) {
                    this.mReadPendingIntent = r10;
                    return this;
                }

                @NonNull
                public Builder setReplyAction(@Nullable PendingIntent r10, @Nullable RemoteInput r11) {
                    this.mRemoteInput = r11;
                    this.mReplyPendingIntent = r10;
                    return this;
                }
            }

            UnreadConversation(@Nullable String[] r10, @Nullable RemoteInput r11, @Nullable PendingIntent r12, @Nullable PendingIntent r13, @Nullable String[] r14, long r15) {
                this.mMessages = r10;
                this.mRemoteInput = r11;
                this.mReadPendingIntent = r13;
                this.mReplyPendingIntent = r12;
                this.mParticipants = r14;
                this.mLatestTimestamp = r15;
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
                String[] r10 = this.mParticipants;
                if (r10.length > 0) goto L7;
                return null;
            L7:
                return r10[0];
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

        public CarExtender(@NonNull Notification r10) {
            this.mColor = 0;
            if (Build.VERSION.SDK_INT >= 21) goto L6;
            return;
        L6:
            if (NotificationCompat.getExtras(r10) != null) goto L8;
            Bundle r11 = null;
        L9:
            if (r11 == null) goto L12;
            this.mLargeIcon = (Bitmap) r11.getParcelable(EXTRA_LARGE_ICON);
            this.mColor = r11.getInt(EXTRA_COLOR, 0);
            this.mUnreadConversation = getUnreadConversationFromBundle(r11.getBundle(EXTRA_CONVERSATION));
            return;
        L12:
            return;
        L8:
            r11 = NotificationCompat.getExtras(r10).getBundle(EXTRA_CAR_EXTENDER);
            goto L9
        }

        @RequiresApi(21)
        private static Bundle getBundleForUnreadConversation(@NonNull UnreadConversation r10) {
            Bundle r11 = new Bundle();
            int r12 = 0;
            if (r10.getParticipants() != null) goto L5;
        L7:
            String r13 = null;
        L8:
            int r14 = r10.getMessages().length;
            Parcelable[] r15 = new Parcelable[r14];
        L9:
            if (r12 >= r14) goto L11;
            Bundle r16 = new Bundle();
            r16.putString(KEY_TEXT, r10.getMessages()[r12]);
            r16.putString(KEY_AUTHOR, r13);
            r15[r12] = r16;
            r12 = r12 + 1;
            goto L9
        L11:
            r11.putParcelableArray(KEY_MESSAGES, r15);
            RemoteInput r17 = r10.getRemoteInput();
            if (r17 == null) goto L14;
            android.app.RemoteInput.Builder r18 = Api20Impl.createBuilder(r17.getResultKey());
            Api20Impl.setLabel(r18, r17.getLabel());
            Api20Impl.setChoices(r18, r17.getChoices());
            Api20Impl.setAllowFreeFormInput(r18, r17.getAllowFreeFormInput());
            Api20Impl.addExtras(r18, r17.getExtras());
            r11.putParcelable(KEY_REMOTE_INPUT, Api20Impl.build(r18));
        L14:
            r11.putParcelable(KEY_ON_REPLY, r10.getReplyPendingIntent());
            r11.putParcelable(KEY_ON_READ, r10.getReadPendingIntent());
            r11.putStringArray(KEY_PARTICIPANTS, r10.getParticipants());
            r11.putLong("timestamp", r10.getLatestTimestamp());
            return r11;
        L5:
            if (r10.getParticipants().length <= 1) goto L7;
            r13 = r10.getParticipants()[0];
            goto L8
        }

        @RequiresApi(21)
        private static UnreadConversation getUnreadConversationFromBundle(@Nullable Bundle r21) {
            RemoteInput r10 = null;
            if (r21 != null) goto L5;
            return null;
        L5:
            Parcelable[] r11 = r21.getParcelableArray(KEY_MESSAGES);
            int r12 = 0;
            if (r11 == null) goto L20;
            int r13 = r11.length;
            String[] r14 = new String[r13];
            int r15 = 0;
        L8:
            if (r15 >= r13) goto L16;
            if ((r11[r15] instanceof Bundle) == false) goto L11;
            r14[r15] = ((Bundle) r11[r15]).getString(KEY_TEXT);
            if (r14[r15] == null) goto L11;
            r15 = r15 + 1;
        L11:
            boolean r16 = false;
        L17:
            if (r16 == false) goto L19;
            String[] r17 = r14;
        L21:
            PendingIntent r18 = (PendingIntent) r21.getParcelable(KEY_ON_READ);
            PendingIntent r19 = (PendingIntent) r21.getParcelable(KEY_ON_REPLY);
            android.app.RemoteInput r20 = (android.app.RemoteInput) r21.getParcelable(KEY_REMOTE_INPUT);
            String[] r110 = r21.getStringArray(KEY_PARTICIPANTS);
            if (r110 != null) goto L24;
            return null;
        L24:
            if (r110.length != 1) goto L37;
            if (r20 == null) goto L32;
            String r111 = Api20Impl.getResultKey(r20);
            CharSequence r112 = Api20Impl.getLabel(r20);
            CharSequence[] r113 = Api20Impl.getChoices(r20);
            boolean r114 = Api20Impl.getAllowFreeFormInput(r20);
            if (Build.VERSION.SDK_INT < 29) goto L30;
            r12 = Api29Impl.getEditChoicesBeforeSending(r20);
        L30:
            r10 = new RemoteInput(r111, r112, r113, r114, r12, Api20Impl.getExtras(r20), null);
        L32:
            return new UnreadConversation(r17, r10, r19, r18, r110, r21.getLong("timestamp"));
        L37:
            return null;
        L19:
            return null;
        L16:
            r16 = true;
            goto L17
        L20:
            r17 = null;
            goto L21
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        @NonNull
        public Builder extend(@NonNull Builder r10) {
            if (Build.VERSION.SDK_INT >= 21) goto L5;
            return r10;
        L5:
            Bundle r11 = new Bundle();
            Bitmap r12 = this.mLargeIcon;
            if (r12 == null) goto L8;
            r11.putParcelable(EXTRA_LARGE_ICON, r12);
        L8:
            int r13 = this.mColor;
            if (r13 == 0) goto L11;
            r11.putInt(EXTRA_COLOR, r13);
        L11:
            UnreadConversation r14 = this.mUnreadConversation;
            if (r14 == null) goto L14;
            r11.putBundle(EXTRA_CONVERSATION, getBundleForUnreadConversation(r14));
        L14:
            r10.getExtras().putBundle(EXTRA_CAR_EXTENDER, r11);
            return r10;
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
        public CarExtender setColor(@ColorInt int r10) {
            this.mColor = r10;
            return this;
        }

        @NonNull
        public CarExtender setLargeIcon(@Nullable Bitmap r10) {
            this.mLargeIcon = r10;
            return this;
        }

        @NonNull
        @Deprecated
        public CarExtender setUnreadConversation(@Nullable UnreadConversation r10) {
            this.mUnreadConversation = r10;
            return this;
        }
    }

    public static class DecoratedCustomViewStyle extends Style {
        private static final int MAX_ACTION_BUTTONS = 3;
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";

        @RequiresApi(15)
        static class Api15Impl {
            private Api15Impl() {
            }

            @DoNotInline
            static void setContentDescription(RemoteViews r10, int r11, CharSequence r12) {
                r10.setContentDescription(r11, r12);
            }
        }

        @RequiresApi(16)
        static class Api16Impl {
            private Api16Impl() {
            }

            @DoNotInline
            static Notification.Builder setStyle(Notification.Builder r10, Object r11) {
                return r10.setStyle((Notification.Style) r11);
            }
        }

        @RequiresApi(24)
        static class Api24Impl {
            private Api24Impl() {
            }

            @DoNotInline
            static Notification.DecoratedCustomViewStyle createDecoratedCustomViewStyle() {
                return new Notification.DecoratedCustomViewStyle();
            }
        }

        public DecoratedCustomViewStyle() {
        }

        private RemoteViews createRemoteViews(RemoteViews r10, boolean r11) {
            boolean r12 = true;
            int r13 = 0;
            RemoteViews r14 = applyStandardTemplate(true, R.layout.notification_template_custom_big, false);
            r14.removeAllViews(R.id.actions);
            List<Action> r15 = getNonContextualActions(this.mBuilder.mActions);
            if (r11 == false) goto L10;
            if (r15 == null) goto L10;
            int r16 = Math.min(r15.size(), 3);
            if (r16 <= 0) goto L10;
            int r17 = 0;
        L8:
            if (r17 >= r16) goto L11;
            r14.addView(R.id.actions, generateActionButton(r15.get(r17)));
            r17 = r17 + 1;
        L11:
            if (r12 == true) goto L14;
            r13 = 8;
        L14:
            r14.setViewVisibility(R.id.actions, r13);
            r14.setViewVisibility(R.id.action_divider, r13);
            buildIntoRemoteViews(r14, r10);
            return r14;
        L10:
            r12 = false;
            goto L11
        }

        private RemoteViews generateActionButton(Action r10) {
            if (r10.actionIntent != null) goto L5;
            boolean r11 = true;
        L6:
            String r12 = this.mBuilder.mContext.getPackageName();
            if (r11 == false) goto L9;
            int r13 = R.layout.notification_action_tombstone;
        L10:
            RemoteViews r14 = new RemoteViews(r12, r13);
            IconCompat r15 = r10.getIconCompat();
            if (r15 == null) goto L13;
            r14.setImageViewBitmap(R.id.action_image, createColoredBitmap(r15, R.color.notification_action_color_filter));
        L13:
            r14.setTextViewText(R.id.action_text, r10.title);
            if (r11 == true) goto L17;
            r14.setOnClickPendingIntent(R.id.action_container, r10.actionIntent);
        L17:
            if (Build.VERSION.SDK_INT < 15) goto L19;
            Api15Impl.setContentDescription(r14, R.id.action_container, r10.title);
        L19:
            return r14;
        L9:
            r13 = R.layout.notification_action;
            goto L10
        L5:
            r11 = false;
            goto L6
        }

        private static List<Action> getNonContextualActions(List<Action> r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            ArrayList r11 = new ArrayList();
            Iterator<Action> r12 = r10.iterator();
        L7:
            if (r12.hasNext() == false) goto L11;
            Action r13 = r12.next();
            if (r13.isContextual() == true) goto L7;
            r11.add(r13);
            goto L7
        L11:
            return r11;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r10) {
            if (Build.VERSION.SDK_INT < 24) goto L6;
            Api16Impl.setStyle(r10.getBuilder(), Api24Impl.createDecoratedCustomViewStyle());
            return;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean displayCustomViewInline() {
            return true;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r10) {
            if (Build.VERSION.SDK_INT < 24) goto L5;
            return null;
        L5:
            RemoteViews r11 = this.mBuilder.getBigContentView();
            if (r11 != null) goto L9;
            r11 = this.mBuilder.getContentView();
        L9:
            if (r11 != null) goto L12;
            return null;
        L12:
            return createRemoteViews(r11, true);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r10) {
            if (Build.VERSION.SDK_INT < 24) goto L6;
            return null;
        L6:
            if (this.mBuilder.getContentView() != null) goto L9;
            return null;
        L9:
            return createRemoteViews(this.mBuilder.getContentView(), false);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor r10) {
            if (Build.VERSION.SDK_INT < 24) goto L5;
            return null;
        L5:
            RemoteViews r11 = this.mBuilder.getHeadsUpContentView();
            if (r11 == null) goto L8;
            RemoteViews r12 = r11;
        L9:
            if (r11 != null) goto L12;
            return null;
        L12:
            return createRemoteViews(r12, true);
        L8:
            r12 = this.mBuilder.getContentView();
            goto L9
        }
    }

    public interface Extender {
        @NonNull
        Builder extend(@NonNull Builder r10);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface GroupAlertBehavior {
    }

    public static class InboxStyle extends Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$InboxStyle";
        private ArrayList<CharSequence> mTexts;

        @RequiresApi(16)
        static class Api16Impl {
            private Api16Impl() {
            }

            @DoNotInline
            static Notification.InboxStyle addLine(Notification.InboxStyle r10, CharSequence r11) {
                return r10.addLine(r11);
            }

            @DoNotInline
            static Notification.InboxStyle createInboxStyle(Notification.Builder r10) {
                return new Notification.InboxStyle(r10);
            }

            @DoNotInline
            static Notification.InboxStyle setBigContentTitle(Notification.InboxStyle r10, CharSequence r11) {
                return r10.setBigContentTitle(r11);
            }

            @DoNotInline
            static Notification.InboxStyle setSummaryText(Notification.InboxStyle r10, CharSequence r11) {
                return r10.setSummaryText(r11);
            }
        }

        public InboxStyle() {
            this.mTexts = new ArrayList();
        }

        public InboxStyle(@Nullable Builder r10) {
            this.mTexts = new ArrayList();
            setBuilder(r10);
        }

        @NonNull
        public InboxStyle addLine(@Nullable CharSequence r10) {
            if (r10 == null) goto L4;
            this.mTexts.add(Builder.limitCharSequenceLength(r10));
        L4:
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r10) {
            if (Build.VERSION.SDK_INT < 16) goto L11;
            Notification.InboxStyle r11 = Api16Impl.setBigContentTitle(Api16Impl.createInboxStyle(r10.getBuilder()), this.mBigContentTitle);
            if (this.mSummaryTextSet == false) goto L7;
            Api16Impl.setSummaryText(r11, this.mSummaryText);
        L7:
            Iterator<CharSequence> r12 = this.mTexts.iterator();
        L9:
            if (r12.hasNext() == false) goto L13;
            Api16Impl.addLine(r11, r12.next());
            goto L9
        L13:
            return;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected void clearCompatExtraKeys(@NonNull Bundle r10) {
            super.clearCompatExtraKeys(r10);
            r10.remove(NotificationCompat.EXTRA_TEXT_LINES);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected void restoreFromCompatExtras(@NonNull Bundle r10) {
            super.restoreFromCompatExtras(r10);
            this.mTexts.clear();
            if (r10.containsKey(NotificationCompat.EXTRA_TEXT_LINES) == false) goto L6;
            Collections.addAll(this.mTexts, r10.getCharSequenceArray(NotificationCompat.EXTRA_TEXT_LINES));
            return;
        }

        @NonNull
        public InboxStyle setBigContentTitle(@Nullable CharSequence r10) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(r10);
            return this;
        }

        @NonNull
        public InboxStyle setSummaryText(@Nullable CharSequence r10) {
            this.mSummaryText = Builder.limitCharSequenceLength(r10);
            this.mSummaryTextSet = true;
            return this;
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

        @RequiresApi(16)
        static class Api16Impl {
            private Api16Impl() {
            }

            @DoNotInline
            static Notification.BigTextStyle bigText(Notification.BigTextStyle r10, CharSequence r11) {
                return r10.bigText(r11);
            }

            @DoNotInline
            static Notification.BigTextStyle createBigTextStyle(Notification.Builder r10) {
                return new Notification.BigTextStyle(r10);
            }

            @DoNotInline
            static Notification.BigTextStyle setBigContentTitle(Notification.BigTextStyle r10, CharSequence r11) {
                return r10.setBigContentTitle(r11);
            }

            @DoNotInline
            static void setBuilder(Notification.Style r10, Notification.Builder r11) {
                r10.setBuilder(r11);
            }
        }

        @RequiresApi(24)
        static class Api24Impl {
            private Api24Impl() {
            }

            @DoNotInline
            static Notification.MessagingStyle addMessage(Notification.MessagingStyle r10, Notification.MessagingStyle.Message r11) {
                return r10.addMessage(r11);
            }

            @DoNotInline
            static Notification.MessagingStyle createMessagingStyle(CharSequence r10) {
                return new Notification.MessagingStyle(r10);
            }

            @DoNotInline
            static Notification.MessagingStyle setConversationTitle(Notification.MessagingStyle r10, CharSequence r11) {
                return r10.setConversationTitle(r11);
            }
        }

        @RequiresApi(26)
        static class Api26Impl {
            private Api26Impl() {
            }

            @DoNotInline
            static Notification.MessagingStyle addHistoricMessage(Notification.MessagingStyle r10, Notification.MessagingStyle.Message r11) {
                return r10.addHistoricMessage(r11);
            }
        }

        @RequiresApi(28)
        static class Api28Impl {
            private Api28Impl() {
            }

            @DoNotInline
            static Notification.MessagingStyle createMessagingStyle(android.app.Person r10) {
                return new Notification.MessagingStyle(r10);
            }

            @DoNotInline
            static Notification.MessagingStyle setGroupConversation(Notification.MessagingStyle r10, boolean r11) {
                return r10.setGroupConversation(r11);
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
            static class Api24Impl {
                private Api24Impl() {
                }

                @DoNotInline
                static Notification.MessagingStyle.Message createMessage(CharSequence r10, long r11, CharSequence r12) {
                    return new Notification.MessagingStyle.Message(r10, r11, r12);
                }

                @DoNotInline
                static Notification.MessagingStyle.Message setData(Notification.MessagingStyle.Message r10, String r11, Uri r12) {
                    return r10.setData(r11, r12);
                }
            }

            @RequiresApi(28)
            static class Api28Impl {
                private Api28Impl() {
                }

                @DoNotInline
                static Notification.MessagingStyle.Message createMessage(CharSequence r10, long r11, android.app.Person r12) {
                    return new Notification.MessagingStyle.Message(r10, r11, r12);
                }
            }

            public Message(@Nullable CharSequence r10, long r11, @Nullable Person r12) {
                this.mExtras = new Bundle();
                this.mText = r10;
                this.mTimestamp = r11;
                this.mPerson = r12;
            }

            @Deprecated
            public Message(@Nullable CharSequence r10, long r11, @Nullable CharSequence r12) {
                this(r10, r11, new Person.Builder().setName(r12).build());
            }

            @NonNull
            static Bundle[] getBundleArrayForMessages(@NonNull List<Message> r10) {
                Bundle[] r11 = new Bundle[r10.size()];
                int r12 = r10.size();
                int r13 = 0;
            L3:
                if (r13 >= r12) goto L5;
                r11[r13] = r10.get(r13).toBundle();
                r13 = r13 + 1;
                goto L3
            L5:
                return r11;
            }

            @Nullable
            static Message getMessageFromBundle(@NonNull Bundle r10) {
                if (r10.containsKey(KEY_TEXT) == false) goto L29;
                if (r10.containsKey("time") == false) goto L29;
                if (r10.containsKey(KEY_PERSON) == false) goto L12;
                Person r11 = Person.fromBundle(r10.getBundle(KEY_PERSON));     // Catch: ClassCastException -> L30
            L20:
                Message r12 = new Message(r10.getCharSequence(KEY_TEXT), r10.getLong("time"), r11);     // Catch: ClassCastException -> L30
                if (r10.containsKey("type") == false) goto L26;
                if (r10.containsKey(KEY_DATA_URI) == false) goto L26;
                r12.setData(r10.getString("type"), (Uri) r10.getParcelable(KEY_DATA_URI));     // Catch: ClassCastException -> L30
            L26:
                if (r10.containsKey(KEY_EXTRAS_BUNDLE) == false) goto L28;
                r12.getExtras().putAll(r10.getBundle(KEY_EXTRAS_BUNDLE));     // Catch: ClassCastException -> L30
            L28:
                return r12;
            L12:
                if (r10.containsKey(KEY_NOTIFICATION_PERSON) == false) goto L17;
                if (Build.VERSION.SDK_INT < 28) goto L17;
                r11 = Person.fromAndroidPerson((android.app.Person) r10.getParcelable(KEY_NOTIFICATION_PERSON));     // Catch: ClassCastException -> L30
            L17:
                if (r10.containsKey(KEY_SENDER) == false) goto L19;
                r11 = new Person.Builder().setName(r10.getCharSequence(KEY_SENDER)).build();     // Catch: ClassCastException -> L30
                goto L20
            L19:
                r11 = null;
            L29:
                return null;
            }

            @NonNull
            static List<Message> getMessagesFromBundleArray(@NonNull Parcelable[] r10) {
                ArrayList r11 = new ArrayList(r10.length);
                int r12 = 0;
            L4:
                if (r12 >= r10.length) goto L11;
                if ((r10[r12] instanceof Bundle) == false) goto L10;
                Message r13 = getMessageFromBundle((Bundle) r10[r12]);
                if (r13 == null) goto L10;
                r11.add(r13);
            L10:
                r12 = r12 + 1;
                goto L4
            L11:
                return r11;
            }

            @NonNull
            private Bundle toBundle() {
                Bundle r10 = new Bundle();
                CharSequence r11 = this.mText;
                if (r11 == null) goto L5;
                r10.putCharSequence(KEY_TEXT, r11);
            L5:
                r10.putLong("time", this.mTimestamp);
                Person r12 = this.mPerson;
                if (r12 == null) goto L11;
                r10.putCharSequence(KEY_SENDER, r12.getName());
                if (Build.VERSION.SDK_INT < 28) goto L10;
                r10.putParcelable(KEY_NOTIFICATION_PERSON, this.mPerson.toAndroidPerson());
                goto L11
            L10:
                r10.putBundle(KEY_PERSON, this.mPerson.toBundle());
            L11:
                String r13 = this.mDataMimeType;
                if (r13 == null) goto L14;
                r10.putString("type", r13);
            L14:
                Uri r14 = this.mDataUri;
                if (r14 == null) goto L17;
                r10.putParcelable(KEY_DATA_URI, r14);
            L17:
                Bundle r15 = this.mExtras;
                if (r15 == null) goto L20;
                r10.putBundle(KEY_EXTRAS_BUNDLE, r15);
            L20:
                return r10;
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
                Person r10 = this.mPerson;
                if (r10 != null) goto L6;
                return null;
            L6:
                return r10.getName();
            }

            @Nullable
            public CharSequence getText() {
                return this.mText;
            }

            public long getTimestamp() {
                return this.mTimestamp;
            }

            @NonNull
            public Message setData(@Nullable String r10, @Nullable Uri r11) {
                this.mDataMimeType = r10;
                this.mDataUri = r11;
                return this;
            }

            @NonNull
            @RequiresApi(24)
            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
            Notification.MessagingStyle.Message toAndroidMessage() {
                Person r10 = getPerson();
                CharSequence r11 = null;
                android.app.Person r12 = null;
                if (Build.VERSION.SDK_INT < 28) goto L9;
                CharSequence r13 = getText();
                long r14 = getTimestamp();
                if (r10 == null) goto L8;
                r12 = r10.toAndroidPerson();
            L8:
                Notification.MessagingStyle.Message r15 = Api28Impl.createMessage(r13, r14, r12);
            L15:
                if (getDataMimeType() == null) goto L17;
                Api24Impl.setData(r15, getDataMimeType(), getDataUri());
            L17:
                return r15;
            L9:
                CharSequence r16 = getText();
                long r17 = getTimestamp();
                if (r10 == null) goto L13;
                r11 = r10.getName();
            L13:
                r15 = Api24Impl.createMessage(r16, r17, r11);
                goto L15
            }
        }

        MessagingStyle() {
            this.mMessages = new ArrayList();
            this.mHistoricMessages = new ArrayList();
        }

        public MessagingStyle(@NonNull Person r10) {
            this.mMessages = new ArrayList();
            this.mHistoricMessages = new ArrayList();
            if (TextUtils.isEmpty(r10.getName()) == true) goto L7;
            this.mUser = r10;
            return;
        L7:
            throw new IllegalArgumentException("User's name must not be empty.");
        }

        @Deprecated
        public MessagingStyle(@NonNull CharSequence r10) {
            this.mMessages = new ArrayList();
            this.mHistoricMessages = new ArrayList();
            this.mUser = new Person.Builder().setName(r10).build();
        }

        @Nullable
        public static MessagingStyle extractMessagingStyleFromNotification(@NonNull Notification r10) {
            Style r11 = Style.extractStyleFromNotification(r10);
            if ((r11 instanceof MessagingStyle) == true) goto L5;
            return null;
        L5:
            return (MessagingStyle) r11;
        }

        @Nullable
        private Message findLatestIncomingMessage() {
            int r10 = this.mMessages.size() - 1;
        L3:
            if (r10 < 0) goto L11;
            Message r11 = this.mMessages.get(r10);
            if (r11.getPerson() == null) goto L9;
            if (TextUtils.isEmpty(r11.getPerson().getName()) == true) goto L9;
            return r11;
        L9:
            r10 = r10 - 1;
            goto L3
        L11:
            if (this.mMessages.isEmpty() == true) goto L14;
            List<Message> r12 = this.mMessages;
            return r12.get(r12.size() - 1);
        L14:
            return null;
        }

        private boolean hasMessagesWithoutSender() {
            int r10 = this.mMessages.size() - 1;
        L3:
            if (r10 < 0) goto L10;
            Message r11 = this.mMessages.get(r10);
            if (r11.getPerson() == null) goto L9;
            if (r11.getPerson().getName() != null) goto L9;
            return true;
        L9:
            r10 = r10 - 1;
            goto L3
        L10:
            return false;
        }

        @NonNull
        private TextAppearanceSpan makeFontColorSpan(int r10) {
            return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(r10), null);
        }

        private CharSequence makeMessageLine(@NonNull Message r10) {
            BidiFormatter r11 = BidiFormatter.getInstance();
            SpannableStringBuilder r12 = new SpannableStringBuilder();
            if (Build.VERSION.SDK_INT < 21) goto L5;
            boolean r13 = true;
        L6:
            if (r13 == false) goto L8;
            int r14 = ViewCompat.MEASURED_STATE_MASK;
        L9:
            CharSequence r15 = "";
            if (r10.getPerson() != null) goto L12;
            CharSequence r16 = "";
        L14:
            if (TextUtils.isEmpty(r16) == false) goto L20;
            r16 = this.mUser.getName();
            if (r13 == false) goto L20;
            if (this.mBuilder.getColor() == 0) goto L20;
            r14 = this.mBuilder.getColor();
        L20:
            CharSequence r17 = r11.unicodeWrap(r16);
            r12.append(r17);
            r12.setSpan(makeFontColorSpan(r14), r12.length() - r17.length(), r12.length(), 33);
            if (r10.getText() == null) goto L24;
            r15 = r10.getText();
        L24:
            r12.append("  ").append(r11.unicodeWrap(r15));
            return r12;
        L12:
            r16 = r10.getPerson().getName();
            goto L14
        L8:
            r14 = -1;
            goto L9
        L5:
            r13 = false;
            goto L6
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void addCompatExtras(@NonNull Bundle r10) {
            super.addCompatExtras(r10);
            r10.putCharSequence(NotificationCompat.EXTRA_SELF_DISPLAY_NAME, this.mUser.getName());
            r10.putBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER, this.mUser.toBundle());
            r10.putCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE, this.mConversationTitle);
            if (this.mConversationTitle == null) goto L8;
            if (this.mIsGroupConversation.booleanValue() == false) goto L8;
            r10.putCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE, this.mConversationTitle);
        L8:
            if (this.mMessages.isEmpty() == true) goto L11;
            r10.putParcelableArray(NotificationCompat.EXTRA_MESSAGES, Message.getBundleArrayForMessages(this.mMessages));
        L11:
            if (this.mHistoricMessages.isEmpty() == true) goto L13;
            r10.putParcelableArray(NotificationCompat.EXTRA_HISTORIC_MESSAGES, Message.getBundleArrayForMessages(this.mHistoricMessages));
        L13:
            Boolean r11 = this.mIsGroupConversation;
            if (r11 == null) goto L17;
            r10.putBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION, r11.booleanValue());
            return;
        }

        @NonNull
        public MessagingStyle addHistoricMessage(@Nullable Message r10) {
            if (r10 == null) goto L6;
            this.mHistoricMessages.add(r10);
            if (this.mHistoricMessages.size() <= 25) goto L6;
            this.mHistoricMessages.remove(0);
        L6:
            return this;
        }

        @NonNull
        public MessagingStyle addMessage(@Nullable Message r10) {
            if (r10 == null) goto L6;
            this.mMessages.add(r10);
            if (this.mMessages.size() <= 25) goto L6;
            this.mMessages.remove(0);
        L6:
            return this;
        }

        @NonNull
        public MessagingStyle addMessage(@Nullable CharSequence r10, long r11, @Nullable Person r12) {
            addMessage(new Message(r10, r11, r12));
            return this;
        }

        @NonNull
        @Deprecated
        public MessagingStyle addMessage(@Nullable CharSequence r10, long r11, @Nullable CharSequence r12) {
            this.mMessages.add(new Message(r10, r11, new Person.Builder().setName(r12).build()));
            if (this.mMessages.size() <= 25) goto L5;
            this.mMessages.remove(0);
        L5:
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r10) {
            setGroupConversation(isGroupConversation());
            int r11 = Build.VERSION.SDK_INT;
            if (r11 >= 24) goto L5;
            Message r12 = findLatestIncomingMessage();
            if (this.mConversationTitle != null) goto L30;
        L33:
            if (r12 == null) goto L37;
            r10.getBuilder().setContentTitle("");
            if (r12.getPerson() == null) goto L37;
            Notification.Builder r13 = r10.getBuilder();
            CharSequence r14 = r12.getPerson().getName();
        L32:
            r13.setContentTitle(r14);
        L37:
            if (r12 == null) goto L44;
            Notification.Builder r15 = r10.getBuilder();
            if (this.mConversationTitle == null) goto L41;
            CharSequence r16 = makeMessageLine(r12);
        L42:
            r15.setContentText(r16);
            goto L44
        L41:
            r16 = r12.getText();
        L44:
            if (r11 < 16) goto L70;
            SpannableStringBuilder r17 = new SpannableStringBuilder();
            if (this.mConversationTitle == null) goto L48;
        L51:
            boolean r18 = true;
        L52:
            int r19 = this.mMessages.size() - 1;
        L53:
            if (r19 < 0) goto L62;
            Message r20 = this.mMessages.get(r19);
            if (r18 == false) goto L57;
            CharSequence r21 = makeMessageLine(r20);
        L59:
            if (r19 == (this.mMessages.size() - 1)) goto L61;
            r17.insert(0, "\n");
        L61:
            r17.insert(0, r21);
            r19 = r19 - 1;
            goto L53
        L57:
            r21 = r20.getText();
            goto L59
        L62:
            Api16Impl.bigText(Api16Impl.setBigContentTitle(Api16Impl.createBigTextStyle(r10.getBuilder()), null), r17);
            return;
        L48:
            if (hasMessagesWithoutSender() == true) goto L51;
            r18 = false;
            goto L52
        L70:
            return;
        L30:
            if (this.mIsGroupConversation.booleanValue() == false) goto L33;
            r13 = r10.getBuilder();
            r14 = this.mConversationTitle;
            goto L32
        L5:
            if (r11 < 28) goto L7;
            Notification.MessagingStyle r22 = Api28Impl.createMessagingStyle(this.mUser.toAndroidPerson());
        L8:
            Iterator<Message> r23 = this.mMessages.iterator();
        L10:
            if (r23.hasNext() == false) goto L13;
            Api24Impl.addMessage(r22, r23.next().toAndroidMessage());
            goto L10
        L13:
            if (Build.VERSION.SDK_INT < 26) goto L19;
            Iterator<Message> r24 = this.mHistoricMessages.iterator();
        L16:
            if (r24.hasNext() == false) goto L19;
            Api26Impl.addHistoricMessage(r22, r24.next().toAndroidMessage());
        L19:
            if (this.mIsGroupConversation.booleanValue() == false) goto L21;
        L22:
            Api24Impl.setConversationTitle(r22, this.mConversationTitle);
        L24:
            if (Build.VERSION.SDK_INT < 28) goto L26;
            Api28Impl.setGroupConversation(r22, this.mIsGroupConversation.booleanValue());
        L26:
            Api16Impl.setBuilder(r22, r10.getBuilder());
            return;
        L21:
            if (Build.VERSION.SDK_INT < 28) goto L24;
        L7:
            r22 = Api24Impl.createMessagingStyle(this.mUser.getName());
            goto L8
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected void clearCompatExtraKeys(@NonNull Bundle r10) {
            super.clearCompatExtraKeys(r10);
            r10.remove(NotificationCompat.EXTRA_MESSAGING_STYLE_USER);
            r10.remove(NotificationCompat.EXTRA_SELF_DISPLAY_NAME);
            r10.remove(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            r10.remove(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
            r10.remove(NotificationCompat.EXTRA_MESSAGES);
            r10.remove(NotificationCompat.EXTRA_HISTORIC_MESSAGES);
            r10.remove(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected String getClassName() {
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
            Builder r10 = this.mBuilder;
            if (r10 != null) goto L5;
        L12:
            Boolean r11 = this.mIsGroupConversation;
            if (r11 != null) goto L15;
            return false;
        L15:
            return r11.booleanValue();
        L5:
            if (r10.mContext.getApplicationInfo().targetSdkVersion >= 28) goto L12;
            if (this.mIsGroupConversation != null) goto L12;
            if (this.mConversationTitle == null) goto L16;
            return true;
        L16:
            return false;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected void restoreFromCompatExtras(@NonNull Bundle r10) {
            super.restoreFromCompatExtras(r10);
            this.mMessages.clear();
            if (r10.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER) == false) goto L5;
            Person r11 = Person.fromBundle(r10.getBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER));
        L6:
            this.mUser = r11;
            CharSequence r12 = r10.getCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            this.mConversationTitle = r12;
            if (r12 != null) goto L9;
            this.mConversationTitle = r10.getCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
        L9:
            Parcelable[] r13 = r10.getParcelableArray(NotificationCompat.EXTRA_MESSAGES);
            if (r13 == null) goto L12;
            this.mMessages.addAll(Message.getMessagesFromBundleArray(r13));
        L12:
            Parcelable[] r14 = r10.getParcelableArray(NotificationCompat.EXTRA_HISTORIC_MESSAGES);
            if (r14 == null) goto L16;
            this.mHistoricMessages.addAll(Message.getMessagesFromBundleArray(r14));
        L16:
            if (r10.containsKey(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION) == false) goto L19;
            this.mIsGroupConversation = Boolean.valueOf(r10.getBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION));
            return;
        L19:
            return;
        L5:
            r11 = new Person.Builder().setName(r10.getString(NotificationCompat.EXTRA_SELF_DISPLAY_NAME)).build();
            goto L6
        }

        @NonNull
        public MessagingStyle setConversationTitle(@Nullable CharSequence r10) {
            this.mConversationTitle = r10;
            return this;
        }

        @NonNull
        public MessagingStyle setGroupConversation(boolean r10) {
            this.mIsGroupConversation = Boolean.valueOf(r10);
            return this;
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

        @RequiresApi(16)
        static class Api16Impl {
            private Api16Impl() {
            }

            @DoNotInline
            static void setTextViewTextSize(RemoteViews r10, int r11, int r12, float r13) {
                r10.setTextViewTextSize(r11, r12, r13);
            }

            @DoNotInline
            static void setViewPadding(RemoteViews r10, int r11, int r12, int r13, int r14, int r15) {
                r10.setViewPadding(r11, r12, r13, r14, r15);
            }
        }

        @RequiresApi(24)
        static class Api24Impl {
            private Api24Impl() {
            }

            @DoNotInline
            static void setChronometerCountDown(RemoteViews r10, int r11, boolean r12) {
                r10.setChronometerCountDown(r11, r12);
            }
        }

        public Style() {
            this.mSummaryTextSet = false;
        }

        private int calculateTopPadding() {
            Resources r10 = this.mBuilder.mContext.getResources();
            int r11 = r10.getDimensionPixelSize(R.dimen.notification_top_pad);
            int r12 = r10.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
            float r13 = (constrain(r10.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return Math.round(((1.0f - r13) * r11) + (r13 * r12));
        }

        private static float constrain(float r10, float r11, float r12) {
            if (r10 >= r11) goto L6;
            return r11;
        L6:
            if (r10 > r12) goto L8;
            return r10;
        L8:
            return r12;
        }

        @Nullable
        static Style constructCompatStyleByName(@Nullable String r10) {
            if (r10 == null) goto L44;
            byte r11 = -1;
            switch(r10.hashCode()) {
                case -716705180: goto L27;
                case -171946061: goto L23;
                case 714386739: goto L19;
                case 912942987: goto L15;
                case 919595044: goto L11;
                case 2090799565: goto L7;
                default: goto L30;
            };
        L30:
            switch(r11) {
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
            if (r10.equals("androidx.core.app.NotificationCompat$MessagingStyle") == false) goto L30;
            r11 = 5;
            goto L30
        L11:
            if (r10.equals("androidx.core.app.NotificationCompat$BigTextStyle") == false) goto L30;
            r11 = 4;
            goto L30
        L15:
            if (r10.equals("androidx.core.app.NotificationCompat$InboxStyle") == false) goto L30;
            r11 = 3;
            goto L30
        L19:
            if (r10.equals("androidx.core.app.NotificationCompat$CallStyle") == false) goto L30;
            r11 = 2;
            goto L30
        L23:
            if (r10.equals("androidx.core.app.NotificationCompat$BigPictureStyle") == false) goto L30;
            r11 = 1;
            goto L30
        L27:
            if (r10.equals("androidx.core.app.NotificationCompat$DecoratedCustomViewStyle") == false) goto L30;
            r11 = 0;
            goto L30
        L44:
            return null;
        }

        @Nullable
        private static Style constructCompatStyleByPlatformName(@Nullable String r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            int r11 = Build.VERSION.SDK_INT;
            if (r11 >= 16) goto L8;
        L29:
            return null;
        L8:
            if (r10.equals(Notification.BigPictureStyle.class.getName()) == false) goto L12;
            return new BigPictureStyle();
        L12:
            if (r10.equals(Notification.BigTextStyle.class.getName()) == false) goto L16;
            return new BigTextStyle();
        L16:
            if (r10.equals(Notification.InboxStyle.class.getName()) == false) goto L20;
            return new InboxStyle();
        L20:
            if (r11 < 24) goto L29;
            if (r10.equals(Notification.MessagingStyle.class.getName()) == false) goto L26;
            return new MessagingStyle();
        L26:
            if (r10.equals(Notification.DecoratedCustomViewStyle.class.getName()) == false) goto L29;
            return new DecoratedCustomViewStyle();
        }

        @Nullable
        static Style constructCompatStyleForBundle(@NonNull Bundle r10) {
            Style r11 = constructCompatStyleByName(r10.getString(NotificationCompat.EXTRA_COMPAT_TEMPLATE));
            if (r11 == null) goto L6;
            return r11;
        L6:
            if (r10.containsKey(NotificationCompat.EXTRA_SELF_DISPLAY_NAME) == true) goto L32;
            if (r10.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER) == true) goto L32;
            if (r10.containsKey(NotificationCompat.EXTRA_PICTURE) == true) goto L30;
            if (r10.containsKey(NotificationCompat.EXTRA_PICTURE_ICON) == true) goto L30;
            if (r10.containsKey(NotificationCompat.EXTRA_BIG_TEXT) == false) goto L20;
            return new BigTextStyle();
        L20:
            if (r10.containsKey(NotificationCompat.EXTRA_TEXT_LINES) == false) goto L24;
            return new InboxStyle();
        L24:
            if (r10.containsKey(NotificationCompat.EXTRA_CALL_TYPE) == false) goto L28;
            return new CallStyle();
        L28:
            return constructCompatStyleByPlatformName(r10.getString(NotificationCompat.EXTRA_TEMPLATE));
        L30:
            return new BigPictureStyle();
        L32:
            return new MessagingStyle();
        }

        @Nullable
        static Style constructStyleForExtras(@NonNull Bundle r10) {
            Style r11 = constructCompatStyleForBundle(r10);
            if (r11 != null) goto L8;
            return null;
        L8:
            r11.restoreFromCompatExtras(r10);     // Catch: ClassCastException -> L7
            return r11;
        L7:
            return null;
        }

        private Bitmap createColoredBitmap(int r10, int r11, int r12) {
            return createColoredBitmap(IconCompat.createWithResource(this.mBuilder.mContext, r10), r11, r12);
        }

        private Bitmap createColoredBitmap(@NonNull IconCompat r10, int r11, int r12) {
            Drawable r13 = r10.loadDrawable(this.mBuilder.mContext);
            if (r12 != 0) goto L5;
            int r14 = r13.getIntrinsicWidth();
        L6:
            if (r12 != 0) goto L8;
            r12 = r13.getIntrinsicHeight();
        L8:
            Bitmap r15 = Bitmap.createBitmap(r14, r12, Bitmap.Config.ARGB_8888);
            r13.setBounds(0, 0, r14, r12);
            if (r11 == 0) goto L11;
            r13.mutate().setColorFilter(new PorterDuffColorFilter(r11, PorterDuff.Mode.SRC_IN));
        L11:
            r13.draw(new Canvas(r15));
            return r15;
        L5:
            r14 = r12;
            goto L6
        }

        private Bitmap createIconWithBackground(int r10, int r11, int r12, int r13) {
            int r14 = R.drawable.notification_icon_background;
            if (r13 != 0) goto L5;
            r13 = 0;
        L5:
            Bitmap r15 = createColoredBitmap(r14, r13, r11);
            Canvas r16 = new Canvas(r15);
            Drawable r17 = this.mBuilder.mContext.getResources().getDrawable(r10).mutate();
            r17.setFilterBitmap(true);
            int r18 = (r11 - r12) / 2;
            int r19 = r12 + r18;
            r17.setBounds(r18, r18, r19, r19);
            r17.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            r17.draw(r16);
            return r15;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static Style extractStyleFromNotification(@NonNull Notification r10) {
            Bundle r11 = NotificationCompat.getExtras(r10);
            if (r11 != null) goto L7;
            return null;
        L7:
            return constructStyleForExtras(r11);
        }

        private void hideNormalContent(RemoteViews r10) {
            r10.setViewVisibility(R.id.title, 8);
            r10.setViewVisibility(R.id.text2, 8);
            r10.setViewVisibility(R.id.text, 8);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(@NonNull Bundle r10) {
            if (this.mSummaryTextSet == false) goto L5;
            r10.putCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT, this.mSummaryText);
        L5:
            CharSequence r11 = this.mBigContentTitle;
            if (r11 == null) goto L8;
            r10.putCharSequence(NotificationCompat.EXTRA_TITLE_BIG, r11);
        L8:
            String r12 = getClassName();
            if (r12 == null) goto L12;
            r10.putString(NotificationCompat.EXTRA_COMPAT_TEMPLATE, r12);
            return;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r10) {
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews applyStandardTemplate(boolean r17, int r18, boolean r19) {
            Resources r10 = this.mBuilder.mContext.getResources();
            RemoteViews r11 = new RemoteViews(this.mBuilder.mContext.getPackageName(), r18);
            boolean r12 = true;
            int r13 = 0;
            if (this.mBuilder.getPriority() >= (-1)) goto L5;
            boolean r14 = true;
        L6:
            int r15 = Build.VERSION.SDK_INT;
            if (r15 < 16) goto L14;
            if (r15 >= 21) goto L14;
            if (r14 == false) goto L12;
            r11.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg_low);
            int r16 = R.id.icon;
            int r20 = R.drawable.notification_template_icon_low_bg;
        L13:
            r11.setInt(r16, "setBackgroundResource", r20);
            goto L14
        L12:
            r11.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg);
            r16 = R.id.icon;
            r20 = R.drawable.notification_template_icon_bg;
        L14:
            Builder r21 = this.mBuilder;
            if (r21.mLargeIcon == null) goto L28;
            int r22 = R.id.icon;
            if (r15 < 16) goto L19;
            r11.setViewVisibility(r22, 0);
            r11.setImageViewBitmap(r22, this.mBuilder.mLargeIcon);
        L20:
            if (r17 == true) goto L22;
        L36:
            CharSequence r23 = this.mBuilder.mContentTitle;
            if (r23 == null) goto L39;
            r11.setTextViewText(R.id.title, r23);
        L39:
            CharSequence r24 = this.mBuilder.mContentText;
            if (r24 == null) goto L42;
            r11.setTextViewText(R.id.text, r24);
            boolean r25 = true;
        L43:
            if (r15 < 21) goto L45;
        L47:
            boolean r26 = false;
        L48:
            Builder r27 = this.mBuilder;
            CharSequence r28 = r27.mContentInfo;
            if (r28 == null) goto L53;
            int r29 = R.id.info;
            r11.setTextViewText(r29, r28);
        L51:
            r11.setViewVisibility(r29, 0);
            boolean r110 = true;
            boolean r111 = true;
        L60:
            CharSequence r30 = this.mBuilder.mSubText;
            if (r30 == null) goto L67;
            if (r15 < 16) goto L67;
            r11.setTextViewText(R.id.text, r30);
            CharSequence r31 = this.mBuilder.mContentText;
            if (r31 == null) goto L66;
            int r32 = R.id.text2;
            r11.setTextViewText(r32, r31);
            r11.setViewVisibility(r32, 0);
            boolean r33 = true;
        L68:
            if (r33 == false) goto L74;
            if (r15 < 16) goto L74;
            if (r19 == false) goto L72;
            Api16Impl.setTextViewTextSize(r11, R.id.text, 0, r10.getDimensionPixelSize(R.dimen.notification_subtext_size));
        L72:
            Api16Impl.setViewPadding(r11, R.id.line1, 0, 0, 0, 0);
        L74:
            if (this.mBuilder.getWhenIfShowing() != 0) goto L76;
            r12 = r111;
        L85:
            int r34 = R.id.right_side;
            if (r12 == false) goto L88;
            int r35 = 0;
        L89:
            r11.setViewVisibility(r34, r35);
            int r36 = R.id.line3;
            if (r110 == true) goto L93;
            r13 = 8;
        L93:
            r11.setViewVisibility(r36, r13);
            return r11;
        L88:
            r35 = 8;
            goto L89
        L76:
            if (this.mBuilder.mUseChronometer == false) goto L83;
            if (r15 < 16) goto L83;
            int r37 = R.id.chronometer;
            r11.setViewVisibility(r37, 0);
            r11.setLong(r37, "setBase", this.mBuilder.getWhenIfShowing() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
            r11.setBoolean(r37, "setStarted", true);
            boolean r38 = this.mBuilder.mChronometerCountDown;
            if (r38 == false) goto L85;
            if (r15 < 24) goto L85;
            Api24Impl.setChronometerCountDown(r11, r37, r38);
        L83:
            int r39 = R.id.time;
            r11.setViewVisibility(r39, 0);
            r11.setLong(r39, "setTime", this.mBuilder.getWhenIfShowing());
            goto L85
        L66:
            r11.setViewVisibility(R.id.text2, 8);
        L67:
            r33 = false;
            goto L68
        L53:
            if (r27.mNumber > 0) goto L55;
            r11.setViewVisibility(R.id.info, 8);
            r110 = r25;
            r111 = r26;
            goto L60
        L55:
            if (this.mBuilder.mNumber <= r10.getInteger(R.integer.status_bar_notification_info_maxnum)) goto L57;
            r11.setTextViewText(R.id.info, r10.getString(R.string.status_bar_notification_info_overflow));
        L58:
            r29 = R.id.info;
            goto L51
        L57:
            r11.setTextViewText(R.id.info, NumberFormat.getIntegerInstance().format(this.mBuilder.mNumber));
            goto L58
        L45:
            if (this.mBuilder.mLargeIcon == null) goto L47;
            r26 = true;
            goto L48
        L42:
            r25 = false;
            goto L43
        L22:
            if (this.mBuilder.mNotification.icon == 0) goto L36;
            int r40 = r10.getDimensionPixelSize(R.dimen.notification_right_icon_size);
            int r41 = r40 - (r10.getDimensionPixelSize(R.dimen.notification_small_icon_background_padding) * 2);
            if (r15 < 21) goto L26;
            Builder r42 = this.mBuilder;
            r11.setImageViewBitmap(R.id.right_icon, createIconWithBackground(r42.mNotification.icon, r40, r41, r42.getColor()));
        L27:
            r11.setViewVisibility(R.id.right_icon, 0);
            goto L36
        L26:
            r11.setImageViewBitmap(R.id.right_icon, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
            goto L27
        L19:
            r11.setViewVisibility(r22, 8);
            goto L20
        L28:
            if (r17 == false) goto L36;
            if (r21.mNotification.icon == 0) goto L36;
            int r43 = R.id.icon;
            r11.setViewVisibility(r43, 0);
            if (r15 < 21) goto L34;
            int r44 = r10.getDimensionPixelSize(R.dimen.notification_large_icon_width) - r10.getDimensionPixelSize(R.dimen.notification_big_circle_margin);
            int r45 = r10.getDimensionPixelSize(R.dimen.notification_small_icon_size_as_large);
            Builder r46 = this.mBuilder;
            Bitmap r47 = createIconWithBackground(r46.mNotification.icon, r44, r45, r46.getColor());
        L35:
            r11.setImageViewBitmap(r43, r47);
            goto L36
        L34:
            r47 = createColoredBitmap(this.mBuilder.mNotification.icon, -1);
            goto L35
        L5:
            r14 = false;
            goto L6
        }

        @Nullable
        public Notification build() {
            Builder r10 = this.mBuilder;
            if (r10 != null) goto L7;
            return null;
        L7:
            return r10.build();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void buildIntoRemoteViews(RemoteViews r10, RemoteViews r11) {
            hideNormalContent(r10);
            int r12 = R.id.notification_main_column;
            r10.removeAllViews(r12);
            r10.addView(r12, r11.clone());
            r10.setViewVisibility(r12, 0);
            if (Build.VERSION.SDK_INT < 21) goto L6;
            Api16Impl.setViewPadding(r10, R.id.notification_main_column_container, 0, calculateTopPadding(), 0, 0);
            return;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected void clearCompatExtraKeys(@NonNull Bundle r10) {
            r10.remove(NotificationCompat.EXTRA_SUMMARY_TEXT);
            r10.remove(NotificationCompat.EXTRA_TITLE_BIG);
            r10.remove(NotificationCompat.EXTRA_COMPAT_TEMPLATE);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Bitmap createColoredBitmap(int r10, int r11) {
            return createColoredBitmap(r10, r11, 0);
        }

        Bitmap createColoredBitmap(@NonNull IconCompat r10, int r11) {
            return createColoredBitmap(r10, r11, 0);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean displayCustomViewInline() {
            return false;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected String getClassName() {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r10) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r10) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor r10) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected void restoreFromCompatExtras(@NonNull Bundle r10) {
            if (r10.containsKey(NotificationCompat.EXTRA_SUMMARY_TEXT) == false) goto L5;
            this.mSummaryText = r10.getCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT);
            this.mSummaryTextSet = true;
        L5:
            this.mBigContentTitle = r10.getCharSequence(NotificationCompat.EXTRA_TITLE_BIG);
        }

        public void setBuilder(@Nullable Builder r10) {
            if (this.mBuilder == r10) goto L8;
            this.mBuilder = r10;
            if (r10 == null) goto L9;
            r10.setStyle(this);
            return;
        L9:
            return;
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
        static class Api20Impl {
            private Api20Impl() {
            }

            @DoNotInline
            static Notification.Action.Builder addExtras(Notification.Action.Builder r10, Bundle r11) {
                return r10.addExtras(r11);
            }

            @DoNotInline
            static Notification.Action.Builder addRemoteInput(Notification.Action.Builder r10, android.app.RemoteInput r11) {
                return r10.addRemoteInput(r11);
            }

            @DoNotInline
            static Notification.Action build(Notification.Action.Builder r10) {
                return r10.build();
            }

            @DoNotInline
            static Notification.Action.Builder createBuilder(int r10, CharSequence r11, PendingIntent r12) {
                return new Notification.Action.Builder(r10, r11, r12);
            }

            @DoNotInline
            public static Action getActionCompatFromAction(ArrayList<Parcelable> r10, int r11) {
                return NotificationCompat.getActionCompatFromAction((Notification.Action) r10.get(r11));
            }
        }

        @RequiresApi(23)
        static class Api23Impl {
            private Api23Impl() {
            }

            @DoNotInline
            static Notification.Action.Builder createBuilder(Icon r10, CharSequence r11, PendingIntent r12) {
                return new Notification.Action.Builder(r10, r11, r12);
            }
        }

        @RequiresApi(24)
        static class Api24Impl {
            private Api24Impl() {
            }

            @DoNotInline
            static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder r10, boolean r11) {
                return r10.setAllowGeneratedReplies(r11);
            }
        }

        @RequiresApi(31)
        static class Api31Impl {
            private Api31Impl() {
            }

            @DoNotInline
            static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder r10, boolean r11) {
                return r10.setAuthenticationRequired(r11);
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

        public WearableExtender(@NonNull Notification r13) {
            this.mActions = new ArrayList();
            this.mFlags = 1;
            this.mPages = new ArrayList();
            this.mContentIconGravity = 8388613;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = 80;
            Bundle r14 = NotificationCompat.getExtras(r13);
            if (r14 == null) goto L5;
            Bundle r15 = r14.getBundle(EXTRA_WEARABLE_EXTENSIONS);
        L6:
            if (r15 == null) goto L28;
            ArrayList r10 = r15.getParcelableArrayList(KEY_ACTIONS);
            if (Build.VERSION.SDK_INT < 16) goto L19;
            if (r10 == null) goto L19;
            int r11 = r10.size();
            Action[] r12 = new Action[r11];
            int r16 = 0;
        L11:
            if (r16 >= r11) goto L18;
            int r17 = Build.VERSION.SDK_INT;
            if (r17 < 20) goto L15;
            r12[r16] = Api20Impl.getActionCompatFromAction(r10, r16);
        L17:
            r16 = r16 + 1;
            goto L11
        L15:
            if (r17 < 16) goto L17;
            r12[r16] = NotificationCompatJellybean.getActionFromBundle((Bundle) r10.get(r16));
            goto L17
        L18:
            Collections.addAll(this.mActions, r12);
        L19:
            this.mFlags = r15.getInt(KEY_FLAGS, 1);
            this.mDisplayIntent = (PendingIntent) r15.getParcelable(KEY_DISPLAY_INTENT);
            Notification[] r18 = NotificationCompat.getNotificationArrayFromBundle(r15, KEY_PAGES);
            if (r18 == null) goto L22;
            Collections.addAll(this.mPages, r18);
        L22:
            this.mBackground = (Bitmap) r15.getParcelable(KEY_BACKGROUND);
            this.mContentIcon = r15.getInt(KEY_CONTENT_ICON);
            this.mContentIconGravity = r15.getInt(KEY_CONTENT_ICON_GRAVITY, 8388613);
            this.mContentActionIndex = r15.getInt(KEY_CONTENT_ACTION_INDEX, -1);
            this.mCustomSizePreset = r15.getInt(KEY_CUSTOM_SIZE_PRESET, 0);
            this.mCustomContentHeight = r15.getInt(KEY_CUSTOM_CONTENT_HEIGHT);
            this.mGravity = r15.getInt(KEY_GRAVITY, 80);
            this.mHintScreenTimeout = r15.getInt(KEY_HINT_SCREEN_TIMEOUT);
            this.mDismissalId = r15.getString(KEY_DISMISSAL_ID);
            this.mBridgeTag = r15.getString(KEY_BRIDGE_TAG);
            return;
        L28:
            return;
        L5:
            r15 = null;
            goto L6
        }

        @RequiresApi(20)
        private static Notification.Action getActionFromActionCompat(Action r10) {
            int r11 = Build.VERSION.SDK_INT;
            int r12 = 0;
            if (r11 < 23) goto L9;
            IconCompat r13 = r10.getIconCompat();
            if (r13 != null) goto L7;
            Icon r14 = null;
        L8:
            Notification.Action.Builder r15 = Api23Impl.createBuilder(r14, r10.getTitle(), r10.getActionIntent());
        L17:
            if (r10.getExtras() == null) goto L19;
            Bundle r16 = new Bundle(r10.getExtras());
        L20:
            r16.putBoolean("android.support.allowGeneratedReplies", r10.getAllowGeneratedReplies());
            if (r11 < 24) goto L24;
            Api24Impl.setAllowGeneratedReplies(r15, r10.getAllowGeneratedReplies());
        L24:
            if (r11 < 31) goto L26;
            Api31Impl.setAuthenticationRequired(r15, r10.isAuthenticationRequired());
        L26:
            Api20Impl.addExtras(r15, r16);
            RemoteInput[] r17 = r10.getRemoteInputs();
            if (r17 == null) goto L32;
            android.app.RemoteInput[] r18 = RemoteInput.fromCompat(r17);
            int r19 = r18.length;
        L29:
            if (r12 >= r19) goto L32;
            Api20Impl.addRemoteInput(r15, r18[r12]);
            r12 = r12 + 1;
        L32:
            return Api20Impl.build(r15);
        L19:
            r16 = new Bundle();
            goto L20
        L7:
            r14 = r13.toIcon();
            goto L8
        L9:
            IconCompat r20 = r10.getIconCompat();
            if (r20 != null) goto L12;
        L14:
            int r21 = 0;
        L15:
            r15 = Api20Impl.createBuilder(r21, r10.getTitle(), r10.getActionIntent());
            goto L17
        L12:
            if (r20.getType() != 2) goto L14;
            r21 = r20.getResId();
            goto L15
        }

        private void setFlag(int r10, boolean r11) {
            if (r11 == false) goto L4;
            int r12 = r10 | this.mFlags;
        L5:
            this.mFlags = r12;
            return;
        L4:
            int r13 = this.mFlags;
            r12 = (~r10) & r13;
            goto L5
        }

        @NonNull
        public WearableExtender addAction(@NonNull Action r10) {
            this.mActions.add(r10);
            return this;
        }

        @NonNull
        public WearableExtender addActions(@NonNull List<Action> r10) {
            this.mActions.addAll(r10);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender addPage(@NonNull Notification r10) {
            this.mPages.add(r10);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender addPages(@NonNull List<Notification> r10) {
            this.mPages.addAll(r10);
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
        public WearableExtender clone() {
            WearableExtender r10 = new WearableExtender();
            r10.mActions = new ArrayList(this.mActions);
            r10.mFlags = this.mFlags;
            r10.mDisplayIntent = this.mDisplayIntent;
            r10.mPages = new ArrayList(this.mPages);
            r10.mBackground = this.mBackground;
            r10.mContentIcon = this.mContentIcon;
            r10.mContentIconGravity = this.mContentIconGravity;
            r10.mContentActionIndex = this.mContentActionIndex;
            r10.mCustomSizePreset = this.mCustomSizePreset;
            r10.mCustomContentHeight = this.mCustomContentHeight;
            r10.mGravity = this.mGravity;
            r10.mHintScreenTimeout = this.mHintScreenTimeout;
            r10.mDismissalId = this.mDismissalId;
            r10.mBridgeTag = this.mBridgeTag;
            return r10;
        }

        @NonNull
        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m7clone() {
            return clone();
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        @NonNull
        public Builder extend(@NonNull Builder r10) {
            Bundle r11 = new Bundle();
            if (this.mActions.isEmpty() == false) goto L5;
        L17:
            int r12 = this.mFlags;
            if (r12 == 1) goto L20;
            r11.putInt(KEY_FLAGS, r12);
        L20:
            PendingIntent r13 = this.mDisplayIntent;
            if (r13 == null) goto L24;
            r11.putParcelable(KEY_DISPLAY_INTENT, r13);
        L24:
            if (this.mPages.isEmpty() == true) goto L26;
            ArrayList<Notification> r14 = this.mPages;
            r11.putParcelableArray(KEY_PAGES, (Parcelable[]) r14.toArray(new Notification[r14.size()]));
        L26:
            Bitmap r15 = this.mBackground;
            if (r15 == null) goto L29;
            r11.putParcelable(KEY_BACKGROUND, r15);
        L29:
            int r16 = this.mContentIcon;
            if (r16 == 0) goto L32;
            r11.putInt(KEY_CONTENT_ICON, r16);
        L32:
            int r17 = this.mContentIconGravity;
            if (r17 == 8388613) goto L35;
            r11.putInt(KEY_CONTENT_ICON_GRAVITY, r17);
        L35:
            int r18 = this.mContentActionIndex;
            if (r18 == (-1)) goto L38;
            r11.putInt(KEY_CONTENT_ACTION_INDEX, r18);
        L38:
            int r19 = this.mCustomSizePreset;
            if (r19 == 0) goto L41;
            r11.putInt(KEY_CUSTOM_SIZE_PRESET, r19);
        L41:
            int r20 = this.mCustomContentHeight;
            if (r20 == 0) goto L44;
            r11.putInt(KEY_CUSTOM_CONTENT_HEIGHT, r20);
        L44:
            int r21 = this.mGravity;
            if (r21 == 80) goto L47;
            r11.putInt(KEY_GRAVITY, r21);
        L47:
            int r22 = this.mHintScreenTimeout;
            if (r22 == 0) goto L50;
            r11.putInt(KEY_HINT_SCREEN_TIMEOUT, r22);
        L50:
            String r23 = this.mDismissalId;
            if (r23 == null) goto L53;
            r11.putString(KEY_DISMISSAL_ID, r23);
        L53:
            String r24 = this.mBridgeTag;
            if (r24 == null) goto L56;
            r11.putString(KEY_BRIDGE_TAG, r24);
        L56:
            r10.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, r11);
            return r10;
        L5:
            if (Build.VERSION.SDK_INT < 16) goto L15;
            ArrayList<? extends Parcelable> r25 = new ArrayList(this.mActions.size());
            Iterator<Action> r26 = this.mActions.iterator();
        L8:
            if (r26.hasNext() == false) goto L16;
            Action r27 = r26.next();
            int r28 = Build.VERSION.SDK_INT;
            if (r28 >= 20) goto L11;
            if (r28 < 16) goto L8;
            Parcelable r29 = NotificationCompatJellybean.getBundleForAction(r27);
        L12:
            r25.add(r29);
            goto L8
        L11:
            r29 = getActionFromActionCompat(r27);
        L16:
            r11.putParcelableArrayList(KEY_ACTIONS, r25);
            goto L17
        L15:
            r25 = null;
            goto L16
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
        public WearableExtender setBackground(@Nullable Bitmap r10) {
            this.mBackground = r10;
            return this;
        }

        @NonNull
        public WearableExtender setBridgeTag(@Nullable String r10) {
            this.mBridgeTag = r10;
            return this;
        }

        @NonNull
        public WearableExtender setContentAction(int r10) {
            this.mContentActionIndex = r10;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setContentIcon(int r10) {
            this.mContentIcon = r10;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setContentIconGravity(int r10) {
            this.mContentIconGravity = r10;
            return this;
        }

        @NonNull
        public WearableExtender setContentIntentAvailableOffline(boolean r10) {
            setFlag(1, r10);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setCustomContentHeight(int r10) {
            this.mCustomContentHeight = r10;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setCustomSizePreset(int r10) {
            this.mCustomSizePreset = r10;
            return this;
        }

        @NonNull
        public WearableExtender setDismissalId(@Nullable String r10) {
            this.mDismissalId = r10;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setDisplayIntent(@Nullable PendingIntent r10) {
            this.mDisplayIntent = r10;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setGravity(int r10) {
            this.mGravity = r10;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintAmbientBigPicture(boolean r10) {
            setFlag(32, r10);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintAvoidBackgroundClipping(boolean r10) {
            setFlag(16, r10);
            return this;
        }

        @NonNull
        public WearableExtender setHintContentIntentLaunchesActivity(boolean r10) {
            setFlag(64, r10);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintHideIcon(boolean r10) {
            setFlag(2, r10);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintScreenTimeout(int r10) {
            this.mHintScreenTimeout = r10;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintShowBackgroundOnly(boolean r10) {
            setFlag(4, r10);
            return this;
        }

        @NonNull
        public WearableExtender setStartScrollBottom(boolean r10) {
            setFlag(8, r10);
            return this;
        }
    }

    @Deprecated
    public NotificationCompat() {
    }

    @Nullable
    public static Action getAction(@NonNull Notification r10, int r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 >= 20) goto L5;
        Bundle r13 = null;
        if (r12 < 19) goto L14;
        Notification.Action r14 = r10.actions[r11];
        SparseArray r15 = r10.extras.getSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
        if (r15 == null) goto L12;
        r13 = (Bundle) r15.get(r11);
    L12:
        return NotificationCompatJellybean.readAction(r14.icon, r14.title, r14.actionIntent, r13);
    L14:
        if (r12 >= 16) goto L16;
        return null;
    L16:
        return NotificationCompatJellybean.getAction(r10, r11);
    L5:
        return getActionCompatFromAction(r10.actions[r11]);
    }

    @NonNull
    @RequiresApi(20)
    static Action getActionCompatFromAction(@NonNull Notification.Action r19) {
        android.app.RemoteInput[] r10 = Api20Impl.getRemoteInputs(r19);
        IconCompat r11 = null;
        boolean r12 = false;
        if (r10 != null) goto L5;
        RemoteInput[] r13 = null;
    L14:
        int r14 = Build.VERSION.SDK_INT;
        if (r14 >= 24) goto L17;
        boolean r15 = Api20Impl.getExtras(r19).getBoolean("android.support.allowGeneratedReplies");
    L24:
        boolean r16 = r15;
        boolean r17 = Api20Impl.getExtras(r19).getBoolean("android.support.action.showsUserInterface", true);
        if (r14 < 28) goto L27;
        int r18 = Api28Impl.getSemanticAction(r19);
    L28:
        int r110 = r18;
        if (r14 < 29) goto L31;
        boolean r111 = Api29Impl.isContextual(r19);
    L33:
        if (r14 < 31) goto L35;
        r12 = Api31Impl.isAuthenticationRequired(r19);
    L35:
        boolean r112 = r12;
        if (r14 < 23) goto L50;
        if (Api23Impl.getIcon(r19) != null) goto L44;
        int r20 = r19.icon;
        if (r20 == 0) goto L44;
        return new Action(r20, r19.title, r19.actionIntent, Api20Impl.getExtras(r19), r13, null, r16, r110, r17, r111, r112);
    L44:
        if (Api23Impl.getIcon(r19) == null) goto L48;
        r11 = IconCompat.createFromIconOrNullIfZeroResId(Api23Impl.getIcon(r19));
    L48:
        return new Action(r11, r19.title, r19.actionIntent, Api20Impl.getExtras(r19), r13, null, r16, r110, r17, r111, r112);
    L50:
        return new Action(r19.icon, r19.title, r19.actionIntent, Api20Impl.getExtras(r19), r13, null, r16, r110, r17, r111, r112);
    L31:
        r111 = false;
        goto L33
    L27:
        r18 = Api20Impl.getExtras(r19).getInt("android.support.action.semanticAction", 0);
        goto L28
    L17:
        if (Api20Impl.getExtras(r19).getBoolean("android.support.allowGeneratedReplies") == false) goto L19;
    L22:
        r15 = true;
        goto L24
    L19:
        if (Api24Impl.getAllowGeneratedReplies(r19) == true) goto L22;
        r15 = false;
        goto L24
    L5:
        RemoteInput[] r21 = new RemoteInput[r10.length];
        int r22 = 0;
    L7:
        if (r22 >= r10.length) goto L13;
        android.app.RemoteInput r23 = r10[r22];
        String r24 = Api20Impl.getResultKey(r23);
        CharSequence r113 = Api20Impl.getLabel(r23);
        CharSequence[] r114 = Api20Impl.getChoices(r23);
        boolean r115 = Api20Impl.getAllowFreeFormInput(r23);
        if (Build.VERSION.SDK_INT < 29) goto L11;
        int r116 = Api29Impl.getEditChoicesBeforeSending(r23);
    L12:
        r21[r22] = new RemoteInput(r24, r113, r114, r115, r116, Api20Impl.getExtras(r23), null);
        r22 = r22 + 1;
        goto L7
    L11:
        r116 = 0;
        goto L12
    L13:
        r13 = r21;
        goto L14
    }

    public static int getActionCount(@NonNull Notification r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 19) goto L9;
        Notification.Action[] r12 = r10.actions;
        if (r12 != null) goto L7;
        return 0;
    L7:
        return r12.length;
    L9:
        if (r11 >= 16) goto L11;
        return 0;
    L11:
        return NotificationCompatJellybean.getActionCount(r10);
    }

    public static boolean getAllowSystemGeneratedContextualActions(@NonNull Notification r10) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return false;
    L5:
        return Api29Impl.getAllowSystemGeneratedContextualActions(r10);
    }

    public static boolean getAutoCancel(@NonNull Notification r10) {
        if ((r10.flags & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static int getBadgeIconType(@NonNull Notification r10) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return 0;
    L5:
        return Api26Impl.getBadgeIconType(r10);
    }

    @Nullable
    public static BubbleMetadata getBubbleMetadata(@NonNull Notification r10) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return null;
    L5:
        return BubbleMetadata.fromPlatform(Api29Impl.getBubbleMetadata(r10));
    }

    @Nullable
    public static String getCategory(@NonNull Notification r10) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return r10.category;
    }

    @Nullable
    public static String getChannelId(@NonNull Notification r10) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return Api26Impl.getChannelId(r10);
    }

    public static int getColor(@NonNull Notification r10) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return 0;
    L5:
        return r10.color;
    }

    @Nullable
    @RequiresApi(19)
    public static CharSequence getContentInfo(@NonNull Notification r10) {
        return r10.extras.getCharSequence(EXTRA_INFO_TEXT);
    }

    @Nullable
    @RequiresApi(19)
    public static CharSequence getContentText(@NonNull Notification r10) {
        return r10.extras.getCharSequence(EXTRA_TEXT);
    }

    @Nullable
    @RequiresApi(19)
    public static CharSequence getContentTitle(@NonNull Notification r10) {
        return r10.extras.getCharSequence(EXTRA_TITLE);
    }

    @Nullable
    public static Bundle getExtras(@NonNull Notification r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 19) goto L7;
        return r10.extras;
    L7:
        if (r11 >= 16) goto L9;
        return null;
    L9:
        return NotificationCompatJellybean.getExtras(r10);
    }

    @Nullable
    public static String getGroup(@NonNull Notification r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 20) goto L7;
        return Api20Impl.getGroup(r10);
    L7:
        if (r11 < 19) goto L12;
        Bundle r12 = r10.extras;
    L10:
        return r12.getString(NotificationCompatExtras.EXTRA_GROUP_KEY);
    L12:
        if (r11 < 16) goto L14;
        r12 = NotificationCompatJellybean.getExtras(r10);
        goto L10
    L14:
        return null;
    }

    public static int getGroupAlertBehavior(@NonNull Notification r10) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return 0;
    L5:
        return Api26Impl.getGroupAlertBehavior(r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static boolean getHighPriority(@NonNull Notification r10) {
        if ((r10.flags & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @NonNull
    @RequiresApi(21)
    public static List<Action> getInvisibleActions(@NonNull Notification r10) {
        ArrayList r11 = new ArrayList();
        if (Build.VERSION.SDK_INT < 19) goto L13;
        Bundle r12 = r10.extras.getBundle("android.car.EXTENSIONS");
        if (r12 != null) goto L7;
        return r11;
    L7:
        Bundle r13 = r12.getBundle("invisible_actions");
        if (r13 == null) goto L13;
        int r14 = 0;
    L11:
        if (r14 >= r13.size()) goto L13;
        r11.add(NotificationCompatJellybean.getActionFromBundle(r13.getBundle(Integer.toString(r14))));
        r14 = r14 + 1;
    L13:
        return r11;
    }

    public static boolean getLocalOnly(@NonNull Notification r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 20) goto L9;
        if ((r10.flags & 256) == 0) goto L17;
        return true;
    L17:
        return false;
    L9:
        if (r11 < 19) goto L14;
        Bundle r12 = r10.extras;
    L12:
        return r12.getBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
    L14:
        if (r11 < 16) goto L16;
        r12 = NotificationCompatJellybean.getExtras(r10);
        goto L12
    L16:
        return false;
    }

    @Nullable
    public static LocusIdCompat getLocusId(@NonNull Notification r10) {
        if (Build.VERSION.SDK_INT < 29) goto L9;
        LocusId r11 = Api29Impl.getLocusId(r10);
        if (r11 != null) goto L8;
        return null;
    L8:
        return LocusIdCompat.toLocusIdCompat(r11);
    L9:
        return null;
    }

    @NonNull
    static Notification[] getNotificationArrayFromBundle(@NonNull Bundle r10, @NonNull String r11) {
        Parcelable[] r12 = r10.getParcelableArray(r11);
        if ((r12 instanceof Notification[]) == true) goto L13;
        if (r12 == null) goto L13;
        Notification[] r13 = new Notification[r12.length];
        int r14 = 0;
    L8:
        if (r14 >= r12.length) goto L10;
        r13[r14] = (Notification) r12[r14];
        r14 = r14 + 1;
        goto L8
    L10:
        r10.putParcelableArray(r11, r13);
        return r13;
    L13:
        return (Notification[]) r12;
    }

    public static boolean getOngoing(@NonNull Notification r10) {
        if ((r10.flags & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean getOnlyAlertOnce(@NonNull Notification r10) {
        if ((r10.flags & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @NonNull
    public static List<Person> getPeople(@NonNull Notification r10) {
        ArrayList r11 = new ArrayList();
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 28) goto L13;
        ArrayList r13 = r10.extras.getParcelableArrayList(EXTRA_PEOPLE_LIST);
        if (r13 != null) goto L7;
    L21:
        return r11;
    L7:
        if (r13.isEmpty() == true) goto L21;
        Iterator r14 = r13.iterator();
    L10:
        if (r14.hasNext() == false) goto L21;
        r11.add(Person.fromAndroidPerson((android.app.Person) r14.next()));
        goto L10
    L13:
        if (r12 < 19) goto L21;
        String[] r15 = r10.extras.getStringArray(EXTRA_PEOPLE);
        if (r15 == null) goto L21;
        if (r15.length == 0) goto L21;
        int r16 = r15.length;
        int r17 = 0;
    L19:
        if (r17 >= r16) goto L21;
        String r18 = r15[r17];
        r11.add(new Person.Builder().setUri(r18).build());
        r17 = r17 + 1;
        goto L19
    }

    @Nullable
    public static Notification getPublicVersion(@NonNull Notification r10) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return r10.publicVersion;
    }

    @Nullable
    public static CharSequence getSettingsText(@NonNull Notification r10) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return Api26Impl.getSettingsText(r10);
    }

    @Nullable
    public static String getShortcutId(@NonNull Notification r10) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return Api26Impl.getShortcutId(r10);
    }

    @RequiresApi(19)
    public static boolean getShowWhen(@NonNull Notification r10) {
        return r10.extras.getBoolean(EXTRA_SHOW_WHEN);
    }

    @Nullable
    public static String getSortKey(@NonNull Notification r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 20) goto L7;
        return Api20Impl.getSortKey(r10);
    L7:
        if (r11 < 19) goto L12;
        Bundle r12 = r10.extras;
    L10:
        return r12.getString(NotificationCompatExtras.EXTRA_SORT_KEY);
    L12:
        if (r11 < 16) goto L14;
        r12 = NotificationCompatJellybean.getExtras(r10);
        goto L10
    L14:
        return null;
    }

    @Nullable
    @RequiresApi(19)
    public static CharSequence getSubText(@NonNull Notification r10) {
        return r10.extras.getCharSequence(EXTRA_SUB_TEXT);
    }

    public static long getTimeoutAfter(@NonNull Notification r10) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return 0;
    L5:
        return Api26Impl.getTimeoutAfter(r10);
    }

    @RequiresApi(19)
    public static boolean getUsesChronometer(@NonNull Notification r10) {
        return r10.extras.getBoolean(EXTRA_SHOW_CHRONOMETER);
    }

    public static int getVisibility(@NonNull Notification r10) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return 0;
    L5:
        return r10.visibility;
    }

    public static boolean isGroupSummary(@NonNull Notification r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 20) goto L9;
        if ((r10.flags & 512) == 0) goto L17;
        return true;
    L17:
        return false;
    L9:
        if (r11 < 19) goto L14;
        Bundle r12 = r10.extras;
    L12:
        return r12.getBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
    L14:
        if (r11 < 16) goto L16;
        r12 = NotificationCompatJellybean.getExtras(r10);
        goto L12
    L16:
        return false;
    }
}
