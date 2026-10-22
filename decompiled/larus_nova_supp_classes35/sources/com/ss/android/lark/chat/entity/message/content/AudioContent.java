package com.ss.android.lark.chat.entity.message.content;

import android.content.Context;
import com.alibaba.fastjson.annotation.JSONType;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.core.ChameleonWebViewClient;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0003KLMB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010G\u001a\u00020\u0011J\u000e\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00020JR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\tR\u001c\u0010-\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\tR\u001a\u00100\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0013\"\u0004\b2\u0010\u0015R\u000e\u00103\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001e\"\u0004\bA\u0010 R\u001a\u0010B\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001e\"\u0004\bC\u0010 R\u001a\u0010D\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\r\"\u0004\bF\u0010\u000f¨\u0006N"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/AudioContent;", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "<init>", "()V", "key", BuildConfig.FLAVOR, "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "size", BuildConfig.FLAVOR, "getSize", "()J", "setSize", "(J)V", "duration", BuildConfig.FLAVOR, "getDuration", "()I", "setDuration", "(I)V", "localFilePath", "getLocalFilePath", "setLocalFilePath", "progress", "getProgress", "setProgress", "isNeedHideText", BuildConfig.FLAVOR, "()Z", "setNeedHideText", "(Z)V", "recognizedText", "getRecognizedText", "setRecognizedText", "recognizedRichText", "Lcom/ss/android/lark/widget/richtext/RichText;", "getRecognizedRichText", "()Lcom/ss/android/lark/widget/richtext/RichText;", "setRecognizedRichText", "(Lcom/ss/android/lark/widget/richtext/RichText;)V", "uploadId", "getUploadId", "setUploadId", "audioToken", "getAudioToken", "setAudioToken", "sequenceId", "getSequenceId", "setSequenceId", "localSequenceId", "fileState", "Lcom/ss/android/lark/chat/entity/message/content/AudioContent$IAudioState;", "getFileState", "()Lcom/ss/android/lark/chat/entity/message/content/AudioContent$IAudioState;", "setFileState", "(Lcom/ss/android/lark/chat/entity/message/content/AudioContent$IAudioState;)V", "audioWaveBytes", BuildConfig.FLAVOR, "getAudioWaveBytes", "()[B", "setAudioWaveBytes", "([B)V", "isRecognizeFinished", "setRecognizeFinished", "isAudioWithText", "setAudioWithText", "audio2TextStartTime", "getAudio2TextStartTime", "setAudio2TextStartTime", "getLocalSequenceId", "formatDuration", "context", "Landroid/content/Context;", "IAudioState", "AudioState", "ErrorAudioState", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JSONType(typeName = "AudioContent")
public final class AudioContent extends Content {
    private long audio2TextStartTime;
    private String audioToken;
    private byte[] audioWaveBytes;
    private int duration;
    private a fileState;
    private boolean isAudioWithText;
    private boolean isNeedHideText;
    private boolean isRecognizeFinished;
    private String key;
    private String localFilePath;
    private int localSequenceId;
    private int progress;
    private RichText recognizedRichText;
    private String recognizedText;
    private int sequenceId;
    private long size;
    private String uploadId;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/AudioContent$AudioState;", "Lcom/ss/android/lark/chat/entity/message/content/AudioContent$IAudioState;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DOWNLOAD", "DOWNLOADING", "UPLOADING", "DONE", "RECORDING", "DONE_OPEN", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AudioState extends Enum<AudioState> implements a {
        public static final AudioState DONE = null;
        public static final AudioState DONE_OPEN = null;
        public static final AudioState DOWNLOAD = null;
        public static final AudioState DOWNLOADING = null;
        public static final AudioState RECORDING = null;
        public static final AudioState UPLOADING = null;
        public static final /* synthetic */ AudioState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<AudioState> getEntries() {
            return b;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AudioContent.a
        public ErrorResult getErrorResult() {
            return null;
        }

        static {
            AudioState r0 = new AudioState("DOWNLOAD", 0, "下载文件");
            DOWNLOAD = r0;
            AudioState r1 = new AudioState("DOWNLOADING", 1, "下载中");
            DOWNLOADING = r1;
            AudioState r2 = new AudioState("UPLOADING", 2, "传输中");
            UPLOADING = r2;
            AudioState r4 = new AudioState("DONE", 3, "打开文件");
            DONE = r4;
            AudioState r6 = new AudioState("RECORDING", 4, "录制中");
            RECORDING = r6;
            AudioState r8 = new AudioState("DONE_OPEN", 5, "下载并打开");
            DONE_OPEN = r8;
            AudioState[] r10 = {r0, r1, r2, r4, r6, r8};
            a = r10;
            b = EnumEntriesKt.enumEntries(r10);
        }

        public static AudioState[] values() {
            return (AudioState[]) a.clone();
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AudioContent.a
        public String getValue() {
            return this.value;
        }

        public static AudioState valueOf(String r1) {
            return (AudioState) r27.a.a(AudioState.class, r1);
        }

        public AudioState(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public interface a {
        ErrorResult getErrorResult();

        String getValue();
    }

    public final int getLocalSequenceId() {
        int r0 = this.localSequenceId + 1;
        this.localSequenceId = r0;
        return r0;
    }

    public AudioContent() {
        this.key = BuildConfig.FLAVOR;
        this.isNeedHideText = true;
        this.recognizedText = BuildConfig.FLAVOR;
        this.fileState = AudioState.DOWNLOAD;
        this.isRecognizeFinished = true;
    }

    public final long getAudio2TextStartTime() {
        return this.audio2TextStartTime;
    }

    public final String getAudioToken() {
        return this.audioToken;
    }

    public final byte[] getAudioWaveBytes() {
        return this.audioWaveBytes;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final a getFileState() {
        return this.fileState;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getLocalFilePath() {
        return this.localFilePath;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final RichText getRecognizedRichText() {
        return this.recognizedRichText;
    }

    public final String getRecognizedText() {
        return this.recognizedText;
    }

    public final int getSequenceId() {
        return this.sequenceId;
    }

    public final long getSize() {
        return this.size;
    }

    public final String getUploadId() {
        return this.uploadId;
    }

    public final boolean isAudioWithText() {
        return this.isAudioWithText;
    }

    public final boolean isNeedHideText() {
        return this.isNeedHideText;
    }

    public final boolean isRecognizeFinished() {
        return this.isRecognizeFinished;
    }

    public final String formatDuration(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        int r0 = this.duration + ChameleonWebViewClient.DEFAULT_SAFE_TIME;
        this.duration = r0;
        int r1 = r0 / 1000;
        this.duration = r1;
        long r2 = r1 / 60;
        long r3 = r1 % 60;
        if (r2 == 0) goto L6;
        String r4 = BuildConfig.FLAVOR + r2 + UIUtils.getString(r10, 2131891951);
        StringBuilder r5 = new StringBuilder();
        r5.append(r4);
        StringCompanionObject r6 = StringCompanionObject.INSTANCE;
        r5.append(String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(r3)}, 1)));
        r5.append(UIUtils.getString(r10, 2131892167));
        return r5.toString();
    L6:
        return BuildConfig.FLAVOR + r3 + UIUtils.getString(r10, 2131892167);
    }

    public final void setAudio2TextStartTime(long r1) {
        this.audio2TextStartTime = r1;
    }

    public final void setAudioToken(String r1) {
        this.audioToken = r1;
    }

    public final void setAudioWaveBytes(byte[] r1) {
        this.audioWaveBytes = r1;
    }

    public final void setAudioWithText(boolean r1) {
        this.isAudioWithText = r1;
    }

    public final void setDuration(int r1) {
        this.duration = r1;
    }

    public final void setFileState(a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.fileState = r2;
    }

    public final void setKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.key = r2;
    }

    public final void setLocalFilePath(String r1) {
        this.localFilePath = r1;
    }

    public final void setNeedHideText(boolean r1) {
        this.isNeedHideText = r1;
    }

    public final void setProgress(int r1) {
        this.progress = r1;
    }

    public final void setRecognizeFinished(boolean r1) {
        this.isRecognizeFinished = r1;
    }

    public final void setRecognizedRichText(RichText r1) {
        this.recognizedRichText = r1;
    }

    public final void setRecognizedText(String r1) {
        this.recognizedText = r1;
    }

    public final void setSequenceId(int r1) {
        this.sequenceId = r1;
    }

    public final void setSize(long r1) {
        this.size = r1;
    }

    public final void setUploadId(String r1) {
        this.uploadId = r1;
    }
}
