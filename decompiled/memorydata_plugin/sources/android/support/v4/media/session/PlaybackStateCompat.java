package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final long ACTION_FAST_FORWARD = 64;
    public static final long ACTION_PAUSE = 2;
    public static final long ACTION_PLAY = 4;
    public static final long ACTION_PLAY_FROM_MEDIA_ID = 1024;
    public static final long ACTION_PLAY_FROM_SEARCH = 2048;
    public static final long ACTION_PLAY_FROM_URI = 8192;
    public static final long ACTION_PLAY_PAUSE = 512;
    public static final long ACTION_PREPARE = 16384;
    public static final long ACTION_PREPARE_FROM_MEDIA_ID = 32768;
    public static final long ACTION_PREPARE_FROM_SEARCH = 65536;
    public static final long ACTION_PREPARE_FROM_URI = 131072;
    public static final long ACTION_REWIND = 8;
    public static final long ACTION_SEEK_TO = 256;
    public static final long ACTION_SET_CAPTIONING_ENABLED = 1048576;
    public static final long ACTION_SET_RATING = 128;
    public static final long ACTION_SET_REPEAT_MODE = 262144;
    public static final long ACTION_SET_SHUFFLE_MODE = 2097152;

    @Deprecated
    public static final long ACTION_SET_SHUFFLE_MODE_ENABLED = 524288;
    public static final long ACTION_SKIP_TO_NEXT = 32;
    public static final long ACTION_SKIP_TO_PREVIOUS = 16;
    public static final long ACTION_SKIP_TO_QUEUE_ITEM = 4096;
    public static final long ACTION_STOP = 1;
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = null;
    public static final int ERROR_CODE_ACTION_ABORTED = 10;
    public static final int ERROR_CODE_APP_ERROR = 1;
    public static final int ERROR_CODE_AUTHENTICATION_EXPIRED = 3;
    public static final int ERROR_CODE_CONCURRENT_STREAM_LIMIT = 5;
    public static final int ERROR_CODE_CONTENT_ALREADY_PLAYING = 8;
    public static final int ERROR_CODE_END_OF_QUEUE = 11;
    public static final int ERROR_CODE_NOT_AVAILABLE_IN_REGION = 7;
    public static final int ERROR_CODE_NOT_SUPPORTED = 2;
    public static final int ERROR_CODE_PARENTAL_CONTROL_RESTRICTED = 6;
    public static final int ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED = 4;
    public static final int ERROR_CODE_SKIP_LIMIT_REACHED = 9;
    public static final int ERROR_CODE_UNKNOWN_ERROR = 0;
    private static final int KEYCODE_MEDIA_PAUSE = 127;
    private static final int KEYCODE_MEDIA_PLAY = 126;
    public static final long PLAYBACK_POSITION_UNKNOWN = -1;
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_GROUP = 3;
    public static final int REPEAT_MODE_INVALID = -1;
    public static final int REPEAT_MODE_NONE = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int SHUFFLE_MODE_ALL = 1;
    public static final int SHUFFLE_MODE_GROUP = 2;
    public static final int SHUFFLE_MODE_INVALID = -1;
    public static final int SHUFFLE_MODE_NONE = 0;
    public static final int STATE_BUFFERING = 6;
    public static final int STATE_CONNECTING = 8;
    public static final int STATE_ERROR = 7;
    public static final int STATE_FAST_FORWARDING = 4;
    public static final int STATE_NONE = 0;
    public static final int STATE_PAUSED = 2;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_REWINDING = 5;
    public static final int STATE_SKIPPING_TO_NEXT = 10;
    public static final int STATE_SKIPPING_TO_PREVIOUS = 9;
    public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
    public static final int STATE_STOPPED = 1;
    final long mActions;
    final long mActiveItemId;
    final long mBufferedPosition;
    List<CustomAction> mCustomActions;
    final int mErrorCode;
    final CharSequence mErrorMessage;
    final Bundle mExtras;
    final long mPosition;
    final float mSpeed;
    final int mState;
    private Object mStateObj;
    final long mUpdateTime;

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = null;
        private final String mAction;
        private Object mCustomActionObj;
        private final Bundle mExtras;
        private final int mIcon;
        private final CharSequence mName;

        static {
            CREATOR = new AnonymousClass1();
        }

        CustomAction(Parcel r4) {
            this.mAction = r4.readString();
            this.mName = (CharSequence) ZeusTransformUtils.preCheckCast(TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r4), CharSequence.class, "com.obric.memorydata.plugin");
            this.mIcon = r4.readInt();
            this.mExtras = r4.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        CustomAction(String r3, CharSequence r4, int r5, Bundle r6) {
            CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
            this.mAction = r3;
            this.mName = r7;
            this.mIcon = r5;
            this.mExtras = r6;
        }

        public static CustomAction fromCustomAction(Object r5) {
            if (r5 != null) goto L4;
            return null;
        L4:
            if (Build.VERSION.SDK_INT < 21) goto L10;
            CustomAction r0 = new CustomAction(e.a.a(r5), e.a.b(r5), e.a.c(r5), e.a.d(r5));
            r0.mCustomActionObj = r5;
            return r0;
        L10:
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getAction() {
            return this.mAction;
        }

        public Object getCustomAction() {
            if (this.mCustomActionObj != null) goto L10;
            if (Build.VERSION.SDK_INT < 21) goto L10;
            Object r0 = e.a.a(this.mAction, this.mName, this.mIcon, this.mExtras);
            this.mCustomActionObj = r0;
            return r0;
        L10:
            return this.mCustomActionObj;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public int getIcon() {
            return this.mIcon;
        }

        public CharSequence getName() {
            return this.mName;
        }

        public String toString() {
            return "Action:mName='" + this.mName + ", mIcon=" + this.mIcon + ", mExtras=" + this.mExtras;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            r2.writeString(this.mAction);
            TextUtils.writeToParcel(this.mName, r2, r3);
            r2.writeInt(this.mIcon);
            r2.writeBundle(this.mExtras);
        }
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    PlaybackStateCompat(int r6, long r7, long r9, float r11, long r12, int r14, CharSequence r15, long r16, List<CustomAction> r18, long r19, Bundle r21) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r15, CharSequence.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        this.mState = r6;
        this.mPosition = r7;
        this.mBufferedPosition = r9;
        this.mSpeed = r11;
        this.mActions = r12;
        this.mErrorCode = r14;
        this.mErrorMessage = r1;
        this.mUpdateTime = r16;
        this.mCustomActions = new ArrayList(r2);
        this.mActiveItemId = r19;
        this.mExtras = r21;
    }

    PlaybackStateCompat(Parcel r4) {
        this.mState = r4.readInt();
        this.mPosition = r4.readLong();
        this.mSpeed = r4.readFloat();
        this.mUpdateTime = r4.readLong();
        this.mBufferedPosition = r4.readLong();
        this.mActions = r4.readLong();
        this.mErrorMessage = (CharSequence) ZeusTransformUtils.preCheckCast(TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r4), CharSequence.class, "com.obric.memorydata.plugin");
        this.mCustomActions = r4.createTypedArrayList(CustomAction.CREATOR);
        this.mActiveItemId = r4.readLong();
        this.mExtras = r4.readBundle(MediaSessionCompat.class.getClassLoader());
        this.mErrorCode = r4.readInt();
    }

    public static PlaybackStateCompat fromPlaybackState(Object r22) {
        Bundle r1 = null;
        if (r22 != null) goto L5;
        return null;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L21;
        List<Object> r2 = e.h(r22);
        if (r2 == null) goto L13;
        ArrayList r3 = new ArrayList(r2.size());
        Iterator<Object> r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        r3.add(CustomAction.fromCustomAction(r4.next()));
        goto L10
    L12:
        ArrayList r18 = r3;
    L15:
        if (Build.VERSION.SDK_INT < 22) goto L17;
        r1 = f.a(r22);
    L17:
        PlaybackStateCompat r5 = new PlaybackStateCompat(e.a(r22), e.b(r22), e.c(r22), e.d(r22), e.e(r22), 0, e.f(r22), e.g(r22), r18, e.i(r22), r1);
        r5.mStateObj = r22;
        return r5;
    L13:
        r18 = null;
        goto L15
    L21:
        return null;
    }

    public static int toKeyCode(long r2) {
        if (r2 != 4) goto L7;
        return 126;
    L7:
        if (r2 != 2) goto L11;
        return 127;
    L11:
        if (r2 != 32) goto L15;
        return 87;
    L15:
        if (r2 != 16) goto L19;
        return 88;
    L19:
        if (r2 != 1) goto L23;
        return 86;
    L23:
        if (r2 != 64) goto L27;
        return 90;
    L27:
        if (r2 != 8) goto L31;
        return 89;
    L31:
        if (r2 != 512) goto L34;
        return 85;
    L34:
        return 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getActions() {
        return this.mActions;
    }

    public long getActiveQueueItemId() {
        return this.mActiveItemId;
    }

    public long getBufferedPosition() {
        return this.mBufferedPosition;
    }

    public long getCurrentPosition(Long r6) {
        long r0 = this.mPosition;
        float r2 = this.mSpeed;
        if (r6 == null) goto L5;
        long r5 = r6.longValue();
    L7:
        return Math.max(0, r0 + ((long) (r2 * r5)));
    L5:
        r5 = SystemClock.elapsedRealtime() - this.mUpdateTime;
        goto L7
    }

    public List<CustomAction> getCustomActions() {
        return this.mCustomActions;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public CharSequence getErrorMessage() {
        return this.mErrorMessage;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public long getLastPositionUpdateTime() {
        return this.mUpdateTime;
    }

    public float getPlaybackSpeed() {
        return this.mSpeed;
    }

    public Object getPlaybackState() {
        if (this.mStateObj != null) goto L18;
        if (Build.VERSION.SDK_INT < 21) goto L18;
        ArrayList r1 = null;
        if (this.mCustomActions == null) goto L12;
        r1 = new ArrayList(this.mCustomActions.size());
        Iterator<CustomAction> r2 = this.mCustomActions.iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        r1.add(((CustomAction) ZeusTransformUtils.preCheckCast(r2.next(), CustomAction.class, "com.obric.memorydata.plugin")).getCustomAction());
    L12:
        ArrayList r15 = r1;
        int r3 = Build.VERSION.SDK_INT;
        int r4 = this.mState;
        long r5 = this.mPosition;
        long r7 = this.mBufferedPosition;
        float r9 = this.mSpeed;
        long r10 = this.mActions;
        CharSequence r12 = this.mErrorMessage;
        long r13 = this.mUpdateTime;
        if (r3 < 22) goto L15;
        Object r6 = f.a(r4, r5, r7, r9, r10, r12, r13, r15, this.mActiveItemId, this.mExtras);
    L16:
        this.mStateObj = r6;
        goto L18
    L15:
        r6 = e.a(r4, r5, r7, r9, r10, r12, r13, r15, this.mActiveItemId);
    L18:
        return this.mStateObj;
    }

    public long getPosition() {
        return this.mPosition;
    }

    public int getState() {
        return this.mState;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("PlaybackState {");
        r0.append("state=").append(this.mState);
        r0.append(", position=").append(this.mPosition);
        r0.append(", buffered position=").append(this.mBufferedPosition);
        r0.append(", speed=").append(this.mSpeed);
        r0.append(", updated=").append(this.mUpdateTime);
        r0.append(", actions=").append(this.mActions);
        r0.append(", error code=").append(this.mErrorCode);
        r0.append(", error message=").append(this.mErrorMessage);
        r0.append(", custom actions=").append(this.mCustomActions);
        r0.append(", active item id=").append(this.mActiveItemId);
        r0.append("}");
        return r0.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(this.mState);
        r3.writeLong(this.mPosition);
        r3.writeFloat(this.mSpeed);
        r3.writeLong(this.mUpdateTime);
        r3.writeLong(this.mBufferedPosition);
        r3.writeLong(this.mActions);
        TextUtils.writeToParcel(this.mErrorMessage, r3, r4);
        r3.writeTypedList(this.mCustomActions);
        r3.writeLong(this.mActiveItemId);
        r3.writeBundle(this.mExtras);
        r3.writeInt(this.mErrorCode);
    }
}
