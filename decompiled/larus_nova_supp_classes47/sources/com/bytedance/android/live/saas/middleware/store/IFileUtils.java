package com.bytedance.android.live.saas.middleware.store;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H&J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H&J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H&J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H&J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0006H&J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0016H&J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H&J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u000bH&J\u0010\u0010 \u001a\u00020!2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H&J\u0010\u0010$\u001a\u00020!2\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010%\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010(\u001a\u00020\u0016H&J\b\u0010)\u001a\u00020\u0003H&J\u0012\u0010*\u001a\u0004\u0018\u00010\u00162\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010,\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0014\u0010-\u001a\u0004\u0018\u00010\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010/\u001a\u00020\u0016H&J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\u0016H&J\u0010\u00102\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u000bH&J\u0010\u00103\u001a\u0002042\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u00105\u001a\u0002062\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u00107\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u00108\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u00109\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010:\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010;\u001a\u00020\u0006H&J\b\u0010<\u001a\u00020\u0006H&J\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0003H&J\u0010\u0010@\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0003H&J\u0010\u0010A\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u0016H&J\u0010\u0010B\u001a\u00020\r2\u0006\u0010C\u001a\u00020\u0016H&J\u0010\u0010D\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010E\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u00032\u0006\u0010G\u001a\u00020\u0003H&J\u0018\u0010H\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u0016H&J \u0010I\u001a\u00020\u00062\u0006\u0010J\u001a\u0002062\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010K\u001a\u00020\u0003H&J\u0018\u0010L\u001a\u00020\r2\u0006\u0010M\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u0003H&J\u0010\u0010O\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010P\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020\u0003H&¨\u0006R"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/store/IFileUtils;", "", "appendFileSeparateForPath", "", "path", "checkFileExists", "", "checkTypeExternalDirIsExist", "type", "checkTypeInternalDirIsExist", "applicationContext", "Landroid/content/Context;", "clearDir", "", "dir", "reserves", "", "copyFile", "sourcePath", "desDir", "destName", "createFile", "Ljava/io/File;", "isFile", "ensureDirExists", "fileChannelCopy", "srcFilePath", "destFilePath", "getByteArray", "", "getCacheDirPath", "context", "getCacheSize", "", "getConfiJsonFilePath", "filePath", "getDirSize", "getEditExternalTypeDir", "getEidtAbsoluteExternalDir", "dirName", "getExternalAppDir", "getExternalAppPath", "getExternalCacheDir", "getExternalCachePath", "getExternalCacheTypeDir", "getExternalFilesDir", "getExternalModelDir", "getExternalPictureDir", "getFileSize", "file", "getFilesDir", "getImageType", "Lcom/bytedance/common/utility/io/FileUtils$ImageType;", "getInputStream", "Ljava/io/InputStream;", "getInternalAppDir", "getInternalAppDirWithType", "getInternalDataDir", "getOutDataDir", "isSdcardAvailable", "isSdcardWritable", "parseJsonFile", "Lorg/json/JSONObject;", "jsonFilePath", "readConfigJsonFile", "readStringFromFile", "removeDir", "fileOrDirectory", "removeFile", "renameFile", "oldPath", "newPath", "saveImageToGallery", "saveInputStream", "input", "name", "unZipFolder", "zipFilePath", "outPath", "updateMediaStore", "writeString2File", "content", "middleware_release"}, k = 1, mv = {1, 4, 3})
public interface IFileUtils {
    String appendFileSeparateForPath(String r1);

    boolean checkFileExists(String r1);

    boolean checkTypeExternalDirIsExist(String r1);

    boolean checkTypeInternalDirIsExist(String r1, Context r2);

    void clearDir(String r1) throws Exception;

    void clearDir(String r1, Set<String> r2) throws Exception;

    boolean copyFile(String r1, String r2, String r3);

    File createFile(String r1, boolean r2);

    boolean ensureDirExists(File r1);

    boolean fileChannelCopy(String r1, String r2);

    byte[] getByteArray(String r1);

    String getCacheDirPath(Context r1) throws NullPointerException;

    long getCacheSize(Context r1);

    String getConfiJsonFilePath(String r1);

    long getDirSize(String r1);

    File getEditExternalTypeDir(String r1, Context r2);

    String getEidtAbsoluteExternalDir(String r1, Context r2);

    File getExternalAppDir();

    String getExternalAppPath();

    File getExternalCacheDir(Context r1);

    String getExternalCachePath(Context r1);

    File getExternalCacheTypeDir(String r1, Context r2);

    File getExternalFilesDir(Context r1);

    File getExternalModelDir(Context r1);

    File getExternalPictureDir();

    long getFileSize(File r1);

    File getFilesDir(Context r1);

    com.bytedance.common.utility.io.FileUtils.ImageType getImageType(String r1);

    InputStream getInputStream(String r1);

    File getInternalAppDir(Context r1);

    File getInternalAppDirWithType(String r1, Context r2);

    File getInternalDataDir(Context r1);

    File getOutDataDir(Context r1);

    boolean isSdcardAvailable();

    boolean isSdcardWritable();

    JSONObject parseJsonFile(String r1);

    String readConfigJsonFile(String r1);

    String readStringFromFile(File r1);

    void removeDir(File r1);

    boolean removeFile(String r1);

    boolean renameFile(String r1, String r2);

    void saveImageToGallery(Context r1, File r2);

    boolean saveInputStream(InputStream r1, String r2, String r3);

    void unZipFolder(String r1, String r2) throws IOException;

    void updateMediaStore(String r1);

    boolean writeString2File(String r1, String r2);
}
