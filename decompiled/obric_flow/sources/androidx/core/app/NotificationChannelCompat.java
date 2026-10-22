package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.provider.Settings;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class NotificationChannelCompat {
    public static final String DEFAULT_CHANNEL_ID = "miscellaneous";
    private static final int DEFAULT_LIGHT_COLOR = 0;
    private static final boolean DEFAULT_SHOW_BADGE = true;
    AudioAttributes mAudioAttributes;
    private boolean mBypassDnd;
    private boolean mCanBubble;
    String mConversationId;
    String mDescription;
    String mGroupId;

    @NonNull
    final String mId;
    int mImportance;
    private boolean mImportantConversation;
    int mLightColor;
    boolean mLights;
    private int mLockscreenVisibility;
    CharSequence mName;
    String mParentId;
    boolean mShowBadge;
    Uri mSound;
    boolean mVibrationEnabled;
    long[] mVibrationPattern;

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static boolean canBypassDnd(NotificationChannel r5) {
            return r5.canBypassDnd();
        }

        @DoNotInline
        public static boolean canShowBadge(NotificationChannel r5) {
            return r5.canShowBadge();
        }

        @DoNotInline
        public static NotificationChannel createNotificationChannel(String r5, CharSequence r10, int r11) {
            return new NotificationChannel(r5, r10, r11);
        }

        @DoNotInline
        public static void enableLights(NotificationChannel r5, boolean r10) {
            r5.enableLights(r10);
        }

        @DoNotInline
        public static void enableVibration(NotificationChannel r5, boolean r10) {
            r5.enableVibration(r10);
        }

        @DoNotInline
        public static AudioAttributes getAudioAttributes(NotificationChannel r5) {
            return r5.getAudioAttributes();
        }

        @DoNotInline
        public static String getDescription(NotificationChannel r5) {
            return r5.getDescription();
        }

        @DoNotInline
        public static String getGroup(NotificationChannel r5) {
            return r5.getGroup();
        }

        @DoNotInline
        public static String getId(NotificationChannel r5) {
            return r5.getId();
        }

        @DoNotInline
        public static int getImportance(NotificationChannel r5) {
            return r5.getImportance();
        }

        @DoNotInline
        public static int getLightColor(NotificationChannel r5) {
            return r5.getLightColor();
        }

        @DoNotInline
        public static int getLockscreenVisibility(NotificationChannel r5) {
            return r5.getLockscreenVisibility();
        }

        @DoNotInline
        public static CharSequence getName(NotificationChannel r5) {
            return r5.getName();
        }

        @DoNotInline
        public static Uri getSound(NotificationChannel r5) {
            return r5.getSound();
        }

        @DoNotInline
        public static long[] getVibrationPattern(NotificationChannel r5) {
            return r5.getVibrationPattern();
        }

        @DoNotInline
        public static void setDescription(NotificationChannel r5, String r10) {
            r5.setDescription(r10);
        }

        @DoNotInline
        public static void setGroup(NotificationChannel r5, String r10) {
            r5.setGroup(r10);
        }

        @DoNotInline
        public static void setLightColor(NotificationChannel r5, int r10) {
            r5.setLightColor(r10);
        }

        @DoNotInline
        public static void setShowBadge(NotificationChannel r5, boolean r10) {
            r5.setShowBadge(r10);
        }

        @DoNotInline
        public static void setSound(NotificationChannel r5, Uri r10, AudioAttributes r11) {
            r5.setSound(r10, r11);
        }

        @DoNotInline
        public static void setVibrationPattern(NotificationChannel r5, long[] r10) {
            r5.setVibrationPattern(r10);
        }

        @DoNotInline
        public static boolean shouldShowLights(NotificationChannel r5) {
            return r5.shouldShowLights();
        }

        @DoNotInline
        public static boolean shouldVibrate(NotificationChannel r5) {
            return r5.shouldVibrate();
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static boolean canBubble(NotificationChannel r5) {
            return r5.canBubble();
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static String getConversationId(NotificationChannel r5) {
            return r5.getConversationId();
        }

        @DoNotInline
        public static String getParentChannelId(NotificationChannel r5) {
            return r5.getParentChannelId();
        }

        @DoNotInline
        public static boolean isImportantConversation(NotificationChannel r5) {
            return r5.isImportantConversation();
        }

        @DoNotInline
        public static void setConversationId(NotificationChannel r5, String r10, String r11) {
            r5.setConversationId(r10, r11);
        }
    }

    public static class Builder {
        private final NotificationChannelCompat mChannel;

        public Builder(@NonNull String r5, int r10) {
            this.mChannel = new NotificationChannelCompat(r5, r10);
        }

        @NonNull
        public NotificationChannelCompat build() {
            return this.mChannel;
        }

        @NonNull
        public Builder setConversationId(@NonNull String r5, @NonNull String r10) {
            NotificationChannelCompat r11 = this.mChannel;
            r11.mParentId = r5;
            r11.mConversationId = r10;
            return this;
        }

        @NonNull
        public Builder setDescription(@Nullable String r5) {
            this.mChannel.mDescription = r5;
            return this;
        }

        @NonNull
        public Builder setGroup(@Nullable String r5) {
            this.mChannel.mGroupId = r5;
            return this;
        }

        @NonNull
        public Builder setImportance(int r5) {
            this.mChannel.mImportance = r5;
            return this;
        }

        @NonNull
        public Builder setLightColor(int r5) {
            this.mChannel.mLightColor = r5;
            return this;
        }

        @NonNull
        public Builder setLightsEnabled(boolean r5) {
            this.mChannel.mLights = r5;
            return this;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence r5) {
            this.mChannel.mName = r5;
            return this;
        }

        @NonNull
        public Builder setShowBadge(boolean r5) {
            this.mChannel.mShowBadge = r5;
            return this;
        }

        @NonNull
        public Builder setSound(@Nullable Uri r5, @Nullable AudioAttributes r10) {
            NotificationChannelCompat r11 = this.mChannel;
            r11.mSound = r5;
            r11.mAudioAttributes = r10;
            return this;
        }

        @NonNull
        public Builder setVibrationEnabled(boolean r5) {
            this.mChannel.mVibrationEnabled = r5;
            return this;
        }

        @NonNull
        public Builder setVibrationPattern(@Nullable long[] r5) {
            NotificationChannelCompat r10 = this.mChannel;
            if (r5 != null) goto L5;
        L7:
            boolean r11 = false;
        L8:
            r10.mVibrationEnabled = r11;
            r10.mVibrationPattern = r5;
            return this;
        L5:
            if (r5.length <= 0) goto L7;
            r11 = NotificationChannelCompat.DEFAULT_SHOW_BADGE;
            goto L8
        }
    }

    public NotificationChannelCompat(@NonNull String r5, int r10) {
        this.mShowBadge = DEFAULT_SHOW_BADGE;
        this.mSound = Settings.System.DEFAULT_NOTIFICATION_URI;
        this.mLightColor = 0;
        this.mId = (String) Preconditions.checkNotNull(r5);
        this.mImportance = r10;
        this.mAudioAttributes = Notification.AUDIO_ATTRIBUTES_DEFAULT;
    }

    public boolean canBubble() {
        return this.mCanBubble;
    }

    public boolean canBypassDnd() {
        return this.mBypassDnd;
    }

    public boolean canShowBadge() {
        return this.mShowBadge;
    }

    @Nullable
    public AudioAttributes getAudioAttributes() {
        return this.mAudioAttributes;
    }

    @Nullable
    public String getConversationId() {
        return this.mConversationId;
    }

    @Nullable
    public String getDescription() {
        return this.mDescription;
    }

    @Nullable
    public String getGroup() {
        return this.mGroupId;
    }

    @NonNull
    public String getId() {
        return this.mId;
    }

    public int getImportance() {
        return this.mImportance;
    }

    public int getLightColor() {
        return this.mLightColor;
    }

    public int getLockscreenVisibility() {
        return this.mLockscreenVisibility;
    }

    @Nullable
    public CharSequence getName() {
        return this.mName;
    }

    public NotificationChannel getNotificationChannel() {
        NotificationChannel r5 = Api26Impl.createNotificationChannel(this.mId, this.mName, this.mImportance);
        Api26Impl.setDescription(r5, this.mDescription);
        Api26Impl.setGroup(r5, this.mGroupId);
        Api26Impl.setShowBadge(r5, this.mShowBadge);
        Api26Impl.setSound(r5, this.mSound, this.mAudioAttributes);
        Api26Impl.enableLights(r5, this.mLights);
        Api26Impl.setLightColor(r5, this.mLightColor);
        Api26Impl.setVibrationPattern(r5, this.mVibrationPattern);
        Api26Impl.enableVibration(r5, this.mVibrationEnabled);
        String r10 = this.mParentId;
        if (r10 == null) goto L7;
        String r11 = this.mConversationId;
        if (r11 == null) goto L7;
        Api30Impl.setConversationId(r5, r10, r11);
    L7:
        return r5;
    }

    @Nullable
    public String getParentChannelId() {
        return this.mParentId;
    }

    @Nullable
    public Uri getSound() {
        return this.mSound;
    }

    @Nullable
    public long[] getVibrationPattern() {
        return this.mVibrationPattern;
    }

    public boolean isImportantConversation() {
        return this.mImportantConversation;
    }

    public boolean shouldShowLights() {
        return this.mLights;
    }

    public boolean shouldVibrate() {
        return this.mVibrationEnabled;
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this.mId, this.mImportance).setName(this.mName).setDescription(this.mDescription).setGroup(this.mGroupId).setShowBadge(this.mShowBadge).setSound(this.mSound, this.mAudioAttributes).setLightsEnabled(this.mLights).setLightColor(this.mLightColor).setVibrationEnabled(this.mVibrationEnabled).setVibrationPattern(this.mVibrationPattern).setConversationId(this.mParentId, this.mConversationId);
    }

    @RequiresApi(26)
    public NotificationChannelCompat(@NonNull NotificationChannel r5) {
        this(Api26Impl.getId(r5), Api26Impl.getImportance(r5));
        this.mName = Api26Impl.getName(r5);
        this.mDescription = Api26Impl.getDescription(r5);
        this.mGroupId = Api26Impl.getGroup(r5);
        this.mShowBadge = Api26Impl.canShowBadge(r5);
        this.mSound = Api26Impl.getSound(r5);
        this.mAudioAttributes = Api26Impl.getAudioAttributes(r5);
        this.mLights = Api26Impl.shouldShowLights(r5);
        this.mLightColor = Api26Impl.getLightColor(r5);
        this.mVibrationEnabled = Api26Impl.shouldVibrate(r5);
        this.mVibrationPattern = Api26Impl.getVibrationPattern(r5);
        this.mParentId = Api30Impl.getParentChannelId(r5);
        this.mConversationId = Api30Impl.getConversationId(r5);
        this.mBypassDnd = Api26Impl.canBypassDnd(r5);
        this.mLockscreenVisibility = Api26Impl.getLockscreenVisibility(r5);
        this.mCanBubble = Api29Impl.canBubble(r5);
        this.mImportantConversation = Api30Impl.isImportantConversation(r5);
    }
}
