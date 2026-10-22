package com.ss.android.lark.filedetail.impl.open;

import com.ss.android.lark.chat.entity.favorite.FavoriteMessageInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class OpenFileInfo implements Serializable {
    public String authFileKey;
    public boolean forwardAsFile;
    public boolean isFromFolderManage;
    public String mChatId;
    public FavoriteMessageInfo mFavoriteMessage;
    public FileContent mFileContent;
    public boolean mIsCrossWithKA;
    public boolean mIsSecret;
    public int mJumpPosition;
    public long mMenuFlag;
    public Message mMessage;
    public String mMessageId;
    public boolean mShowDownload;
    public boolean mShowForward;
    public boolean mShowOpenWith3rdPartyApp;
    public String mSourceId;
    public Message.SourceType mSourceType;
    public String msgLinkToken;
    public String originMergeForwardId;
    public String previewId;
    public String threadId;

    public OpenFileInfo() {
        this.mSourceId = BuildConfig.FLAVOR;
        this.mJumpPosition = -1;
    }
}
