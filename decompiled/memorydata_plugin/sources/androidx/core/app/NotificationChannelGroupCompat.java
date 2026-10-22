package androidx.core.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.os.Build;
import androidx.core.util.Preconditions;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    static class Api26Impl {
        private Api26Impl() {
        }

        static NotificationChannelGroup createNotificationChannelGroup(String r2, CharSequence r3) {
            return new NotificationChannelGroup(r2, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        }

        static List<NotificationChannel> getChannels(NotificationChannelGroup r0) {
            return r0.getChannels();
        }

        static String getGroup(NotificationChannel r0) {
            return r0.getGroup();
        }

        static String getId(NotificationChannelGroup r0) {
            return r0.getId();
        }

        static CharSequence getName(NotificationChannelGroup r0) {
            return r0.getName();
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static String getDescription(NotificationChannelGroup r0) {
            return r0.getDescription();
        }

        static boolean isBlocked(NotificationChannelGroup r0) {
            return r0.isBlocked();
        }

        static void setDescription(NotificationChannelGroup r0, String r1) {
            r0.setDescription(r1);
        }
    }

    public static class Builder {
        final NotificationChannelGroupCompat mGroup;

        public Builder(String r2) {
            this.mGroup = new NotificationChannelGroupCompat(r2);
        }

        public NotificationChannelGroupCompat build() {
            return this.mGroup;
        }

        public Builder setDescription(String r2) {
            this.mGroup.mDescription = r2;
            return this;
        }

        public Builder setName(CharSequence r3) {
            this.mGroup.mName = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            return this;
        }
    }

    NotificationChannelGroupCompat(NotificationChannelGroup r2) {
        this(r2, Collections.emptyList());
    }

    NotificationChannelGroupCompat(NotificationChannelGroup r3, List<NotificationChannel> r4) {
        List<NotificationChannel> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this(Api26Impl.getId(r3));
        this.mName = Api26Impl.getName(r3);
        if (Build.VERSION.SDK_INT < 28) goto L6;
        this.mDescription = Api28Impl.getDescription(r3);
    L6:
        if (Build.VERSION.SDK_INT < 28) goto L8;
        this.mBlocked = Api28Impl.isBlocked(r3);
        List<NotificationChannelCompat> r6 = getChannelsCompat(Api26Impl.getChannels(r3));
    L9:
        this.mChannels = r6;
        return;
    L8:
        r6 = getChannelsCompat(r5);
        goto L9
    }

    NotificationChannelGroupCompat(String r3) {
        this.mChannels = Collections.emptyList();
        this.mId = (String) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r3), String.class, "com.obric.memorydata.plugin");
    }

    private List<NotificationChannelCompat> getChannelsCompat(List<NotificationChannel> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        NotificationChannel r2 = (NotificationChannel) ZeusTransformUtils.preCheckCast(r8.next(), NotificationChannel.class, "com.obric.memorydata.plugin");
        if (this.mId.equals(Api26Impl.getGroup(r2)) == false) goto L4;
        r0.add(new NotificationChannelCompat(r2));
        goto L4
    L8:
        return r0;
    }

    public List<NotificationChannelCompat> getChannels() {
        return this.mChannels;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getId() {
        return this.mId;
    }

    public CharSequence getName() {
        return this.mName;
    }

    NotificationChannelGroup getNotificationChannelGroup() {
        if (Build.VERSION.SDK_INT >= 26) goto L6;
        return null;
    L6:
        NotificationChannelGroup r0 = Api26Impl.createNotificationChannelGroup(this.mId, this.mName);
        if (Build.VERSION.SDK_INT < 28) goto L9;
        Api28Impl.setDescription(r0, this.mDescription);
    L9:
        return r0;
    }

    public boolean isBlocked() {
        return this.mBlocked;
    }

    public Builder toBuilder() {
        return new Builder(this.mId).setName(this.mName).setDescription(this.mDescription);
    }
}
