package androidx.exifinterface.media;

import ai.j0;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.motion.widget.a;
import androidx.core.view.InputDeviceCompat;
import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes.dex */
public class ExifInterface {
    public static final short ALTITUDE_ABOVE_SEA_LEVEL = 0;
    public static final short ALTITUDE_BELOW_SEA_LEVEL = 1;
    static final Charset ASCII = null;
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_1 = null;
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2 = null;
    public static final int[] BITS_PER_SAMPLE_RGB = null;
    static final short BYTE_ALIGN_II = 18761;
    static final short BYTE_ALIGN_MM = 19789;
    public static final int COLOR_SPACE_S_RGB = 1;
    public static final int COLOR_SPACE_UNCALIBRATED = 65535;
    public static final short CONTRAST_HARD = 2;
    public static final short CONTRAST_NORMAL = 0;
    public static final short CONTRAST_SOFT = 1;
    public static final int DATA_DEFLATE_ZIP = 8;
    public static final int DATA_HUFFMAN_COMPRESSED = 2;
    public static final int DATA_JPEG = 6;
    public static final int DATA_JPEG_COMPRESSED = 7;
    public static final int DATA_LOSSY_JPEG = 34892;
    public static final int DATA_PACK_BITS_COMPRESSED = 32773;
    public static final int DATA_UNCOMPRESSED = 1;
    private static final boolean DEBUG = false;
    static final byte[] EXIF_ASCII_PREFIX = null;
    private static final ExifTag[] EXIF_POINTER_TAGS = null;
    static final ExifTag[][] EXIF_TAGS = null;
    public static final short EXPOSURE_MODE_AUTO = 0;
    public static final short EXPOSURE_MODE_AUTO_BRACKET = 2;
    public static final short EXPOSURE_MODE_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_ACTION = 6;
    public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = 3;
    public static final short EXPOSURE_PROGRAM_CREATIVE = 5;
    public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = 8;
    public static final short EXPOSURE_PROGRAM_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_NORMAL = 2;
    public static final short EXPOSURE_PROGRAM_NOT_DEFINED = 0;
    public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = 7;
    public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = 4;
    public static final short FILE_SOURCE_DSC = 3;
    public static final short FILE_SOURCE_OTHER = 0;
    public static final short FILE_SOURCE_REFLEX_SCANNER = 2;
    public static final short FILE_SOURCE_TRANSPARENT_SCANNER = 1;
    public static final short FLAG_FLASH_FIRED = 1;
    public static final short FLAG_FLASH_MODE_AUTO = 24;
    public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = 8;
    public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = 16;
    public static final short FLAG_FLASH_NO_FLASH_FUNCTION = 32;
    public static final short FLAG_FLASH_RED_EYE_SUPPORTED = 64;
    public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = 6;
    public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = 4;
    private static final List<Integer> FLIPPED_ROTATION_ORDER = null;
    public static final short FORMAT_CHUNKY = 1;
    public static final short FORMAT_PLANAR = 2;
    public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = 4;
    public static final short GAIN_CONTROL_HIGH_GAIN_UP = 2;
    public static final short GAIN_CONTROL_LOW_GAIN_DOWN = 3;
    public static final short GAIN_CONTROL_LOW_GAIN_UP = 1;
    public static final short GAIN_CONTROL_NONE = 0;
    public static final String GPS_DIRECTION_MAGNETIC = "M";
    public static final String GPS_DIRECTION_TRUE = "T";
    public static final String GPS_DISTANCE_KILOMETERS = "K";
    public static final String GPS_DISTANCE_MILES = "M";
    public static final String GPS_DISTANCE_NAUTICAL_MILES = "N";
    public static final String GPS_MEASUREMENT_2D = "2";
    public static final String GPS_MEASUREMENT_3D = "3";
    public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = 1;
    public static final String GPS_MEASUREMENT_INTERRUPTED = "V";
    public static final String GPS_MEASUREMENT_IN_PROGRESS = "A";
    public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = 0;
    public static final String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
    public static final String GPS_SPEED_KNOTS = "N";
    public static final String GPS_SPEED_MILES_PER_HOUR = "M";
    static final byte[] IDENTIFIER_EXIF_APP1 = null;
    private static final ExifTag[] IFD_EXIF_TAGS = null;
    private static final int IFD_FORMAT_BYTE = 1;
    static final int[] IFD_FORMAT_BYTES_PER_FORMAT = null;
    private static final int IFD_FORMAT_DOUBLE = 12;
    private static final int IFD_FORMAT_IFD = 13;
    static final String[] IFD_FORMAT_NAMES = null;
    private static final int IFD_FORMAT_SBYTE = 6;
    private static final int IFD_FORMAT_SINGLE = 11;
    private static final int IFD_FORMAT_SLONG = 9;
    private static final int IFD_FORMAT_SRATIONAL = 10;
    private static final int IFD_FORMAT_SSHORT = 8;
    private static final int IFD_FORMAT_STRING = 2;
    private static final int IFD_FORMAT_ULONG = 4;
    private static final int IFD_FORMAT_UNDEFINED = 7;
    private static final int IFD_FORMAT_URATIONAL = 5;
    private static final int IFD_FORMAT_USHORT = 3;
    private static final ExifTag[] IFD_GPS_TAGS = null;
    private static final ExifTag[] IFD_INTEROPERABILITY_TAGS = null;
    private static final int IFD_OFFSET = 8;
    private static final ExifTag[] IFD_THUMBNAIL_TAGS = null;
    private static final ExifTag[] IFD_TIFF_TAGS = null;
    private static final int IFD_TYPE_EXIF = 1;
    private static final int IFD_TYPE_GPS = 2;
    private static final int IFD_TYPE_INTEROPERABILITY = 3;
    private static final int IFD_TYPE_ORF_CAMERA_SETTINGS = 7;
    private static final int IFD_TYPE_ORF_IMAGE_PROCESSING = 8;
    private static final int IFD_TYPE_ORF_MAKER_NOTE = 6;
    private static final int IFD_TYPE_PEF = 9;
    static final int IFD_TYPE_PREVIEW = 5;
    static final int IFD_TYPE_PRIMARY = 0;
    static final int IFD_TYPE_THUMBNAIL = 4;
    private static final int IMAGE_TYPE_ARW = 1;
    private static final int IMAGE_TYPE_CR2 = 2;
    private static final int IMAGE_TYPE_DNG = 3;
    private static final int IMAGE_TYPE_JPEG = 4;
    private static final int IMAGE_TYPE_NEF = 5;
    private static final int IMAGE_TYPE_NRW = 6;
    private static final int IMAGE_TYPE_ORF = 7;
    private static final int IMAGE_TYPE_PEF = 8;
    private static final int IMAGE_TYPE_RAF = 9;
    private static final int IMAGE_TYPE_RW2 = 10;
    private static final int IMAGE_TYPE_SRW = 11;
    private static final int IMAGE_TYPE_UNKNOWN = 0;
    private static final ExifTag JPEG_INTERCHANGE_FORMAT_LENGTH_TAG = null;
    private static final ExifTag JPEG_INTERCHANGE_FORMAT_TAG = null;
    static final byte[] JPEG_SIGNATURE = null;
    public static final String LATITUDE_NORTH = "N";
    public static final String LATITUDE_SOUTH = "S";
    public static final short LIGHT_SOURCE_CLOUDY_WEATHER = 10;
    public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = 14;
    public static final short LIGHT_SOURCE_D50 = 23;
    public static final short LIGHT_SOURCE_D55 = 20;
    public static final short LIGHT_SOURCE_D65 = 21;
    public static final short LIGHT_SOURCE_D75 = 22;
    public static final short LIGHT_SOURCE_DAYLIGHT = 1;
    public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = 12;
    public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = 13;
    public static final short LIGHT_SOURCE_FINE_WEATHER = 9;
    public static final short LIGHT_SOURCE_FLASH = 4;
    public static final short LIGHT_SOURCE_FLUORESCENT = 2;
    public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = 24;
    public static final short LIGHT_SOURCE_OTHER = 255;
    public static final short LIGHT_SOURCE_SHADE = 11;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = 17;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = 18;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = 19;
    public static final short LIGHT_SOURCE_TUNGSTEN = 3;
    public static final short LIGHT_SOURCE_UNKNOWN = 0;
    public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = 16;
    public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = 15;
    public static final String LONGITUDE_EAST = "E";
    public static final String LONGITUDE_WEST = "W";
    static final byte MARKER = -1;
    static final byte MARKER_APP1 = -31;
    private static final byte MARKER_COM = -2;
    static final byte MARKER_EOI = -39;
    private static final byte MARKER_SOF0 = -64;
    private static final byte MARKER_SOF1 = -63;
    private static final byte MARKER_SOF10 = -54;
    private static final byte MARKER_SOF11 = -53;
    private static final byte MARKER_SOF13 = -51;
    private static final byte MARKER_SOF14 = -50;
    private static final byte MARKER_SOF15 = -49;
    private static final byte MARKER_SOF2 = -62;
    private static final byte MARKER_SOF3 = -61;
    private static final byte MARKER_SOF5 = -59;
    private static final byte MARKER_SOF6 = -58;
    private static final byte MARKER_SOF7 = -57;
    private static final byte MARKER_SOF9 = -55;
    private static final byte MARKER_SOI = -40;
    private static final byte MARKER_SOS = -38;
    private static final int MAX_THUMBNAIL_SIZE = 512;
    public static final short METERING_MODE_AVERAGE = 1;
    public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = 2;
    public static final short METERING_MODE_MULTI_SPOT = 4;
    public static final short METERING_MODE_OTHER = 255;
    public static final short METERING_MODE_PARTIAL = 6;
    public static final short METERING_MODE_PATTERN = 5;
    public static final short METERING_MODE_SPOT = 3;
    public static final short METERING_MODE_UNKNOWN = 0;
    private static final ExifTag[] ORF_CAMERA_SETTINGS_TAGS = null;
    private static final ExifTag[] ORF_IMAGE_PROCESSING_TAGS = null;
    private static final byte[] ORF_MAKER_NOTE_HEADER_1 = null;
    private static final int ORF_MAKER_NOTE_HEADER_1_SIZE = 8;
    private static final byte[] ORF_MAKER_NOTE_HEADER_2 = null;
    private static final int ORF_MAKER_NOTE_HEADER_2_SIZE = 12;
    private static final ExifTag[] ORF_MAKER_NOTE_TAGS = null;
    private static final short ORF_SIGNATURE_1 = 20306;
    private static final short ORF_SIGNATURE_2 = 21330;
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
    private static final int PEF_MAKER_NOTE_SKIP_SIZE = 6;
    private static final String PEF_SIGNATURE = "PENTAX";
    private static final ExifTag[] PEF_TAGS = null;
    public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
    public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
    public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
    private static final int RAF_INFO_SIZE = 160;
    private static final int RAF_JPEG_LENGTH_VALUE_SIZE = 4;
    private static final int RAF_OFFSET_TO_JPEG_IMAGE_OFFSET = 84;
    private static final String RAF_SIGNATURE = "FUJIFILMCCD-RAW";
    public static final int REDUCED_RESOLUTION_IMAGE = 1;
    public static final short RENDERED_PROCESS_CUSTOM = 1;
    public static final short RENDERED_PROCESS_NORMAL = 0;
    public static final short RESOLUTION_UNIT_CENTIMETERS = 3;
    public static final short RESOLUTION_UNIT_INCHES = 2;
    private static final List<Integer> ROTATION_ORDER = null;
    private static final short RW2_SIGNATURE = 85;
    public static final short SATURATION_HIGH = 0;
    public static final short SATURATION_LOW = 0;
    public static final short SATURATION_NORMAL = 0;
    public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = 1;
    public static final short SCENE_CAPTURE_TYPE_NIGHT = 3;
    public static final short SCENE_CAPTURE_TYPE_PORTRAIT = 2;
    public static final short SCENE_CAPTURE_TYPE_STANDARD = 0;
    public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = 1;
    public static final short SENSITIVITY_TYPE_ISO_SPEED = 3;
    public static final short SENSITIVITY_TYPE_REI = 2;
    public static final short SENSITIVITY_TYPE_REI_AND_ISO = 6;
    public static final short SENSITIVITY_TYPE_SOS = 1;
    public static final short SENSITIVITY_TYPE_SOS_AND_ISO = 5;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI = 4;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = 7;
    public static final short SENSITIVITY_TYPE_UNKNOWN = 0;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = 5;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = 8;
    public static final short SENSOR_TYPE_NOT_DEFINED = 1;
    public static final short SENSOR_TYPE_ONE_CHIP = 2;
    public static final short SENSOR_TYPE_THREE_CHIP = 4;
    public static final short SENSOR_TYPE_TRILINEAR = 7;
    public static final short SENSOR_TYPE_TWO_CHIP = 3;
    public static final short SHARPNESS_HARD = 2;
    public static final short SHARPNESS_NORMAL = 0;
    public static final short SHARPNESS_SOFT = 1;
    private static final int SIGNATURE_CHECK_SIZE = 5000;
    static final byte START_CODE = 42;
    public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = 2;
    public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = 3;
    public static final short SUBJECT_DISTANCE_RANGE_MACRO = 1;
    public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = 0;
    private static final String TAG = "ExifInterface";
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
    public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_DNG_VERSION = "DNGVersion";
    private static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_GAMMA = "Gamma";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    private static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    private static final String TAG_HAS_THUMBNAIL = "HasThumbnail";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    private static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final String TAG_ISO_SPEED = "ISOSpeed";
    public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";

    @Deprecated
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_LENS_MAKE = "LensMake";
    public static final String TAG_LENS_MODEL = "LensModel";
    public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    private static final String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
    private static final String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    private static final ExifTag TAG_RAF_IMAGE_SIZE = null;
    public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    private static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    private static final String TAG_THUMBNAIL_DATA = "ThumbnailData";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
    private static final String TAG_THUMBNAIL_LENGTH = "ThumbnailLength";
    private static final String TAG_THUMBNAIL_OFFSET = "ThumbnailOffset";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_RESOLUTION = "YResolution";

    @Deprecated
    public static final int WHITEBALANCE_AUTO = 0;

    @Deprecated
    public static final int WHITEBALANCE_MANUAL = 1;
    public static final short WHITE_BALANCE_AUTO = 0;
    public static final short WHITE_BALANCE_MANUAL = 1;
    public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
    public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;
    private static final HashMap<Integer, Integer> sExifPointerTagMap = null;
    private static final HashMap<Integer, ExifTag>[] sExifTagMapsForReading = null;
    private static final HashMap<String, ExifTag>[] sExifTagMapsForWriting = null;
    private static SimpleDateFormat sFormatter;
    private static final Pattern sGpsTimestampPattern = null;
    private static final Pattern sNonZeroTimePattern = null;
    private static final HashSet<String> sTagSetForCompatibility = null;
    private final AssetManager.AssetInputStream mAssetInputStream;
    private final HashMap<String, ExifAttribute>[] mAttributes;
    private Set<Integer> mAttributesOffsets;
    private ByteOrder mExifByteOrder;
    private int mExifOffset;
    private final String mFilename;
    private boolean mHasThumbnail;
    private boolean mIsSupportedFile;
    private int mMimeType;
    private int mOrfMakerNoteOffset;
    private int mOrfThumbnailLength;
    private int mOrfThumbnailOffset;
    private int mRw2JpgFromRawOffset;
    private byte[] mThumbnailBytes;
    private int mThumbnailCompression;
    private int mThumbnailLength;
    private int mThumbnailOffset;

    public static class ByteOrderedDataInputStream extends InputStream implements DataInput {
        private static final ByteOrder BIG_ENDIAN = null;
        private static final ByteOrder LITTLE_ENDIAN = null;
        private ByteOrder mByteOrder;
        private DataInputStream mDataInputStream;
        final int mLength;
        int mPosition;

        static {
            LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
            BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
        }

        public ByteOrderedDataInputStream(InputStream r5) throws IOException {
            this.mByteOrder = ByteOrder.BIG_ENDIAN;
            DataInputStream r10 = new DataInputStream(r5);
            this.mDataInputStream = r10;
            int r11 = r10.available();
            this.mLength = r11;
            this.mPosition = 0;
            this.mDataInputStream.mark(r11);
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.mDataInputStream.available();
        }

