package com.obric.cae.libs.appscene;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseAppScene implements Parcelable {
    public static final Parcelable.Creator<BaseAppScene> CREATOR = null;
    public static final int ENTER_STATUS_ENTER = 1;
    public static final int ENTER_STATUS_EXIT = 0;
    public static final int SCENE_COMMON = 0;
    public static final int SCENE_FILE_DOWNLOAD = 11;
    public static final int SCENE_FILE_UPLOAD = 10;
    public static final int SCENE_GAMEPLAY = 5;
    public static final int SCENE_GAME_LOBBY = 6;
    public static final int SCENE_LIVE_BROADCAST = 4;

    @Deprecated
    public static final int SCENE_LIVE_BROADCOST = 4;
    public static final int SCENE_LIVE_PLAY = 3;
    public static final int SCENE_LONG_VIDEO = 2;
    public static final int SCENE_MEETING = 9;
    public static final int SCENE_SHORT_VIDEO = 1;
    public static final int SCENE_VIDEO_CALL = 7;
    public static final int SCENE_VOICE_CALL = 8;

    @Deprecated
    public static final int SCENE_VOICE_CALLL = 8;
    public static final int SCENE_WEBPAGES = 12;
    public static final int WINDOWS_FLOATING = 1;
    public static final int WINDOWS_FULLSCREEN = 0;
    private final Integer mActionStatus;
    private final int mEnterStatus;
    private final String mPackageName;
    private final int mScene;
    private final int mWindows;

    public static final class CommonScene extends BaseAppScene {
        public CommonScene(String r2, int r3, int r4) {
            this(r2, r3, r4, null);
        }

        public CommonScene(String r7, int r8, int r9, Integer r10) {
            super(r7, r8, r9, 0, r10);
        }
    }

    public static final class FileDownloadScene extends BaseAppScene {
        public FileDownloadScene(String r2, int r3, int r4) {
            this(r2, r3, r4, null);
        }

        public FileDownloadScene(String r7, int r8, int r9, Integer r10) {
            super(r7, r8, r9, 11, r10);
        }
    }

    public static final class FileUploadScene extends BaseAppScene {
        public FileUploadScene(String r2, int r3, int r4) {
            this(r2, r3, r4, null);
        }

        public FileUploadScene(String r7, int r8, int r9, Integer r10) {
            super(r7, r8, r9, 10, r10);
        }
    }

    public static final class GameLobbyScene extends BaseAppScene {
        public GameLobbyScene(String r2, int r3, int r4) {
            this(r2, r3, r4, null);
        }

        public GameLobbyScene(String r7, int r8, int r9, Integer r10) {
            super(r7, r8, r9, 6, r10);
        }
    }

    public static final class GameplayScene extends BaseAppScene {
        public GameplayScene(String r2, int r3, int r4) {
            this(r2, r3, r4, null);
        }

        public GameplayScene(String r7, int r8, int r9, Integer r10) {
            super(r7, r8, r9, 5, r10);
        }
    }

    public static final class LiveBroadcastScene extends BaseAppScene {
        public LiveBroadcastScene(String r2, int r3, int r4) {
            this(r2, r3, r4, null);
        }

        public LiveBroadcastScene(String r7, int r8, int r9, Integer r10) {
            super(r7, r8, r9, 4, r10);
        }
    }

    public static final class LivePlayScene extends BaseAppScene {
        public LivePlayScene(String r2, int r3, int r4) {
            this(r2, r3, r4, null);
        }

        public LivePlayScene(String r7, int r8, int r9, Integer r10) {
            super(r7, r8, r9, 3, r10);
        }
    }

    public static final class LongVideoScene extends BaseAppScene {
        public LongVideoScene(String r2, int r3, int r4) {
            this(r2, r3, r4, null);
        }

        public LongVideoScene(String r7, int r8, int r9, Integer r10) {
            super(r7, r8, r9, 2, r10);
        }
    }

    public static final class MeetingScene extends BaseAppScene {
        public MeetingScene(String r2, int r3, int r4) {
            this(r2, r3, r4, null);
        }

        public MeetingScene(String r7, int r8, int r9, Integer r10) {
            super(r7, r8, r9, 9, r10);
        }
    }

    public static final class ShortVideoScene extends BaseAppScene {
        public static final int ACTION_PAUSED = 0;
        public static final int ACTION_PLAYING = 1;

        public ShortVideoScene(String r2, int r3, int r4) {
            this(r2, r3, r4, 1);
        }

        public ShortVideoScene(String r7, int r8, int r9, Integer r10) {
            super(r7, r8, r9, 1, r10);
        }
    }

    public static final class VideoCallScene extends BaseAppScene {
        public VideoCallScene(String r2, int r3, int r4) {
            this(r2, r3, r4, null);
        }

        public VideoCallScene(String r7, int r8, int r9, Integer r10) {
            super(r7, r8, r9, 7, r10);
        }
    }

    public static final class VoiceCallScene extends BaseAppScene {
        public VoiceCallScene(String r2, int r3, int r4) {
            this(r2, r3, r4, null);
        }

        public VoiceCallScene(String r7, int r8, int r9, Integer r10) {
            super(r7, r8, r9, 8, r10);
        }
    }

    public static final class WebPagesScene extends BaseAppScene {
        public WebPagesScene(String r2, int r3, int r4) {
            this(r2, r3, r4, null);
        }

        public WebPagesScene(String r7, int r8, int r9, Integer r10) {
            super(r7, r8, r9, 12, r10);
        }
    }

    public class a implements Parcelable.Creator<BaseAppScene> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BaseAppScene createFromParcel(Parcel r5) {
            String r4 = r5.readString();
            int r0 = r5.readInt();
            int r1 = r5.readInt();
            int r2 = r5.readInt();
            if (r5.readInt() != 0) goto L5;
            Integer r6 = null;
        L7:
            return BaseAppScene.create(r4, r0, r1, r2, r6);
        L5:
            r6 = Integer.valueOf(r5.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final BaseAppScene[] newArray(int r1) {
            return new BaseAppScene[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public BaseAppScene(String r1, int r2, int r3, int r4, Integer r5) {
        a(r2);
        c(r3);
        b(r4);
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        this.mPackageName = r1;
        this.mEnterStatus = r2;
        this.mWindows = r3;
        this.mScene = r4;
        this.mActionStatus = a(r4, r5);
    }

    public static Integer a(int r2, Integer r3) {
        if (r2 == 1) goto L5;
        return r3;
    L5:
        if (r3 != null) goto L9;
        return 1;
    L9:
        if (r3.intValue() != 0) goto L11;
    L15:
        return r3;
    L11:
        if (r3.intValue() == 1) goto L15;
        throw new IllegalArgumentException("Invalid short video action status: " + r3);
    }

    public static void a(int r3) {
        if (r3 != 0) goto L4;
        return;
    L4:
        if (r3 != 1) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("Invalid enter status: " + r3);
    }

    public static void b(int r3) {
        if (r3 < 0) goto L7;
        if (r3 > 12) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("Invalid scene: " + r3);
    }

    public static void c(int r3) {
        if (r3 != 0) goto L4;
        return;
    L4:
        if (r3 != 1) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("Invalid windows state: " + r3);
    }

    public static BaseAppScene create(String r0, int r1, int r2, int r3, Integer r4) {
        switch(r3) {
            case 0: goto L30;
            case 1: goto L28;
            case 2: goto L26;
            case 3: goto L24;
            case 4: goto L22;
            case 5: goto L20;
            case 6: goto L18;
            case 7: goto L16;
            case 8: goto L14;
            case 9: goto L12;
            case 10: goto L10;
            case 11: goto L8;
            case 12: goto L6;
            default: goto L4;
        };
    L4:
        throw new IllegalArgumentException("Unsupported scene: " + r3);
    L6:
        return new WebPagesScene(r0, r1, r2, r4);
    L8:
        return new FileDownloadScene(r0, r1, r2, r4);
    L10:
        return new FileUploadScene(r0, r1, r2, r4);
    L12:
        return new MeetingScene(r0, r1, r2, r4);
    L14:
        return new VoiceCallScene(r0, r1, r2, r4);
    L16:
        return new VideoCallScene(r0, r1, r2, r4);
    L18:
        return new GameLobbyScene(r0, r1, r2, r4);
    L20:
        return new GameplayScene(r0, r1, r2, r4);
    L22:
        return new LiveBroadcastScene(r0, r1, r2, r4);
    L24:
        return new LivePlayScene(r0, r1, r2, r4);
    L26:
        return new LongVideoScene(r0, r1, r2, r4);
    L28:
        return new ShortVideoScene(r0, r1, r2, r4);
    L30:
        return new CommonScene(r0, r1, r2, r4);
    }

    public BaseAppScene copy() {
        return create(this.mPackageName, this.mEnterStatus, this.mWindows, this.mScene, this.mActionStatus);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BaseAppScene.class) == true) goto L8;
        return false;
    L8:
        BaseAppScene r6 = (BaseAppScene) ZeusTransformUtils.preCheckCast(r5, BaseAppScene.class, "com.obric.memorydata.plugin");
        if (this.mEnterStatus != r6.mEnterStatus) goto L20;
        if (this.mWindows != r6.mWindows) goto L20;
        if (this.mScene != r6.mScene) goto L20;
        if (Objects.equals(this.mPackageName, r6.mPackageName) == false) goto L20;
        if (Objects.equals(this.mActionStatus, r6.mActionStatus) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public Integer getActionStatus() {
        return this.mActionStatus;
    }

    public int getEnterStatus() {
        return this.mEnterStatus;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int getScene() {
        return this.mScene;
    }

    public int getWindows() {
        return this.mWindows;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mPackageName, Integer.valueOf(this.mEnterStatus), Integer.valueOf(this.mWindows), Integer.valueOf(this.mScene), this.mActionStatus});
    }

    public String toString() {
        return getClass().getSimpleName() + "{packageName='" + this.mPackageName + "', enterStatus=" + this.mEnterStatus + ", windows=" + this.mWindows + ", scene=" + this.mScene + ", actionStatus=" + this.mActionStatus + '}';
    }

    public BaseAppScene withActionStatus(Integer r4) {
        return create(this.mPackageName, this.mEnterStatus, this.mWindows, this.mScene, r4);
    }

    public BaseAppScene withEnterStatus(int r4) {
        return create(this.mPackageName, r4, this.mWindows, this.mScene, this.mActionStatus);
    }

    public BaseAppScene withWindows(int r4) {
        return create(this.mPackageName, this.mEnterStatus, r4, this.mScene, this.mActionStatus);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.mPackageName);
        r1.writeInt(this.mEnterStatus);
        r1.writeInt(this.mWindows);
        r1.writeInt(this.mScene);
        if (this.mActionStatus != null) goto L5;
        int r3 = 0;
    L6:
        r1.writeInt(r3);
        Integer r0 = this.mActionStatus;
        if (r0 == null) goto L10;
        r1.writeInt(r0.intValue());
        return;
    L10:
        return;
    L5:
        r3 = 1;
        goto L6
    }
}
