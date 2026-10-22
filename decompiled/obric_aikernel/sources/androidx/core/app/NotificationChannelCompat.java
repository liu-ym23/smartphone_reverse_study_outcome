package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
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
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static boolean canBypassDnd(NotificationChannel r10) {
            return r10.canBypassDnd();
        }

        @DoNotInline
        static boolean canShowBadge(NotificationChannel r10) {
            return r10.canShowBadge();
        }

        @DoNotInline
        static NotificationChannel createNotificationChannel(String r10, CharSequence r11, int r12) {
            return new NotificationChannel(r10, r11, r12);
        }

        @DoNotInline
        static void enableLights(NotificationChannel r10, boolean r11) {
            r10.enableLights(r11);
        }

        @DoNotInline
        static void enableVibration(NotificationChannel r10, boolean r11) {
            r10.enableVibration(r11);
        }

        @DoNotInline
        static AudioAttributes getAudioAttributes(NotificationChannel r10) {
            return r10.getAudioAttributes();
        }

        @DoNotInline
        static String getDescription(NotificationChannel r10) {
            return r10.getDescription();
        }

        @DoNotInline
        static String getGroup(NotificationChannel r10) {
            return r10.getGroup();
        }

        @DoNotInline
        static String getId(NotificationChannel r10) {
            return r10.getId();
        }

        @DoNotInline
        static int getImportance(NotificationChannel r10) {
            return r10.getImportance();
        }

        @DoNotInline
        static int getLightColor(NotificationChannel r10) {
            return r10.getLightColor();
        }

        @DoNotInline
        static int getLockscreenVisibility(NotificationChannel r10) {
            return r10.getLockscreenVisibility();
        }

        @DoNotInline
        static CharSequence getName(NotificationChannel r10) {
            return r10.getName();
        }

        @DoNotInline
        static Uri getSound(NotificationChannel r10) {
            return r10.getSound();
        }

        @DoNotInline
        static long[] getVibrationPattern(NotificationChannel r10) {
            return r10.getVibrationPattern();
        }

        @DoNotInline
        static void setDescription(NotificationChannel r10, String r11) {
            r10.setDescription(r11);
        }

        @DoNotInline
        static void setGroup(NotificationChannel r10, String r11) {
            r10.setGroup(r11);
        }

        @DoNotInline
        static void setLightColor(NotificationChannel r10, int r11) {
            r10.setLightColor(r11);
        }

        @DoNotInline
        static void setShowBadge(NotificationChannel r10, boolean r11) {
            r10.setShowBadge(r11);
        }

        @DoNotInline
        static void setSound(NotificationChannel r10, Uri r11, AudioAttributes r12) {
            r10.setSound(r11, r12);
        }

        @DoNotInline
        static void setVibrationPattern(NotificationChannel r10, long[] r11) {
            r10.setVibrationPattern(r11);
        }

        @DoNotInline
        static boolean shouldShowLights(NotificationChannel r10) {
            return r10.shouldShowLights();
        }

        @DoNotInline
        static boolean shouldVibrate(NotificationChannel r10) {
            return r10.shouldVibrate();
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static boolean canBubble(NotificationChannel r10) {
            return r10.canBubble();
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static String getConversationId(NotificationChannel r10) {
            return r10.getConversationId();
        }

        @DoNotInline
        static String getParentChannelId(NotificationChannel r10) {
            return r10.getParentChannelId();
        }

        @DoNotInline
        static boolean isImportantConversation(NotificationChannel r10) {
            return r10.isImportantConversation();
        }

        @DoNotInline
        static void setConversationId(NotificationChannel r10, String r11, String r12) {
            r10.setConversationId(r11, r12);
        }
    }

    public static class Builder {
        private final NotificationChannelCompat mChannel;

        public Builder(@NonNull String r10, int r11) {
            this.mChannel = new NotificationChannelCompat(r10, r11);
        }

        @NonNull
        public NotificationChannelCompat build() {
            return this.mChannel;
        }

        @NonNull
        public Builder setConversationId(@NonNull String r10, @NonNull String r11) {
            if (Build.VERSION.SDK_INT < 30) goto L5;
            NotificationChannelCompat r12 = this.mChannel;
            r12.mParentId = r10;
            r12.mConversationId = r11;
        L5:
            return this;
        }

        @NonNull
        public Builder setDescription(@Nullable String r10) {
            this.mChannel.mDescription = r10;
            return this;
        }

        @NonNull
        public Builder setGroup(@Nullable String r10) {
            this.mChannel.mGroupId = r10;
            return this;
        }

        @NonNull
        public Builder setImportance(int r10) {
            this.mChannel.mImportance = r10;
            return this;
        }

        @NonNull
        public Builder setLightColor(int r10) {
            this.mChannel.mLightColor = r10;
            return this;
        }

        @NonNull
        public Builder setLightsEnabled(boolean r10) {
            this.mChannel.mLights = r10;
            return this;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence r10) {
            this.mChannel.mName = r10;
            return this;
        }

        @NonNull
        public Builder setShowBadge(boolean r10) {
            this.mChannel.mShowBadge = r10;
            return this;
        }

        @NonNull
        public Builder setSound(@Nullable Uri r10, @Nullable AudioAttributes r11) {
            NotificationChannelCompat r12 = this.mChannel;
            r12.mSound = r10;
            r12.mAudioAttributes = r11;
            return this;
        }

        @NonNull
        public Builder setVibrationEnabled(boolean r10) {
            this.mChannel.mVibrationEnabled = r10;
            return this;
        }

        @NonNull
        public Builder setVibrationPattern(@Nullable long[] r10) {
            NotificationChannelCompat r11 = this.mChannel;
            if (r10 != null) goto L5;
        L7:
            boolean r12 = false;
        L8:
            r11.mVibrationEnabled = r12;
            r11.mVibrationPattern = r10;
            return this;
        L5:
            if (r10.length <= 0) goto L7;
            r12 = true;
            goto L8
        }
    }

    @RequiresApi(26)
    NotificationChannelCompat(@NonNull NotificationChannel r10) {
        this(Api26Impl.getId(r10), Api26Impl.getImportance(r10));
        this.mName = Api26Impl.getName(r10);
        this.mDescription = Api26Impl.getDescription(r10);
        this.mGroupId = Api26Impl.getGroup(r10);
        this.mShowBadge = Api26Impl.canShowBadge(r10);
        this.mSound = Api26Impl.getSound(r10);
        this.mAudioAttributes = Api26Impl.getAudioAttributes(r10);
        this.mLights = Api26Impl.shouldShowLights(r10);
        this.mLightColor = Api26Impl.getLightColor(r10);
        this.mVibrationEnabled = Api26Impl.shouldVibrate(r10);
        this.mVibrationPattern = Api26Impl.getVibrationPattern(r10);
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 30) goto L5;
        this.mParentId = Api30Impl.getParentChannelId(r10);
        this.mConversationId = Api30Impl.getConversationId(r10);
    L5:
        this.mBypassDnd = Api26Impl.canBypassDnd(r10);
        this.mLockscreenVisibility = Api26Impl.getLockscreenVisibility(r10);
        if (r11 < 29) goto L8;
        this.mCanBubble = Api29Impl.canBubble(r10);
    L8:
        if (r11 < 30) goto L11;
        this.mImportantConversation = Api30Impl.isImportantConversation(r10);
        return;
    }

    NotificationChannelCompat(@NonNull String r10, int r11) {
        this.mShowBadge = true;
        this.mSound = Settings.System.DEFAULT_NOTIFICATION_URI;
        this.mLightColor = 0;
        this.mId = (String) Preconditions.checkNotNull(r10);
        this.mImportance = r11;
        if (Build.VERSION.SDK_INT < 21) goto L6;
        this.mAudioAttributes = Notification.AUDIO_ATTRIBUTES_DEFAULT;
        return;
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

    NotificationChannel getNotificationChannel() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 >= 26) goto L6;
        return null;
    L6:
        NotificationChannel r11 = Api26Impl.createNotificationChannel(this.mId, this.mName, this.mImportance);
        Api26Impl.setDescription(r11, this.mDescription);
        Api26Impl.setGroup(r11, this.mGroupId);
        Api26Impl.setShowBadge(r11, this.mShowBadge);
        Api26Impl.setSound(r11, this.mSound, this.mAudioAttributes);
        Api26Impl.enableLights(r11, this.mLights);
        Api26Impl.setLightColor(r11, this.mLightColor);
        Api26Impl.setVibrationPattern(r11, this.mVibrationPattern);
        Api26Impl.enableVibration(r11, this.mVibrationEnabled);
        if (r10 < 30) goto L13;
        String r12 = this.mParentId;
        if (r12 == null) goto L13;
        String r13 = this.mConversationId;
        if (r13 == null) goto L13;
        Api30Impl.setConversationId(r11, r12, r13);
    L13:
        return r11;
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
}