        public int peek() {
            return this.mPosition;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            int r5 = this.mPosition + 1;
            this.mPosition = r5;
            if (r5 > this.mLength) goto L11;
            int r10 = this.mDataInputStream.read();
            if (r10 < 0) goto L9;
            return (byte) r10;
        L9:
            throw new EOFException();
        L11:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] r5, int r10, int r11) throws IOException {
            int r12 = this.mPosition + r11;
            this.mPosition = r12;
            if (r12 > this.mLength) goto L10;
            if (this.mDataInputStream.read(r5, r10, r11) != r11) goto L8;
            return;
        L8:
            throw new IOException("Couldn't read up to the length of buffer");
        L10:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            int r5 = this.mPosition + 4;
            this.mPosition = r5;
            if (r5 > this.mLength) goto L19;
            int r10 = this.mDataInputStream.read();
            int r11 = this.mDataInputStream.read();
            int r12 = this.mDataInputStream.read();
            int r13 = this.mDataInputStream.read();
            if ((((r10 | r11) | r12) | r13) < 0) goto L17;
            ByteOrder r14 = this.mByteOrder;
            if (r14 != LITTLE_ENDIAN) goto L11;
            return (((r13 << 24) + (r12 << 16)) + (r11 << 8)) + r10;
        L11:
            if (r14 != BIG_ENDIAN) goto L15;
            return (((r10 << 24) + (r11 << 16)) + (r12 << 8)) + r13;
        L15:
            throw new IOException("Invalid byte order: " + this.mByteOrder);
        L17:
            throw new EOFException();
        L19:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readLine() throws IOException {
            Log.d(ExifInterface.TAG, "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            int r5 = this.mPosition + 8;
            this.mPosition = r5;
            if (r5 > this.mLength) goto L19;
            int r10 = this.mDataInputStream.read();
            int r11 = this.mDataInputStream.read();
            int r12 = this.mDataInputStream.read();
            int r13 = this.mDataInputStream.read();
            int r14 = this.mDataInputStream.read();
            int r15 = this.mDataInputStream.read();
            int r16 = this.mDataInputStream.read();
            int r17 = this.mDataInputStream.read();
            if ((((((((r10 | r11) | r12) | r13) | r14) | r15) | r16) | r17) < 0) goto L17;
            ByteOrder r18 = this.mByteOrder;
            if (r18 != LITTLE_ENDIAN) goto L11;
            return (((((((((long) r17) << 56) + (((long) r16) << 48)) + (((long) r15) << 40)) + (((long) r14) << 32)) + (((long) r13) << 24)) + (((long) r12) << 16)) + (((long) r11) << 8)) + ((long) r10);
        L11:
            if (r18 != BIG_ENDIAN) goto L15;
            return (((((((((long) r10) << 56) + (((long) r11) << 48)) + (((long) r12) << 40)) + (((long) r13) << 32)) + (((long) r14) << 24)) + (((long) r15) << 16)) + (((long) r16) << 8)) + ((long) r17);
        L15:
            throw new IOException("Invalid byte order: " + this.mByteOrder);
        L17:
            throw new EOFException();
        L19:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            int r5 = this.mPosition + 2;
            this.mPosition = r5;
            if (r5 > this.mLength) goto L19;
            int r10 = this.mDataInputStream.read();
            int r11 = this.mDataInputStream.read();
            if ((r10 | r11) < 0) goto L17;
            ByteOrder r12 = this.mByteOrder;
            if (r12 != LITTLE_ENDIAN) goto L12;
            int r13 = (r11 << 8) + r10;
        L10:
            return (short) r13;
        L12:
            if (r12 != BIG_ENDIAN) goto L15;
            r13 = (r10 << 8) + r11;
            goto L10
        L15:
            throw new IOException("Invalid byte order: " + this.mByteOrder);
        L17:
            throw new EOFException();
        L19:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readUnsignedByte();
        }

        public long readUnsignedInt() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            int r5 = this.mPosition + 2;
            this.mPosition = r5;
            if (r5 > this.mLength) goto L19;
            int r10 = this.mDataInputStream.read();
            int r11 = this.mDataInputStream.read();
            if ((r10 | r11) < 0) goto L17;
            ByteOrder r12 = this.mByteOrder;
            if (r12 != LITTLE_ENDIAN) goto L11;
            return (r11 << 8) + r10;
        L11:
            if (r12 != BIG_ENDIAN) goto L15;
            return (r10 << 8) + r11;
        L15:
            throw new IOException("Invalid byte order: " + this.mByteOrder);
        L17:
            throw new EOFException();
        L19:
            throw new EOFException();
        }

        public void seek(long r5) throws IOException {
            int r10 = this.mPosition;
            if (r10 <= r5) goto L5;
            this.mPosition = 0;
            this.mDataInputStream.reset();
            this.mDataInputStream.mark(this.mLength);
        L6:
            int r11 = (int) r5;
            if (skipBytes(r11) != r11) goto L10;
            return;
        L10:
            throw new IOException("Couldn't seek up to the byteCount");
        L5:
            r5 = r5 - ((long) r10);
            goto L6
        }

        public void setByteOrder(ByteOrder r5) {
            this.mByteOrder = r5;
        }

        @Override // java.io.DataInput
        public int skipBytes(int r5) throws IOException {
            int r10 = Math.min(r5, this.mLength - this.mPosition);
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L5;
            r11 = r11 + this.mDataInputStream.skipBytes(r10 - r11);
            goto L3
        L5:
            this.mPosition += r11;
            return r11;
        }

        @Override // java.io.InputStream
        public int read(byte[] r5, int r10, int r11) throws IOException {
            int r12 = this.mDataInputStream.read(r5, r10, r11);
            this.mPosition += r12;
            return r12;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] r5) throws IOException {
            int r10 = this.mPosition + r5.length;
            this.mPosition = r10;
            if (r10 > this.mLength) goto L10;
            if (this.mDataInputStream.read(r5, 0, r5.length) != r5.length) goto L8;
            return;
        L8:
            throw new IOException("Couldn't read up to the length of buffer");
        L10:
            throw new EOFException();
        }

