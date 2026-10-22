package com.tencent.qqmusic.third.api.contract;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface Data {
    public static final int LIVE = 2;
    public static final int MV = 1;
    public static final int SONG = 0;

    public static class Album {
        private String coverUri;
        private long id;
        private String mid;
        private String title;

        public Album() {
        }

        public String getCoverUri() {
            return this.coverUri;
        }

        public long getId() {
            return this.id;
        }

        public String getMid() {
            return this.mid;
        }

        public String getTitle() {
            return this.title;
        }

        public void setCoverUri(String r1) {
            this.coverUri = r1;
        }

        public void setId(long r1) {
            this.id = r1;
        }

        public void setMid(String r1) {
            this.mid = r1;
        }

        public void setTitle(String r1) {
            this.title = r1;
        }
    }

    public interface AppForeground {
        public static final int APP_BACKGROUND = 0;
        public static final int APP_FOREGROUND = 1;
    }

    public static class FolderInfo {
        private String id;
        private boolean isSongFolder;
        private String mainTitle;
        private String picUrl;
        private String subTitle;
        private int type;

        public FolderInfo() {
        }

        public String getId() {
            return this.id;
        }

        public String getMainTitle() {
            return this.mainTitle;
        }

        public String getPicUrl() {
            return this.picUrl;
        }

        public String getSubTitle() {
            return this.subTitle;
        }

        public int getType() {
            return this.type;
        }

        public boolean isSongFolder() {
            return this.isSongFolder;
        }

        public void setId(String r1) {
            this.id = r1;
        }

        public void setMainTitle(String r1) {
            this.mainTitle = r1;
        }

        public void setPicUrl(String r1) {
            this.picUrl = r1;
        }

        public void setSongFolder(boolean r1) {
            this.isSongFolder = r1;
        }

        public void setSubTitle(String r1) {
            this.subTitle = r1;
        }

        public void setType(int r1) {
            this.type = r1;
        }
    }

    public static class FolderType {
        public static final int AI_FOLDER = 6;
        public static final int ALBUM_FOLDER_SONG_LIST = 106;
        public static final int DAY30_SONG_LIST = 108;
        public static final int LOCAL_SONG_LIST = 100;
        public static final int MYFAV_FOLDER_SONG_LIST = 201;
        public static final int MY_FAV_FOLDER = 5;
        public static final int MY_FOLDER = 1;
        public static final int MY_FOLDER_SONG_LIST = 101;
        public static final int PERSONAL_RADIO_FOLDER_SONG_LIST = 104;
        public static final int PLAYLIST_FOLDER_SONG_LIST = 105;
        public static final int RADIO = 4;
        public static final int RADIO_SONG_LIST = 107;
        public static final int RANK = 2;
        public static final int RANK_SONG_LIST = 102;
        public static final int RECENTPLAY_FOLDER_SONG_LIST = 202;
        public static final int RECOMMEND_FOLDER = 3;
        public static final int RECOMMEND_FOLDER_SONG_LIST = 103;
        public static final int ROOT = 0;

        public FolderType() {
        }
    }

    public interface LoginState {
        public static final int NOT_LOGIN = 0;
        public static final int STRONG_LOGIN = 2;
        public static final int WEAK_LOGIN = 1;
    }

    public static class MediaInfo implements Parcelable {
        public static final Parcelable.Creator<MediaInfo> CREATOR = null;
        private int audioFormat;
        private int channelConfig;
        private int sampleRateInHz;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public MediaInfo() {
        }

        public int getAudioFormat() {
            return this.audioFormat;
        }

        public int getChannelConfig() {
            return this.channelConfig;
        }

        public int getSampleRateInHz() {
            return this.sampleRateInHz;
        }

        public MediaInfo(Parcel r2) {
            this.sampleRateInHz = r2.readInt();
            this.channelConfig = r2.readInt();
            this.audioFormat = r2.readInt();
        }

        public void setAudioFormat(int r1) {
            this.audioFormat = r1;
        }

        public void setChannelConfig(int r1) {
            this.channelConfig = r1;
        }

        public void setSampleRateInHz(int r1) {
            this.sampleRateInHz = r1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeInt(this.sampleRateInHz);
            r1.writeInt(this.channelConfig);
            r1.writeInt(this.audioFormat);
        }
    }

    public static class NewMixSearchResult {
        private List<Album> albums;
        private List<FolderInfo> folders;
        private List<Song> songs;

        public NewMixSearchResult() {
        }

        public List<Album> getAlbums() {
            return this.albums;
        }

        public List<FolderInfo> getFolders() {
            return this.folders;
        }

        public List<Song> getSongs() {
            return this.songs;
        }

        public void setAlbums(List<Album> r1) {
            this.albums = r1;
        }

        public void setFolders(List<FolderInfo> r1) {
            this.folders = r1;
        }

        public void setSongs(List<Song> r1) {
            this.songs = r1;
        }
    }

    public interface PlayMode {
        public static final int PLAY_MODE_REPEAT_LIST = 0;
        public static final int PLAY_MODE_REPEAT_ONE = 1;
        public static final int PLAY_MODE_SHUFFLE = 2;
    }

    public interface SearchType {
        public static final int SEARCH_TYPE_ALBUM = 2;
        public static final int SEARCH_TYPE_FOLDER = 3;
        public static final int SEARCH_TYPE_LYRIC = 7;
        public static final int SEARCH_TYPE_MIX = 100;
        public static final int SEARCH_TYPE_MIX_NEW = 101;
        public static final int SEARCH_TYPE_MV = 4;
        public static final int SEARCH_TYPE_SIMILAR_SONG = 9;
        public static final int SEARCH_TYPE_SINGER = 1;
        public static final int SEARCH_TYPE_SONG = 0;
        public static final int SEARCH_TYPE_USER = 8;
    }

    public static class Singer {
        private long id;
        private String mid;
        private String title;

        public Singer() {
        }

        public long getId() {
            return this.id;
        }

        public String getMid() {
            return this.mid;
        }

        public String getTitle() {
            return this.title;
        }

        public void setId(long r1) {
            this.id = r1;
        }

        public void setMid(String r1) {
            this.mid = r1;
        }

        public void setTitle(String r1) {
            this.title = r1;
        }
    }

    public static class Song {
        private Album album;
        private long duration;
        private String genre;
        private boolean hasCopyRight;
        private String id;
        private boolean isAudition;
        private boolean isOrigin;
        private List<Integer> labelIdList;
        private String mid;
        private Singer singer;
        private String title;
        private int type;
        private boolean useTry;
        private int vipState;

        public Song() {
        }

        public Album getAlbum() {
            return this.album;
        }

        public long getDuration() {
            return this.duration;
        }

        public String getGenre() {
            return this.genre;
        }

        public String getId() {
            return this.id;
        }

        public List<Integer> getLabelIdList() {
            return this.labelIdList;
        }

        public String getMid() {
            return this.mid;
        }

        public Singer getSinger() {
            return this.singer;
        }

        public String getTitle() {
            return this.title;
        }

        public int getType() {
            return this.type;
        }

        public int getVipState() {
            return this.vipState;
        }

        public boolean hasCopyRight() {
            return this.hasCopyRight;
        }

        public boolean isAudition() {
            return this.isAudition;
        }

        public boolean isOrigin() {
            return this.isOrigin;
        }

        public boolean isUseTry() {
            return this.useTry;
        }

        public void setAlbum(Album r1) {
            this.album = r1;
        }

        public void setAudition(boolean r1) {
            this.isAudition = r1;
        }

        public void setDuration(long r1) {
            this.duration = r1;
        }

        public void setGenre(String r1) {
            this.genre = r1;
        }

        public void setHasCopyRight(boolean r1) {
            this.hasCopyRight = r1;
        }

        public void setId(String r1) {
            this.id = r1;
        }

        public void setLabelIdList(List<Integer> r1) {
            this.labelIdList = r1;
        }

        public void setMid(String r1) {
            this.mid = r1;
        }

        public void setOrigin(boolean r1) {
            this.isOrigin = r1;
        }

        public void setSinger(Singer r1) {
            this.singer = r1;
        }

        public void setTitle(String r1) {
            this.title = r1;
        }

        public void setType(int r1) {
            this.type = r1;
        }

        public void setUseTry(boolean r1) {
            this.useTry = r1;
        }

        public void setVipState(int r1) {
            this.vipState = r1;
        }
    }

    public interface VipState {
        public static final int NORMAL_SONG = 0;
        public static final int SVIP_SONG = 2;
        public static final int VIP_SONG = 1;
    }
}
