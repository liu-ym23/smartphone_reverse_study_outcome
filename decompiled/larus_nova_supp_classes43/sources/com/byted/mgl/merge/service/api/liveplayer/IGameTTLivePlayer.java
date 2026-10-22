package com.byted.mgl.merge.service.api.liveplayer;

import android.graphics.Point;
import android.view.Surface;
import com.byted.cast.sink.api.IAPI;
import com.byted.mgl.merge.service.api.liveplayer.listener.IGameTTLivePlayerListener;
import com.bytedance.android.anniex.base.depend.DeviceDepend;
import com.bytedance.android.ec.core.event.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0005\u001c\u001d\u001e\u001f J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\tH&J.\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0012\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\b\u0010\u001b\u001a\u00020\tH&¨\u0006!"}, d2 = {"Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer;", "", "getPlayState", "Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$PlayerState;", "getVideoSize", "Landroid/graphics/Point;", "isPlaying", "", "muted", "", "pause", a.VALUE_PLAY, "release", "reset", "setDataSource", a.KEY_URL, "", "headers", "", "extraConfig", "Lorg/json/JSONObject;", "setListener", "listener", "Lcom/byted/mgl/merge/service/api/liveplayer/listener/IGameTTLivePlayerListener;", "setSurface", "surface", "Landroid/view/Surface;", "stop", "DisplayMode", "LiveError", "ObjectFit", "Orientation", "PlayerState", "bdp-service-api_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
public interface IGameTTLivePlayer {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$DisplayMode;", "", "objectFit", "Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$ObjectFit;", "displayOrientation", "Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$Orientation;", "(Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$ObjectFit;Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$Orientation;)V", "getDisplayOrientation", "()Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$Orientation;", "getObjectFit", "()Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$ObjectFit;", "bdp-service-api_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
    public static final class DisplayMode {
        private final Orientation displayOrientation;
        private final ObjectFit objectFit;

        public final Orientation getDisplayOrientation() {
            return this.displayOrientation;
        }

        public final ObjectFit getObjectFit() {
            return this.objectFit;
        }