        public ByteOrderedDataInputStream(byte[] r5) throws IOException {
            this(new ByteArrayInputStream(r5));
        }
    }

    public static class ByteOrderedDataOutputStream extends FilterOutputStream {
        private ByteOrder mByteOrder;
        private final OutputStream mOutputStream;

        public ByteOrderedDataOutputStream(OutputStream r5, ByteOrder r10) {
            super(r5);
            this.mOutputStream = r5;
            this.mByteOrder = r10;
        }

        public void setByteOrder(ByteOrder r5) {
            this.mByteOrder = r5;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] r5) throws IOException {
            this.mOutputStream.write(r5);
        }

        public void writeByte(int r5) throws IOException {
            this.mOutputStream.write(r5);
        }

        public void writeInt(int r5) throws IOException {
            ByteOrder r10 = this.mByteOrder;
            if (r10 != ByteOrder.LITTLE_ENDIAN) goto L6;
            this.mOutputStream.write(r5 & 255);
            this.mOutputStream.write((r5 >>> 8) & 255);
            this.mOutputStream.write((r5 >>> 16) & 255);
            this.mOutputStream.write((r5 >>> 24) & 255);
            return;
        L6:
            if (r10 != ByteOrder.BIG_ENDIAN) goto L10;
            this.mOutputStream.write((r5 >>> 24) & 255);
            this.mOutputStream.write((r5 >>> 16) & 255);
            this.mOutputStream.write((r5 >>> 8) & 255);
            this.mOutputStream.write(r5 & 255);
            return;
        }

        public void writeShort(short r5) throws IOException {
            ByteOrder r10 = this.mByteOrder;
            if (r10 != ByteOrder.LITTLE_ENDIAN) goto L6;
            this.mOutputStream.write(r5 & 255);
            this.mOutputStream.write((r5 >>> 8) & 255);
            return;
        L6:
            if (r10 != ByteOrder.BIG_ENDIAN) goto L10;
            this.mOutputStream.write((r5 >>> 8) & 255);
            this.mOutputStream.write(r5 & 255);
            return;
        }

        public void writeUnsignedInt(long r5) throws IOException {
            writeInt((int) r5);
        }

        public void writeUnsignedShort(int r5) throws IOException {
            writeShort((short) r5);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] r5, int r10, int r11) throws IOException {
            this.mOutputStream.write(r5, r10, r11);
        }
    }

    public static class ExifAttribute {
        public final byte[] bytes;
        public final int format;
        public final int numberOfComponents;

        public ExifAttribute(int r5, int r10, byte[] r11) {
            this.format = r5;
            this.numberOfComponents = r10;
            this.bytes = r11;
        }

        public static ExifAttribute createByte(String r5) {
            if (r5.length() == 1) goto L5;
        L10:
            byte[] r10 = r5.getBytes(ExifInterface.ASCII);
            return new ExifAttribute(1, r10.length, r10);
        L5:
            if (r5.charAt(0) < '0') goto L10;
            if (r5.charAt(0) > '1') goto L10;
            return new ExifAttribute(1, 1, new byte[]{(byte) (r5.charAt(0) - '0')});
        }

        public static ExifAttribute createDouble(double[] r5, ByteOrder r10) {
            ByteBuffer r11 = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[12] * r5.length]);
            r11.order(r10);
            int r12 = r5.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L6;
            r11.putDouble(r5[r13]);
            r13 = r13 + 1;
            goto L3
        L6:
            return new ExifAttribute(12, r5.length, r11.array());
        }

        public static ExifAttribute createSLong(int[] r5, ByteOrder r10) {
            ByteBuffer r11 = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[9] * r5.length]);
            r11.order(r10);
            int r12 = r5.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L6;
            r11.putInt(r5[r13]);
            r13 = r13 + 1;
            goto L3
        L6:
            return new ExifAttribute(9, r5.length, r11.array());
        }

        public static ExifAttribute createSRational(Rational[] r10, ByteOrder r11) {
            ByteBuffer r5 = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[10] * r10.length]);
            r5.order(r11);
            int r12 = r10.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L6;
            Rational r14 = r10[r13];
            r5.putInt((int) r14.numerator);
            r5.putInt((int) r14.denominator);
            r13 = r13 + 1;
            goto L3
        L6:
            return new ExifAttribute(10, r10.length, r5.array());
        }

        public static ExifAttribute createString(String r5) {
            byte[] r10 = (r5 + 0).getBytes(ExifInterface.ASCII);
            return new ExifAttribute(2, r10.length, r10);
        }

        public static ExifAttribute createULong(long[] r5, ByteOrder r10) {
            ByteBuffer r11 = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[4] * r5.length]);
            r11.order(r10);
            int r12 = r5.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L6;
            r11.putInt((int) r5[r13]);
            r13 = r13 + 1;
            goto L3
        L6:
            return new ExifAttribute(4, r5.length, r11.array());
        }

        public static ExifAttribute createURational(Rational[] r10, ByteOrder r11) {
            ByteBuffer r5 = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[5] * r10.length]);
            r5.order(r11);
            int r12 = r10.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L6;
            Rational r14 = r10[r13];
            r5.putInt((int) r14.numerator);
            r5.putInt((int) r14.denominator);
            r13 = r13 + 1;
            goto L3
        L6:
            return new ExifAttribute(5, r10.length, r5.array());
        }

        public static ExifAttribute createUShort(int[] r5, ByteOrder r10) {
            ByteBuffer r11 = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[3] * r5.length]);
            r11.order(r10);
            int r12 = r5.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L6;
            r11.putShort((short) r5[r13]);
            r13 = r13 + 1;
            goto L3
        L6:
            return new ExifAttribute(3, r5.length, r11.array());
        }

        public double getDoubleValue(ByteOrder r5) {
            Object r10 = getValue(r5);
            if (r10 == null) goto L43;
            if ((r10 instanceof String) == false) goto L9;
            return Double.parseDouble((String) r10);
        L9:
            if ((r10 instanceof long[]) == false) goto L17;
            long[] r11 = (long[]) r10;
            if (r11.length != 1) goto L15;
            return r11[0];
        L15:
            throw new NumberFormatException("There are more than one component");
        L17:
            if ((r10 instanceof int[]) == false) goto L25;
            int[] r12 = (int[]) r10;
            if (r12.length != 1) goto L23;
            return r12[0];
        L23:
            throw new NumberFormatException("There are more than one component");
        L25:
            if ((r10 instanceof double[]) == false) goto L33;
            double[] r13 = (double[]) r10;
            if (r13.length != 1) goto L31;
            return r13[0];
        L31:
            throw new NumberFormatException("There are more than one component");
        L33:
            if ((r10 instanceof Rational[]) == false) goto L41;
            Rational[] r14 = (Rational[]) r10;
            if (r14.length != 1) goto L39;
            return r14[0].calculate();
        L39:
            throw new NumberFormatException("There are more than one component");
        L41:
            throw new NumberFormatException("Couldn't find a double value");
        L43:
            throw new NumberFormatException("NULL can't be converted to a double value");
        }

        public int getIntValue(ByteOrder r5) {
            Object r10 = getValue(r5);
            if (r10 == null) goto L27;
            if ((r10 instanceof String) == false) goto L9;
            return Integer.parseInt((String) r10);
        L9:
            if ((r10 instanceof long[]) == false) goto L17;
            long[] r11 = (long[]) r10;
            if (r11.length != 1) goto L15;
            return (int) r11[0];
        L15:
            throw new NumberFormatException("There are more than one component");
        L17:
            if ((r10 instanceof int[]) == false) goto L25;
            int[] r12 = (int[]) r10;
            if (r12.length != 1) goto L23;
            return r12[0];
        L23:
            throw new NumberFormatException("There are more than one component");
        L25:
            throw new NumberFormatException("Couldn't find a integer value");
        L27:
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }

        public String getStringValue(ByteOrder r10) {
            Object r11 = getValue(r10);
            if (r11 != null) goto L6;
            return null;
        L6:
            if ((r11 instanceof String) == true) goto L8;
            StringBuilder r5 = new StringBuilder();
            int r12 = 0;
            if ((r11 instanceof long[]) == false) goto L20;
            long[] r13 = (long[]) r11;
        L13:
            if (r12 >= r13.length) goto L18;
            r5.append(r13[r12]);
            r12 = r12 + 1;
            if (r12 == r13.length) goto L13;
            r5.append(",");
            goto L13
        L18:
            return r5.toString();
        L20:
            if ((r11 instanceof int[]) == false) goto L30;
            int[] r14 = (int[]) r11;
        L23:
            if (r12 >= r14.length) goto L28;
            r5.append(r14[r12]);
            r12 = r12 + 1;
            if (r12 == r14.length) goto L23;
            r5.append(",");
            goto L23
        L28:
            return r5.toString();
        L30:
            if ((r11 instanceof double[]) == false) goto L40;
            double[] r15 = (double[]) r11;
        L33:
            if (r12 >= r15.length) goto L38;
            r5.append(r15[r12]);
            r12 = r12 + 1;
            if (r12 == r15.length) goto L33;
            r5.append(",");
            goto L33
        L38:
            return r5.toString();
        L40:
            if ((r11 instanceof Rational[]) == false) goto L49;
            Rational[] r16 = (Rational[]) r11;
        L43:
            if (r12 >= r16.length) goto L48;
            r5.append(r16[r12].numerator);
            r5.append('/');
            r5.append(r16[r12].denominator);
            r12 = r12 + 1;
            if (r12 == r16.length) goto L43;
            r5.append(",");
            goto L43
        L48:
            return r5.toString();
        L49:
            return null;
        L8:
            return (String) r11;
        }

        /* JADX WARN: Not initialized variable reg: 5, insn: 0x0030: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:17:0x0030 */
        public Object getValue(ByteOrder r12) {
            int r5 = 0;
            InputStream r10 = null;
            ByteOrderedDataInputStream r11 = new ByteOrderedDataInputStream(this.bytes);     // Catch: Throwable -> L139 IOException -> L141
            r11.setByteOrder(r12);     // Catch: Throwable -> L16 IOException -> L18
            switch(this.format) {
                case 1: goto L122;
                case 2: goto L96;
                case 3: goto L85;
                case 4: goto L75;
                case 5: goto L65;
                case 6: goto L122;
                case 7: goto L96;
                case 8: goto L55;
                case 9: goto L45;
                case 10: goto L35;
                case 11: goto L25;
                case 12: goto L11;
                default: goto L158;
            };
        L11:
            double[] r13 = new double[this.numberOfComponents];     // Catch: Throwable -> L16 IOException -> L18
        L13:
            if (r5 >= this.numberOfComponents) goto L156;
            r13[r5] = r11.readDouble();     // Catch: Throwable -> L16 IOException -> L18
            r5 = r5 + 1;
            goto L13
        L156:
            r11.close();     // Catch: IOException -> L22
        L24:
            return r13;
        L22:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
            goto L24
        L25:
            double[] r14 = new double[this.numberOfComponents];     // Catch: Throwable -> L16 IOException -> L18
        L27:
            if (r5 >= this.numberOfComponents) goto L167;
            r14[r5] = r11.readFloat();     // Catch: Throwable -> L16 IOException -> L18
            r5 = r5 + 1;
            goto L27
        L167:
            r11.close();     // Catch: IOException -> L32
        L34:
            return r14;
        L32:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
            goto L34
        L35:
            Rational[] r15 = new Rational[this.numberOfComponents];     // Catch: Throwable -> L16 IOException -> L18
        L37:
            if (r5 >= this.numberOfComponents) goto L160;
            r15[r5] = new Rational(r11.readInt(), r11.readInt());     // Catch: Throwable -> L16 IOException -> L18
            r5 = r5 + 1;
            goto L37
        L160:
            r11.close();     // Catch: IOException -> L42
        L44:
            return r15;
        L42:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
            goto L44
        L45:
            int[] r16 = new int[this.numberOfComponents];     // Catch: Throwable -> L16 IOException -> L18
        L47:
            if (r5 >= this.numberOfComponents) goto L169;
            r16[r5] = r11.readInt();     // Catch: Throwable -> L16 IOException -> L18
            r5 = r5 + 1;
            goto L47
        L169:
            r11.close();     // Catch: IOException -> L52
        L54:
            return r16;
        L52:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
            goto L54
        L55:
            int[] r17 = new int[this.numberOfComponents];     // Catch: Throwable -> L16 IOException -> L18
        L57:
            if (r5 >= this.numberOfComponents) goto L174;
            r17[r5] = r11.readShort();     // Catch: Throwable -> L16 IOException -> L18
            r5 = r5 + 1;
            goto L57
        L174:
            r11.close();     // Catch: IOException -> L62
        L64:
            return r17;
        L62:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
            goto L64
        L65:
            Rational[] r18 = new Rational[this.numberOfComponents];     // Catch: Throwable -> L16 IOException -> L18
        L67:
            if (r5 >= this.numberOfComponents) goto L171;
            r18[r5] = new Rational(r11.readUnsignedInt(), r11.readUnsignedInt());     // Catch: Throwable -> L16 IOException -> L18
            r5 = r5 + 1;
            goto L67
        L171:
            r11.close();     // Catch: IOException -> L72
        L74:
            return r18;
        L72:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
            goto L74
        L75:
            long[] r19 = new long[this.numberOfComponents];     // Catch: Throwable -> L16 IOException -> L18
        L77:
            if (r5 >= this.numberOfComponents) goto L178;
            r19[r5] = r11.readUnsignedInt();     // Catch: Throwable -> L16 IOException -> L18
            r5 = r5 + 1;
            goto L77
        L178:
            r11.close();     // Catch: IOException -> L82
        L84:
            return r19;
        L82:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
            goto L84
        L85:
            int[] r110 = new int[this.numberOfComponents];     // Catch: Throwable -> L16 IOException -> L18
        L87:
            if (r5 >= this.numberOfComponents) goto L184;
            r110[r5] = r11.readUnsignedShort();     // Catch: Throwable -> L16 IOException -> L18
            r5 = r5 + 1;
            goto L87
        L184:
            r11.close();     // Catch: IOException -> L92
        L94:
            return r110;
        L92:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
            goto L94
        L122:
            byte[] r111 = this.bytes;     // Catch: Throwable -> L16 IOException -> L18
            if (r111.length != 1) goto L133;
            byte r112 = r111[0];     // Catch: Throwable -> L16 IOException -> L18
            if (r112 < 0) goto L133;
            if (r112 > 1) goto L133;
            String r113 = new String(new char[]{(char) (r112 + 48)});     // Catch: Throwable -> L16 IOException -> L18
            r11.close();     // Catch: IOException -> L130
        L132:
            return r113;
        L130:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
        L133:
            String r114 = new String(r111, ExifInterface.ASCII);     // Catch: Throwable -> L16 IOException -> L18
            r11.close();     // Catch: IOException -> L136
        L138:
            return r114;
        L136:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
            goto L138
        L158:
            r11.close();     // Catch: IOException -> L8
        L10:
            return null;
        L8:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
            goto L10
        L96:
            if (this.numberOfComponents < ExifInterface.EXIF_ASCII_PREFIX.length) goto L105;
            int r115 = 0;
        L98:
            byte[] r20 = ExifInterface.EXIF_ASCII_PREFIX;     // Catch: Throwable -> L16 IOException -> L18
            if (r115 >= r20.length) goto L104;
            if (this.bytes[r115] != r20[r115]) goto L105;
            r115 = r115 + 1;     // Catch: Throwable -> L16 IOException -> L18
            goto L98
        L104:
            r5 = r20.length;     // Catch: Throwable -> L16 IOException -> L18
        L105:
            StringBuilder r116 = new StringBuilder();     // Catch: Throwable -> L16 IOException -> L18
        L107:
            if (r5 >= this.numberOfComponents) goto L116;
            byte r21 = this.bytes[r5];     // Catch: Throwable -> L16 IOException -> L18
            if (r21 == 0) goto L116;
            if (r21 < 32) goto L114;
            r116.append((char) r21);     // Catch: Throwable -> L16 IOException -> L18
        L115:
            r5 = r5 + 1;     // Catch: Throwable -> L16 IOException -> L18
            goto L107
        L114:
            r116.append('?');     // Catch: Throwable -> L16 IOException -> L18
        L116:
            String r117 = r116.toString();     // Catch: Throwable -> L16 IOException -> L18
            r11.close();     // Catch: IOException -> L119
        L121:
            return r117;
        L119:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
        L18:
            e = e;
        L143:
            Log.w(ExifInterface.TAG, "IOException occurred during reading a value", e);     // Catch: Throwable -> L16
            if (r11 != null) goto L176;
        L149:
            return null;
        L176:
            r11.close();     // Catch: IOException -> L147
        L147:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
            goto L149
        L16:
            th = th;
            r10 = r5;
        L150:
            if (r10 != null) goto L162;
        L155:
            throw th;
        L162:
            r10.close();     // Catch: IOException -> L153
        L153:
            e = move-exception;
            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
        L141:
            e = e;
            r11 = null;
        L139:
            th = th;
            goto L150
        }

        public int size() {
            return ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents;
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("(");
            r5.append(ExifInterface.IFD_FORMAT_NAMES[this.format]);
            r5.append(", data length:");
            return a.s(r5, this.bytes.length, ")");
        }

        public static ExifAttribute createDouble(double r5, ByteOrder r10) {
            return createDouble(new double[]{r5}, r10);
        }

        public static ExifAttribute createSLong(int r5, ByteOrder r10) {
            return createSLong(new int[]{r5}, r10);
        }

        public static ExifAttribute createULong(long r5, ByteOrder r10) {
            return createULong(new long[]{r5}, r10);
        }

        public static ExifAttribute createUShort(int r5, ByteOrder r10) {
            return createUShort(new int[]{r5}, r10);
        }

        public static ExifAttribute createSRational(Rational r5, ByteOrder r10) {
            return createSRational(new Rational[]{r5}, r10);
        }

        public static ExifAttribute createURational(Rational r5, ByteOrder r10) {
            return createURational(new Rational[]{r5}, r10);
        }
    }

    public static class ExifTag {
        public final String name;
        public final int number;
        public final int primaryFormat;
        public final int secondaryFormat;

        public ExifTag(String r5, int r10, int r11) {
            this.name = r5;
            this.number = r10;
            this.primaryFormat = r11;
            this.secondaryFormat = -1;
        }

        public boolean isFormatCompatible(int r5) {
            int r10 = this.primaryFormat;
            if (r10 == 7) goto L30;
            if (r5 == 7) goto L30;
            if (r10 == r5) goto L30;
            int r11 = this.secondaryFormat;
            if (r11 == r5) goto L30;
            if (r10 == 4) goto L14;
            if (r11 == 4) goto L14;
        L17:
            if (r10 == 9) goto L20;
            if (r11 == 9) goto L20;
        L23:
            if (r10 == 12) goto L26;
            if (r11 == 12) goto L26;
            return false;
        L26:
            if (r5 != 11) goto L31;
            return true;
        L31:
            return false;
        L20:
            if (r5 != 8) goto L23;
            return true;
        L14:
            if (r5 != 3) goto L17;
            return true;
        L30:
            return true;
        }

        public ExifTag(String r5, int r10, int r11, int r12) {
            this.name = r5;
            this.number = r10;
            this.primaryFormat = r11;
            this.secondaryFormat = r12;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface IfdType {
    }

    public static class Rational {
        public final long denominator;
        public final long numerator;

        public Rational(double r5) {
            this((long) (r5 * 10000.0d), 10000);
        }

        public double calculate() {
            return this.numerator / this.denominator;
        }

        public String toString() {
            return this.numerator + "/" + this.denominator;
        }

        public Rational(long r5, long r10) {
            if (r10 != 0) goto L6;
            this.numerator = 0;
            this.denominator = 1;
            return;
        L6:
            this.numerator = r5;
            this.denominator = r10;
        }
    }

    static {
        ROTATION_ORDER = Arrays.asList(new Integer[]{1, 6, 3, 8});
        FLIPPED_ROTATION_ORDER = Arrays.asList(new Integer[]{2, 7, 4, 5});
        BITS_PER_SAMPLE_RGB = new int[]{8, 8, 8};
        BITS_PER_SAMPLE_GREYSCALE_1 = new int[]{4};
        BITS_PER_SAMPLE_GREYSCALE_2 = new int[]{8};
        JPEG_SIGNATURE = new byte[]{-1, MARKER_SOI, -1};
        ORF_MAKER_NOTE_HEADER_1 = new byte[]{79, 76, 89, 77, 80, 0};
        ORF_MAKER_NOTE_HEADER_2 = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        IFD_FORMAT_NAMES = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
        IFD_FORMAT_BYTES_PER_FORMAT = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        EXIF_ASCII_PREFIX = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        ExifTag[] r64 = {new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag(TAG_IMAGE_WIDTH, 256, 3, 4), new ExifTag(TAG_IMAGE_LENGTH, 257, 3, 4), new ExifTag(TAG_BITS_PER_SAMPLE, 258, 3), new ExifTag(TAG_COMPRESSION, 259, 3), new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifTag(TAG_MAKE, 271, 2), new ExifTag(TAG_MODEL, 272, 2), new ExifTag(TAG_STRIP_OFFSETS, 273, 3, 4), new ExifTag(TAG_ORIENTATION, 274, 3), new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4), new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new ExifTag(TAG_X_RESOLUTION, 282, 5), new ExifTag(TAG_Y_RESOLUTION, 283, 5), new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(TAG_TRANSFER_FUNCTION, LynxErrorCode.LYNX_ERROR_CODE_RESOURCE, 3), new ExifTag(TAG_SOFTWARE, 305, 2), new ExifTag(TAG_DATETIME, 306, 2), new ExifTag(TAG_ARTIST, 315, 2), new ExifTag(TAG_WHITE_POINT, 318, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, InputDeviceCompat.SOURCE_DPAD, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new ExifTag(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new ExifTag(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new ExifTag(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new ExifTag(TAG_RW2_ISO, 23, 3), new ExifTag(TAG_RW2_JPG_FROM_RAW, 46, 7)};
        IFD_TIFF_TAGS = r64;
        ExifTag[] r60 = {new ExifTag(TAG_EXPOSURE_TIME, 33434, 5), new ExifTag(TAG_F_NUMBER, 33437, 5), new ExifTag(TAG_EXPOSURE_PROGRAM, 34850, 3), new ExifTag(TAG_SPECTRAL_SENSITIVITY, 34852, 2), new ExifTag(TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new ExifTag(TAG_OECF, 34856, 7), new ExifTag(TAG_EXIF_VERSION, 36864, 2), new ExifTag(TAG_DATETIME_ORIGINAL, 36867, 2), new ExifTag(TAG_DATETIME_DIGITIZED, 36868, 2), new ExifTag(TAG_COMPONENTS_CONFIGURATION, 37121, 7), new ExifTag(TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5), new ExifTag(TAG_SHUTTER_SPEED_VALUE, 37377, 10), new ExifTag(TAG_APERTURE_VALUE, 37378, 5), new ExifTag(TAG_BRIGHTNESS_VALUE, 37379, 10), new ExifTag(TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new ExifTag(TAG_MAX_APERTURE_VALUE, 37381, 5), new ExifTag(TAG_SUBJECT_DISTANCE, 37382, 5), new ExifTag(TAG_METERING_MODE, 37383, 3), new ExifTag(TAG_LIGHT_SOURCE, 37384, 3), new ExifTag(TAG_FLASH, 37385, 3), new ExifTag(TAG_FOCAL_LENGTH, 37386, 5), new ExifTag(TAG_SUBJECT_AREA, 37396, 3), new ExifTag(TAG_MAKER_NOTE, 37500, 7), new ExifTag(TAG_USER_COMMENT, 37510, 7), new ExifTag(TAG_SUBSEC_TIME, 37520, 2), new ExifTag(TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new ExifTag(TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new ExifTag(TAG_FLASHPIX_VERSION, 40960, 7), new ExifTag(TAG_COLOR_SPACE, 40961, 3), new ExifTag(TAG_PIXEL_X_DIMENSION, 40962, 3, 4), new ExifTag(TAG_PIXEL_Y_DIMENSION, 40963, 3, 4), new ExifTag(TAG_RELATED_SOUND_FILE, 40964, 2), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag(TAG_FLASH_ENERGY, 41483, 5), new ExifTag(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new ExifTag(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new ExifTag(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new ExifTag(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new ExifTag(TAG_SUBJECT_LOCATION, 41492, 3), new ExifTag(TAG_EXPOSURE_INDEX, 41493, 5), new ExifTag(TAG_SENSING_METHOD, 41495, 3), new ExifTag(TAG_FILE_SOURCE, 41728, 7), new ExifTag(TAG_SCENE_TYPE, 41729, 7), new ExifTag(TAG_CFA_PATTERN, 41730, 7), new ExifTag(TAG_CUSTOM_RENDERED, 41985, 3), new ExifTag(TAG_EXPOSURE_MODE, 41986, 3), new ExifTag(TAG_WHITE_BALANCE, 41987, 3), new ExifTag(TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new ExifTag(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new ExifTag(TAG_SCENE_CAPTURE_TYPE, 41990, 3), new ExifTag(TAG_GAIN_CONTROL, 41991, 3), new ExifTag(TAG_CONTRAST, 41992, 3), new ExifTag(TAG_SATURATION, 41993, 3), new ExifTag(TAG_SHARPNESS, 41994, 3), new ExifTag(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new ExifTag(TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new ExifTag(TAG_IMAGE_UNIQUE_ID, 42016, 2), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        IFD_EXIF_TAGS = r60;
        ExifTag[] r61 = {new ExifTag(TAG_GPS_VERSION_ID, 0, 1), new ExifTag(TAG_GPS_LATITUDE_REF, 1, 2), new ExifTag(TAG_GPS_LATITUDE, 2, 5), new ExifTag(TAG_GPS_LONGITUDE_REF, 3, 2), new ExifTag(TAG_GPS_LONGITUDE, 4, 5), new ExifTag(TAG_GPS_ALTITUDE_REF, 5, 1), new ExifTag(TAG_GPS_ALTITUDE, 6, 5), new ExifTag(TAG_GPS_TIMESTAMP, 7, 5), new ExifTag(TAG_GPS_SATELLITES, 8, 2), new ExifTag(TAG_GPS_STATUS, 9, 2), new ExifTag(TAG_GPS_MEASURE_MODE, 10, 2), new ExifTag(TAG_GPS_DOP, 11, 5), new ExifTag(TAG_GPS_SPEED_REF, 12, 2), new ExifTag(TAG_GPS_SPEED, 13, 5), new ExifTag(TAG_GPS_TRACK_REF, 14, 2), new ExifTag(TAG_GPS_TRACK, 15, 5), new ExifTag(TAG_GPS_IMG_DIRECTION_REF, 16, 2), new ExifTag(TAG_GPS_IMG_DIRECTION, 17, 5), new ExifTag(TAG_GPS_MAP_DATUM, 18, 2), new ExifTag(TAG_GPS_DEST_LATITUDE_REF, 19, 2), new ExifTag(TAG_GPS_DEST_LATITUDE, 20, 5), new ExifTag(TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new ExifTag(TAG_GPS_DEST_LONGITUDE, 22, 5), new ExifTag(TAG_GPS_DEST_BEARING_REF, 23, 2), new ExifTag(TAG_GPS_DEST_BEARING, 24, 5), new ExifTag(TAG_GPS_DEST_DISTANCE_REF, 25, 2), new ExifTag(TAG_GPS_DEST_DISTANCE, 26, 5), new ExifTag(TAG_GPS_PROCESSING_METHOD, 27, 7), new ExifTag(TAG_GPS_AREA_INFORMATION, 28, 7), new ExifTag(TAG_GPS_DATESTAMP, 29, 2), new ExifTag(TAG_GPS_DIFFERENTIAL, 30, 3)};
        IFD_GPS_TAGS = r61;
        ExifTag[] r62 = {new ExifTag(TAG_INTEROPERABILITY_INDEX, 1, 2)};
        IFD_INTEROPERABILITY_TAGS = r62;
        ExifTag[] r63 = {new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag(TAG_THUMBNAIL_IMAGE_WIDTH, 256, 3, 4), new ExifTag(TAG_THUMBNAIL_IMAGE_LENGTH, 257, 3, 4), new ExifTag(TAG_BITS_PER_SAMPLE, 258, 3), new ExifTag(TAG_COMPRESSION, 259, 3), new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifTag(TAG_MAKE, 271, 2), new ExifTag(TAG_MODEL, 272, 2), new ExifTag(TAG_STRIP_OFFSETS, 273, 3, 4), new ExifTag(TAG_ORIENTATION, 274, 3), new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4), new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new ExifTag(TAG_X_RESOLUTION, 282, 5), new ExifTag(TAG_Y_RESOLUTION, 283, 5), new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(TAG_TRANSFER_FUNCTION, LynxErrorCode.LYNX_ERROR_CODE_RESOURCE, 3), new ExifTag(TAG_SOFTWARE, 305, 2), new ExifTag(TAG_DATETIME, 306, 2), new ExifTag(TAG_ARTIST, 315, 2), new ExifTag(TAG_WHITE_POINT, 318, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, InputDeviceCompat.SOURCE_DPAD, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        IFD_THUMBNAIL_TAGS = r63;
        TAG_RAF_IMAGE_SIZE = new ExifTag(TAG_STRIP_OFFSETS, 273, 3);
        ExifTag[] r65 = {new ExifTag(TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 4), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 4)};
        ORF_MAKER_NOTE_TAGS = r65;
        ExifTag[] r66 = {new ExifTag(TAG_ORF_PREVIEW_IMAGE_START, 257, 4), new ExifTag(TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4)};
        ORF_CAMERA_SETTINGS_TAGS = r66;
        ExifTag[] r67 = {new ExifTag(TAG_ORF_ASPECT_FRAME, 4371, 3)};
        ORF_IMAGE_PROCESSING_TAGS = r67;
        ExifTag[] r68 = {new ExifTag(TAG_COLOR_SPACE, 55, 3)};
        PEF_TAGS = r68;
        ExifTag[][] r5 = {r64, r60, r61, r62, r63, r64, r65, r66, r67, r68};
        EXIF_TAGS = r5;
        EXIF_POINTER_TAGS = new ExifTag[]{new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 1), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 1)};
        JPEG_INTERCHANGE_FORMAT_TAG = new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, InputDeviceCompat.SOURCE_DPAD, 4);
        JPEG_INTERCHANGE_FORMAT_LENGTH_TAG = new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4);
        sExifTagMapsForReading = new HashMap[r5.length];
        sExifTagMapsForWriting = new HashMap[r5.length];
        sTagSetForCompatibility = new HashSet(Arrays.asList(new String[]{TAG_F_NUMBER, TAG_DIGITAL_ZOOM_RATIO, TAG_EXPOSURE_TIME, TAG_SUBJECT_DISTANCE, TAG_GPS_TIMESTAMP}));
        sExifPointerTagMap = new HashMap();
        Charset r10 = Charset.forName("US-ASCII");
        ASCII = r10;
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(r10);
        SimpleDateFormat r11 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        sFormatter = r11;
        r11.setTimeZone(TimeZone.getTimeZone("UTC"));
        int r12 = 0;
    L3:
        ExifTag[][] r13 = EXIF_TAGS;
        if (r12 >= r13.length) goto L9;
        sExifTagMapsForReading[r12] = new HashMap();
        sExifTagMapsForWriting[r12] = new HashMap();
        ExifTag[] r14 = r13[r12];
        int r15 = r14.length;
        int r16 = 0;
    L6:
        if (r16 >= r15) goto L8;
        ExifTag r17 = r14[r16];
        sExifTagMapsForReading[r12].put(Integer.valueOf(r17.number), r17);
        sExifTagMapsForWriting[r12].put(r17.name, r17);
        r16 = r16 + 1;
        goto L6
    L8:
        r12 = r12 + 1;
        goto L3
    L9:
        HashMap<Integer, Integer> r18 = sExifPointerTagMap;
        ExifTag[] r19 = EXIF_POINTER_TAGS;
        r18.put(Integer.valueOf(r19[0].number), 5);
        r18.put(Integer.valueOf(r19[1].number), 1);
        r18.put(Integer.valueOf(r19[2].number), 2);
        r18.put(Integer.valueOf(r19[3].number), 3);
        r18.put(Integer.valueOf(r19[4].number), 7);
        r18.put(Integer.valueOf(r19[5].number), 8);
        sNonZeroTimePattern = Pattern.compile(".*[1-9].*");
        sGpsTimestampPattern = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    }

    public ExifInterface(@NonNull String r5) throws IOException {
        ExifTag[][] r10 = EXIF_TAGS;
        this.mAttributes = new HashMap[r10.length];
        this.mAttributesOffsets = new HashSet(r10.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (r5 == null) goto L15;
        FileInputStream r11 = null;
        this.mAssetInputStream = null;
        this.mFilename = r5;
        FileInputStream r12 = new FileInputStream(r5);     // Catch: Throwable -> L11
        loadAttributes(r12);     // Catch: Throwable -> L9
        closeQuietly(r12);
        return;
    L9:
        th = th;
        r11 = r12;
    L12:
        closeQuietly(r11);
        throw th;
    L11:
        th = th;
        goto L12
    L15:
        throw new IllegalArgumentException("filename cannot be null");
    }

    private void addDefaultValuesForCompatibility() {
        String r5 = getAttribute(TAG_DATETIME_ORIGINAL);
        if (r5 == null) goto L8;
        if (getAttribute(TAG_DATETIME) != null) goto L8;
        this.mAttributes[0].put(TAG_DATETIME, ExifAttribute.createString(r5));
    L8:
        if (getAttribute(TAG_IMAGE_WIDTH) != null) goto L11;
        this.mAttributes[0].put(TAG_IMAGE_WIDTH, ExifAttribute.createULong(0, this.mExifByteOrder));
    L11:
        if (getAttribute(TAG_IMAGE_LENGTH) != null) goto L14;
        this.mAttributes[0].put(TAG_IMAGE_LENGTH, ExifAttribute.createULong(0, this.mExifByteOrder));
    L14:
        if (getAttribute(TAG_ORIENTATION) != null) goto L17;
        this.mAttributes[0].put(TAG_ORIENTATION, ExifAttribute.createULong(0, this.mExifByteOrder));
    L17:
        if (getAttribute(TAG_LIGHT_SOURCE) != null) goto L20;
        this.mAttributes[1].put(TAG_LIGHT_SOURCE, ExifAttribute.createULong(0, this.mExifByteOrder));
        return;
    }

    private static void closeQuietly(Closeable r5) {
        if (r5 != null) goto L9;
        return;
    L9:
        r5.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    private String convertDecimalDegree(double r10) {
        long r5 = (long) r10;
        double r11 = r10 - r5;
        long r12 = (long) (r11 * 60.0d);
        return r5 + "/1," + r12 + "/1," + Math.round(((r11 - (r12 / 60.0d)) * 3600.0d) * 1.0E7d) + "/10000000";
    }

    private static double convertRationalLatLonToDouble(String r11, String r12) {
        String[] r13 = r11.split(",", -1);     // Catch: Throwable -> L18
        String[] r5 = r13[0].split("/", -1);     // Catch: Throwable -> L18
        double r10 = Double.parseDouble(r5[0].trim()) / Double.parseDouble(r5[1].trim());     // Catch: Throwable -> L18
        String[] r14 = r13[1].split("/", -1);     // Catch: Throwable -> L18
        double r15 = Double.parseDouble(r14[0].trim()) / Double.parseDouble(r14[1].trim());     // Catch: Throwable -> L18
        String[] r16 = r13[2].split("/", -1);     // Catch: Throwable -> L18
        double r17 = (Double.parseDouble(r16[0].trim()) / Double.parseDouble(r16[1].trim())) / 3600.0d;     // Catch: Throwable -> L18
        double r18 = r17 + ((r15 / 60.0d) + r10);     // Catch: Throwable -> L18
        if (r12.equals(LATITUDE_SOUTH) == true) goto L17;
        if (r12.equals(LONGITUDE_WEST) == true) goto L17;
        if (r12.equals("N") == false) goto L11;
    L15:
        return r18;
    L11:
        if (r12.equals(LONGITUDE_EAST) == true) goto L15;
        throw new IllegalArgumentException();     // Catch: Throwable -> L18
    L17:
        return -r18;
    L19:
        throw new IllegalArgumentException();
    }

    private static long[] convertToLongArray(Object r5) {
        if ((r5 instanceof int[]) == false) goto L10;
        int[] r10 = (int[]) r5;
        long[] r11 = new long[r10.length];
        int r12 = 0;
    L6:
        if (r12 >= r10.length) goto L8;
        r11[r12] = r10[r12];
        r12 = r12 + 1;
        goto L6
    L8:
        return r11;
    L10:
        if ((r5 instanceof long[]) == true) goto L12;
        return null;
    L12:
        return (long[]) r5;
    }

    private static int copy(InputStream r5, OutputStream r10) throws IOException {
        byte[] r11 = new byte[8192];
        int r12 = 0;
    L3:
        int r13 = r5.read(r11);
        if (r13 == (-1)) goto L6;
        r12 = r12 + r13;
        r10.write(r11, 0, r13);
        goto L3
    L6:
        return r12;
    }

    @Nullable
    private ExifAttribute getExifAttribute(@NonNull String r5) {
        if (TAG_ISO_SPEED_RATINGS.equals(r5) == false) goto L5;
        r5 = TAG_PHOTOGRAPHIC_SENSITIVITY;
    L5:
        int r10 = 0;
    L7:
        if (r10 >= EXIF_TAGS.length) goto L12;
        ExifAttribute r11 = this.mAttributes[r10].get(r5);
        if (r11 != null) goto L10;
        r10 = r10 + 1;
        goto L7
    L10:
        return r11;
    L12:
        return null;
    }

    private void getJpegAttributes(ByteOrderedDataInputStream r10, int r11, int r12) throws IOException {
        r10.setByteOrder(ByteOrder.BIG_ENDIAN);
        r10.seek(r11);
        byte r5 = r10.readByte();
        if (r5 != (-1)) goto L73;
        if (r10.readByte() != (-40)) goto L71;
        int r13 = r11 + 2;
    L7:
        byte r14 = r10.readByte();
        if (r14 != (-1)) goto L69;
        byte r15 = r10.readByte();
        if (r15 == (-39)) goto L66;
        if (r15 == (-38)) goto L66;
        int r16 = r10.readUnsignedShort();
        int r17 = r16 - 2;
        int r18 = r13 + 4;
        if (r17 < 0) goto L65;
        if (r15 == (-31)) goto L39;
        if (r15 == (-2)) goto L30;
        switch(r15) {
            case -64: goto L26;
            case -63: goto L26;
            case -62: goto L26;
            case -61: goto L26;
            default: goto L21;
        };
    L21:
        switch(r15) {
            case -59: goto L26;
            case -58: goto L26;
            case -57: goto L26;
            default: goto L22;
        };
    L22:
        switch(r15) {
            case -55: goto L26;
            case -54: goto L26;
            case -53: goto L26;
            default: goto L23;
        };
    L23:
        switch(r15) {
            case -51: goto L26;
            case -50: goto L26;
            case -49: goto L26;
            default: goto L50;
        };
    L50:
        if (r17 < 0) goto L57;
        if (r10.skipBytes(r17) != r17) goto L55;
        r13 = r18 + r17;
        goto L7
    L55:
        throw new IOException("Invalid JPEG segment");
    L57:
        throw new IOException("Invalid length");
    L26:
        if (r10.skipBytes(1) != 1) goto L29;
        this.mAttributes[r12].put(TAG_IMAGE_LENGTH, ExifAttribute.createULong(r10.readUnsignedShort(), this.mExifByteOrder));
        this.mAttributes[r12].put(TAG_IMAGE_WIDTH, ExifAttribute.createULong(r10.readUnsignedShort(), this.mExifByteOrder));
        r17 = r16 - 7;
        goto L50
    L29:
        throw new IOException("Invalid SOFx");
    L30:
        byte[] r19 = new byte[r17];
        if (r10.read(r19) != r17) goto L37;
        if (getAttribute(TAG_USER_COMMENT) != null) goto L35;
        this.mAttributes[1].put(TAG_USER_COMMENT, ExifAttribute.createString(new String(r19, ASCII)));
    L35:
        r17 = 0;
        goto L50
    L37:
        throw new IOException("Invalid exif");
    L39:
        if (r17 < 6) goto L50;
        byte[] r20 = new byte[6];
        if (r10.read(r20) != 6) goto L63;
        r18 = r13 + 10;
        int r110 = r16 - 8;
        if (Arrays.equals(r20, IDENTIFIER_EXIF_APP1) == true) goto L46;
        r17 = r110;
        goto L50
    L46:
        if (r110 <= 0) goto L61;
        this.mExifOffset = r18;
        byte[] r21 = new byte[r110];
        if (r10.read(r21) != r110) goto L59;
        r18 = r18 + r110;
        readExifSegment(r21, r12);
        goto L35
    L59:
        throw new IOException("Invalid exif");
    L61:
        throw new IOException("Invalid exif");
    L63:
        throw new IOException("Invalid exif");
    L65:
        throw new IOException("Invalid length");
    L66:
        r10.setByteOrder(this.mExifByteOrder);
        return;
    L69:
        throw new IOException("Invalid marker:" + Integer.toHexString(r14 & 255));
    L71:
        throw new IOException("Invalid marker: " + Integer.toHexString(r5 & 255));
    L73:
        throw new IOException("Invalid marker: " + Integer.toHexString(r5 & 255));
    }

    private int getMimeType(BufferedInputStream r5) throws IOException {
        r5.mark(SIGNATURE_CHECK_SIZE);
        byte[] r10 = new byte[SIGNATURE_CHECK_SIZE];
        r5.read(r10);
        r5.reset();
        if (isJpegFormat(r10) == false) goto L7;
        return 4;
    L7:
        if (isRafFormat(r10) == false) goto L11;
        return 9;
    L11:
        if (isOrfFormat(r10) == false) goto L15;
        return 7;
    L15:
        if (isRw2Format(r10) == false) goto L18;
        return 10;
    L18:
        return 0;
    }

    private void getOrfAttributes(ByteOrderedDataInputStream r10) throws IOException {
        getRawAttributes(r10);
        ExifAttribute r11 = this.mAttributes[1].get(TAG_MAKER_NOTE);
        if (r11 == null) goto L31;
        ByteOrderedDataInputStream r5 = new ByteOrderedDataInputStream(r11.bytes);
        r5.setByteOrder(this.mExifByteOrder);
        byte[] r12 = ORF_MAKER_NOTE_HEADER_1;
        byte[] r13 = new byte[r12.length];
        r5.readFully(r13);
        r5.seek(0);
        byte[] r14 = ORF_MAKER_NOTE_HEADER_2;
        byte[] r15 = new byte[r14.length];
        r5.readFully(r15);
        if (Arrays.equals(r13, r12) == false) goto L8;
        r5.seek(8);
    L10:
        readImageFileDirectory(r5, 6);
        ExifAttribute r16 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_START);
        ExifAttribute r17 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
        if (r16 == null) goto L14;
        if (r17 == null) goto L14;
        this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT, r16);
        this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, r17);
    L14:
        ExifAttribute r18 = this.mAttributes[8].get(TAG_ORF_ASPECT_FRAME);
        if (r18 == null) goto L32;
        int[] r19 = (int[]) r18.getValue(this.mExifByteOrder);
        if (r19 != null) goto L19;
    L29:
        Log.w(TAG, "Invalid aspect frame values. frame=" + Arrays.toString(r19));
        return;
    L19:
        if (r19.length != 4) goto L29;
        int r20 = r19[2];
        int r21 = r19[0];
        if (r20 <= r21) goto L33;
        int r22 = r19[3];
        int r23 = r19[1];
        if (r22 <= r23) goto L34;
        int r24 = (r20 - r21) + 1;
        int r25 = (r22 - r23) + 1;
        if (r24 >= r25) goto L28;
        int r26 = r24 + r25;
        r25 = r26 - r25;
        r24 = r26 - r25;
    L28:
        ExifAttribute r27 = ExifAttribute.createUShort(r24, this.mExifByteOrder);
        ExifAttribute r28 = ExifAttribute.createUShort(r25, this.mExifByteOrder);
        this.mAttributes[0].put(TAG_IMAGE_WIDTH, r27);
        this.mAttributes[0].put(TAG_IMAGE_LENGTH, r28);
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L8:
        if (Arrays.equals(r15, r14) == false) goto L10;
        r5.seek(12);
        goto L10
    }

    private void getRafAttributes(ByteOrderedDataInputStream r10) throws IOException {
        r10.skipBytes(84);
        byte[] r5 = new byte[4];
        byte[] r11 = new byte[4];
        r10.read(r5);
        r10.skipBytes(4);
        r10.read(r11);
        int r12 = ByteBuffer.wrap(r5).getInt();
        int r13 = ByteBuffer.wrap(r11).getInt();
        getJpegAttributes(r10, r12, 5);
        r10.seek(r13);
        r10.setByteOrder(ByteOrder.BIG_ENDIAN);
        int r14 = r10.readInt();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L9;
        int r16 = r10.readUnsignedShort();
        int r17 = r10.readUnsignedShort();
        if (r16 == TAG_RAF_IMAGE_SIZE.number) goto L6;
        r10.skipBytes(r17);
        r15 = r15 + 1;
        goto L3
    L6:
        short r18 = r10.readShort();
        short r19 = r10.readShort();
        ExifAttribute r20 = ExifAttribute.createUShort(r18, this.mExifByteOrder);
        ExifAttribute r21 = ExifAttribute.createUShort(r19, this.mExifByteOrder);
        this.mAttributes[0].put(TAG_IMAGE_LENGTH, r20);
        this.mAttributes[0].put(TAG_IMAGE_WIDTH, r21);
        return;
    }

    private void getRawAttributes(ByteOrderedDataInputStream r5) throws IOException {
        parseTiffHeaders(r5, r5.available());
        readImageFileDirectory(r5, 0);
        updateImageSizeValues(r5, 0);
        updateImageSizeValues(r5, 5);
        updateImageSizeValues(r5, 4);
        validateImages(r5);
        if (this.mMimeType != 8) goto L10;
        ExifAttribute r10 = this.mAttributes[1].get(TAG_MAKER_NOTE);
        if (r10 == null) goto L11;
        ByteOrderedDataInputStream r11 = new ByteOrderedDataInputStream(r10.bytes);
        r11.setByteOrder(this.mExifByteOrder);
        r11.seek(6);
        readImageFileDirectory(r11, 9);
        ExifAttribute r12 = this.mAttributes[9].get(TAG_COLOR_SPACE);
        if (r12 == null) goto L12;
        this.mAttributes[1].put(TAG_COLOR_SPACE, r12);
        return;
    L12:
        return;
    L11:
        return;
    }

    private void getRw2Attributes(ByteOrderedDataInputStream r5) throws IOException {
        getRawAttributes(r5);
        if (this.mAttributes[0].get(TAG_RW2_JPG_FROM_RAW) == null) goto L5;
        getJpegAttributes(r5, this.mRw2JpgFromRawOffset, 5);
    L5:
        ExifAttribute r10 = this.mAttributes[0].get(TAG_RW2_ISO);
        ExifAttribute r11 = this.mAttributes[1].get(TAG_PHOTOGRAPHIC_SENSITIVITY);
        if (r10 == null) goto L10;
        if (r11 != null) goto L11;
        this.mAttributes[1].put(TAG_PHOTOGRAPHIC_SENSITIVITY, r10);
        return;
    L11:
        return;
    }

    private static Pair<Integer, Integer> guessDataFormat(String r10) {
        int r5 = 1;
        if (r10.contains(",") == false) goto L35;
        String[] r11 = r10.split(",", -1);
        Pair<Integer, Integer> r12 = guessDataFormat(r11[0]);
        if (((Integer) r12.first).intValue() != 2) goto L8;
        return r12;
    L8:
        if (r5 >= r11.length) goto L33;
        Pair<Integer, Integer> r13 = guessDataFormat(r11[r5]);
        if (((Integer) r13.first).equals(r12.first) == false) goto L12;
    L15:
        int r14 = ((Integer) r12.first).intValue();
    L17:
        if (((Integer) r12.second).intValue() != (-1)) goto L19;
    L23:
        int r15 = -1;
    L24:
        if (r14 != (-1)) goto L28;
        if (r15 != (-1)) goto L28;
        return new Pair(2, -1);
    L28:
        if (r14 != (-1)) goto L30;
        r12 = new Pair(Integer.valueOf(r15), -1);
    L32:
        r5 = r5 + 1;
        goto L8
    L30:
        if (r15 != (-1)) goto L32;
        r12 = new Pair(Integer.valueOf(r14), -1);
        goto L32
    L19:
        if (((Integer) r13.first).equals(r12.second) == false) goto L21;
    L22:
        r15 = ((Integer) r12.second).intValue();
        goto L24
    L21:
        if (((Integer) r13.second).equals(r12.second) == false) goto L23;
    L12:
        if (((Integer) r13.second).equals(r12.first) == true) goto L15;
        r14 = -1;
        goto L17
    L33:
        return r12;
    L35:
        if (r10.contains("/") == false) goto L73;
        String[] r16 = r10.split("/", -1);
        if (r16.length != 2) goto L55;
        long r17 = (long) Double.parseDouble(r16[0]);     // Catch: NumberFormatException -> L71
        long r18 = (long) Double.parseDouble(r16[1]);     // Catch: NumberFormatException -> L71
        if (r17 < 0) goto L53;
        if (r18 < 0) goto L53;
        if (r17 > 2147483647L) goto L51;
        if (r18 > 2147483647L) goto L51;
        return new Pair(10, 5);
    L51:
        return new Pair(5, -1);
    L53:
        return new Pair(10, -1);
    L55:
        return new Pair(2, -1);
    L73:
        long r19 = Long.parseLong(r10);     // Catch: NumberFormatException -> L67
        if (r19 >= 0) goto L59;
    L62:
        if (r19 >= 0) goto L66;
        return new Pair(9, -1);
    L66:
        return new Pair(4, -1);
    L59:
        if (r19 > WebSocketProtocol.PAYLOAD_SHORT_MAX) goto L62;
        return new Pair(3, 4);
    L67:
        Double.parseDouble(r10);     // Catch: NumberFormatException -> L69
        return new Pair(12, -1);
    L70:
        return new Pair(2, -1);
    }

    private void handleThumbnailFromJfif(ByteOrderedDataInputStream r5, HashMap r10) throws IOException {
        ExifAttribute r11 = (ExifAttribute) r10.get(TAG_JPEG_INTERCHANGE_FORMAT);
        ExifAttribute r12 = (ExifAttribute) r10.get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (r11 == null) goto L25;
        if (r12 == null) goto L26;
        int r13 = r11.getIntValue(this.mExifByteOrder);
        int r14 = Math.min(r12.getIntValue(this.mExifByteOrder), r5.available() - r13);
        int r15 = this.mMimeType;
        if (r15 != 4) goto L8;
    L16:
        int r16 = this.mExifOffset;
    L15:
        r13 = r13 + r16;
    L17:
        if (r13 <= 0) goto L27;
        if (r14 <= 0) goto L28;
        this.mHasThumbnail = true;
        this.mThumbnailOffset = r13;
        this.mThumbnailLength = r14;
        if (this.mFilename == null) goto L22;
        return;
    L22:
        if (this.mAssetInputStream != null) goto L30;
        byte[] r17 = new byte[r14];
        r5.seek(r13);
        r5.readFully(r17);
        this.mThumbnailBytes = r17;
        return;
    L30:
        return;
    L28:
        return;
    L27:
        return;
    L8:
        if (r15 == 9) goto L16;
        if (r15 == 10) goto L16;
        if (r15 != 7) goto L17;
        r16 = this.mOrfMakerNoteOffset;
        goto L15
    L26:
        return;
    }

    private void handleThumbnailFromStrips(ByteOrderedDataInputStream r13, HashMap r14) throws IOException {
        ExifAttribute r5 = (ExifAttribute) r14.get(TAG_STRIP_OFFSETS);
        ExifAttribute r15 = (ExifAttribute) r14.get(TAG_STRIP_BYTE_COUNTS);
        if (r5 == null) goto L28;
        if (r15 == null) goto L29;
        long[] r10 = convertToLongArray(r5.getValue(this.mExifByteOrder));
        long[] r16 = convertToLongArray(r15.getValue(this.mExifByteOrder));
        if (r10 != null) goto L9;
        Log.w(TAG, "stripOffsets should not be null.");
        return;
    L9:
        if (r16 != null) goto L12;
        Log.w(TAG, "stripByteCounts should not be null.");
        return;
    L12:
        int r11 = r16.length;
        long r12 = 0;
        int r17 = 0;
    L13:
        if (r17 >= r11) goto L15;
        r12 = r12 + r16[r17];
        r17 = r17 + 1;
        goto L13
    L15:
        int r18 = (int) r12;
        byte[] r19 = new byte[r18];
        int r20 = 0;
        int r21 = 0;
        int r22 = 0;
    L17:
        if (r20 >= r10.length) goto L22;
        int r23 = (int) r10[r20];
        int r24 = (int) r16[r20];
        int r25 = r23 - r21;
        if (r25 >= 0) goto L21;
        Log.d(TAG, "Invalid strip offset value");
    L21:
        r13.seek(r25);
        int r26 = r21 + r25;
        byte[] r27 = new byte[r24];
        r13.read(r27);
        r21 = r26 + r24;
        System.arraycopy(r27, 0, r19, r22, r24);
        r22 = r22 + r24;
        r20 = r20 + 1;
        goto L17
    L22:
        this.mHasThumbnail = true;
        this.mThumbnailBytes = r19;
        this.mThumbnailLength = r18;
        return;
    L29:
        return;
    }

    private static boolean isJpegFormat(byte[] r5) throws IOException {
        int r10 = 0;
    L3:
        byte[] r11 = JPEG_SIGNATURE;
        if (r10 >= r11.length) goto L9;
        if (r5[r10] != r11[r10]) goto L7;
        r10 = r10 + 1;
        goto L3
    L7:
        return false;
    L9:
        return true;
    }

    private boolean isOrfFormat(byte[] r5) throws IOException {
        ByteOrderedDataInputStream r10 = new ByteOrderedDataInputStream(r5);
        ByteOrder r11 = readByteOrder(r10);
        this.mExifByteOrder = r11;
        r10.setByteOrder(r11);
        short r12 = r10.readShort();
        r10.close();
        if (r12 != 20306) goto L5;
    L8:
        return true;
    L5:
        if (r12 == 21330) goto L8;
        return false;
    }

    private boolean isRafFormat(byte[] r5) throws IOException {
        byte[] r10 = RAF_SIGNATURE.getBytes(Charset.defaultCharset());
        int r11 = 0;
    L4:
        if (r11 >= r10.length) goto L9;
        if (r5[r11] != r10[r11]) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    private boolean isRw2Format(byte[] r5) throws IOException {
        ByteOrderedDataInputStream r10 = new ByteOrderedDataInputStream(r5);
        ByteOrder r11 = readByteOrder(r10);
        this.mExifByteOrder = r11;
        r10.setByteOrder(r11);
        short r12 = r10.readShort();
        r10.close();
        if (r12 != 85) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isSupportedDataType(HashMap r10) throws IOException {
        ExifAttribute r5 = (ExifAttribute) r10.get(TAG_BITS_PER_SAMPLE);
        if (r5 == null) goto L20;
        int[] r11 = (int[]) r5.getValue(this.mExifByteOrder);
        int[] r12 = BITS_PER_SAMPLE_RGB;
        if (Arrays.equals(r12, r11) == false) goto L8;
        return true;
    L8:
        if (this.mMimeType != 3) goto L22;
        ExifAttribute r13 = (ExifAttribute) r10.get(TAG_PHOTOMETRIC_INTERPRETATION);
        if (r13 == null) goto L23;
        int r14 = r13.getIntValue(this.mExifByteOrder);
        if (r14 != 1) goto L16;
        if (Arrays.equals(r11, BITS_PER_SAMPLE_GREYSCALE_2) == false) goto L16;
    L19:
        return true;
    L16:
        if (r14 == 6) goto L18;
        return false;
    L18:
        if (Arrays.equals(r11, r12) == true) goto L19;
        return false;
    L23:
        return false;
    L22:
        return false;
    L20:
        return false;
    }

    private boolean isThumbnail(HashMap r5) throws IOException {
        ExifAttribute r10 = (ExifAttribute) r5.get(TAG_IMAGE_LENGTH);
        ExifAttribute r11 = (ExifAttribute) r5.get(TAG_IMAGE_WIDTH);
        if (r10 == null) goto L10;
        if (r11 == null) goto L12;
        int r12 = r10.getIntValue(this.mExifByteOrder);
        int r13 = r11.getIntValue(this.mExifByteOrder);
        if (r12 > 512) goto L13;
        if (r13 > 512) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L12:
        return false;
    L10:
        return false;
    }

    private void loadAttributes(@NonNull InputStream r5) throws IOException {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            r0 = 0
            r1 = r0
        L2:
            androidx.exifinterface.media.ExifInterface$ExifTag[][] r2 = androidx.exifinterface.media.ExifInterface.EXIF_TAGS     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L4a
            int r2 = r2.length     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L4a
            if (r1 >= r2) goto L15
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r4.mAttributes     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L4a
            java.util.HashMap r3 = new java.util.HashMap     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L4a
            r3.<init>()     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L4a
            r2[r1] = r3     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L4a
            int r1 = r1 + 1
            goto L2
        L13:
            r5 = move-exception
            goto L4e
        L15:
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L4a
            r2 = 5000(0x1388, float:7.006E-42)
            r1.<init>(r5, r2)     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L4a
            int r5 = r4.getMimeType(r1)     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L4a
            r4.mMimeType = r5     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L4a
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r5 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L4a
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L4a
            int r1 = r4.mMimeType     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L4a
            switch(r1) {
                case 0: goto L3d;
                case 1: goto L3d;
                case 2: goto L3d;
                case 3: goto L3d;
                case 4: goto L39;
                case 5: goto L3d;
                case 6: goto L3d;
                case 7: goto L35;
                case 8: goto L3d;
                case 9: goto L31;
                case 10: goto L2d;
                case 11: goto L3d;
                default: goto L2c;
            }     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L4a
        L2c:
            goto L40
        L2d:
            r4.getRw2Attributes(r5)     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L4a
            goto L40
        L31:
            r4.getRafAttributes(r5)     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L4a
            goto L40
        L35:
            r4.getOrfAttributes(r5)     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L4a
            goto L40
        L39:
            r4.getJpegAttributes(r5, r0, r0)     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L4a
            goto L40
        L3d:
            r4.getRawAttributes(r5)     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L4a
        L40:
            r4.setThumbnailData(r5)     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L4a
            r5 = 1
            r4.mIsSupportedFile = r5     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L4a
        L46:
            r4.addDefaultValuesForCompatibility()
            goto L4d
        L4a:
            r4.mIsSupportedFile = r0     // Catch: java.lang.Throwable -> L13
            goto L46
        L4d:
            return
        L4e:
            r4.addDefaultValuesForCompatibility()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.loadAttributes(java.io.InputStream):void");
    }

    private void parseTiffHeaders(ByteOrderedDataInputStream r5, int r10) throws IOException {
        ByteOrder r11 = readByteOrder(r5);
        this.mExifByteOrder = r11;
        r5.setByteOrder(r11);
        int r12 = r5.readUnsignedShort();
        int r13 = this.mMimeType;
        if (r13 != 7) goto L5;
    L11:
        int r14 = r5.readInt();
        if (r14 < 8) goto L23;
        if (r14 >= r10) goto L23;
        int r15 = r14 - 8;
        if (r15 > 0) goto L17;
        return;
    L17:
        if (r5.skipBytes(r15) != r15) goto L20;
        return;
    L20:
        throw new IOException(j0.g(r15, "Couldn't jump to first Ifd: "));
    L23:
        throw new IOException(j0.g(r14, "Invalid first Ifd offset: "));
    L5:
        if (r13 == 10) goto L11;
        if (r12 == 42) goto L11;
        throw new IOException("Invalid start code: " + Integer.toHexString(r12));
    }

    private void printAttributes() {
        int r5 = 0;
    L4:
        if (r5 >= this.mAttributes.length) goto L10;
        StringBuilder r10 = j0.s(r5, "The size of tag group[", "]: ");
        r10.append(this.mAttributes[r5].size());
        Log.d(TAG, r10.toString());
        Iterator<Map.Entry<String, ExifAttribute>> r11 = this.mAttributes[r5].entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        Map.Entry<String, ExifAttribute> r12 = r11.next();
        ExifAttribute r13 = r12.getValue();
        Log.d(TAG, "tagName: " + r12.getKey() + ", tagType: " + r13.toString() + ", tagValue: '" + r13.getStringValue(this.mExifByteOrder) + "'");
        goto L7
    L9:
        r5 = r5 + 1;
        goto L4
    }

    private ByteOrder readByteOrder(ByteOrderedDataInputStream r5) throws IOException {
        short r10 = r5.readShort();
        if (r10 == 18761) goto L11;
        if (r10 != 19789) goto L9;
        return ByteOrder.BIG_ENDIAN;
    L9:
        throw new IOException("Invalid byte order: " + Integer.toHexString(r10));
    L11:
        return ByteOrder.LITTLE_ENDIAN;
    }

    private void readExifSegment(byte[] r5, int r10) throws IOException {
        ByteOrderedDataInputStream r11 = new ByteOrderedDataInputStream(r5);
        parseTiffHeaders(r11, r5.length);
        readImageFileDirectory(r11, r10);
    }

    private void readImageFileDirectory(ByteOrderedDataInputStream r24, int r25) throws IOException {
        this.mAttributesOffsets.add(Integer.valueOf(r24.mPosition));
        if ((r24.mPosition + 2) <= r24.mLength) goto L5;
        return;
    L5:
        short r5 = r24.readShort();
        if (((r5 * 12) + r24.mPosition) > r24.mLength) goto L129;
        if (r5 <= 0) goto L135;
        short r10 = 0;
    L11:
        if (r10 >= r5) goto L107;
        int r11 = r24.readUnsignedShort();
        int r12 = r24.readUnsignedShort();
        int r13 = r24.readInt();
        long r14 = ((long) r24.peek()) + 4;
        ExifTag r15 = sExifTagMapsForReading[r25].get(Integer.valueOf(r11));
        if (r15 != null) goto L16;
        Log.w(TAG, "Skip the tag entry since tag number is not defined: " + r11);
    L15:
        String r16 = TAG;
    L34:
        long r17 = 0;
    L32:
        boolean r18 = false;
    L35:
        if (r18 == true) goto L38;
        r24.seek(r14);
        short r19 = r5;
    L105:
        r10 = (short) (r10 + 1);
        r5 = r19;
        goto L11
    L38:
        if (r17 <= 4) goto L59;
        int r20 = r24.readInt();
        int r110 = this.mMimeType;
        r19 = r5;
        if (r110 == 7) goto L42;
        int r21 = r12;
        int r111 = r13;
        long r22 = r14;
        if (r110 == 10) goto L53;
    L55:
        long r112 = r20;
        if ((r112 + r17) > r24.mLength) goto L58;
        r24.seek(r112);
        r14 = r22;
    L60:
        Integer r23 = sExifPointerTagMap.get(Integer.valueOf(r11));
        if (r23 == null) goto L88;
        int r113 = r21;
        if (r113 != 3) goto L65;
        int r26 = r24.readUnsignedShort();
    L74:
        long r27 = r26;
    L79:
        if (r27 > 0) goto L81;
    L86:
        Log.w(r16, "Skip jump into the IFD since its offset is invalid: " + r27);
    L87:
        r24.seek(r14);
        goto L105
    L81:
        if (r27 >= r24.mLength) goto L86;
        if (this.mAttributesOffsets.contains(Integer.valueOf((int) r27)) == true) goto L85;
        r24.seek(r27);
        readImageFileDirectory(r24, r23.intValue());
        goto L87
    L85:
        Log.w(r16, "Skip jump into the IFD since it has already been read: IfdType " + r23 + " (at " + r27 + ")");
        goto L87
    L65:
        if (r113 == 4) goto L76;
        if (r113 != 8) goto L68;
        r26 = r24.readShort();
        goto L74
    L68:
        if (r113 != 9) goto L70;
    L73:
        r26 = r24.readInt();
        goto L74
    L70:
        if (r113 == 13) goto L73;
        r27 = -1;
        goto L79
    L76:
        r27 = r24.readUnsignedInt();
        goto L79
    L88:
        byte[] r28 = new byte[(int) r17];
        r24.readFully(r28);
        ExifAttribute r29 = new ExifAttribute(r21, r111, r28);
        this.mAttributes[r25].put(r15.name, r29);
        if (TAG_DNG_VERSION.equals(r15.name) == false) goto L92;
        this.mMimeType = 3;
    L92:
        if (TAG_MAKE.equals(r15.name) == true) goto L96;
        if (TAG_MODEL.equals(r15.name) == true) goto L96;
    L98:
        if (TAG_COMPRESSION.equals(r15.name) == false) goto L103;
        if (r29.getIntValue(this.mExifByteOrder) != 65535) goto L103;
    L101:
        this.mMimeType = 8;
    L103:
        if (r24.peek() == r14) goto L105;
        r24.seek(r14);
    L96:
        if (r29.getStringValue(this.mExifByteOrder).contains(PEF_SIGNATURE) == true) goto L101;
    L58:
        Log.w(r16, "Skip the tag entry since data offset is invalid: " + r20);
        r24.seek(r22);
        goto L105
    L53:
        if (TAG_RW2_JPG_FROM_RAW.equals(r15.name) == false) goto L55;
        this.mRw2JpgFromRawOffset = r20;
        goto L55
    L42:
        if (TAG_MAKER_NOTE.equals(r15.name) == false) goto L46;
        this.mOrfMakerNoteOffset = r20;
    L44:
        r21 = r12;
        r111 = r13;
        r22 = r14;
        goto L55
    L46:
        if (r25 != 6) goto L44;
        if (TAG_ORF_THUMBNAIL_IMAGE.equals(r15.name) == false) goto L44;
        this.mOrfThumbnailOffset = r20;
        this.mOrfThumbnailLength = r13;
        ExifAttribute r30 = ExifAttribute.createUShort(6, this.mExifByteOrder);
        r21 = r12;
        r111 = r13;
        ExifAttribute r114 = ExifAttribute.createULong(this.mOrfThumbnailOffset, this.mExifByteOrder);
        r22 = r14;
        ExifAttribute r115 = ExifAttribute.createULong(this.mOrfThumbnailLength, this.mExifByteOrder);
        this.mAttributes[4].put(TAG_COMPRESSION, r30);
        this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT, r114);
        this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, r115);
        goto L55
    L59:
        r19 = r5;
        r21 = r12;
        r111 = r13;
        goto L60
    L16:
        if (r12 <= 0) goto L19;
        int[] r31 = IFD_FORMAT_BYTES_PER_FORMAT;
        if (r12 >= r31.length) goto L19;
        if (r15.isFormatCompatible(r12) == true) goto L23;
        Log.w(TAG, "Skip the tag entry since data format (" + IFD_FORMAT_NAMES[r12] + ") is unexpected for tag: " + r15.name);
        goto L15
    L23:
        if (r12 != 7) goto L25;
        r12 = r15.primaryFormat;
    L25:
        r16 = TAG;
        r10 = r10;
        r17 = r31[r12] * ((long) r13);
        if (r17 >= 0) goto L28;
    L31:
        Log.w(r16, "Skip the tag entry since the number of components is invalid: " + r13);
        goto L32
    L28:
        if (r17 > 2147483647L) goto L31;
        r18 = true;
    L19:
        r16 = TAG;
        Log.w(r16, "Skip the tag entry since data format is invalid: " + r12);
        goto L34
    L107:
        if ((r24.peek() + 4) > r24.mLength) goto L130;
        int r32 = r24.readInt();
        long r33 = r32;
        if (r33 > 0) goto L111;
    L121:
        Log.w(TAG, "Stop reading file since a wrong offset may cause an infinite loop: " + r32);
        return;
    L111:
        if (r32 >= r24.mLength) goto L121;
        if (this.mAttributesOffsets.contains(Integer.valueOf(r32)) == true) goto L120;
        r24.seek(r33);
        if (this.mAttributes[4].isEmpty() == false) goto L118;
        readImageFileDirectory(r24, 4);
        return;
    L118:
        if (this.mAttributes[5].isEmpty() == false) goto L132;
        readImageFileDirectory(r24, 5);
        return;
    L132:
        return;
    L120:
        Log.w(TAG, "Stop reading file since re-reading an IFD may cause an infinite loop: " + r32);
        return;
    L130:
        return;
    L135:
        return;
    }

    private void removeAttribute(String r5) {
        int r10 = 0;
    L4:
        if (r10 >= EXIF_TAGS.length) goto L6;
        this.mAttributes[r10].remove(r5);
        r10 = r10 + 1;
        goto L4
    }

    private void retrieveJpegImageSize(ByteOrderedDataInputStream r5, int r10) throws IOException {
        ExifAttribute r11 = this.mAttributes[r10].get(TAG_IMAGE_LENGTH);
        ExifAttribute r12 = this.mAttributes[r10].get(TAG_IMAGE_WIDTH);
        if (r11 == null) goto L5;
        if (r12 == null) goto L5;
        return;
    L5:
        ExifAttribute r13 = this.mAttributes[r10].get(TAG_JPEG_INTERCHANGE_FORMAT);
        if (r13 == null) goto L10;
        getJpegAttributes(r5, r13.getIntValue(this.mExifByteOrder), r10);
        return;
    }

    private void saveJpegAttributes(InputStream r13, OutputStream r14) throws IOException {
        DataInputStream r5 = new DataInputStream(r13);
        ByteOrderedDataOutputStream r15 = new ByteOrderedDataOutputStream(r14, ByteOrder.BIG_ENDIAN);
        if (r5.readByte() != (-1)) goto L54;
        r15.writeByte(-1);
        if (r5.readByte() != (-40)) goto L52;
        r15.writeByte(-40);
        r15.writeByte(-1);
        r15.writeByte(-31);
        writeExifSegment(r15, 6);
        byte[] r10 = new byte[4096];
    L8:
        if (r5.readByte() != (-1)) goto L50;
        byte r11 = r5.readByte();
        if (r11 == (-39)) goto L47;
        if (r11 == (-38)) goto L47;
        if (r11 != (-31)) goto L15;
        int r12 = r5.readUnsignedShort();
        int r16 = r12 - 2;
        if (r16 < 0) goto L46;
        byte[] r17 = new byte[6];
        if (r16 < 6) goto L38;
        if (r5.read(r17) != 6) goto L37;
        if (Arrays.equals(r17, IDENTIFIER_EXIF_APP1) == false) goto L38;
        int r18 = r12 - 8;
        if (r5.skipBytes(r18) == r18) goto L8;
        throw new IOException("Invalid length");
    L37:
        throw new IOException("Invalid exif");
    L38:
        r15.writeByte(-1);
        r15.writeByte(r11);
        r15.writeUnsignedShort(r12);
        if (r16 < 6) goto L41;
        r16 = r12 - 8;
        r15.write(r17);
    L41:
        if (r16 <= 0) goto L8;
        int r19 = r5.read(r10, 0, Math.min(r16, 4096));
        if (r19 < 0) goto L8;
        r15.write(r10, 0, r19);
        r16 = r16 - r19;
        goto L41
    L46:
        throw new IOException("Invalid length");
    L15:
        r15.writeByte(-1);
        r15.writeByte(r11);
        int r20 = r5.readUnsignedShort();
        r15.writeUnsignedShort(r20);
        int r21 = r20 - 2;
        if (r21 < 0) goto L22;
    L17:
        if (r21 <= 0) goto L8;
        int r22 = r5.read(r10, 0, Math.min(r21, 4096));
        if (r22 < 0) goto L8;
        r15.write(r10, 0, r22);
        r21 = r21 - r22;
        goto L17
    L22:
        throw new IOException("Invalid length");
    L47:
        r15.writeByte(-1);
        r15.writeByte(r11);
        copy(r5, r15);
        return;
    L50:
        throw new IOException("Invalid marker");
    L52:
        throw new IOException("Invalid marker");
    L54:
        throw new IOException("Invalid marker");
    }

    private void setThumbnailData(ByteOrderedDataInputStream r5) throws IOException {
        HashMap<String, ExifAttribute> r10 = this.mAttributes[4];
        ExifAttribute r11 = r10.get(TAG_COMPRESSION);
        if (r11 == null) goto L14;
        int r12 = r11.getIntValue(this.mExifByteOrder);
        this.mThumbnailCompression = r12;
        if (r12 == 1) goto L12;
        if (r12 != 6) goto L8;
        handleThumbnailFromJfif(r5, r10);
        return;
    L8:
        if (r12 == 7) goto L12;
        return;
    L12:
        if (isSupportedDataType(r10) == false) goto L17;
        handleThumbnailFromStrips(r5, r10);
        return;
    L17:
        return;
    L14:
        this.mThumbnailCompression = 6;
        handleThumbnailFromJfif(r5, r10);
    }

    private void swapBasedOnImageSize(int r10, int r11) throws IOException {
        if (this.mAttributes[r10].isEmpty() == false) goto L5;
        return;
    L5:
        if (this.mAttributes[r11].isEmpty() == true) goto L24;
        ExifAttribute r5 = this.mAttributes[r10].get(TAG_IMAGE_LENGTH);
        ExifAttribute r12 = this.mAttributes[r10].get(TAG_IMAGE_WIDTH);
        ExifAttribute r13 = this.mAttributes[r11].get(TAG_IMAGE_LENGTH);
        ExifAttribute r14 = this.mAttributes[r11].get(TAG_IMAGE_WIDTH);
        if (r5 == null) goto L20;
        if (r12 == null) goto L25;
        if (r13 == null) goto L21;
        if (r14 == null) goto L26;
        int r15 = r5.getIntValue(this.mExifByteOrder);
        int r16 = r12.getIntValue(this.mExifByteOrder);
        int r17 = r13.getIntValue(this.mExifByteOrder);
        int r18 = r14.getIntValue(this.mExifByteOrder);
        if (r15 >= r17) goto L22;
        if (r16 >= r18) goto L23;
        HashMap<String, ExifAttribute>[] r19 = this.mAttributes;
        HashMap<String, ExifAttribute> r20 = r19[r10];
        r19[r10] = r19[r11];
        r19[r11] = r20;
        return;
    L23:
        return;
    L22:
        return;
    L26:
        return;
    L21:
        return;
    L25:
        return;
    L20:
        return;
    }

    private boolean updateAttribute(String r5, ExifAttribute r10) {
        int r11 = 0;
        boolean r12 = false;
    L4:
        if (r11 >= EXIF_TAGS.length) goto L9;
        if (this.mAttributes[r11].containsKey(r5) == false) goto L8;
        this.mAttributes[r11].put(r5, r10);
        r12 = true;
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        return r12;
    }

    private void updateImageSizeValues(ByteOrderedDataInputStream r10, int r11) throws IOException {
        ExifAttribute r5 = this.mAttributes[r11].get(TAG_DEFAULT_CROP_SIZE);
        ExifAttribute r12 = this.mAttributes[r11].get(TAG_RW2_SENSOR_TOP_BORDER);
        ExifAttribute r13 = this.mAttributes[r11].get(TAG_RW2_SENSOR_LEFT_BORDER);
        ExifAttribute r14 = this.mAttributes[r11].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
        ExifAttribute r15 = this.mAttributes[r11].get(TAG_RW2_SENSOR_RIGHT_BORDER);
        if (r5 != null) goto L5;
        if (r12 == null) goto L31;
        if (r13 == null) goto L31;
        if (r14 == null) goto L31;
        if (r15 == null) goto L31;
        int r16 = r12.getIntValue(this.mExifByteOrder);
        int r17 = r14.getIntValue(this.mExifByteOrder);
        int r18 = r15.getIntValue(this.mExifByteOrder);
        int r19 = r13.getIntValue(this.mExifByteOrder);
        if (r17 <= r16) goto L34;
        if (r18 <= r19) goto L35;
        ExifAttribute r110 = ExifAttribute.createUShort(r17 - r16, this.mExifByteOrder);
        ExifAttribute r20 = ExifAttribute.createUShort(r18 - r19, this.mExifByteOrder);
        this.mAttributes[r11].put(TAG_IMAGE_LENGTH, r110);
        this.mAttributes[r11].put(TAG_IMAGE_WIDTH, r20);
        return;
    L35:
        return;
    L34:
        return;
    L31:
        retrieveJpegImageSize(r10, r11);
        return;
    L5:
        if (r5.format != 5) goto L14;
        Rational[] r111 = (Rational[]) r5.getValue(this.mExifByteOrder);
        if (r111 != null) goto L9;
    L12:
        Log.w(TAG, "Invalid crop size values. cropSize=" + Arrays.toString(r111));
        return;
    L9:
        if (r111.length != 2) goto L12;
        ExifAttribute r21 = ExifAttribute.createURational(r111[0], this.mExifByteOrder);
        ExifAttribute r112 = ExifAttribute.createURational(r111[1], this.mExifByteOrder);
    L20:
        this.mAttributes[r11].put(TAG_IMAGE_WIDTH, r21);
        this.mAttributes[r11].put(TAG_IMAGE_LENGTH, r112);
        return;
    L14:
        int[] r113 = (int[]) r5.getValue(this.mExifByteOrder);
        if (r113 != null) goto L17;
    L21:
        Log.w(TAG, "Invalid crop size values. cropSize=" + Arrays.toString(r113));
        return;
    L17:
        if (r113.length != 2) goto L21;
        r21 = ExifAttribute.createUShort(r113[0], this.mExifByteOrder);
        r112 = ExifAttribute.createUShort(r113[1], this.mExifByteOrder);
        goto L20
    }

    private void validateImages(InputStream r10) throws IOException {
        swapBasedOnImageSize(0, 5);
        swapBasedOnImageSize(0, 4);
        swapBasedOnImageSize(5, 4);
        ExifAttribute r5 = this.mAttributes[1].get(TAG_PIXEL_X_DIMENSION);
        ExifAttribute r11 = this.mAttributes[1].get(TAG_PIXEL_Y_DIMENSION);
        if (r5 == null) goto L7;
        if (r11 == null) goto L7;
        this.mAttributes[0].put(TAG_IMAGE_WIDTH, r5);
        this.mAttributes[0].put(TAG_IMAGE_LENGTH, r11);
    L7:
        if (this.mAttributes[4].isEmpty() == false) goto L12;
        if (isThumbnail(this.mAttributes[5]) == false) goto L12;
        HashMap<String, ExifAttribute>[] r12 = this.mAttributes;
        r12[4] = r12[5];
        r12[5] = new HashMap();
    L12:
        if (isThumbnail(this.mAttributes[4]) == true) goto L15;
        Log.d(TAG, "No image meets the size requirements of a thumbnail image.");
        return;
    }

    private int writeExifSegment(ByteOrderedDataOutputStream r17, int r18) throws IOException {
        ExifTag[][] r5 = EXIF_TAGS;
        int[] r10 = new int[r5.length];
        int[] r11 = new int[r5.length];
        ExifTag[] r12 = EXIF_POINTER_TAGS;
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        removeAttribute(r12[r14].name);
        r14 = r14 + 1;
        goto L3
    L5:
        removeAttribute(JPEG_INTERCHANGE_FORMAT_TAG.name);
        removeAttribute(JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name);
        int r15 = 0;
    L7:
        if (r15 >= EXIF_TAGS.length) goto L16;
        Object[] r16 = this.mAttributes[r15].entrySet().toArray();
        int r19 = r16.length;
        int r20 = 0;
    L9:
        if (r20 >= r19) goto L14;
        Map.Entry r21 = (Map.Entry) r16[r20];
        if (r21.getValue() != null) goto L13;
        this.mAttributes[r15].remove(r21.getKey());
    L13:
        r20 = r20 + 1;
        goto L9
    L14:
        r15 = r15 + 1;
        goto L7
    L16:
        if (this.mAttributes[1].isEmpty() == true) goto L19;
        this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(0, this.mExifByteOrder));
    L19:
        if (this.mAttributes[2].isEmpty() == true) goto L22;
        this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(0, this.mExifByteOrder));
    L22:
        if (this.mAttributes[3].isEmpty() == true) goto L25;
        this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(0, this.mExifByteOrder));
    L25:
        if (this.mHasThumbnail == false) goto L27;
        this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_TAG.name, ExifAttribute.createULong(0, this.mExifByteOrder));
        this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name, ExifAttribute.createULong(this.mThumbnailLength, this.mExifByteOrder));
    L27:
        int r22 = 0;
    L29:
        if (r22 >= EXIF_TAGS.length) goto L37;
        Iterator<Map.Entry<String, ExifAttribute>> r110 = this.mAttributes[r22].entrySet().iterator();
        int r111 = 0;
    L32:
        if (r110.hasNext() == false) goto L36;
        int r112 = r110.next().getValue().size();
        if (r112 <= 4) goto L32;
        r111 = r111 + r112;
        goto L32
    L36:
        r11[r22] = r11[r22] + r111;
        r22 = r22 + 1;
        goto L29
    L37:
        int r113 = 8;
        int r114 = 0;
    L39:
        if (r114 >= EXIF_TAGS.length) goto L45;
        if (this.mAttributes[r114].isEmpty() == true) goto L43;
        r10[r114] = r113;
        r113 = r113 + (((this.mAttributes[r114].size() * 12) + 6) + r11[r114]);
    L43:
        r114 = r114 + 1;
        goto L39
    L45:
        if (this.mHasThumbnail == false) goto L47;
        this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_TAG.name, ExifAttribute.createULong(r113, this.mExifByteOrder));
        this.mThumbnailOffset = r18 + r113;
        r113 = r113 + this.mThumbnailLength;
    L47:
        int r115 = r113 + 8;
        if (this.mAttributes[1].isEmpty() == true) goto L51;
        this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(r10[1], this.mExifByteOrder));
    L51:
        if (this.mAttributes[2].isEmpty() == true) goto L54;
        this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(r10[2], this.mExifByteOrder));
    L54:
        if (this.mAttributes[3].isEmpty() == true) goto L56;
        this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(r10[3], this.mExifByteOrder));
    L56:
        r17.writeUnsignedShort(r115);
        r17.write(IDENTIFIER_EXIF_APP1);
        if (this.mExifByteOrder != ByteOrder.BIG_ENDIAN) goto L59;
        short r23 = BYTE_ALIGN_MM;
    L60:
        r17.writeShort(r23);
        r17.setByteOrder(this.mExifByteOrder);
        r17.writeUnsignedShort(42);
        r17.writeUnsignedInt(8);
        int r24 = 0;
    L62:
        if (r24 >= EXIF_TAGS.length) goto L89;
        if (this.mAttributes[r24].isEmpty() == true) goto L87;
        r17.writeUnsignedShort(this.mAttributes[r24].size());
        int r25 = ((this.mAttributes[r24].size() * 12) + (r10[r24] + 2)) + 4;
        Iterator<Map.Entry<String, ExifAttribute>> r26 = this.mAttributes[r24].entrySet().iterator();
    L67:
        if (r26.hasNext() == false) goto L75;
        Map.Entry<String, ExifAttribute> r27 = r26.next();
        int r28 = sExifTagMapsForWriting[r24].get(r27.getKey()).number;
        ExifAttribute r29 = r27.getValue();
        int r116 = r29.size();
        r17.writeUnsignedShort(r28);
        r17.writeUnsignedShort(r29.format);
        r17.writeInt(r29.numberOfComponents);
        if (r116 > 4) goto L70;
        r17.write(r29.bytes);
        if (r116 >= 4) goto L67;
    L73:
        if (r116 >= 4) goto L67;
        r17.writeByte(0);
        r116 = r116 + 1;
        goto L73
    L70:
        r17.writeUnsignedInt(r25);
        r25 = r25 + r116;
        goto L67
    L75:
        if (r24 == 0) goto L77;
    L79:
        r17.writeUnsignedInt(0);
    L80:
        Iterator<Map.Entry<String, ExifAttribute>> r30 = this.mAttributes[r24].entrySet().iterator();
    L82:
        if (r30.hasNext() == false) goto L87;
        byte[] r31 = r30.next().getValue().bytes;
        if (r31.length <= 4) goto L82;
        r17.write(r31, 0, r31.length);
        goto L82
    L77:
        if (this.mAttributes[4].isEmpty() == true) goto L79;
        r17.writeUnsignedInt(r10[4]);
    L87:
        r24 = r24 + 1;
        goto L62
    L89:
        if (this.mHasThumbnail == false) goto L91;
        r17.write(getThumbnailBytes());
    L91:
        r17.setByteOrder(ByteOrder.BIG_ENDIAN);
        return r115;
    L59:
        r23 = BYTE_ALIGN_II;
        goto L60
    }

    public void flipHorizontally() {
        int r5 = 1;
        switch(getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1: goto L11;
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        r5 = 0;
        goto L12
    L5:
        r5 = 7;
        goto L12
    L6:
        r5 = 8;
        goto L12
    L7:
        r5 = 5;
        goto L12
    L8:
        r5 = 6;
        goto L12
    L9:
        r5 = 3;
        goto L12
    L10:
        r5 = 4;
        goto L12
    L11:
        r5 = 2;
    L12:
        setAttribute(TAG_ORIENTATION, Integer.toString(r5));
    }

    public void flipVertically() {
        int r5 = 1;
        switch(getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L12;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        r5 = 0;
        goto L12
    L5:
        r5 = 5;
        goto L12
    L6:
        r5 = 6;
        goto L12
    L7:
        r5 = 7;
        goto L12
    L8:
        r5 = 8;
        goto L12
    L9:
        r5 = 2;
        goto L12
    L10:
        r5 = 3;
        goto L12
    L11:
        r5 = 4;
    L12:
        setAttribute(TAG_ORIENTATION, Integer.toString(r5));
    }

    public double getAltitude(double r10) {
        double r5 = getAttributeDouble(TAG_GPS_ALTITUDE, -1.0d);
        int r11 = -1;
        int r12 = getAttributeInt(TAG_GPS_ALTITUDE_REF, -1);
        if (r5 < 0.0d) goto L11;
        if (r12 < 0) goto L11;
        if (r12 == 1) goto L10;
        r11 = 1;
    L10:
        return r5 * ((double) r11);
    L11:
        return r10;
    }

    @Nullable
    public String getAttribute(@NonNull String r5) {
        ExifAttribute r10 = getExifAttribute(r5);
        if (r10 != null) goto L5;
    L27:
        return null;
    L5:
        if (sTagSetForCompatibility.contains(r5) == true) goto L9;
        return r10.getStringValue(this.mExifByteOrder);
    L9:
        if (r5.equals(TAG_GPS_TIMESTAMP) == false) goto L29;
        int r11 = r10.format;
        if (r11 != 5) goto L13;
    L16:
        Rational[] r12 = (Rational[]) r10.getValue(this.mExifByteOrder);
        if (r12 != null) goto L19;
    L23:
        Log.w(TAG, "Invalid GPS Timestamp array. array=" + Arrays.toString(r12));
        return null;
    L19:
        if (r12.length != 3) goto L23;
        Rational r13 = r12[0];
        Integer r14 = Integer.valueOf((int) (r13.numerator / r13.denominator));
        Rational r15 = r12[1];
        Integer r16 = Integer.valueOf((int) (r15.numerator / r15.denominator));
        Rational r17 = r12[2];
        return String.format("%02d:%02d:%02d", new Object[]{r14, r16, Integer.valueOf((int) (r17.numerator / r17.denominator))});
    L13:
        if (r11 == 10) goto L16;
        Log.w(TAG, "GPS Timestamp format is not rational. format=" + r10.format);
        return null;
    L29:
        return Double.toString(r10.getDoubleValue(this.mExifByteOrder));
    }

    public double getAttributeDouble(@NonNull String r5, double r10) {
        ExifAttribute r11 = getExifAttribute(r5);
        if (r11 != null) goto L8;
        return r10;
    L8:
        return r11.getDoubleValue(this.mExifByteOrder);
    L7:
        return r10;
    }

    public int getAttributeInt(@NonNull String r5, int r10) {
        ExifAttribute r11 = getExifAttribute(r5);
        if (r11 != null) goto L8;
        return r10;
    L8:
        return r11.getIntValue(this.mExifByteOrder);
    L7:
        return r10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long getDateTime() {
        String r5 = getAttribute(TAG_DATETIME);
        if (r5 != null) goto L5;
    L20:
        return -1;
    L5:
        if (sNonZeroTimePattern.matcher(r5).matches() == false) goto L20;
        ParsePosition r10 = new ParsePosition(0);
        Date r11 = sFormatter.parse(r5, r10);     // Catch: IllegalArgumentException -> L22
        if (r11 != null) goto L11;
        return -1;
    L11:
        long r12 = r11.getTime();     // Catch: IllegalArgumentException -> L22
        String r13 = getAttribute(TAG_SUBSEC_TIME);     // Catch: IllegalArgumentException -> L22
        if (r13 == null) goto L28;
        long r14 = Long.parseLong(r13);     // Catch: NumberFormatException -> L21 IllegalArgumentException -> L22
    L15:
        if (r14 <= 1000) goto L19;
        r14 = r14 / 10;     // Catch: NumberFormatException -> L21 IllegalArgumentException -> L22
    L19:
        return r12 + r14;
    L29:
        return r12;
    L28:
        return r12;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long getGpsDateTime() {
        String r5 = getAttribute(TAG_GPS_DATESTAMP);
        String r10 = getAttribute(TAG_GPS_TIMESTAMP);
        if (r5 == null) goto L16;
        if (r10 == null) goto L16;
        Pattern r11 = sNonZeroTimePattern;
        if (r11.matcher(r5).matches() == false) goto L8;
    L10:
        String r12 = a.m(r5, ' ', r10);
        ParsePosition r13 = new ParsePosition(0);
        Date r14 = sFormatter.parse(r12, r13);     // Catch: IllegalArgumentException -> L17
        if (r14 != null) goto L14;
        return -1;
    L14:
        return r14.getTime();
    L8:
        if (r11.matcher(r10).matches() == true) goto L10;
    L16:
        return -1;
    }

    @Deprecated
    public boolean getLatLong(float[] r5) {
        double[] r10 = getLatLong();
        if (r10 != null) goto L5;
        return false;
    L5:
        r5[0] = (float) r10[0];
        r5[1] = (float) r10[1];
        return true;
    }

    public int getRotationDegrees() {
        switch(getAttributeInt(TAG_ORIENTATION, 1)) {
            case 3: goto L10;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L8;
            default: goto L4;
        };
    L4:
        return 0;
    L6:
        return 90;
    L8:
        return 270;
    L10:
        return 180;
    }

    @Nullable
    public byte[] getThumbnail() {
        int r5 = this.mThumbnailCompression;
        if (r5 == 6) goto L10;
        if (r5 == 7) goto L10;
        return null;
    L10:
        return getThumbnailBytes();
    }

    @Nullable
    public Bitmap getThumbnailBitmap() {
        if (this.mHasThumbnail == true) goto L6;
        return null;
    L6:
        if (this.mThumbnailBytes != null) goto L8;
        this.mThumbnailBytes = getThumbnailBytes();
    L8:
        int r5 = this.mThumbnailCompression;
        int r10 = 0;
        if (r5 == 6) goto L25;
        if (r5 == 7) goto L25;
        if (r5 != 1) goto L23;
        int r11 = this.mThumbnailBytes.length / 3;
        int[] r12 = new int[r11];
    L16:
        if (r10 >= r11) goto L18;
        byte[] r13 = this.mThumbnailBytes;
        int r14 = r10 * 3;
        r12[r10] = ((r13[r14] << 16) + (r13[r14 + 1] << 8)) + r13[r14 + 2];
        r10 = r10 + 1;
        goto L16
    L18:
        ExifAttribute r15 = this.mAttributes[4].get(TAG_IMAGE_LENGTH);
        ExifAttribute r16 = this.mAttributes[4].get(TAG_IMAGE_WIDTH);
        if (r15 == null) goto L23;
        if (r16 == null) goto L23;
        int r17 = r15.getIntValue(this.mExifByteOrder);
        return Bitmap.createBitmap(r12, r16.getIntValue(this.mExifByteOrder), r17, Bitmap.Config.ARGB_8888);
    L23:
        return null;
    L25:
        return BitmapFactory.decodeByteArray(this.mThumbnailBytes, 0, this.mThumbnailLength);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    @Nullable
    public byte[] getThumbnailBytes() {
        ?? r5 = 0;
        if (this.mHasThumbnail == true) goto L5;
        return null;
    L5:
        byte[] r10 = this.mThumbnailBytes;
        if (r10 == null) goto L51;
        return r10;
    L51:
        InputStream r11 = this.mAssetInputStream;     // Catch: Throwable -> L24 IOException -> L26
        if (r11 == null) goto L21;
    L15:
        e = e;
    L44:
        Log.d(TAG, "Encountered exception while getting thumbnail", e);     // Catch: Throwable -> L13
        closeQuietly(r11);
        return null;
    L11:
        if (r11.markSupported() == false) goto L17;
        r11.reset();     // Catch: Throwable -> L13 IOException -> L15
    L29:
        if (r11 == null) goto L43;
        if (r11.skip(this.mThumbnailOffset) != this.mThumbnailOffset) goto L41;
        byte[] r12 = new byte[this.mThumbnailLength];     // Catch: Throwable -> L13 IOException -> L15
        if (r11.read(r12) != this.mThumbnailLength) goto L39;
        this.mThumbnailBytes = r12;     // Catch: Throwable -> L13 IOException -> L15
        closeQuietly(r11);
        return r12;
    L39:
        throw new IOException("Corrupted image");     // Catch: Throwable -> L13 IOException -> L15
    L41:
        throw new IOException("Corrupted image");     // Catch: Throwable -> L13 IOException -> L15
    L43:
        throw new FileNotFoundException();     // Catch: Throwable -> L13 IOException -> L15
    L17:
        Log.d(TAG, "Cannot read thumbnail from inputstream without mark/reset support");     // Catch: Throwable -> L13 IOException -> L15
        closeQuietly(r11);
        return null;
    L21:
        if (this.mFilename == null) goto L28;
        r11 = new FileInputStream(this.mFilename);     // Catch: Throwable -> L24 IOException -> L26
    L28:
        r11 = null;
    L26:
        e = e;
        r11 = null;
    L24:
        th = th;
    L47:
        closeQuietly(r5);
        throw th;
    L13:
        th = th;
        r5 = r10;
        goto L47
    }

    @Nullable
    public long[] getThumbnailRange() {
        if (this.mHasThumbnail == true) goto L7;
        return null;
    L7:
        return new long[]{this.mThumbnailOffset, this.mThumbnailLength};
    }

    public boolean hasThumbnail() {
        return this.mHasThumbnail;
    }

    public boolean isFlipped() {
        int r5 = getAttributeInt(TAG_ORIENTATION, 1);
        if (r5 != 2) goto L5;
    L12:
        return true;
    L5:
        if (r5 == 7) goto L12;
        if (r5 == 4) goto L12;
        if (r5 == 5) goto L12;
        return false;
    }

    public boolean isThumbnailCompressed() {
        int r5 = this.mThumbnailCompression;
        if (r5 != 6) goto L5;
    L8:
        return true;
    L5:
        if (r5 == 7) goto L8;
        return false;
    }

    public void resetOrientation() {
        setAttribute(TAG_ORIENTATION, Integer.toString(1));
    }

    public void rotate(int r10) {
        if ((r10 % 90) != 0) goto L19;
        int r5 = getAttributeInt(TAG_ORIENTATION, 1);
        List<Integer> r11 = ROTATION_ORDER;
        int r12 = 0;
        if (r11.contains(Integer.valueOf(r5)) == false) goto L10;
        int r13 = ((r10 / 90) + r11.indexOf(Integer.valueOf(r5))) % 4;
        if (r13 >= 0) goto L9;
        r12 = 4;
    L9:
        r12 = r11.get(r13 + r12).intValue();
    L16:
        setAttribute(TAG_ORIENTATION, Integer.toString(r12));
        return;
    L10:
        List<Integer> r14 = FLIPPED_ROTATION_ORDER;
        if (r14.contains(Integer.valueOf(r5)) == false) goto L16;
        int r15 = ((r10 / 90) + r14.indexOf(Integer.valueOf(r5))) % 4;
        if (r15 >= 0) goto L15;
        r12 = 4;
    L15:
        r12 = r14.get(r15 + r12).intValue();
        goto L16
    L19:
        throw new IllegalArgumentException("degree should be a multiple of 90");
    }

    public void saveAttributes() throws IOException {
        if (this.mIsSupportedFile == false) goto L29;
        if (this.mMimeType != 4) goto L29;
        if (this.mFilename == null) goto L27;
        this.mThumbnailBytes = getThumbnail();
        File r5 = new File(j0.q(new StringBuilder(), this.mFilename, ".tmp"));
        if (new File(this.mFilename).renameTo(r5) == false) goto L25;
        FileInputStream r10 = null;
        FileInputStream r11 = new FileInputStream(r5);     // Catch: Throwable -> L20
        FileOutputStream r12 = new FileOutputStream(this.mFilename);     // Catch: Throwable -> L18
        saveJpegAttributes(r11, r12);     // Catch: Throwable -> L16
        closeQuietly(r11);
        closeQuietly(r12);
        r5.delete();
        this.mThumbnailBytes = null;
        return;
    L16:
        th = th;
    L17:
        r10 = r11;
    L22:
        closeQuietly(r10);
        closeQuietly(r12);
        r5.delete();
        throw th;
    L18:
        th = th;
        r12 = null;
    L20:
        th = th;
        r12 = null;
        goto L22
    L25:
        throw new IOException("Could not rename to " + r5.getAbsolutePath());
    L27:
        throw new IOException("ExifInterface does not support saving attributes for the current input.");
    L29:
        throw new IOException("ExifInterface only supports saving attributes on JPEG formats.");
    }

    public void setAltitude(double r5) {
        if (r5 < 0.0d) goto L5;
        String r10 = "0";
    L6:
        setAttribute(TAG_GPS_ALTITUDE, new Rational(Math.abs(r5)).toString());
        setAttribute(TAG_GPS_ALTITUDE_REF, r10);
        return;
    L5:
        r10 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
        goto L6
    }

    public void setAttribute(@NonNull String r17, @Nullable String r18) {
        String r5 = r18;
        if (TAG_ISO_SPEED_RATINGS.equals(r17) == false) goto L5;
        String r10 = TAG_PHOTOGRAPHIC_SENSITIVITY;
    L6:
        int r11 = 2;
        String r12 = TAG;
        int r13 = 1;
        if (r5 != null) goto L9;
    L21:
        int r14 = 0;
        int r15 = 0;
    L23:
        if (r15 >= EXIF_TAGS.length) goto L99;
        if (r15 == 4) goto L27;
    L29:
        ExifTag r16 = sExifTagMapsForWriting[r15].get(r10);
        if (r16 != null) goto L31;
    L28:
        String r19 = r12;
        int r110 = r13;
    L98:
        r15 = r15 + 1;
        r12 = r19;
        r13 = r110;
        r11 = 2;
        r14 = 0;
        goto L23
    L31:
        if (r5 != null) goto L33;
        this.mAttributes[r15].remove(r10);
        goto L28
    L33:
        Pair<Integer, Integer> r20 = guessDataFormat(r5);
        int r111 = -1;
        if (r16.primaryFormat != ((Integer) r20.first).intValue()) goto L36;
    L61:
        int r21 = r16.primaryFormat;
    L63:
        switch(r21) {
            case 1: goto L97;
            case 2: goto L96;
            case 3: goto L91;
            case 4: goto L86;
            case 5: goto L81;
            case 6: goto L64;
            case 7: goto L96;
            case 8: goto L64;
            case 9: goto L76;
            case 10: goto L70;
            case 11: goto L64;
            case 12: goto L65;
            default: goto L64;
        };
    L64:
        Log.w(r12, "Data format isn't one of expected formats: " + r21);
        goto L28
    L65:
        String[] r22 = r5.split(",", -1);
        double[] r23 = new double[r22.length];
        int r112 = r14;
    L67:
        if (r112 >= r22.length) goto L69;
        r23[r112] = Double.parseDouble(r22[r112]);
        r112 = r112 + 1;
        goto L67
    L69:
        this.mAttributes[r15].put(r10, ExifAttribute.createDouble(r23, this.mExifByteOrder));
        goto L28
    L70:
        String[] r24 = r5.split(",", -1);
        Rational[] r113 = new Rational[r24.length];
        int r114 = r14;
    L72:
        if (r114 >= r24.length) goto L74;
        String[] r115 = r24[r114].split("/", -1);
        r113[r114] = new Rational((long) Double.parseDouble(r115[r14]), (long) Double.parseDouble(r115[r13]));
        r114 = r114 + 1;
        r12 = r12;
        r13 = 1;
        r14 = 0;
        goto L72
    L74:
        r19 = r12;
        this.mAttributes[r15].put(r10, ExifAttribute.createSRational(r113, this.mExifByteOrder));
    L75:
        r110 = 1;
        goto L98
    L76:
        r19 = r12;
        String[] r25 = r5.split(",", -1);
        int[] r26 = new int[r25.length];
        int r27 = 0;
    L78:
        if (r27 >= r25.length) goto L80;
        r26[r27] = Integer.parseInt(r25[r27]);
        r27 = r27 + 1;
        goto L78
    L80:
        this.mAttributes[r15].put(r10, ExifAttribute.createSLong(r26, this.mExifByteOrder));
        goto L75
    L81:
        r19 = r12;
        String[] r28 = r5.split(",", -1);
        Rational[] r29 = new Rational[r28.length];
        int r30 = 0;
    L83:
        if (r30 >= r28.length) goto L85;
        String[] r31 = r28[r30].split("/", r111);
        r29[r30] = new Rational((long) Double.parseDouble(r31[0]), (long) Double.parseDouble(r31[1]));
        r30 = r30 + 1;
        r111 = -1;
        goto L83
    L85:
        r110 = 1;
        this.mAttributes[r15].put(r10, ExifAttribute.createURational(r29, this.mExifByteOrder));
        goto L98
    L86:
        r19 = r12;
        r110 = r13;
        String[] r32 = r5.split(",", -1);
        long[] r33 = new long[r32.length];
        int r34 = 0;
    L88:
        if (r34 >= r32.length) goto L90;
        r33[r34] = Long.parseLong(r32[r34]);
        r34 = r34 + 1;
        goto L88
    L90:
        this.mAttributes[r15].put(r10, ExifAttribute.createULong(r33, this.mExifByteOrder));
        goto L98
    L91:
        r19 = r12;
        r110 = r13;
        String[] r35 = r5.split(",", -1);
        int[] r36 = new int[r35.length];
        int r37 = 0;
    L93:
        if (r37 >= r35.length) goto L95;
        r36[r37] = Integer.parseInt(r35[r37]);
        r37 = r37 + 1;
        goto L93
    L95:
        this.mAttributes[r15].put(r10, ExifAttribute.createUShort(r36, this.mExifByteOrder));
        goto L98
    L96:
        r19 = r12;
        r110 = r13;
        this.mAttributes[r15].put(r10, ExifAttribute.createString(r5));
        goto L98
    L97:
        r19 = r12;
        r110 = r13;
        this.mAttributes[r15].put(r10, ExifAttribute.createByte(r5));
        goto L98
    L36:
        if (r16.primaryFormat == ((Integer) r20.second).intValue()) goto L61;
        int r116 = r16.secondaryFormat;
        if (r116 != (-1)) goto L41;
    L45:
        int r117 = r16.primaryFormat;
        if (r117 != r13) goto L48;
    L60:
        r21 = r117;
        goto L63
    L48:
        if (r117 == 7) goto L60;
        if (r117 == r11) goto L60;
        StringBuilder r118 = j0.x("Given tag (", r10, ") value didn't match with one of expected formats: ");
        String[] r119 = IFD_FORMAT_NAMES;
        r118.append(r119[r16.primaryFormat]);
        String r120 = "";
        if (r16.secondaryFormat != (-1)) goto L54;
        String r38 = "";
    L55:
        r118.append(r38);
        r118.append(" (guess: ");
        r118.append(r119[((Integer) r20.first).intValue()]);
        if (((Integer) r20.second).intValue() == (-1)) goto L59;
        r120 = ", " + r119[((Integer) r20.second).intValue()];
    L59:
        r118.append(r120);
        r118.append(")");
        Log.w(r12, r118.toString());
        goto L28
    L54:
        r38 = ", " + r119[r16.secondaryFormat];
        goto L55
    L41:
        if (r116 != ((Integer) r20.first).intValue()) goto L43;
    L44:
        r21 = r16.secondaryFormat;
        goto L63
    L43:
        if (r16.secondaryFormat != ((Integer) r20.second).intValue()) goto L45;
    L27:
        if (this.mHasThumbnail == true) goto L29;
    L99:
        return;
    L9:
        if (sTagSetForCompatibility.contains(r10) == false) goto L21;
        if (r10.equals(TAG_GPS_TIMESTAMP) == false) goto L100;
        Matcher r39 = sGpsTimestampPattern.matcher(r5);
        if (r39.find() == true) goto L16;
        Log.w(TAG, "Invalid value for " + r10 + " : " + r5);
        return;
    L16:
        r5 = Integer.parseInt(r39.group(1)) + "/1," + Integer.parseInt(r39.group(2)) + "/1," + Integer.parseInt(r39.group(3)) + "/1";
        goto L21
    L100:
        r5 = new Rational(Double.parseDouble(r18)).toString();     // Catch: NumberFormatException -> L19
    L19:
        Log.w(TAG, "Invalid value for " + r10 + " : " + r5);
        return;
    L5:
        r10 = r17;
        goto L6
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setDateTime(long r5) {
        long r10 = r5 % 1000;
        setAttribute(TAG_DATETIME, sFormatter.format(new Date(r5)));
        setAttribute(TAG_SUBSEC_TIME, Long.toString(r10));
    }

    public void setGpsInfo(Location r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        setAttribute(TAG_GPS_PROCESSING_METHOD, r10.getProvider());
        setLatLong(r10.getLatitude(), r10.getLongitude());
        setAltitude(r10.getAltitude());
        setAttribute(TAG_GPS_SPEED_REF, "K");
        setAttribute(TAG_GPS_SPEED, new Rational((r10.getSpeed() * TimeUnit.HOURS.toSeconds(1)) / 1000.0f).toString());
        String[] r11 = sFormatter.format(new Date(r10.getTime())).split("\\s+", -1);
        setAttribute(TAG_GPS_DATESTAMP, r11[0]);
        setAttribute(TAG_GPS_TIMESTAMP, r11[1]);
    }

    public void setLatLong(double r5, double r10) {
        if (r5 < (-90.0d)) goto L27;
        if (r5 > 90.0d) goto L27;
        if (Double.isNaN(r5) == true) goto L27;
        if (r10 < (-180.0d)) goto L25;
        if (r10 > 180.0d) goto L25;
        if (Double.isNaN(r10) == true) goto L25;
        if (r5 < 0.0d) goto L17;
        String r11 = "N";
    L18:
        setAttribute(TAG_GPS_LATITUDE_REF, r11);
        setAttribute(TAG_GPS_LATITUDE, convertDecimalDegree(Math.abs(r5)));
        if (r10 < 0.0d) goto L21;
        String r12 = LONGITUDE_EAST;
    L22:
        setAttribute(TAG_GPS_LONGITUDE_REF, r12);
        setAttribute(TAG_GPS_LONGITUDE, convertDecimalDegree(Math.abs(r10)));
        return;
    L21:
        r12 = LONGITUDE_WEST;
        goto L22
    L17:
        r11 = LATITUDE_SOUTH;
    L25:
        throw new IllegalArgumentException("Longitude value " + r10 + " is not valid.");
    L27:
        throw new IllegalArgumentException("Latitude value " + r5 + " is not valid.");
    }

    @Nullable
    public double[] getLatLong() {
        String r5 = getAttribute(TAG_GPS_LATITUDE);
        String r10 = getAttribute(TAG_GPS_LATITUDE_REF);
        String r11 = getAttribute(TAG_GPS_LONGITUDE);
        String r12 = getAttribute(TAG_GPS_LONGITUDE_REF);
        if (r5 == null) goto L14;
        if (r10 == null) goto L15;
        if (r11 == null) goto L16;
        if (r12 == null) goto L17;
        return new double[]{convertRationalLatLonToDouble(r5, r10), convertRationalLatLonToDouble(r11, r12)};
    L9:
        StringBuilder r13 = a.y("latValue=", r5, ", latRef=", r10, ", lngValue=");
        r13.append(r11);
        r13.append(", lngRef=");
        r13.append(r12);
        Log.w(TAG, "Latitude/longitude values are not parseable. ".concat(r13.toString()));
        return null;
    L17:
        return null;
    L16:
        return null;
    L15:
        return null;
    L14:
        return null;
    }

    public ExifInterface(@NonNull InputStream r5) throws IOException {
        ExifTag[][] r10 = EXIF_TAGS;
        this.mAttributes = new HashMap[r10.length];
        this.mAttributesOffsets = new HashSet(r10.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (r5 == null) goto L11;
        this.mFilename = null;
        if ((r5 instanceof AssetManager.AssetInputStream) == false) goto L7;
        this.mAssetInputStream = (AssetManager.AssetInputStream) r5;
    L8:
        loadAttributes(r5);
        return;
    L7:
        this.mAssetInputStream = null;
        goto L8
    L11:
        throw new IllegalArgumentException("inputStream cannot be null");
    }
}
