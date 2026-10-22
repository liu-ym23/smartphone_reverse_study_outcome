package androidx.core.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.os.Build;
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
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static NotificationChannelGroup createNotificationChannelGroup(String r10, CharSequence r11) {
            return new NotificationChannelGroup(r10, r11);
        }

        @DoNotInline
        static List<NotificationChannel> getChannels(NotificationChannelGroup r10) {
            return r10.getChannels();
        }

        @DoNotInline
        static String getGroup(NotificationChannel r10) {
            return r10.getGroup();
        }

        @DoNotInline
        static String getId(NotificationChannelGroup r10) {
            return r10.getId();
        }

        @DoNotInline
        static CharSequence getName(NotificationChannelGroup r10) {
            return r10.getName();
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static String getDescription(NotificationChannelGroup r10) {
            return r10.getDescription();
        }

        @DoNotInline
        static boolean isBlocked(NotificationChannelGroup r10) {
            return r10.isBlocked();
        }

        @DoNotInline
        static void setDescription(NotificationChannelGroup r10, String r11) {
            r10.setDescription(r11);
        }
    }

    public static class Builder {
        final NotificationChannelGroupCompat mGroup;

        public Builder(@NonNull String r10) {
            this.mGroup = new NotificationChannelGroupCompat(r10);
        }

        @NonNull
        public NotificationChannelGroupCompat build() {
            return this.mGroup;
        }

        @NonNull
        public Builder setDescription(@Nullable String r10) {
            this.mGroup.mDescription = r10;
            return this;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence r10) {
            this.mGroup.mName = r10;
            return this;
        }
    }

    @RequiresApi(28)
    NotificationChannelGroupCompat(@NonNull NotificationChannelGroup r10) {
        this(r10, Collections.emptyList());
    }

    @RequiresApi(26)
    NotificationChannelGroupCompat(@NonNull NotificationChannelGroup r10, @NonNull List<NotificationChannel> r11) {
        this(Api26Impl.getId(r10));
        this.mName = Api26Impl.getName(r10);
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 28) goto L5;
        this.mDescription = Api28Impl.getDescription(r10);
    L5:
        if (r12 < 28) goto L7;
        this.mBlocked = Api28Impl.isBlocked(r10);
        List<NotificationChannelCompat> r13 = getChannelsCompat(Api26Impl.getChannels(r10));
    L8:
        this.mChannels = r13;
        return;
    L7:
        r13 = getChannelsCompat(r11);
        goto L8
    }

    NotificationChannelGroupCompat(@NonNull String r10) {
        this.mChannels = Collections.emptyList();
        this.mId = (String) Preconditions.checkNotNull(r10);
    }

    @RequiresApi(26)
    private List<NotificationChannelCompat> getChannelsCompat(List<NotificationChannel> r10) {
        ArrayList r11 = new ArrayList();
        Iterator<NotificationChannel> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        NotificationChannel r13 = r12.next();
        if (this.mId.equals(Api26Impl.getGroup(r13)) == false) goto L4;
        r11.add(new NotificationChannelCompat(r13));
        goto L4
    L8:
        return r11;
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

    NotificationChannelGroup getNotificationChannelGroup() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 >= 26) goto L6;
        return null;
    L6:
        NotificationChannelGroup r11 = Api26Impl.createNotificationChannelGroup(this.mId, this.mName);
        if (r10 < 28) goto L9;
        Api28Impl.setDescription(r11, this.mDescription);
    L9:
        return r11;
    }

    public boolean isBlocked() {
        return this.mBlocked;
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this.mId).setName(this.mName).setDescription(this.mDescription);
    }
}
