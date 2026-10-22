package com.tencent.qqmusic.third.api.contract;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface Methods {
    void addLocalPathToFavourite(List<String> r1, IQQMusicApiCallback r2);

    void addToFavourite(List<String> r1, IQQMusicApiCallback r2);

    long getCurrTime();

    Data.Song getCurrentSong();

    int getCurrentSongIndexInList();

    String getFavouriteFolderId();

    void getFolderList(String r1, int r2, int r3, IQQMusicApiCallback r4);

    int getLoginState();

    void getLyric(long r1, IQQMusicApiCallback r3);

    void getLyricIncludeEndTime(String r1, IQQMusicApiCallback r2);

    void getLyricWithId(String r1, IQQMusicApiCallback r2);

    void getPlayList(int r1, IQQMusicApiCallback r2);

    int getPlayMode();

    int getPlaybackState();

    void getSongList(String r1, int r2, int r3, IQQMusicApiCallback r4);

    long getTotalTime();

    void getUserFolderList(String r1, String r2, String r3, int r4, int r5, IQQMusicApiCallback r6);

    void getUserSongList(String r1, String r2, String r3, int r4, int r5, IQQMusicApiCallback r6);

    void hi();

    void isFavouriteLocalPath(List<String> r1, IQQMusicApiCallback r2);

    void isFavouriteMid(List<String> r1, List<String> r2, List<String> r3, IQQMusicApiCallback r4);

    boolean isNewUser();

    int isQQMusicForeground();

    void openQQMusic();

    int pauseMusic();

    void playFolderType(String r1, int r2, int r3, IQQMusicApiCallback r4);

    void playFromChorus(boolean r1);

    int playMusic();

    void playSongId(List<String> r1, IQQMusicApiCallback r2);

    void playSongIdAtIndex(List<String> r1, int r2, IQQMusicApiCallback r3);

    void playSongLocalPath(List<String> r1, IQQMusicApiCallback r2);

    void playSongMid(List<String> r1, IQQMusicApiCallback r2);

    void playSongMidAtIndex(List<String> r1, int r2, IQQMusicApiCallback r3);

    void registerEventListener(List<String> r1, IQQMusicApiEventListener r2);

    void removeFromFavourite(List<String> r1, IQQMusicApiCallback r2);

    void removeLocalPathFromFavourite(List<String> r1, IQQMusicApiCallback r2);

    void requestAuth(String r1, IQQMusicApiCallback r2);

    int resumeMusic();

    void search(String r1, int r2, boolean r3, IQQMusicApiCallback r4);

    long seek(long r1);

    int seekBack(long r1);

    int seekForward(long r1);

    void setPlayMode(int r1);

    int setPlayModeWithRet(int r1);

    int skipToNext();

    int skipToPrevious();

    void startPcmMode(IQQMusicApiCallback r1);

    int stopMusic();

    void stopPcmMode();

    void unregisterEventListener(List<String> r1, IQQMusicApiEventListener r2);

    void voicePlay(String r1, List<String> r2, IQQMusicApiCallback r3);

    void voiceShortcut(String r1, IQQMusicApiCallback r2);
}
