package com.larus.bmhome.music.applet;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/music/applet/MusicAppletPage;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TEMPLATE_LIST", "TEMPLATE_DETAIL", "CHAT_MUSIC_DETAIL", "Companion", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MusicAppletPage extends Enum<MusicAppletPage> {
    public static final String APP_ID = "db_2c90E66";
    public static final MusicAppletPage CHAT_MUSIC_DETAIL = null;
    public static final a Companion = null;
    public static final String KEY_CONVERSATION_ID = "conversation_id";
    public static final String KEY_DATA_KEY = "data_key";
    public static final String KEY_INIT_PROGRESS = "init_progress";
    public static final String KEY_KEEP_FOREGROUND_AFTER_SEND = "keep_foreground_after_send";
    public static final String KEY_MESSAGE_ID = "message_id";
    public static final String KEY_MUSIC_CONTENT = "music_content";
    public static final String KEY_OUT_PULLING_FINISHED = "out_pulling_finished";
    public static final String KEY_PATH = "path";
    public static final String KEY_PLAYER_DATA = "music_player_data";
    public static final String KEY_REPLICA_PARAMS = "music_replica_params";
    public static final String KEY_SOURCE = "source";
    public static final String KEY_SOURCE_CREATION_SESSION_ID = "source_creation_session_id";
    public static final String QUERY_APP_ID = "app_id";
    public static final String ROUTE_DOUBAO_APPS = "sslocal://doubao_apps";
    public static final String ROUTE_MODE = "route_mode";
    public static final String ROUTE_MODE_NAVIGATION = "navigate";
    public static final String ROUTE_MODE_RELAUNCH = "relaunch";
    public static final String SOURCE_PROFILE_CREATION_DETAIL = "profile_creation_detail";
    public static final String SOURCE_TEMPLATE_LIST = "template_list";
    public static final MusicAppletPage TEMPLATE_DETAIL = null;
    public static final MusicAppletPage TEMPLATE_LIST = null;
    public static final /* synthetic */ MusicAppletPage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<MusicAppletPage> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.music.applet.MusicAppletPage$a] */
    static {
        MusicAppletPage r0 = new MusicAppletPage("TEMPLATE_LIST", 0, SOURCE_TEMPLATE_LIST);
        TEMPLATE_LIST = r0;
        MusicAppletPage r1 = new MusicAppletPage("TEMPLATE_DETAIL", 1, "template_detail");
        TEMPLATE_DETAIL = r1;
        MusicAppletPage r3 = new MusicAppletPage("CHAT_MUSIC_DETAIL", 2, "chat_music_detail");
        CHAT_MUSIC_DETAIL = r3;
        MusicAppletPage[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static MusicAppletPage[] values() {
        return (MusicAppletPage[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static MusicAppletPage valueOf(String r1) {
        return (MusicAppletPage) r27.a.a(MusicAppletPage.class, r1);
    }

    public MusicAppletPage(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