        public DisplayMode(ObjectFit r1, Orientation r10) {
            this.objectFit = r1;
            this.displayOrientation = r10;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$LiveError;", "", "code", "", a.KEY_MSG, "", "info", "(ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getInfo", "()Ljava/lang/String;", "getMessage", "toString", "bdp-service-api_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
    public static final class LiveError {
        private final int code;
        private final String info;
        private final String message;

        public String toString() {
            return "LivePlayer_Error{code: " + this.code + ", msg: " + this.message + ", info: " + this.info + "}.";
        }

        public final int getCode() {
            return this.code;
        }

        public final String getInfo() {
            return this.info;
        }

        public final String getMessage() {
            return this.message;
        }

        public LiveError(int r1, String r10, String r11) {
            this.code = r1;
            this.message = r10;
            this.info = r11;
        }

        public /* synthetic */ LiveError(int r1, String r10, String r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 4) == 0) goto L5;
            r11 = null;
        L5:
            this(r1, r10, r11);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$ObjectFit;", "", a.KEY_LUBAN_VALUE, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CONTAIN", "FILLCROP", "bdp-service-api_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
    public static final enum ObjectFit extends Enum<ObjectFit> {
        private static final /* synthetic */ ObjectFit[] $VALUES = null;
        public static final ObjectFit CONTAIN = null;
        public static final ObjectFit FILLCROP = null;
        private final String value;

        static {
            ObjectFit r1 = new ObjectFit("CONTAIN", 0, "contain");
            CONTAIN = r1;
            ObjectFit r10 = new ObjectFit("FILLCROP", 1, "fillCrop");
            FILLCROP = r10;
            $VALUES = new ObjectFit[]{r1, r10};
        }

        public static ObjectFit valueOf(String r1) {
            return (ObjectFit) r27.a.a(ObjectFit.class, r1);
        }

        public static ObjectFit[] values() {
            return (ObjectFit[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }

        private ObjectFit(String r1, int r10, String r11) {
            super(r1, r10);
            this.value = r11;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$Orientation;", "", a.KEY_LUBAN_VALUE, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "VERTICAL", "HORIZONTAL", "bdp-service-api_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
    public static final enum Orientation extends Enum<Orientation> {
        private static final /* synthetic */ Orientation[] $VALUES = null;
        public static final Orientation HORIZONTAL = null;
        public static final Orientation VERTICAL = null;
        private final String value;

        static {
            Orientation r1 = new Orientation("VERTICAL", 0, DeviceDepend.FoldType.VERTICAL);
            VERTICAL = r1;
            Orientation r10 = new Orientation("HORIZONTAL", 1, DeviceDepend.FoldType.HORIZONTAL);
            HORIZONTAL = r10;
            $VALUES = new Orientation[]{r1, r10};
        }

        public static Orientation valueOf(String r1) {
            return (Orientation) r27.a.a(Orientation.class, r1);
        }

        public static Orientation[] values() {
            return (Orientation[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }

        private Orientation(String r1, int r10, String r11) {
            super(r1, r10);
            this.value = r11;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$PlayerState;", "", "(Ljava/lang/String;I)V", "INIT", "FETCHING", "PREPARED", "PLAYING", "STALLING", "STOPPED", "COMPLETED", "ERROR", "STREAM_DRY_UP", "REQUEST_PLAY_URL_ERROR", "bdp-service-api_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
    public static final enum PlayerState extends Enum<PlayerState> {
        private static final /* synthetic */ PlayerState[] $VALUES = null;
        public static final PlayerState COMPLETED = null;
        public static final PlayerState ERROR = null;
        public static final PlayerState FETCHING = null;
        public static final PlayerState INIT = null;
        public static final PlayerState PLAYING = null;
        public static final PlayerState PREPARED = null;
        public static final PlayerState REQUEST_PLAY_URL_ERROR = null;
        public static final PlayerState STALLING = null;
        public static final PlayerState STOPPED = null;
        public static final PlayerState STREAM_DRY_UP = null;

        static {
            PlayerState r1 = new PlayerState("INIT", 0);
            INIT = r1;
            PlayerState r10 = new PlayerState("FETCHING", 1);
            FETCHING = r10;
            PlayerState r11 = new PlayerState("PREPARED", 2);
            PREPARED = r11;
            PlayerState r12 = new PlayerState("PLAYING", 3);
            PLAYING = r12;
            PlayerState r13 = new PlayerState("STALLING", 4);
            STALLING = r13;
            PlayerState r14 = new PlayerState("STOPPED", 5);
            STOPPED = r14;
            PlayerState r15 = new PlayerState("COMPLETED", 6);
            COMPLETED = r15;
            PlayerState r16 = new PlayerState("ERROR", 7);
            ERROR = r16;
            PlayerState r17 = new PlayerState("STREAM_DRY_UP", 8);
            STREAM_DRY_UP = r17;
            PlayerState r18 = new PlayerState("REQUEST_PLAY_URL_ERROR", 9);
            REQUEST_PLAY_URL_ERROR = r18;
            $VALUES = new PlayerState[]{r1, r10, r11, r12, r13, r14, r15, r16, r17, r18};
        }

        public static PlayerState valueOf(String r1) {
            return (PlayerState) r27.a.a(PlayerState.class, r1);
        }

        public static PlayerState[] values() {
            return (PlayerState[]) $VALUES.clone();
        }

        private PlayerState(String r1, int r10) {
            super(r1, r10);
        }
    }

    PlayerState getPlayState();

    Point getVideoSize();

    boolean isPlaying();

    void muted(boolean r1);

    void pause();

    void play();

    void release();

    void reset();

    void setDataSource(String r1, Map<String, String> r10, JSONObject r11);

    void setListener(IGameTTLivePlayerListener r1);

    void setSurface(Surface r1);

    void stop();
}
