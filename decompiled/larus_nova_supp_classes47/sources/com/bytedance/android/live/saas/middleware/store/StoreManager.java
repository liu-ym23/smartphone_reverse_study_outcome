package com.bytedance.android.live.saas.middleware.store;

import android.content.Context;
import java.io.File;
import java.io.InputStream;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0096\u0001J\u001f\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0096\u0001J!\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0017H\u0096\u0001J\u0019\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\fH\u0096\u0001J\u0011\u0010!\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0011\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010%\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010&\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0019\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\t\u0010)\u001a\u00020\u0017H\u0096\u0001J\t\u0010*\u001a\u00020\u0004H\u0096\u0001J\u0013\u0010+\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0011\u0010,\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0019\u0010-\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0015\u0010.\u001a\u0004\u0018\u00010\u00172\b\u0010 \u001a\u0004\u0018\u00010\fH\u0096\u0001J\u0011\u0010/\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\t\u00100\u001a\u00020\u0017H\u0096\u0001J\u0011\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\u0017H\u0096\u0001J\u0011\u00103\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\fH\u0096\u0001J\u0011\u00104\u001a\u0002052\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u0011\u00106\u001a\u0002072\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u0011\u00108\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0019\u00109\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0011\u0010:\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0011\u0010;\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\t\u0010<\u001a\u00020\u0007H\u0096\u0001J\t\u0010=\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010A\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010B\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0017H\u0096\u0001J\u0011\u0010C\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020\u0017H\u0096\u0001J\u0011\u0010E\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010I\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\f2\u0006\u00102\u001a\u00020\u0017H\u0096\u0001J!\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u0002072\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010M\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010P\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010Q\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u0004H\u0096\u0001¨\u0006S"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/store/StoreManager;", "Lcom/bytedance/android/live/saas/middleware/store/IFileUtils;", "()V", "appendFileSeparateForPath", "", "path", "checkFileExists", "", "checkTypeExternalDirIsExist", "type", "checkTypeInternalDirIsExist", "applicationContext", "Landroid/content/Context;", "clearDir", "", "dir", "reserves", "", "copyFile", "sourcePath", "desDir", "destName", "createFile", "Ljava/io/File;", "isFile", "ensureDirExists", "fileChannelCopy", "srcFilePath", "destFilePath", "getByteArray", "", "getCacheDirPath", "context", "getCacheSize", "", "getConfiJsonFilePath", "filePath", "getDirSize", "getEditExternalTypeDir", "getEidtAbsoluteExternalDir", "dirName", "getExternalAppDir", "getExternalAppPath", "getExternalCacheDir", "getExternalCachePath", "getExternalCacheTypeDir", "getExternalFilesDir", "getExternalModelDir", "getExternalPictureDir", "getFileSize", "file", "getFilesDir", "getImageType", "Lcom/bytedance/common/utility/io/FileUtils$ImageType;", "getInputStream", "Ljava/io/InputStream;", "getInternalAppDir", "getInternalAppDirWithType", "getInternalDataDir", "getOutDataDir", "isSdcardAvailable", "isSdcardWritable", "parseJsonFile", "Lorg/json/JSONObject;", "jsonFilePath", "readConfigJsonFile", "readStringFromFile", "removeDir", "fileOrDirectory", "removeFile", "renameFile", "oldPath", "newPath", "saveImageToGallery", "saveInputStream", "input", "name", "unZipFolder", "zipFilePath", "outPath", "updateMediaStore", "writeString2File", "content", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class StoreManager implements IFileUtils {
    public static final StoreManager INSTANCE = null;
    private final /* synthetic */ FileUtils $$delegate_0;

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String appendFileSeparateForPath(String r2) {
        Intrinsics.checkNotNullParameter(r2, "path");
        return this.$$delegate_0.appendFileSeparateForPath(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean checkFileExists(String r2) {
        Intrinsics.checkNotNullParameter(r2, "path");
        return this.$$delegate_0.checkFileExists(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean checkTypeExternalDirIsExist(String r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return this.$$delegate_0.checkTypeExternalDirIsExist(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean checkTypeInternalDirIsExist(String r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "applicationContext");
        return this.$$delegate_0.checkTypeInternalDirIsExist(r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void clearDir(String r2) {
        Intrinsics.checkNotNullParameter(r2, "dir");
        this.$$delegate_0.clearDir(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void clearDir(String r2, Set<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "dir");
        Intrinsics.checkNotNullParameter(r3, "reserves");
        this.$$delegate_0.clearDir(r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean copyFile(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "sourcePath");
        Intrinsics.checkNotNullParameter(r3, "desDir");
        Intrinsics.checkNotNullParameter(r4, "destName");
        return this.$$delegate_0.copyFile(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File createFile(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "path");
        return this.$$delegate_0.createFile(r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean ensureDirExists(File r2) {
        Intrinsics.checkNotNullParameter(r2, "dir");
        return this.$$delegate_0.ensureDirExists(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean fileChannelCopy(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "srcFilePath");
        Intrinsics.checkNotNullParameter(r3, "destFilePath");
        return this.$$delegate_0.fileChannelCopy(r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public byte[] getByteArray(String r2) {
        Intrinsics.checkNotNullParameter(r2, "path");
        return this.$$delegate_0.getByteArray(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String getCacheDirPath(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return this.$$delegate_0.getCacheDirPath(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public long getCacheSize(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "applicationContext");
        return this.$$delegate_0.getCacheSize(r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String getConfiJsonFilePath(String r2) {
        Intrinsics.checkNotNullParameter(r2, "filePath");
        return this.$$delegate_0.getConfiJsonFilePath(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public long getDirSize(String r3) {
        Intrinsics.checkNotNullParameter(r3, "path");
        return this.$$delegate_0.getDirSize(r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getEditExternalTypeDir(String r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "applicationContext");
        return this.$$delegate_0.getEditExternalTypeDir(r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String getEidtAbsoluteExternalDir(String r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dirName");
        Intrinsics.checkNotNullParameter(r3, "applicationContext");
        return this.$$delegate_0.getEidtAbsoluteExternalDir(r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalAppDir() {
        return this.$$delegate_0.getExternalAppDir();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String getExternalAppPath() {
        return this.$$delegate_0.getExternalAppPath();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalCacheDir(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "applicationContext");
        return this.$$delegate_0.getExternalCacheDir(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String getExternalCachePath(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "applicationContext");
        return this.$$delegate_0.getExternalCachePath(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalCacheTypeDir(String r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "applicationContext");
        return this.$$delegate_0.getExternalCacheTypeDir(r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalFilesDir(Context r2) {
        return this.$$delegate_0.getExternalFilesDir(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalModelDir(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "applicationContext");
        return this.$$delegate_0.getExternalModelDir(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalPictureDir() {
        return this.$$delegate_0.getExternalPictureDir();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public long getFileSize(File r3) {
        Intrinsics.checkNotNullParameter(r3, "file");
        return this.$$delegate_0.getFileSize(r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getFilesDir(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return this.$$delegate_0.getFilesDir(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public com.bytedance.common.utility.io.FileUtils.ImageType getImageType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "path");
        return this.$$delegate_0.getImageType(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public InputStream getInputStream(String r2) {
        Intrinsics.checkNotNullParameter(r2, "path");
        return this.$$delegate_0.getInputStream(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getInternalAppDir(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "applicationContext");
        return this.$$delegate_0.getInternalAppDir(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getInternalAppDirWithType(String r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "applicationContext");
        return this.$$delegate_0.getInternalAppDirWithType(r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getInternalDataDir(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "applicationContext");
        return this.$$delegate_0.getInternalDataDir(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getOutDataDir(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "applicationContext");
        return this.$$delegate_0.getOutDataDir(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean isSdcardAvailable() {
        return this.$$delegate_0.isSdcardAvailable();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean isSdcardWritable() {
        return this.$$delegate_0.isSdcardWritable();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public JSONObject parseJsonFile(String r2) {
        Intrinsics.checkNotNullParameter(r2, "jsonFilePath");
        return this.$$delegate_0.parseJsonFile(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String readConfigJsonFile(String r2) {
        Intrinsics.checkNotNullParameter(r2, "jsonFilePath");
        return this.$$delegate_0.readConfigJsonFile(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String readStringFromFile(File r2) {
        Intrinsics.checkNotNullParameter(r2, "file");
        return this.$$delegate_0.readStringFromFile(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void removeDir(File r2) {
        Intrinsics.checkNotNullParameter(r2, "fileOrDirectory");
        this.$$delegate_0.removeDir(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean removeFile(String r2) {
        Intrinsics.checkNotNullParameter(r2, "path");
        return this.$$delegate_0.removeFile(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean renameFile(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "oldPath");
        Intrinsics.checkNotNullParameter(r3, "newPath");
        return this.$$delegate_0.renameFile(r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void saveImageToGallery(Context r2, File r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "file");
        this.$$delegate_0.saveImageToGallery(r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean saveInputStream(InputStream r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "input");
        Intrinsics.checkNotNullParameter(r3, "dir");
        Intrinsics.checkNotNullParameter(r4, "name");
        return this.$$delegate_0.saveInputStream(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void unZipFolder(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "zipFilePath");
        Intrinsics.checkNotNullParameter(r3, "outPath");
        this.$$delegate_0.unZipFolder(r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void updateMediaStore(String r2) {
        Intrinsics.checkNotNullParameter(r2, "path");
        this.$$delegate_0.updateMediaStore(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean writeString2File(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r3, "content");
        return this.$$delegate_0.writeString2File(r2, r3);
    }

    static {
        INSTANCE = new StoreManager();
    }

    private StoreManager() {
        this.$$delegate_0 = new FileUtils();
    }
}
