package androidx.core.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NotificationChannelGroupCompat {
    private boolean mBlocked;
    private List<NotificationChannelCompat> mChannels;
    String mDescription;
    final String mId;
    CharSequence mName;

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static NotificationChannelGroup createNotificationChannelGroup(String r5, CharSequence r10) {
            return new NotificationChannelGroup(r5, r10);
        }

        @DoNotInline
        public static List<NotificationChannel> getChannels(NotificationChannelGroup r5) {
            return r5.getChannels();
        }

        @DoNotInline
        public static String getGroup(NotificationChannel r5) {
            return r5.getGroup();
        }

        @DoNotInline
        public static String getId(NotificationChannelGroup r5) {
            return r5.getId();
        }

        @DoNotInline
        public static CharSequence getName(NotificationChannelGroup r5) {
            return r5.getName();
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static String getDescription(NotificationChannelGroup r5) {
            return r5.getDescription();
        }

        @DoNotInline
        public static boolean isBlocked(NotificationChannelGroup r5) {
            return r5.isBlocked();
        }

        @DoNotInline
        public static void setDescription(NotificationChannelGroup r5, String r10) {
            r5.setDescription(r10);
        }
    }

    public static class Builder {
        final NotificationChannelGroupCompat mGroup;

        public Builder(@NonNull String r5) {
            this.mGroup = new NotificationChannelGroupCompat(r5);
        }

        @NonNull
        public NotificationChannelGroupCompat build() {
            return this.mGroup;
        }

        @NonNull
        public Builder setDescription(@Nullable String r5) {
            this.mGroup.mDescription = r5;
            return this;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence r5) {
            this.mGroup.mName = r5;
            return this;
        }
    }

    public NotificationChannelGroupCompat(@NonNull String r5) {
        this.mChannels = Collections.emptyList();
        this.mId = (String) Preconditions.checkNotNull(r5);
    }

    @RequiresApi(26)
    private List<NotificationChannelCompat> getChannelsCompat(List<NotificationChannel> r5) {
        ArrayList r10 = new ArrayList();
        Iterator<NotificationChannel> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        NotificationChannel r12 = r11.next();
        if (this.mId.equals(Api26Impl.getGroup(r12)) == false) goto L4;
        r10.add(new NotificationChannelCompat(r12));
        goto L4
    L8:
        return r10;
    }

    @NonNull
    public List<NotificationChannelCompat> getChannels() {
        return this.mChannels;
    }

    @Nullable
    public String getDescription() {
        return this.mDescription;
    }

    @NonNull
    public String getId() {
        return this.mId;
    }

    @Nullable
    public CharSequence getName() {
        return this.mName;
    }

    public NotificationChannelGroup getNotificationChannelGroup() {
        NotificationChannelGroup r5 = Api26Impl.createNotificationChannelGroup(this.mId, this.mName);
        Api28Impl.setDescription(r5, this.mDescription);
        return r5;
    }

    public boolean isBlocked() {
        return this.mBlocked;
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this.mId).setName(this.mName).setDescription(this.mDescription);
    }

    @RequiresApi(28)
    public NotificationChannelGroupCompat(@NonNull NotificationChannelGroup r5) {
        this(r5, Collections.emptyList());
    }

    @RequiresApi(26)
    public NotificationChannelGroupCompat(@NonNull NotificationChannelGroup r5, @NonNull List<NotificationChannel> r10) {
        this(Api26Impl.getId(r5));
        this.mName = Api26Impl.getName(r5);
        this.mDescription = Api28Impl.getDescription(r5);
        this.mBlocked = Api28Impl.isBlocked(r5);
        this.mChannels = getChannelsCompat(Api26Impl.getChannels(r5));
    }
}
